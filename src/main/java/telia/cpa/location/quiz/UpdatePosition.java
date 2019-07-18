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
    public static void main(String[] args) {
        try {

            JobDetail job1 = JobBuilder.newJob(UpdatePositionJob.class)
                    .withIdentity("job1", "group1").build();

            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(15)
                            .repeatForever())
                    .build();

            Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();

            ArrayList<User> memberList = new ArrayList<>();



            Quiz quiz = new Quiz();
            Polygon telia = new Polygon();
            telia.createPolygonFromWKT("POLYGON ((10.76729569807776 59.95319251881604,10.764195064456544 59.952956149672424,10.765171388537965 59.95107050818612,10.76903376951941 59.951666833759084,10.76729569807776 59.95319251881604))");
            QuizLocation quizLocation = new QuizLocation(telia, "Et fint brunt bygg");
            quiz.addQuizLocation(quizLocation);
            quiz.addQuizLocation(quizLocation);
            quiz.addQuizLocation(quizLocation);

            User user = new User("4747351212");
            quiz.addMember(user);
            user = new User("4747350966");
            quiz.addMember(user);

            memberList = quiz.getMemberList();




            scheduler1.getContext().put("memberList", memberList);
            scheduler1.getContext().put("quizLocations",quiz.getQuizLocations());


            scheduler1.start();
            scheduler1.scheduleJob(job1, trigger1);


            System.out.println("Keep running?");




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
