package telia.cpa.location.quiz;

import telia.cpa.location.Polygon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private ArrayList<QuizLocation> locations;
    public ArrayList<User> memberList;
    private Leaderboard leaderboard;
    UpdatePosition updatePosition;

    public Quiz(){
        this.locations = new ArrayList<>();
        this.memberList = new ArrayList<>();
        this.leaderboard = new Leaderboard();
    }

    public void addQuizLocation(QuizLocation quizLocation) {
        locations.add(quizLocation);
    }

    public QuizLocation getQuizLocation(int index) {
        return locations.get(index);
    }

    public ArrayList<QuizLocation> getQuizLocations(){
        return this.locations;
    }

    public void addMember(User user, int sec){
        memberList.add(user);
        if(this.updatePosition != null) {
            //kill QuartzJob
            this.updatePosition.shutdown();
        }
        // member to memberList
        this.updatePosition = new UpdatePosition(sec, memberList, locations);
    }

    public void setMemberList(ArrayList<User> memberList){
        this.memberList = memberList;
    }

    public ArrayList<User> getMemberList(){
        return this.memberList;
    }

    public List <User> getLeaderboard(){
        return leaderboard.getUserScores();
    }

    public List<User> getTopN(int n){
        return leaderboard.getTopN(n);
    }

    public void addToLeaderboard(User user){
        leaderboard.add(user);
    }

    public Polygon getLevel(User user){
        return locations.get(user.getLevel()).getPolygon();
    }

    public void createTestQuiz(){
        Polygon actual, margin;
        QuizLocation quizLocation;

        // BUSS STATION
        actual = new Polygon("POLYGON ((10.768163822998076 59.95144956371486,10.76894971023944 59.95151671726368,10.769172333587676 59.951201094401206,10.768397175182372 59.95104663956474,10.768163822998076 59.95144956371486))");
        margin = new Polygon("POLYGON ((10.767496693479188 59.951667543363556,10.76946007047809 59.951850199496775,10.770028698789247 59.95099600480862,10.768000948773988 59.9506145648505,10.767496693479188 59.951667543363556))");
        quizLocation = new QuizLocation(actual, margin,"Busstopp");
        addQuizLocation(quizLocation);


        // BI BUILDING
        actual = new Polygon("POLYGON ((10.7666341990722 59.948959445085976,10.769316408087093 59.9494214934601,10.770324918676693 59.94791712626488,10.767717811514217 59.947412073398965,10.767106267858821 59.948223377978444,10.7666341990722 59.948959445085976))");
        margin = new Polygon("POLYGON ((10.765357467581111 59.949246840939196,10.769992324758846 59.950160178239926,10.771666023184139 59.94751680366071,10.767074081350643 59.9466678703589,10.765357467581111 59.949246840939196))");
        quizLocation = new QuizLocation(actual, margin,"Sossebygget");
        addQuizLocation(quizLocation);


        // TELIA BUILDING
        actual = new Polygon("POLYGON ((10.766114664431711 59.95263143567234,10.766747665759226 59.951847100115806,10.7678956512176 59.95200558037182,10.767943930979868 59.95223389805245,10.766785216685435 59.952814086493575,10.766114664431711 59.95263143567234))");
        margin = new Polygon("POLYGON ((10.765470934268137 59.95276573784472,10.766275596972605 59.95158386004976,10.768507194872996 59.951809494520084,10.76864666974177 59.95226075885263,10.767005157824656 59.953082688813886,10.765470934268137 59.95276573784472))");
        quizLocation = new QuizLocation(actual, margin,"Et fint brunt bygg");
        addQuizLocation(quizLocation);

        //Ullevål Stasjon
        actual = new Polygon("POLYGON ((10.731541544208994 59.94626313536613,10.731123119602671 59.94647268677298,10.73215845228242 59.947077154563615,10.732453495274058 59.947230284654154,10.732920199642649 59.94737804108849,10.733531743298045 59.947195360309784,10.731541544208994 59.94626313536613))");
        margin = new Polygon("POLYGON ((10.731332331905833 59.94577820683899,10.72964790464448 59.946503582060636,10.732920199642649 59.94812621583186,10.735033780346384 59.94728804406595,10.731332331905833 59.94577820683899))");
        quizLocation = new QuizLocation(actual, margin,"En stasjon nær et kjent fotballstadion");
        addQuizLocation(quizLocation);

        //Forskningsparken
        actual = new Polygon("POLYGON((10.716848848427958 59.942838875903725,10.71630167778892 59.94247883705616,10.716923950280375 59.94223970461613,10.717503307427592 59.942626614668114,10.716848848427958 59.942838875903725))");
        margin = new Polygon("POLYGON((10.716366050805277 59.94310621565301,10.715389726723856 59.94233240222734,10.717074153985209 59.94178964731286,10.718479631509013 59.94281603773474,10.716591356362528 59.94326205089428,10.716366050805277 59.94310621565301))");
        quizLocation = new QuizLocation(actual, margin,"En park hvor det gjøres forskning :) ");
        addQuizLocation(quizLocation);

        //Blindern
        actual = new Polygon("POLYGON((10.716632956061858 59.94083200407365,10.71607505658676 59.940450447152564,10.716665142570037 59.940251605890104,10.71734642365982 59.94071914966694,10.716632956061858 59.94083200407365))");
        margin = new Polygon("POLYGON((10.712200390874727 59.93074951664571,10.715236651479586 59.93133545668892,10.71835874277292 59.92955610216577,10.715515601217135 59.92867982906418,10.712200390874727 59.93074951664571))");
        quizLocation = new QuizLocation(actual, margin,"Tusenvis av studenter går av på dette stoppet ");
        addQuizLocation(quizLocation);

        //Majorstua
        actual = new Polygon("POLYGON((10.713906275808199 59.93051164353684,10.714764582692965 59.930839558563946,10.716583120405062 59.92974291199633,10.715590703069552 59.929439177491936,10.713906275808199 59.93051164353684))");
        margin = new Polygon("POLYGON((10.716386192832488 59.94121221311708,10.715291851554412 59.94034162201476,10.716643684897917 59.93992781452596,10.718263739142913 59.94089514863364,10.716386192832488 59.94121221311708))");
        quizLocation = new QuizLocation(actual, margin,"Major Lazer");
        addQuizLocation(quizLocation);

        //Universitetsplassen
        actual = new Polygon("POLYGON((10.73453040404138 59.91557343717039,10.735855415294736 59.915196967801336,10.735436990688413 59.914801670368355,10.734090521762937 59.91518621147089,10.73453040404138 59.91557343717039))");
        margin = new Polygon("POLYGON((10.734348013828367 59.9159566248218,10.73325367255029 59.915042345216335,10.73552818579492 59.91441846938351,10.73603244108972 59.91429476847198,10.737298443744749 59.915327388030434,10.734348013828367 59.9159566248218))");
        quizLocation = new QuizLocation(actual, margin,"Her er det mange unge advokater");
        addQuizLocation(quizLocation);

        //Universitetsplassen
        actual = new Polygon("POLYGON((10.750084217399376 59.91150513805998,10.749574597686546 59.910894642901816,10.750432904571312 59.910746723883136,10.751173194259422 59.91135991115456,10.750084217399376 59.91150513805998))");
        margin = new Polygon("POLYGON((10.749864276260155 59.911866857868105,10.748887952178734 59.9107534474892,10.75073331198098 59.910398439227336,10.752010043472069 59.91149572522425,10.749864276260155 59.911866857868105))");
        quizLocation = new QuizLocation(actual, margin,"Her er det mange unge advokater");
        addQuizLocation(quizLocation);
    }//end createQuizTest

}// end Quiz
