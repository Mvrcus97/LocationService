package no.telia.cpa.location.quiz;



/* Class represents a User, with a lot of information related to a user/player.
 *
 * Calculating score is based on a customized sigmoid function. The score system as of 31.07.2019
 * works as follows:
 *
 * - The score is dependent on time. The more time a player uses to find the next location, the less
 *   points (s)he receives.
 * - Max points per level/location is 100. Min score is 50.
 * - If the next location isn't found within 6 hours, a player receives min score of 50.
 * - If the player finds the next location between 0-6 hours, the score will be scattered
 *   between 100-50 points, following an inverse sigmoid function.
 */

public class User {
    String msisdn;
    String firstName;
    String lastName;
    String userName;
    int score;
    int level;
    int marginCount;
    double timeLastFound;


    public User(String msisdn){
        this.msisdn = msisdn;
        this.score = 0;
        this.level = 0;
        this.timeLastFound = System.currentTimeMillis();
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public int getScore() {
        return score;
    }
    public void updateScore(int extra){this.score += extra;}
    public void updateScore(){
        double sigmoid = sigmoid(getTimeConstant());
        int extra = (int) Math.round(sigmoid * 100);
        //if(extra > 85) extra = 100; //otherwise impossible to receive 100% score. disabled currently for testing purposes.
        // System.out.println("Sigmoid is:" + sigmoid);
        // System.out.println("Updated score by: " + extra);
        this.score += extra;
    }

    public int getLevel(){
        return this.level;
    }

    public void updateLevel(){
        this.level += 1;
        updateScore();
        resetMarginCount();
        this.timeLastFound = System.currentTimeMillis();
        //System.out.println("UpdateLevel completed");
    }
    public void resetLevel() { this.level = 0; }

    public int getMarginCount() {return this.marginCount; }
    public void updateMarginCount() { this.marginCount++; }
    public void resetMarginCount() { this.marginCount = 0; }

    public double getTimeLastFound(){return this.timeLastFound;}

    private double createTimeConstant(){
        double second = (System.currentTimeMillis() - timeLastFound);
        second = second/1000;
        //System.out.println("Second:" + second);
        return second;///(60*60);

    }

    public double getTimeConstant() {
        double constant = Math.round(30*60 - createTimeConstant());
        if (constant < 0) constant = 0;
        //System.out.println("Time constant: " + constant);
        return constant;
    }

    public double sigmoid(double x){
        return (1/( 1 + Math.pow(Math.E,(-0.5*x))));
    }

}
