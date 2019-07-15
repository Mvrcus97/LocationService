package telia.cpa.location.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leaderboard {
    ArrayList<UserScore> userScores;



    public Leaderboard(){
        userScores = new ArrayList<>();

    }


    public void add(UserScore userScore) {
        if(userScore == null){
            throw new IllegalArgumentException("You cannot insert null into Leaderboard.");
        }
        userScores.add(userScore);
        sort();
    }

    public List<UserScore> getUserScores() {
        return this.userScores;
    }

    //Sort in descending order.
    public void sort(){
        Collections.sort(userScores, (s1, s2) -> s2.getScore() - s1.getScore());
    }

    //get top N UserScores.
    public List<UserScore> getTopN(int n){
        if( n > userScores.size()){
            return userScores;
        }


        ArrayList<UserScore> top = new ArrayList<>();
        for(int i = 0; i < n; i++){
            top.add(i, userScores.get(i));
        }
        return top;
    }




}//end Leaderboard
