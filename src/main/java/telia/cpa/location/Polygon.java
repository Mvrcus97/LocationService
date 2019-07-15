package telia.cpa.location;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * This class represent a Polygon.
 * It can be used to interact with a group of Points.
 */

public class Polygon {
    ArrayList<Point> points;
    double minX, maxX, minY, maxY;

    public Polygon(){
        this.points = new ArrayList<>();
        maxX = maxY = 0;
        minX = minY = 9999999;
    }

    public Polygon(Point[] points){
        this.points = new ArrayList<>(Arrays.asList(points));
        maxX = maxY = 0;
        minX = minY = 9999999;
    }


    public void addPoint(Point p){
        updateMinMax(p);
        points.add(p);
    }

    private void updateMinMax(Point p){
        double x = p.getX();
        double y = p.getY();

        if(x > maxX) maxX = x;
        if(y > maxY) maxY = y;
        if(x < minX) minX = x;
        if(y < minY) minY = y;
    }

    public ArrayList<Point> getPoints(){return this.points;}
    public Object[] getPointsAsArray(){return this.points.toArray();}
    public int size(){
        return points.size();
    }


    public double getMaxX(){return this.maxX;}
    public double getMaxY(){return this.maxY;}
    public double getMinX(){return this.minX;}
    public double getMinY(){return this.minY;}


}//end Polygon
