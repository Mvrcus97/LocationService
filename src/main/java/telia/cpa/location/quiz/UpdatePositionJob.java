package telia.cpa.location.quiz;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import telia.cpa.location.SmsInvoker;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import telia.cpa.location.Point;
import telia.cpa.location.Polygon;

import telia.cpa.location.CoverageAreaInvoker;
import telia.cpa.location.main;

@DisallowConcurrentExecution
public class UpdatePositionJob implements Job {

    final static Logger logger = LoggerFactory.getLogger(main.class);
    CoverageAreaInvoker coverageClient = new CoverageAreaInvoker();
    SmsInvoker client = new SmsInvoker();
    ArrayList<User> memberList;
    ArrayList<QuizLocation> quizLocations;
    Leaderboard leaderboard;


    public void execute(JobExecutionContext context){

        System.out.println("\n --------- JOB STARTED ---------      " + new Date());

        SchedulerContext schedulerContext = null;

        try {
            schedulerContext = context.getScheduler().getContext();
        } catch (SchedulerException e1) {
            e1.printStackTrace();
        }
        // loll

        // Get data from Scheduler
        this.memberList = (ArrayList<User>) schedulerContext.get("memberList");
        this.quizLocations = (ArrayList<QuizLocation>) schedulerContext.get("quizLocations");
        this.leaderboard = (Leaderboard) schedulerContext.get("leaderboard");

        checkMemberList();

        List<User> leaderList = leaderboard.getTopN(10);
        System.out.println("\n----------------LEADERBOARD---------------------");
        User u;
        for(int i = 0 ; i < leaderList.size(); i++){
            u = leaderList.get(i);
            System.out.println( u.getScore() + " - "  + u.getFirstName());
        }

        System.out.println("------------------------------------------------\n");


        System.out.println("--------- JOB DONE --------- \n");

    } //execute


    /*   Go through each user in the memberList and update their Level
     *   if they are within their current secret location.
     */
    public void checkMemberList(){
        Point point;
        Polygon polygon;
        Polygon margin;

        System.out.println("memberList size: " + memberList.size());


        for (User user : memberList ){

            coverageClient.setMsisdn(user.getMsisdn()); // Update client from API.
            point = coverageClient.getPoint();
            polygon = quizLocations.get(user.getLevel()).getPolygon();
            margin = quizLocations.get(user.getLevel()).getMargin();

            System.out.println("Location of " + user.getFirstName() + " is: " + coverageClient.getLocation()+ "\n" +
                    "Next location: " + quizLocations.get(user.getLevel()).getHint() + ".     " +
                    "Current Level: " + user.getLevel() + ".");
            logger.info("Location of " + user.getFirstName() + " is: " + coverageClient.getLocation()+ "\n" +
                    "Next location: " + quizLocations.get(user.getLevel()).getHint() + ".     " +
                    "Current Level: " + user.getLevel() + ".    Margin Count: " + user.getMarginCount());

            if (polygon.isInside(point)){
                updateUser(user);
            } else if (margin.isInside(point)){
                user.updateMarginCount();
                System.out.println("marginCount: " + user.getMarginCount() + "\n");

                    if (user.getMarginCount() >= 2) {
                        updateUser(user);
                    }

            } else {
                System.out.println("DID NOT LEVEL UP");
            }
        }//end for

    }//end checkMemberList


    public void updateUser(User user){

        Promo promo = new Promo("NON", 0);
        if (user.getLevel() < quizLocations.size()) {
            promo = quizLocations.get(user.getLevel()).getPromo();
        }

        user.updateLevel();
        leaderboard.sort();

        System.out.println(user.getMsisdn() + " Level up! - Now on level " + user.getLevel() + " 🏋️‍ ");
        logger.info(user.getMsisdn() + " Level up! -  "+ user.getLevel());
        sendSMS(user);

        if (user.getLevel() >= quizLocations.size()) {
            user.resetLevel();
        }
    }

    public void sendSMS(User user){
        StringBuilder levelUptxt = new StringBuilder("Congratulations, ");
        levelUptxt.append(user.getFirstName()).append("!\n\nNew Level: ").append(user.getLevel()).append("\nYour score is: ").append(user.getScore()).append("\n\n");
        levelUptxt.append("Here is your reward:\nhttp://telia-summer-interns.s3-website-eu-west-1.amazonaws.com/\n\n");

        StringBuilder leaderboardTxt = new StringBuilder("-----LEADERBOARD-----\n");
        User u;
        List<User> leaderList = leaderboard.getTopN(10);

        for(int i = 0 ; i < leaderList.size(); i++){
            u = leaderList.get(i);
            leaderboardTxt.append(u.getScore());
            leaderboardTxt.append(" - " );
            leaderboardTxt.append(u.getFirstName());
            leaderboardTxt.append("\n");
            System.out.println( u.getScore() + " - "  + u.getFirstName());
        }

        leaderboardTxt.append("--------------------------\n\n\nFind your next secret Location: ").append(quizLocations.get(user.getLevel()-1).getHint());

        levelUptxt.append(leaderboardTxt);
        client.addMessage(user.getMsisdn(), levelUptxt.toString());
    }

 }

