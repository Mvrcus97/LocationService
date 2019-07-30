package telia.cpa.location.quiz;


import telia.cpa.location.Polygon;

import java.util.ArrayList;
import java.util.List;

/*
     * Class represents a Quiz Location. Represented by a Polygon(area) and a hint.
     * Each Quiz should have a list of Quiz Locations.
     */
public class QuizLocation {
    private Polygon polygon;
    private Polygon margin;
    private String hint;
    private Promo promo;


    public QuizLocation(Polygon polygon, Polygon margin, String hint, Promo promo){
        this.polygon = polygon;
        this.margin = margin;
        this.hint = hint;
        this.promo = promo;
    }

    //Setters and Getters.
    public void setHint(String hint){ this.hint = hint; }

    public void setPolygon(Polygon polygon){ this.polygon = polygon; }

    public void setMargin(Polygon margin) { this.margin = margin; }

    public String getHint(){ return this.hint; }

    public Polygon getPolygon(){ return this.polygon; }

    public Polygon getMargin() { return this.margin; }

    public Promo getPromo(){ return this.promo; }

    //public ArrayList<Promo> getPromos() {return this.promos; }


}
