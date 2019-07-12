package telia.cpa.location;

public class Ray extends Segment{

    //Point point;
    //Point extreme;

    public Ray(Point point){
        super(point,new Point(Double.POSITIVE_INFINITY, point.y));
    }

}
