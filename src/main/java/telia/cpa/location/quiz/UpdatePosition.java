package telia.cpa.location.quiz;
import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import java.util.ArrayList;


public class UpdatePosition {
    public static void main(String[] args) {
        try {

            JobDetail job1 = JobBuilder.newJob(UpdatePositionJob.class)
                    .withIdentity("job1", "group1").build();

            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger1", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                    .build();

            Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
            scheduler1.start();
           scheduler1.scheduleJob(job1, trigger1);




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
