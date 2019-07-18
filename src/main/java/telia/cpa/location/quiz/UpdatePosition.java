package telia.cpa.location.quiz;
import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import static org.quartz.JobBuilder.*;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

public class UpdatePosition {
    public static void main(String[] args) {
        try {

            JobDetail job1 = JobBuilder.newJob(UpdatePositionJob.class)
                    .withIdentity("job1", "group1").build();

            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(30)
                            .repeatForever())
                    .build();

            Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
            ArrayList<User> memberList = new ArrayList<>();
            User user = new User("4740553014");
            memberList.add(user);
            user = new User("4747350966");
            memberList.add(user);



            scheduler1.getContext().put("memberList", memberList);
            scheduler1.start();
            scheduler1.scheduleJob(job1, trigger1);






        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
