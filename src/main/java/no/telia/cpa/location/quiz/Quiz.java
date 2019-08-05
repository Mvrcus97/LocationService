package no.telia.cpa.location.quiz;

import no.telia.cpa.location.Polygon;
import no.telia.cpa.location.quiz.cronJob.UpdatePosition;

import java.util.ArrayList;
import java.util.List;

/* The Quiz class is one of the most central classes in this project.
 * The Quiz represents an entire instance of a QuizGame, and acts as a "Game Master" / State-keeper.
 *
 * A game includes a list of QuizLocations, a memberlist, a Leaderboard and also
 * a cron job called UpdatePosition which task is to check through the memberlist and
 * update the game-state dependent on the players' position.
 */

public class Quiz {
    private ArrayList<QuizLocation> quizLocations;
    public ArrayList<User> memberList;
    private Leaderboard leaderboard;
    UpdatePosition updatePosition;

    public Quiz(){
        this.quizLocations = new ArrayList<>();
        this.memberList = new ArrayList<>();
        this.leaderboard = new Leaderboard();


    }

    public void addQuizLocation(QuizLocation quizLocation) {
        quizLocations.add(quizLocation);
    }

    public QuizLocation getQuizLocation(int index) {
        return quizLocations.get(index);
    }

    public ArrayList<QuizLocation> getQuizLocations(){
        return this.quizLocations;
    }


