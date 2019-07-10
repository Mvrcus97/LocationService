package telia.cpa.location;

public class CheckPosition {

    // check if q lies on segment p-r
    public boolean onSegment(Point p, Point q, Point r){

        if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x,r.x) &&
            q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y,r.y)){
            return true;
        }
            return false;
    }

    // 0 - colinear, 1 - clockwise, 2 - counterclockwise
    public int orientation(Point p, Point q, Point r){
        double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

        if (val == 0) return 0;
        return (val > 0) ? 1 : 2;

    }

    // true if line segment (p1q1) and (p2q2) intersect
    public boolean doIntersect(Point p1, Point q1, Point p2, Point q2){

        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q1, p1);

        //general case
        if (o1 != o2 && o3 != o4) return  true;

        if (o1 == 0 && onSegment(p1, p2, q1)) return true;

        if (o2 == 0 && onSegment(p1, q2, q1)) return true;

        if (o3 == 0 && onSegment(p2, q1, q2)) return true;

        if (o4 == 0 && onSegment(p2, q1, q2)) return true;

        return false;
    }

    // n vertices
    boolean isInside(Point polygon[], int n, Point p){

        if (n < 3) return false;

        Point extreme = new Point(Double.POSITIVE_INFINITY, p.getY());

        // count intersections of point with sides of polygon
        int count = 0;
        int i = 0;

        do {
            int next = (i + 1) % n;

            // check if p-extreme intersects with polygon[i]-polygon[next]
            if (doIntersect(polygon[i], polygon[next], p, extreme)){

                // if point p is colinear with i-next, then check if it lies on i-next
                // if yes -> return true, otherwise false
                if (orientation(polygon[i], p, polygon[next]) == 0){
                    return onSegment(polygon[i], p, polygon[next]);
                }

                count++;

            }
            i = next;
        } while (i != 0);

        //return true if count = odd
        return count % 2 != 0;

    }

}
