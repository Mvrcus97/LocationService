package telia.cpa.location.quiz;

public class User {
    String msisdn;
    String firstName;
    String lastName;
    String userName;
    int score;
    int level;


    public User(String msisdn){
        this.msisdn = msisdn;
        this.score = 0;
        this.level = 0;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){ return this.userName; }

    public void setScore(int score) { this.score = score; }
    public void updateScore(int extra){this.score += extra;}
    public int getScore() {
        return score;
    }

    public int getLevel(){
        return this.level;
    }

    public void updateLevel(){
        this.level +=1;
    }


}
