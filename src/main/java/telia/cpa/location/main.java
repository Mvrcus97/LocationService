package telia.cpa.location;

import telia.cpa.location.quiz.Quiz;
import telia.cpa.location.quiz.QuizLocation;
import telia.cpa.location.quiz.UpdatePosition;
import telia.cpa.location.quiz.User;

import java.util.ArrayList;


public class main {
    public static void main(String[] args) {

        Quiz quiz = new Quiz();
        int sec = 40;

        // BUSS STATION
        Polygon buss = new Polygon("POLYGON ((10.768163822998076 59.95144956371486,10.76894971023944 59.95151671726368,10.769172333587676 59.951201094401206,10.768397175182372 59.95104663956474,10.768163822998076 59.95144956371486))");
        Polygon bussMargin = new Polygon("POLYGON ((10.767496693479188 59.951667543363556,10.76946007047809 59.951850199496775,10.770028698789247 59.95099600480862,10.768000948773988 59.9506145648505,10.767496693479188 59.951667543363556))");
        QuizLocation bussStopp = new QuizLocation(buss, bussMargin,"Busstopp");
        quiz.addQuizLocation(bussStopp);


        // BI BUILDING
        Polygon BI = new Polygon("POLYGON ((10.7666341990722 59.948959445085976,10.769316408087093 59.9494214934601,10.770324918676693 59.94791712626488,10.767717811514217 59.947412073398965,10.767106267858821 59.948223377978444,10.7666341990722 59.948959445085976))");
        Polygon BImargin = new Polygon("POLYGON ((10.765357467581111 59.949246840939196,10.769992324758846 59.950160178239926,10.771666023184139 59.94751680366071,10.767074081350643 59.9466678703589,10.765357467581111 59.949246840939196))");
        QuizLocation bi = new QuizLocation(BI, BImargin,"Sossebygget");
        quiz.addQuizLocation(bi);


        // TELIA BUILDING
        Polygon telia = new Polygon("POLYGON ((10.766114664431711 59.95263143567234,10.766747665759226 59.951847100115806,10.7678956512176 59.95200558037182,10.767943930979868 59.95223389805245,10.766785216685435 59.952814086493575,10.766114664431711 59.95263143567234))");
        Polygon teliaMargin = new Polygon("POLYGON ((10.765470934268137 59.95276573784472,10.766275596972605 59.95158386004976,10.768507194872996 59.951809494520084,10.76864666974177 59.95226075885263,10.767005157824656 59.953082688813886,10.765470934268137 59.95276573784472))");
        QuizLocation teliaBygg = new QuizLocation(telia, teliaMargin,"Et fint brunt bygg");
        quiz.addQuizLocation(teliaBygg);


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
        System.out.println("ADDING PATIENCE \n");
        quiz.addMember(user, sec);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        user = new User("4747351212");
        user.setFirstName("Mamma");
        System.out.println("ADDING MAMMA \n");
        quiz.addMember(user, sec);

    }
}

