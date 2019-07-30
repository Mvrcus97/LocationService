package telia.cpa.location.quiz;

public class Promo {

    String owner;
    int prosent;
    String text;

    public Promo(String owner, int promo){
        this.owner = owner;
        this.prosent = promo;
        this.text = "You get " + promo + " % off from " + owner + "!";
    }

    public void setProsent(int prosent) {
        this.prosent = prosent;
    }

    public void setOwner() {
        this.owner = owner;
    }

    public String getProsent() {
        return text;
    }

    public String getOwner() {
        return owner;
    }

    public String getPromoText(){
        return text;
    }
}
