package no.telia.cpa.location;

import no.telia.cpa.location.clients.SmsInvoker;
import no.telia.cpa.location.quiz.*;

import org.slf4j.*;

public class Main {

    final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

       /* System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");*/

        User user;

        Quiz quiz = new Quiz();
        int sec = 11;

        quiz.createTestQuiz();

        user = new User("4740553014");
        user.setFirstName("Telia Test Phone");
        quiz.addMember(user, sec);

        /*  try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        user = new User("4740604325");
        user.setFirstName("Marcus ;) ");
        quiz.addMember(user, sec);

       /*try {
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

