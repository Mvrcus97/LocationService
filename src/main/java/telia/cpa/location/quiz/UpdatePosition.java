package telia.cpa.location.quiz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.ArrayList;
import java.util.Date;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

public class UpdatePosition {

    Scheduler scheduler1;

    public UpdatePosition(int sec, ArrayList<User> memberList, ArrayList<QuizLocation> locations, Leaderboard leaderboard){

        try {

            Thread.sleep(sec * 1000);

            JobDetail job1 = JobBuilder.newJob(UpdatePositionJob.class)
                             .withIdentity("job1", "group1").build();

            Trigger trigger1 = TriggerBuilder.newTrigger()
                               .withIdentity("simpleTrigger", "group1")
                               .startNow()
                               .withSchedule(simpleSchedule()
                               .withIntervalInSeconds(sec)
                               .repeatForever())
                               .build();

            System.out.println("******************** SCHEDULER STARTED ********************" + new Date());

            scheduler1 = new StdSchedulerFactory().getScheduler();
            scheduler1.getContext().put("memberList", memberList);
            scheduler1.getContext().put("quizLocations",locations);
            scheduler1.getContext().put("leaderbaord", leaderboard);

            scheduler1.start();
            scheduler1.scheduleJob(job1, trigger1);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void shutdown(){
        try {
            scheduler1.shutdown(false);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
