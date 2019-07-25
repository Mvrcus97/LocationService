package telia.cpa.location;

import org.quartz.Scheduler;
import telia.cpa.location.quiz.Quiz;
import telia.cpa.location.quiz.QuizLocation;
import telia.cpa.location.quiz.UpdatePosition;
import telia.cpa.location.quiz.User;

import java.util.ArrayList;
import org.slf4j.*;

public class main {

    //final static Logger logger = LoggerFactory.getLogger(main.class);

    public static void main(String[] args) {


        User user = new User("4746443715");
        user.updateLevel();
        System.out.println("Instant update - Should be about 100\n");

        try {
            Thread.sleep(3200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        user.updateLevel();
        System.out.println("After 3 hours - Should be about 80\n");

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        user.updateLevel();
        System.out.println("After 6 hours - should be about 50\n");

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        user.updateLevel();
        System.out.println("After 20 hours and beyound - SHould be about 50\n");











        Quiz quiz = new Quiz();
        int sec = 10;

        quiz.createTestQuiz();

        user = new User("4740553014");
        user.setFirstName("Telia");
        quiz.addMember(user, sec);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        user = new User("4798679661");
        user.setFirstName("Patience");
        System.out.println("ADDING Patience \n");
        quiz.addMember(user, sec);
        

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        user = new User("4790519192");
        user.setFirstName("Per Anders");
        System.out.println("ADDING PER ANDERS \n");
        quiz.addMember(user, sec);

    }
}

