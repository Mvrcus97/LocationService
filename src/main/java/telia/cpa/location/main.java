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

        Polygon buss = new Polygon(); //fix construct
        buss.createPolygonFromWKT("POLYGON ((10.768071901632993 59.95157035825779,10.76842058880493 59.95100357895124,10.769509565664976 59.951215786556524,10.76916624291107 59.95169929248146,10.768071901632993 59.95157035825779))");
        QuizLocation bussStopp = new QuizLocation(buss, "BUsstopp");
        quiz.addQuizLocation(bussStopp);

        Polygon telia = new Polygon();
        telia.createPolygonFromWKT("POLYGON ((10.766812379734233 59.95192068692169,10.76737564362736 59.95200664221799,10.766742642299846 59.95278560192664,10.765819962398723 59.952608323050384,10.766351039783672 59.951818614717816,10.766812379734233 59.95192068692169))");
        QuizLocation teliaBygg = new QuizLocation(telia, "Et fint brunt bygg");
        quiz.addQuizLocation(teliaBygg);
        quiz.addQuizLocation(bussStopp);
        quiz.addQuizLocation(teliaBygg);

        User user = new User("4740553014");
        user.setFirstName("Telia SimCard");
        quiz.addMember(user);
        /*
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

         */

        user = new User("4790519192");
        user.setFirstName("Per Anders");
        System.out.println("ADDING NEW MEMBER");
        quiz.addMember(user);

        /*
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        user = new User("4798679661");
        user.setFirstName("Patience");
        System.out.println("ADDING NEW MEMBER!!!!!!");
        quiz.addMember(user);


        user = new User("4747351212");
        user.setFirstName("Morra til Shobi");
        System.out.println("Adding new member.");
        quiz.addMember(user);


    }

}

