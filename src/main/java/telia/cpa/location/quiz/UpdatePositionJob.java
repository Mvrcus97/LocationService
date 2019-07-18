package telia.cpa.location.quiz;


import java.util.ArrayList;
import java.util.Date;

import org.quartz.*;
import telia.cpa.location.Point;
import telia.cpa.location.Polygon;

import no.differitas._2015._10.coveragearea.CoverageAreaService;
import telia.cpa.location.CoverageAreaInvoker;


public class UpdatePositionJob implements Job{
    CoverageAreaInvoker client = new CoverageAreaInvoker();
    ArrayList<User> memberList;
    ArrayList<QuizLocation> quizLocations;


    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("CronJob --->>> Hello! Time is " + new Date());

        SchedulerContext schedulerContext = null;
        try {
            schedulerContext = context.getScheduler().getContext();
        } catch (SchedulerException e1) {
            e1.printStackTrace();
        }
        this.memberList = (ArrayList<User>) schedulerContext.get("memberList");
        this.quizLocations = (ArrayList<QuizLocation>) schedulerContext.get("quizLocations");

        System.out.println("List we found: ");
        checkMemberList();

       /* for(String nr : numberList){
            System.out.println("Current number lookup: " + nr );
            client.setMsisdn(nr);
            System.out.println(client.toString());
        }*/

        System.out.println("All numbers located.");
    }

    public void checkMemberList(){

        Point point;
        Polygon polygon;
        for (User user : memberList ){
            client.setMsisdn(user.getMsisdn());
            point = client.getPoint();
            System.out.println(client.getLocation());
            polygon = quizLocations.get(user.getLevel()).getPolygon();

            if (polygon.isInside(point)){
                updateUser(user);
            }
        }

    }

    public void updateUser(User user){
        user.updateLevel();
        user.updateScore(scoreCalc()); //can be replaced with scoreCalc
        System.out.println(user.getMsisdn() + " Level up! - "+ user.getLevel());

    }

    public int scoreCalc(){
        return 10;
    }

}

