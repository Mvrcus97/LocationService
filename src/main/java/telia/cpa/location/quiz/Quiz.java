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
            this.updatePosition.stop();
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



}// end Quiz
