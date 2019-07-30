package telia.cpa.location;

import telia.cpa.location.quiz.*;

import org.slf4j.*;

public class main {

    final static Logger logger = LoggerFactory.getLogger(main.class);

    public static void main(String[] args) {


        /*Promo promo;
        Polygon actual, margin;
        QuizLocation quizLocation;


        User user;

        Quiz quiz = new Quiz();
        int sec = 11;

        quiz.createTestQuiz();

        user = new User("4740553014");
        user.setFirstName("Telia");
        //quiz.addMember(user, sec);

        promo = new Promo("Telia",40);
        actual = new Polygon("POLYGON ((10.766267113933509 59.952661724072996,10.766787462482398 59.95189887810627,10.767635040531104 59.95208959124402,10.766267113933509 59.952661724072996))");
        margin = new Polygon("POLYGON ((10.768277942062582 59.95317436842931,10.766904651046957 59.95335701625844,10.764200984359945 59.9532818084507,10.76407223832723 59.95208920468926,10.764673053146566 59.951541237221186,10.766701369001112 59.95143307329731,10.76850381345912 59.95175540925114,10.768277942062582 59.95317436842931))");
        quizLocation = new QuizLocation(actual, margin,"purple", promo);
        quiz.addQuizLocation(quizLocation);

        promo = quiz.getQuizLocations().get(user.getLevel()).getPromo(user.getLevel());
        System.out.println("PROMO: " + promo.getPromoText());*/

        User user;

        Quiz quiz = new Quiz();
        int sec = 11;

        quiz.createTestQuiz();

        user = new User("4740553014");
        user.setFirstName("Telia");
        quiz.addMember(user, sec);

        /*user = new User("4794430236");
        user.setFirstName("Soma");
        quiz.addMember(user, sec);*/

        /*
           try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        user = new User("4740604325");
        user.setFirstName("TeliaDue");
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
        quiz.addMember(user, sec);*/

    }
}

