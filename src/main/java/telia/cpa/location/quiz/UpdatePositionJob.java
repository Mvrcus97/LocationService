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

    /*@Override
    public void interrupt() throws UnableToInterruptJobException {
        System.err.println("calling interrupt: " + thisThread + " ==> " + jobKey);
        isJobInterrupted = true;
        if (thisThread != null){
            thisThread.interrupt();
        }
    }*/

    public void execute(JobExecutionContext context) throws JobExecutionException {

        thisThread = Thread.currentThread();
        jobKey = context.getJobDetail().getKey();

        System.out.println("SimpleJob --->>> Hello! Time is " + new Date());

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

        System.out.println("All numbers located.");
    }

    public void checkMemberList(){

        Point point;
        Polygon polygon;
        System.out.println("Size: " + memberList.size());
        for (User user : memberList ){
            client.setMsisdn(user.getMsisdn());
            point = client.getPoint();
            System.out.println(client.getLocation());
            polygon = quizLocations.get(user.getLevel()).getPolygon();

            if (polygon.isInside(point)){
                System.out.println("LEVEL UP");
                updateUser(user);
            } else {
                System.out.println("DID NOT LEVEL UP");
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

