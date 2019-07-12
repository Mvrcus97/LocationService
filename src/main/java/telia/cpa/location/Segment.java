package telia.cpa.location;


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
                System.out.println("WIth abs: " + Math.abs(b.x - a.x));
                System.out.println("Without abs: " + (b.x - a.x));
                if (Math.abs(b.x - a.x) < 0.0001){
                    return true;
                }
            }

            double m = (b.y - a.y)/(b.x - a.x); // slope
            double c = -(m * a.x) + a.y; // interceptY

            System.out.println("calcY: " + (m * point.x + c));
            System.out.println("Y: " + point.y);

        if (Math.abs((point.y - (m * point.x + c))) <= 0.0001){
            return true;
        }

        return false;
        }

        public void print(){
            Point a = new Point(0,0);
            Point b = new Point(5,5);
            Point point = new Point(1,2);

            double m = (b.y - a.y)/(b.x - a.x); // slope
            double c = -(m * a.x) + a.y; // interceptY

            double calcY = m * point.x + c;
            double diff = point.y - (m * point.x + c);

            System.out.println("CalcY: " + calcY);
            System.out.println("Diff btwn calculatedY and Y: " + diff);
        }

}
