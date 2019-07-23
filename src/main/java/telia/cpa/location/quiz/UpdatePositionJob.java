package telia.cpa.location.quiz;


import java.util.ArrayList;
import java.util.Date;

import org.quartz.*;
import telia.cpa.location.Point;
import telia.cpa.location.Polygon;

import no.differitas._2015._10.coveragearea.CoverageAreaService;
import telia.cpa.location.CoverageAreaInvoker;


public class UpdatePositionJob implements Job{

    private volatile boolean isJobInterrupted = false;
    private JobKey jobKey = null;
    private volatile Thread thisThread;

    CoverageAreaInvoker client = new CoverageAreaInvoker();
    ArrayList<User> memberList;
    ArrayList<QuizLocation> quizLocations;


    public void execute(JobExecutionContext context) throws JobExecutionException {

        thisThread = Thread.currentThread();
        jobKey = context.getJobDetail().getKey();

        //System.out.println("SimpleJob --->>> Hello! Time is " + new Date());
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
    }

    public void checkMemberList(){

        Point point;
        Polygon polygon;
        Polygon margin;
        System.out.println("memberList size: " + memberList.size() + "\n");

        for (User user : memberList ){
            client.setMsisdn(user.getMsisdn());
            point = client.getPoint();
            polygon = quizLocations.get(user.getLevel()).getPolygon();
            margin = quizLocations.get(user.getLevel()).getMargin();
            System.out.println(user.getFirstName() + " " + client.getLocation());

            if (polygon.isInside(point)){
                System.out.println("LEVEL UP \n");
                updateUser(user);
            } else if (margin.isInside(point)){
                user.updateMarginCount();
                if (user.getMarginCount() >= 5) {
                    System.out.println("LEVEL UP \n");
                    updateUser(user);
                }
            } else {
                System.out.println("DID NOT LEVEL UP \n");
            }
        }

    }

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

