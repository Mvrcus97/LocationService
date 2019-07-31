package no.telia.cpa.location.quiz;


import no.telia.cpa.location.Polygon;

/*
     * Class represents a Quiz Location. Including the actual polygon and a margin polygon,
     * in addition to a hint of where the area is located and also a (list) of promotions.
     *
     * An area is represented by an actual polygon defining the area, but also a margin
     * which acts as an extended polygon. Because our coverageArea API is 50-100m off by accuracy,
     * we included a margin area which acts as a safety net for the unfortunate accurracy.
     * If a player is located within the margin area over a duration of 5 "cronjob-updates",
     * the player is most likely in the correct location and they should level up.
     *
     * Each location should have their own promotions. A promotion is a way of introducing
     * location based advertisement for shop-owners who wish to partake. Example of promotion
     * could be as follows: Player arrives at secret location near telia-store -> player recieves
     * a promotion of X-percent off Y-item(s).
     * This will most likely be very interesting for shop-owners if the game succeeds in popularity.
     *
     * Each Quiz should have a list of Quiz Locations.
     */


public class QuizLocation {
    private Polygon polygon;
    private Polygon margin;
    private String hint;
    private String promo;


    public QuizLocation(Polygon polygon, Polygon margin, String hint){
        this.polygon = polygon;
        this.margin = margin;
        this.hint = hint;
        this.promo = null;
    }

    //Setters and Getters.
    public void setHint(String hint){ this.hint = hint; }

    public void setPromo(String promo){this.promo = promo;}
    public void setPolygon(Polygon polygon){ this.polygon = polygon; }

    public void setMargin(Polygon margin) { this.margin = margin; }

    public String getHint(){ return this.hint; }

    public Polygon getPolygon(){ return this.polygon; }

    public Polygon getMargin() { return this.margin; }

    public String getPromo(){ return this.promo; }

    //public ArrayList<Promo> getPromos() {return this.promos; }
}
