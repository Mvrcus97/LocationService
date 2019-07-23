package telia.cpa.location.quiz;


import java.util.ArrayList;
import java.util.Date;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import telia.cpa.location.Point;
import telia.cpa.location.Polygon;

import no.differitas._2015._10.coveragearea.CoverageAreaService;
import telia.cpa.location.CoverageAreaInvoker;
import telia.cpa.location.main;


public class UpdatePositionJob implements Job{
    final static Logger logger = LoggerFactory.getLogger(main.class);
    CoverageAreaInvoker client = new CoverageAreaInvoker();
    ArrayList<User> memberList;
    ArrayList<QuizLocation> quizLocations;


    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("\n --------- JOB STARTED ---------      " + new Date());
        SchedulerContext schedulerContext = null;
        try {
            schedulerContext = context.getScheduler().getContext();
        } catch (SchedulerException e1) {
            e1.printStackTrace();
        }

        this.memberList = (ArrayList<User>) schedulerContext.get("memberList");
        this.quizLocations = (ArrayList<QuizLocation>) schedulerContext.get("quizLocations");

        checkMemberList();
        System.out.println("--------- JOB DONE --------- \n");
    }//end  execute


    /*   Go through each user in the memberList and update their Level dependent on if they are within their
     *
     */
    public void checkMemberList(){
        Point point;
        Polygon polygon;
        Polygon margin;
        System.out.println("memberList size: " + memberList.size() + "\n");

        for (User user : memberList ){
            client.setMsisdn(user.getMsisdn()); // Update client from API.
            point = client.getPoint();
            polygon = quizLocations.get(user.getLevel()).getPolygon();
            margin = quizLocations.get(user.getLevel()).getMargin();

            System.out.println("Location of " + user.getFirstName() + " is: " + client.getLocation()+ "\n" +
                    "Next location: " + quizLocations.get(user.getLevel()).getHint());
            logger.info("Location of " + user.getFirstName() + " is: " + client.getLocation()+ "\n" +
                    "Next location: " + quizLocations.get(user.getLevel()).getHint());

            if (polygon.isInside(point)){
                logger.info(user.getMsisdn() + " Level up!!!! -  "+ user.getLevel());
                System.out.println("LEVEL UP \n");
                updateUser(user);
            } else if (margin.isInside(point)){
                user.updateMarginCount();
                if (user.getMarginCount() >= 5) {
                    System.out.println("LEVEL UP \n");
                    updateUser(user);
                }
            } else {
                System.out.println("DID NOT LEVEL UP");
            }
        }//end for

    }//end checkMemberList


    public void updateUser(User user){
        user.updateLevel();
        user.updateScore(scoreCalc()); //can be replaced with scoreCalc
        user.resetMarginCount();
        System.out.println(user.getMsisdn() + " Level up! - "+ user.getLevel());
    }

    public int scoreCalc(){
        return 10;
    }

}

