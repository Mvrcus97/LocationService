package no.telia.cpa.location;


public class Segment {

        final Point a;
        final Point b;

        public Segment(Point a, Point b){
            this.a = a;
            this.b = b;
        }

        public double maxX(){
            return Math.max(a.x, b.x);
        }

        public double maxY(){
            return Math.max(a.y, b.y);
        }

        public double minX(){
            return Math.min(a.x, b.x);
        }

        public double minY(){
            return Math.min(a.y, b.y);
        }

        public boolean isBetween(Point p){
            return p.x <= maxX() && p.x >= minX()
                    && p.y <= maxY() && p.y >= minY();
        }

        public boolean onSegment(Point point) {

            if (point == null){
                return false;
            }

            if (!isBetween(point)){
                return false;
            }

            if (isBetween(point)) {
                //vertical segment
                if (Math.abs(b.x - a.x) < 0.0001){
                    return true;
                }
            }

            double m = (b.y - a.y)/(b.x - a.x); // slope
            double c = -(m * a.x) + a.y; // interceptY


            if (Math.abs((point.y - (m * point.x + c))) <= 0.0001){
                return true;
            }

            return false;
        }

        // 0 - colinear, 1 - clockwise, 2 - counterclockwise
        public int orientation(Point point) {
            //double val = (b.y - a.y) * (point.x - b.x) - (b.x - a.x) * (point.y - b.y);
            double val = (a.y - b.y) * (point.x - a.x) - (a.x - b.x) * (point.y - a.y);
            if (val == 0) return 0;

            return (val > 0) ? 1 : 2;

        }

    public boolean doIntersect(Segment other) {

        int o1 = orientation(other.a);
        int o2 = orientation(other.b);

        int o3 = other.orientation(a);
        int o4 = other.orientation(b);

        //general case
        if (o1 != o2 && o3 != o4) return true;

        //special case
        if (o1 == 0 && onSegment(other.a)) return true;

        if (o2 == 0 && onSegment(other.b)) return true;

        //if (o3 == 0 && other.onSegment(a)) return true;
        //if (o4 == 0 && other.onSegment(b)) return true;

        return false;
    }

}