    /*
     * This method is used to add an extra player to the current Quiz.
     * Kills the scheduler, and creates a new one which will spawn a cron-job every sec* seconds.
     */
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
        this.updatePosition = new UpdatePosition(sec, memberList, quizLocations, leaderboard);
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
        return quizLocations.get(user.getLevel()).getPolygon();
    }

    public void createTestQuiz(){
        Polygon actual, margin;
        QuizLocation quizLocation;

        // TELIA
        actual = new Polygon("POLYGON ((10.766385131130164 59.95268321243758,10.766787462482398 59.95189887810627,10.767635040531104 59.95208959124402,10.766385131130164 59.95268321243758))");
        margin = new Polygon("POLYGON ((10.768277942062582 59.95317436842931,10.766904651046957 59.95335701625844,10.764200984359945 59.9532818084507,10.76407223832723 59.95208920468926,10.764673053146566 59.951541237221186,10.766701369001112 59.95143307329731,10.76850381345912 59.95175540925114,10.768277942062582 59.95317436842931))");
        quizLocation = new QuizLocation(actual, margin,"Telia Building");
        quizLocation.setPromo("http://telia-summer-interns.s3-website-eu-west-1.amazonaws.com/telia.html");
        addQuizLocation(quizLocation);

        /*// BUSS STATION
        actual = new Polygon("POLYGON ((10.768163822998076 59.95144956371486,10.76894971023944 59.95151671726368,10.769172333587676 59.951201094401206,10.768397175182372 59.95104663956474,10.768163822998076 59.95144956371486))");
        margin = new Polygon("POLYGON ((10.766820776807435 59.951807221673675,10.769910681592592 59.952110751356564,10.770838725911744 59.95101212189333,10.767555702077516 59.95056621299303,10.766820776807435 59.951807221673675))");
        quizLocation = new QuizLocation(actual, margin,"Busstopp", null);
        addQuizLocation(quizLocation);*/

        /*//STORO
        actual = new Polygon("POLYGON ((10.773668094947652 59.94806411618621,10.773432060554342 59.946828340395136,10.774698063209371 59.946419986964,10.775856777503805 59.94639849453879,10.776994034126119 59.94717221306732,10.77497701294692 59.94805337050831,10.773668094947652 59.94806411618621))");
        margin = new Polygon("POLYGON ((10.774118706062154 59.94558177205659,10.771629616096334 59.94628028595121,10.772058769538717 59.948547668086064,10.774161621406392 59.948902268329626,10.77570657379897 59.94877332322542,10.777101322486715 59.94834350258873,10.778817936256246 59.94720445094744,10.777294441535787 59.94578595456348,10.774118706062154 59.94558177205659))");
        quizLocation = new QuizLocation(actual, margin,"loose som $$$");
        quizLocation.setPromo("http://telia-summer-interns.s3-website-eu-west-1.amazonaws.com/storo.html");
        addQuizLocation(quizLocation);*/

        //Ullevål Stasjon
        actual = new Polygon("POLYGON ((10.731541544208994 59.94626313536613,10.730946093807688 59.94660701390119,10.732104808102122 59.947114765528646,10.73241594434785 59.94728670082493,10.733000665913096 59.94750967808437,10.733531743298045 59.947195360309784,10.731541544208994 59.94626313536613))");
        margin = new Polygon("POLYGON ((10.730795890102854 59.9448969889213,10.727952748547068 59.94643910490592,10.733048945675364 59.94842709283495,10.73737266660737 59.94745997846364,10.730795890102854 59.9448969889213))");
        quizLocation = new QuizLocation(actual, margin,"En stasjon nær et kjent fotballstadion");
        addQuizLocation(quizLocation);

        //COLOSSEUM
        actual = new Polygon("POLYGON((10.711518972859949 59.929732000971384,10.70997402046737 59.92903313842782,10.709287374959558 59.92947396113128,10.710049122319788 59.929887899068795,10.711518972859949 59.929732000971384))");
        margin = new Polygon("POLYGON ((10.710073798675467 59.92881544649093,10.709086745757986 59.92955732034754,10.709880679626394 59.930111026978835,10.712380498428274 59.929976633014796,10.712348311920096 59.9296487094575,10.710073798675467 59.92881544649093))");
        quizLocation = new QuizLocation(actual, margin,"Kuppel");
        quizLocation.setPromo("http://telia-summer-interns.s3-website-eu-west-1.amazonaws.com/colosseum.html");
        addQuizLocation(quizLocation);

        //MAJORSTUA
        actual = new Polygon("POLYGON ((10.71697244026177 59.92874721406999,10.71774491645806 59.929185352624096,10.716934889335562 59.92963154913074,10.715899556655813 59.92940038783433,10.71697244026177 59.92874721406999))");
        margin = new Polygon("POLYGON ((10.715447822938245 59.92916890157403,10.71757213247804 59.92980325174968,10.71979300154237 59.9289753685971,10.716885486970227 59.9279485497504,10.715447822938245 59.92916890157403))");
        quizLocation = new QuizLocation(actual, margin,"Major stua");
        quizLocation.setPromo("http://telia-summer-interns.s3-website-eu-west-1.amazonaws.com/majorstua.html");
        addQuizLocation(quizLocation);

        // BI BUILDING
        actual = new Polygon("POLYGON ((10.7666341990722 59.948959445085976,10.769316408087093 59.9494214934601,10.770324918676693 59.94791712626488,10.767717811514217 59.947412073398965,10.767106267858821 59.948223377978444,10.7666341990722 59.948959445085976))");
        margin = new Polygon("POLYGON ((10.765786621023494 59.949160878485706,10.76962754433282 59.94988080714898,10.773725959707576 59.94678607756447,10.766966792990047 59.94555025412952,10.765786621023494 59.949160878485706))");
        quizLocation = new QuizLocation(actual, margin,"Sossebygget");
        quizLocation.setPromo("http://telia-summer-interns.s3-website-eu-west-1.amazonaws.com/starbucks.html");
        addQuizLocation(quizLocation);

        // TELIA
        actual = new Polygon("POLYGON ((10.766385131130164 59.95268321243758,10.766787462482398 59.95189887810627,10.767635040531104 59.95208959124402,10.766385131130164 59.95268321243758))");
        margin = new Polygon("POLYGON ((10.768277942062582 59.95317436842931,10.766904651046957 59.95335701625844,10.764200984359945 59.9532818084507,10.76407223832723 59.95208920468926,10.764673053146566 59.951541237221186,10.766701369001112 59.95143307329731,10.76850381345912 59.95175540925114,10.768277942062582 59.95317436842931))");
        quizLocation = new QuizLocation(actual, margin,"Telia Building");
        quizLocation.setPromo("http://telia-summer-interns.s3-website-eu-west-1.amazonaws.com/telia.html");
        addQuizLocation(quizLocation);

        /*

        //Forskningsparken
        actual = new Polygon("POLYGON ((10.716848848427958 59.942838875903725,10.71630167778892 59.94247883705616,10.716923950280375 59.94223970461613,10.717503307427592 59.942626614668114,10.716848848427958 59.942838875903725))");
        margin = new Polygon("POLYGON((10.715733049477763 59.94315457839251,10.71479964074058 59.942289412063054,10.717106340493388 59.9413866057371,10.71878003891868 59.94250973606583,10.716258762444681 59.94331041340643,10.715733049477763 59.94315457839251))");
        quizLocation = new QuizLocation(actual, margin,"En park hvor det gjøres forskning :) ");
        addQuizLocation(quizLocation);


       //Blindern
        actual = new Polygon("POLYGON ((10.716632956061858 59.94083200407365,10.71607505658676 59.940450447152564,10.716665142570037 59.940251605890104,10.71734642365982 59.94071914966694,10.716632956061858 59.94083200407365))");
        margin = new Polygon("POLYGON ((10.71708356717636 59.94234744032556,10.71235215047409 59.939982899587086,10.716750973258513 59.93840823688436,10.720511430297393 59.94091798812575,10.71708356717636 59.94234744032556))");
        quizLocation = new QuizLocation(actual, margin,"Tusenvis av studenter går av på dette stoppet ");
        addQuizLocation(quizLocation)


        //Universitetsplassen
        actual = new Polygon("POLYGON ((10.73453040404138 59.91557343717039,10.735855415294736 59.915196967801336,10.735436990688413 59.914801670368355,10.734090521762937 59.91518621147089,10.73453040404138 59.91557343717039))");
        margin = new Polygon("POLYGON ((10.7344982175332 59.916622150755124,10.738542988727659 59.91553041231573,10.736091449688047 59.91373676406511,10.731912568042844 59.91485276349873,10.7344982175332 59.916622150755124))");
        quizLocation = new QuizLocation(actual, margin,"Her er det mange unge advokater");
        addQuizLocation(quizLocation);*/

    }//end createQuizTest



}// end Quiz
