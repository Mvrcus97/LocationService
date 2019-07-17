package telia.cpa.location.quiz;

import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private ArrayList<QuizLocation> locations;
    private Leaderboard leaderboard;

    public Quiz(){
        this.locations = new ArrayList<>();
        leaderboard = new Leaderboard();

    }


    public void addQuizLocation(QuizLocation quizLocation) {locations.add(quizLocation); }
    public QuizLocation getQuizLocation(int index)         {return locations.get(index); }

    public List <User> getLeaderboard(){
        return leaderboard.getUserScores();
    }

    public List<User> getTopN(int n){
        return leaderboard.getTopN(n);
    }


    public void addUser(User user){
        leaderboard.add(user);
    }


















}// end Quiz
