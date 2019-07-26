package telia.cpa.location.quiz;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import telia.cpa.location.Point;
import telia.cpa.location.Polygon;

import no.differitas._2015._10.coveragearea.CoverageAreaService;
import telia.cpa.location.CoverageAreaInvoker;
import telia.cpa.location.main;

@DisallowConcurrentExecution
public class UpdatePositionJob implements Job {

    final static Logger logger = LoggerFactory.getLogger(main.class);
    CoverageAreaInvoker client = new CoverageAreaInvoker();
    ArrayList<User> memberList;
    ArrayList<QuizLocation> quizLocations;
    Leaderboard leaderboard;

    public void execute(JobExecutionContext context) throws JobExecutionException {

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

        checkMemberList();
        leaderboard.sort();

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

            if (user.getLevel() >= quizLocations.size()) {
                user.resetLevel();
            }

            client.setMsisdn(user.getMsisdn()); // Update client from API.
            point = client.getPoint();
            polygon = quizLocations.get(user.getLevel()).getPolygon();
            margin = quizLocations.get(user.getLevel()).getMargin();

            System.out.println("Location of " + user.getFirstName() + " is: " + client.getLocation()+ ".     " +
                    "Next location: " + quizLocations.get(user.getLevel()).getHint());
            logger.info("Location of " + user.getFirstName() + " is: " + client.getLocation()+ "\n" +
                    "Next location: " + quizLocations.get(user.getLevel()).getHint() + ".     " +
                    "Current Level: " + user.getLevel() + ".    Margin Count: " + user.getMarginCount());

            if (polygon.isInside(point)){
                updateUser(user);
            } else if (margin.isInside(point)){
                user.updateMarginCount();
                System.out.println("marginCount: " + user.getMarginCount());
                if (user.getMarginCount() >= 4) {
                    updateUser(user);
                }
            } else {
                System.out.println("DID NOT LEVEL UP");
            }
        }//end for

    }//end checkMemberList


    public void updateUser(User user){
        user.updateLevel();
        user.updateScore();
        user.resetMarginCount();
        System.out.println(user.getMsisdn() + " Level up! - "+ user.getLevel() + " 🏋️‍ ");
        logger.info(user.getMsisdn() + " Level up! -  "+ user.getLevel());
    }



 }

