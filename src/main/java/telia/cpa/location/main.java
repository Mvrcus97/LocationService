package telia.cpa.location;

import telia.cpa.location.quiz.*;

import org.slf4j.*;

public class main {

    final static Logger logger = LoggerFactory.getLogger(main.class);

    public static void main(String[] args) {

        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

        SmsInvoker client = new SmsInvoker();
        client.addMessage("4740553014","Test melding");

        /*User user;

        Quiz quiz = new Quiz();
        int sec = 11;

        quiz.createTestQuiz();

        user = new User("4740553014");
        user.setFirstName("Telia");
        quiz.addMember(user, sec);

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

