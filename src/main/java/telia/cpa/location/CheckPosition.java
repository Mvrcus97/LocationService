package telia.cpa.location;

public class CheckPosition {

    // n vertices
    /*boolean isInside(Point polygon[], Point p) {

        if (polygon == null || p == null){
            return false;
        }

        int n = polygon.length;

        if (n < 3) return false;


        Point extreme = new Point(Double.POSITIVE_INFINITY, p.y);

        // count intersections of point with sides of polygon
        int count = 0;
        int i = 0;

        do {
            int next = (i + 1) % n;

            // check if p-extreme intersects with polygon[i]-polygon[next]
            if (doIntersect(polygon[i], polygon[next], p, extreme)) {

                // if point p is colinear with i-next, then check if it lies on i-next
                // if yes -> return true, otherwise false
                if (orientation(polygon[i], p, polygon[next]) == 0) {
                    return onSegment(polygon[i], p, polygon[next]);
                }

                count++;

            }
            i = next;
        } while (i != 0);

        //return true if count = odd
        return count % 2 != 0;

    }*/

}
