package telia.cpa.location.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* This class represents a Leaderboard.
 * The Leaderboard should be updated/sorted (manually) for each time a User.score is updated.
 *
 * Also includes function to return or print the top N players.
 */

public class Leaderboard {
    ArrayList<User> userScores;


    public Leaderboard(){
        userScores = new ArrayList<>();
    }


    public void add(User userScore) {
        if(userScore == null){
            throw new IllegalArgumentException("You cannot insert null into Leaderboard.");
        }
        userScores.add(userScore);
        sort();
    }

    public List<User> getUserScores() {
        return this.userScores;
    }

    //Sort in descending order.
    public void sort(){
        Collections.sort(userScores, (s1, s2) -> s2.getScore() - s1.getScore());
    }

    //get top N UserScores.
    public List<User> getTopN(int n){
        if( n > userScores.size()){
            return userScores;
        }

        ArrayList<User> top = new ArrayList<>();
        for(int i = 0; i < n; i++){
            top.add(i, userScores.get(i));
        }
        return top;
    }//end getTopN

    public void print(int max){
        if(max > userScores.size()) max = userScores.size();

        System.out.println("\n----------------LEADERBOARD---------------------");
        User u;
        for(int i = 0 ; i < max; i++){
            u = userScores.get(i);
            System.out.println( u.getScore() + " - "  + u.getFirstName());
        }
        System.out.println("------------------------------------------------\n");
    }//end print
}//end Leaderboard
