package no.telia.cpa.location;

import no.telia.cpa.location.quiz.*;

import org.slf4j.*;

public class main {

    final static Logger logger = LoggerFactory.getLogger(main.class);

    public static void main(String[] args) {

        Polygon actual, margin;
        QuizLocation quizLocation;


        User user;

        Quiz quiz = new Quiz();
        int sec = 11;

        quiz.createTestQuiz();

        user = new User("4740553014");
        user.setFirstName("Telia Test Phone");
        quiz.addMember(user, sec);


        /*user = new User("4794430236");
        user.setFirstName("Soma-Loma-Poma");
        quiz.addMember(user, sec);


         /*  try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    */
        user = new User("4740604325");
        user.setFirstName("Marcus ;) ");
        quiz.addMember(user, sec);
/*6
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

