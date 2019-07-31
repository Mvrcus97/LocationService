package no.telia.cpa.location.quiz.cronJob;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import no.telia.cpa.location.clients.SmsInvoker;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import no.telia.cpa.location.Point;
import no.telia.cpa.location.Polygon;
import no.telia.cpa.location.clients.CoverageAreaInvoker;
import no.telia.cpa.location.main;
import no.telia.cpa.location.quiz.Leaderboard;
import no.telia.cpa.location.quiz.QuizLocation;
import no.telia.cpa.location.quiz.User;


/* This class represents the cronJob which will be ran continuously.
 * The main goal of the job is to go through each member and check
 * if they are located within their current given Secret Location.
 *
 * Once the job finds a user who is located correctly ->
 * update that user and send them a corresponding text SMS.
 */

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

        // Get data from Scheduler
        this.memberList = (ArrayList<User>) schedulerContext.get("memberList");
        this.quizLocations = (ArrayList<QuizLocation>) schedulerContext.get("quizLocations");
        this.leaderboard = (Leaderboard) schedulerContext.get("leaderboard");

        //Go through memberlist
        checkMemberList();

        //Print leaderboard
        leaderboard.print(10);


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
            if (point == null) continue;
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
        user.updateLevel();
        leaderboard.sort();

        System.out.println(user.getMsisdn() + " Level up! - Now on level " + user.getLevel() + " 🏋️‍ ");
        logger.info(user.getMsisdn() + " Level up! -  "+ user.getLevel());
        sendSMS(user);

        if (user.getLevel() >= quizLocations.size()) {
            user.resetLevel();
        }
    }//end updateUser




    public void sendSMS(User user){
        String promo = quizLocations.get(user.getLevel()-1).getPromo();
        StringBuilder levelUptxt = new StringBuilder("Congratulations, ");
        levelUptxt.append(user.getFirstName()).append("!\n\nNew Level: ").append(user.getLevel()).append("\nYour score is: ").append(user.getScore()).append("\n\n");
        if(promo != null){
            levelUptxt.append("Here is your reward:\n").append(promo).append("\n\n");
        }

        StringBuilder leaderboardTxt = new StringBuilder("-----LEADERBOARD-----\n");
        User u;
        List<User> leaderList = leaderboard.getTopN(10);

        for(int i = 0 ; i < leaderList.size(); i++){
            u = leaderList.get(i);
            leaderboardTxt.append(u.getScore());
            leaderboardTxt.append(" - " );
            leaderboardTxt.append(u.getFirstName());
            leaderboardTxt.append("\n");
        }

        leaderboardTxt.append("--------------------------\n\nFind your next secret Location: ").append(quizLocations.get(user.getLevel()-1).getHint());

        levelUptxt.append(leaderboardTxt);
        client.addMessage(user.getMsisdn(), levelUptxt.toString());
    }//end sendSMS
 }//end updatePositionJob

