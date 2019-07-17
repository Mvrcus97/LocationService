package telia.cpa.location.quiz;


import java.util.ArrayList;
import java.util.Date;
import telia.cpa.location.Point;
import telia.cpa.location.Polygon;

import no.differitas._2015._10.coveragearea.CoverageAreaService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import telia.cpa.location.CoverageAreaInvoker;


public class UpdatePositionJob implements Job{
    CoverageAreaInvoker client = new CoverageAreaInvoker();
    ArrayList<String> numberList = new ArrayList<String>();

    public void setList(ArrayList<String> list){
        this.numberList = list;
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("CronJob --->>> Hello! Time is " + new Date());
        numberList.add("4740553014");
        numberList.add("4745675796");

       /* for(String nr : numberList){
            System.out.println("Current number lookup: " + nr );
            client.setMsisdn(nr);
            System.out.println(client.toString());
        }*/

        System.out.println("All numbers located.");
    }

    public void checkMemberList(Quiz quiz){

        Point point;
        Polygon polygon;
        for (User user : quiz.memberList){
            client.setMsisdn(user.getMsisdn());
            point = client.getPoint();
            polygon = quiz.getLevel(user);

            if (polygon.isInside(point)){
                updateUser(user);
            }
        }

    }

    public void updateUser(User user){
        user.updateLevel();
        user.updateScore(scoreCalc()); //can be replaced with scoreCalc
    }

    public int scoreCalc(){
        return 10;
    }

}
