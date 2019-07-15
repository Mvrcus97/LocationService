package telia.cpa.location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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

    /*
     * Transfrom a polygon string in the Well-Known Text format
     * to a Polygon object.
     */
    public void createPolygonFromWKT(String WKT){
        WKT = WKT.replaceAll(",", " ");
        WKT = WKT.replaceAll("[((]", "");
        WKT = WKT.replaceAll("[))]", "");

        Scanner scanner = new Scanner(WKT);
        int pair_pos = 0;
        double[] pair = new double[2];
        while (scanner.hasNext()){
            if (scanner.hasNextDouble()) {
                pair[pair_pos] = scanner.nextDouble();
                //System.out.println("Found: " + pair[pair_pos]);
                pair_pos ++;
                if(pair_pos == 2){
                    points.add( new Point(pair[0], pair[1]));
                    System.out.println("New pair: "+ pair[0] + ", " + pair[1]);
                    pair_pos = 0;
                }
            }
            else{
                scanner.next();
            }
        }
        scanner.close();
    }


    boolean isInside(Point p) {

        if (points == null || p == null){
            return false;
        }

        int n = size();
        if (n < 3) return false;

        Point extreme = new Point(Double.POSITIVE_INFINITY, p.y);
        Segment ray = new Segment(p, extreme);

        if (p.x < minX || p.x > maxX ||
            p.y < minY || p.y > maxY) {
            return false;
        }

        for (int i = 0; i < points.size(); i++){
            if (points.get(i) == p){
                return true;
            }
        }

        int count = 0;
        int i = 0;

        do {
            int next = (i + 1) % n;

            Segment seg = new Segment(points.get(i), points.get(next));
            if (seg.doIntersect(ray)) {

                // if point p is colinear with i-next, then check if it lies on i-next
                if (seg.orientation(p) == 0) {
                    return seg.onSegment(p);
                }
                count++;
            }
            i = next;
        } while (i != 0);

        //return true if count = odd
        return count % 2 != 0;

    }

}//end Polygon
