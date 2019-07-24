package telia.cpa.location;

import telia.cpa.location.quiz.Quiz;
import telia.cpa.location.quiz.QuizLocation;
import telia.cpa.location.quiz.UpdatePosition;
import telia.cpa.location.quiz.User;

import java.util.ArrayList;
import org.slf4j.*;

public class main {

    final static Logger logger = LoggerFactory.getLogger(main.class);

    public static void main(String[] args) {

        Quiz quiz = new Quiz();
        int sec = 10;

        quiz.createTestQuiz();

        User user = new User("4740553014");
        user.setFirstName("Telia");
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

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        user = new User("4798679661");
        user.setFirstName("Patience");
        System.out.println("ADDING Patience \n");
        quiz.addMember(user, sec);

    }
}

