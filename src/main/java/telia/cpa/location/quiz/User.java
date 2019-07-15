package telia.cpa.location.quiz;

public class User {
    String msisdn;
    String firstName;
    String lastName;


    public User(String msisdn){
        this.msisdn = msisdn;
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

}
