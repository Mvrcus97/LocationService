package telia.cpa.location.quiz;

import java.util.ArrayList;
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
    }

    public List<UserScore> getUserScores() {
        return this.userScores;
    }
}
