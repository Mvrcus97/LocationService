package telia.cpa.location.quiz;

public class UserScore {
    User user;
    int score;

    public UserScore(User user){
        this.user = user;
        this.score = 0;
    }

    public void setScore(int score) { this.score = score; }
    public void updateScore(int extra){this.score += extra;}
    public int getScore() {
        return score;
    }

    public User getUser() {
        return user;
    }




}
