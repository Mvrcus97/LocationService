package telia.cpa.location.quiz;

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
        if(extra > 85) extra = 100;
        System.out.println("Sigmoid is:" + sigmoid);
        System.out.println("Updated score by: " + extra);
        this.score += extra;
    }

    public int getLevel(){
        return this.level;
    }

    public void updateLevel(){
        this.level +=1;
        updateScore();
        this.timeLastFound = System.currentTimeMillis();
    }
    public void resetLevel() { this.level = 0; }

    public int getMarginCount() {return this.marginCount; }
    public void updateMarginCount() { this.marginCount++; }
    public void resetMarginCount() { this.marginCount = 0; }

    public double getTimeLastFound(){return this.timeLastFound;}

    private double createTimeConstant(){
        double second = (System.currentTimeMillis() - timeLastFound);
        second = second/1000;
        System.out.println("Second:" + second);
        return second;///(60*60);

    }

    public double getTimeConstant() {
        double constant = Math.round(6 - createTimeConstant());
        if (constant < 0) constant = 0;
        System.out.println("Time constant: " + constant);
        return constant;
    }


    public double sigmoid(double x){
        return (1/( 1 + Math.pow(Math.E,(-0.5*x))));
    }
}
