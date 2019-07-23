package telia.cpa.location.quiz;


import telia.cpa.location.Polygon;

/*
     * Class represents a Quiz Location. Represented by a Polygon(area) and a hint.
     * Each Quiz should have a list of Quiz Locations.
     */
public class QuizLocation {
    private Polygon polygon;
    private Polygon margin;
    private String hint;

    public QuizLocation(Polygon polygon, Polygon margin, String hint){
        this.polygon = polygon;
        this.margin = margin;
        this.hint = hint;
    }

    //Setters and Getters.
    public void setHint(String hint){ this.hint = hint; }

    public void setPolygon(Polygon polygon){ this.polygon = polygon; }

    public void setMargin(Polygon margin) { this.margin = margin; }

    public String getHint(){ return this.hint; }

    public Polygon getPolygon(){ return this.polygon; }

    public Polygon getMargin() { return this.margin; }


}
