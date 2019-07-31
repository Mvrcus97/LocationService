package telia.cpa.location.quiz.cronJob;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import telia.cpa.location.quiz.Leaderboard;
import telia.cpa.location.quiz.QuizLocation;
import telia.cpa.location.quiz.User;

import java.util.ArrayList;
import java.util.Date;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/* This class represents a Scheduler, which job is to schedule cron-jobs for execution.
 * The scheduler decides when cron-job(s) should be spawned.
 *
 * Currently we believe a cron job should be ran approx. every 10-15 second.
 * In an ideal world, this also means every player's position should be updated every 10-15 second.
 *
 */


public class UpdatePosition {

    Scheduler scheduler;

    public UpdatePosition(int sec, ArrayList<User> memberList, ArrayList<QuizLocation> locations, Leaderboard leaderboard){

        try {
            //Create job and trigger
            JobDetail job = JobBuilder.newJob(UpdatePositionJob.class)
                             .withIdentity("job", "group").build();

            Trigger trigger = TriggerBuilder.newTrigger()
                               .withIdentity("simpleTrigger", "group")
                               .startNow()
                               .withSchedule(simpleSchedule()
                               .withIntervalInSeconds(sec)
                               .repeatForever())
                               .build();

            System.out.println("******************** SCHEDULER STARTED ********************" + new Date());

            //Give the cron-job access to memberlist, leaderboard and quizLocations.
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.getContext().put("memberList", memberList);
            scheduler.getContext().put("leaderboard", leaderboard);
            scheduler.getContext().put("quizLocations",locations);

            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//end Constructor


    /*This methods is used to shutdown the current active scheduler.
      The corresponding active cron job will shut down as soon as possible, meaning the current
      running job will NOT complete. */
    public void shutdown(){
        try {
            scheduler.shutdown(false);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}//end UpdatePosition
