package telia.cpa.location;

public class CheckPosition {

    // check if q lies on segment p-r
    /*public boolean onSegment(Point start, Point q, Point end) {

        if (q.x <= Math.max(start.x, end.x) && q.x >= Math.min(start.x, end.x) &&
                q.y <= Math.max(start.y, end.y) && q.y >= Math.min(start.y, end.y)) {
            return true;
        }
        return false;
    }*/

    public boolean onSegment(Segment s, Point p) {

        if (s == null || p == null){
            return false;
        }

        /*}

        if (p.x <= Math.max(s.a.x, s.b.x) && p.x >= Math.min(s.a.x, s.b.x) &&
                p.y <= Math.max(s.a.y, s.b.y) && p.y >= Math.min(s.a.y, s.b.y)) {

            return true;
        }*/
        return true;
    }

    // 0 - colinear, 1 - clockwise, 2 - counterclockwise
    public int orientation(Point p, Point q, Point r) {
        double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

        if (val == 0) return 0;
        return (val > 0) ? 1 : 2;

    }


    public boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {

        /*int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q1, p1);

        //general case
        if (o1 != o2 && o3 != o4) return true;

        //special case
        if (o1 == 0 && onSegment(p1, p2, q1)) return true;

        if (o2 == 0 && onSegment(p1, q2, q1)) return true;

        if (o3 == 0 && onSegment(p2, q1, q2)) return true;

        if (o4 == 0 && onSegment(p2, q1, q2)) return true;*/

        return false;
    }

    // n vertices
    boolean isInside(Point polygon[], Point p) {

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
                /*if (orientation(polygon[i], p, polygon[next]) == 0) {
                    return onSegment(polygon[i], p, polygon[next]);
                }*/

                count++;

            }
            i = next;
        } while (i != 0);

        //return true if count = odd
        return count % 2 != 0;

    }

}
