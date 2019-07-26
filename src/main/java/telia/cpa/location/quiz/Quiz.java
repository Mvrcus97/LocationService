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
        leaderboard.add(user);
        if(this.updatePosition != null) {
            try {
                this.updatePosition.shutdown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.updatePosition = new UpdatePosition(sec, memberList, locations, leaderboard);
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

        // TELIA
        actual = new Polygon("POLYGON ((10.766267113933509 59.952661724072996,10.766787462482398 59.95189887810627,10.767635040531104 59.95208959124402,10.766267113933509 59.952661724072996))");
        margin = new Polygon("POLYGON ((10.768277942062582 59.95317436842931,10.766904651046957 59.95335701625844,10.764200984359945 59.9532818084507,10.76407223832723 59.95208920468926,10.764673053146566 59.951541237221186,10.766701369001112 59.95143307329731,10.76850381345912 59.95175540925114,10.768277942062582 59.95317436842931))");
        quizLocation = new QuizLocation(actual, margin,"purple");
        addQuizLocation(quizLocation);

        // BUSS STATION
        actual = new Polygon("POLYGON ((10.768163822998076 59.95144956371486,10.76894971023944 59.95151671726368,10.769172333587676 59.951201094401206,10.768397175182372 59.95104663956474,10.768163822998076 59.95144956371486))");
        margin = new Polygon("POLYGON ((10.766820776807435 59.951807221673675,10.769910681592592 59.952110751356564,10.770838725911744 59.95101212189333,10.767555702077516 59.95056621299303,10.766820776807435 59.951807221673675))");
        quizLocation = new QuizLocation(actual, margin,"Busstopp");
        addQuizLocation(quizLocation);


        // BI BUILDING
        actual = new Polygon("POLYGON ((10.7666341990722 59.948959445085976,10.769316408087093 59.9494214934601,10.770324918676693 59.94791712626488,10.767717811514217 59.947412073398965,10.767106267858821 59.948223377978444,10.7666341990722 59.948959445085976))");
        margin = new Polygon("POLYGON((10.765786621023494 59.949160878485706,10.76962754433282 59.94988080714898,10.773725959707576 59.94678607756447,10.766966792990047 59.94555025412952,10.765786621023494 59.949160878485706))");
        quizLocation = new QuizLocation(actual, margin,"Sossebygget");
        addQuizLocation(quizLocation);

        //Ullevål Stasjon
        actual = new Polygon("POLYGON((10.731541544208994 59.94626313536613,10.730946093807688 59.94660701390119,10.732104808102122 59.947114765528646,10.73241594434785 59.94728670082493,10.733000665913096 59.94750967808437,10.733531743298045 59.947195360309784,10.731541544208994 59.94626313536613))");
        margin = new Polygon("POLYGON((10.730795890102854 59.9448969889213,10.727952748547068 59.94643910490592,10.733048945675364 59.94842709283495,10.73737266660737 59.94745997846364,10.730795890102854 59.9448969889213))");
        quizLocation = new QuizLocation(actual, margin,"En stasjon nær et kjent fotballstadion");
        addQuizLocation(quizLocation);

        //Forskningsparken
        actual = new Polygon("POLYGON ((10.716848848427958 59.942838875903725,10.71630167778892 59.94247883705616,10.716923950280375 59.94223970461613,10.717503307427592 59.942626614668114,10.716848848427958 59.942838875903725))");
        margin = new Polygon("POLYGON((10.715733049477763 59.94315457839251,10.71479964074058 59.942289412063054,10.717106340493388 59.9413866057371,10.71878003891868 59.94250973606583,10.716258762444681 59.94331041340643,10.715733049477763 59.94315457839251))");
        quizLocation = new QuizLocation(actual, margin,"En park hvor det gjøres forskning :) ");
        addQuizLocation(quizLocation);

        // TELIA
        actual = new Polygon("POLYGON ((10.766267113933509 59.952661724072996,10.766787462482398 59.95189887810627,10.767635040531104 59.95208959124402,10.766267113933509 59.952661724072996))");
        margin = new Polygon("POLYGON ((10.762779815132262 59.95461296812349,10.770933730537536 59.954903042789994,10.77256451361859 59.9507558080848,10.762028796608092 59.95057314592042,10.762779815132262 59.95461296812349))");
        quizLocation = new QuizLocation(actual, margin,"purple");
        addQuizLocation(quizLocation);

        //--------------------------------------

        /*//Blindern
        actual = new Polygon("POLYGON ((10.716632956061858 59.94083200407365,10.71607505658676 59.940450447152564,10.716665142570037 59.940251605890104,10.71734642365982 59.94071914966694,10.716632956061858 59.94083200407365))");
        margin = new Polygon("POLYGON ((10.71708356717636 59.94234744032556,10.71235215047409 59.939982899587086,10.716750973258513 59.93840823688436,10.720511430297393 59.94091798812575,10.71708356717636 59.94234744032556))");
        quizLocation = new QuizLocation(actual, margin,"Tusenvis av studenter går av på dette stoppet ");
        addQuizLocation(quizLocation);

        //Majorstua
        actual = new Polygon("POLYGON ((10.713906275808199 59.93051164353684,10.714764582692965 59.930839558563946,10.716583120405062 59.92974291199633,10.715590703069552 59.929439177491936,10.713906275808199 59.93051164353684))");
        margin = new Polygon("POLYGON ((10.71011899667917 59.93085702935555,10.712184297620638 59.9323111045294,10.715665804921969 59.93303408675863,10.720306026517733 59.93184344220332,10.720826375066622 59.92957760550919,10.720188009321078 59.92762880840415,10.715472685872896 59.927099253411164,10.710542785703524 59.9281825472242,10.71011899667917 59.93085702935555))");
        quizLocation = new QuizLocation(actual, margin,"Major Living");
        addQuizLocation(quizLocation);

        //Universitetsplassen
        actual = new Polygon("POLYGON ((10.73453040404138 59.91557343717039,10.735855415294736 59.915196967801336,10.735436990688413 59.914801670368355,10.734090521762937 59.91518621147089,10.73453040404138 59.91557343717039))");
        margin = new Polygon("POLYGON ((10.7344982175332 59.916622150755124,10.738542988727659 59.91553041231573,10.736091449688047 59.91373676406511,10.731912568042844 59.91485276349873,10.7344982175332 59.916622150755124))");
        quizLocation = new QuizLocation(actual, margin,"Her er det mange unge advokater");
        addQuizLocation(quizLocation);*/

    }//end createQuizTest

}// end Quiz
