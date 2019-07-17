package telia.cpa.location.quiz;

import telia.cpa.location.Polygon;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private ArrayList<QuizLocation> locations;
    public ArrayList<User> memberList;
    private Leaderboard leaderboard;

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

    public void addMember(User user){
        memberList.add(user);
    }

    public void setMemberList(ArrayList<User> memberList){
        this.memberList = memberList;
    }

    public List <User> getLeaderboard(){
        return leaderboard.getUserScores();
    }

    public List<User> getTopN(int n){
        return leaderboard.getTopN(n);
    }

    public void addUser(User user){
        leaderboard.add(user);
    }

    public Polygon getLevel(User user){
        return locations.get(user.getLevel()).getPolygon();
    }


}// end Quiz
