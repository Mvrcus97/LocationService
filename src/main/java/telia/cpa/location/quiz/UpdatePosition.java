package telia.cpa.location.quiz;
import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import telia.cpa.location.Polygon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import static org.quartz.JobBuilder.*;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

public class UpdatePosition {

    Scheduler scheduler1;
    ArrayList<User> memberList;
    ArrayList<QuizLocation> locations;



    public UpdatePosition(int sec, ArrayList<User> memberList, ArrayList<QuizLocation> locations){
        this.memberList = memberList;
        this.locations = locations;

        try {
            Thread.sleep(sec*1000);

            JobDetail job1 = JobBuilder.newJob(UpdatePositionJob.class)
                    .withIdentity("job1", "group1").build();

            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(sec)
                            .repeatForever())
                    .build();

            scheduler1 = new StdSchedulerFactory().getScheduler();

            scheduler1.getContext().put("memberList", memberList);
            scheduler1.getContext().put("quizLocations",locations);

            scheduler1.start();
            scheduler1.scheduleJob(job1, trigger1);
            //scheduler1.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//end updatePosition



    public void stop() {
        try {
            this.scheduler1.shutdown();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
