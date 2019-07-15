package telia.cpa.location;

public class main {
    public static void main(String[] args) {
        CoverageAreaInvoker client = new CoverageAreaInvoker();

        client.setMsisdn("4793859166");
        System.out.println("Location of number: " + client.getMsisdn() + " is:  " + client.getLocation());
        System.out.println("Country: " + client.getCountry() + ", County: " + client.getCounty() + ", Council: " + client.getCouncil());
        System.out.println();

        client.setMsisdn("4792291073");
        System.out.println();
        System.out.println(client.toString());
        System.out.println(client.getLocation());

        System.out.println(client.getMultiPolygon());

        Point[] points = client.getPolygonAsPoints();
        System.out.println("List of points generated: ");
        /*for(int i = 0; i < points.length; i++){
            System.out.println("(" + points[i].getX() +", " + points[i].getY() + ")");
        }*/

        System.out.println();
        Polygon storoKjopesenter = new Polygon();
        storoKjopesenter.addPoint(new Point(10.775379841289122, 59.94631989892596 ));
        storoKjopesenter.addPoint(new Point(10.77668875928839, 59.94668526912539 ));
        storoKjopesenter.addPoint(new Point(10.77696770902594, 59.94722257092696 ));
        storoKjopesenter.addPoint(new Point(10.775379841289122, 59.94631989892596 ));
        storoKjopesenter.addPoint(new Point(10.77595919843634, 59.94767389771036 ));
        storoKjopesenter.addPoint(new Point(10.774414246043761, 59.94801776161148 ));
        storoKjopesenter.addPoint(new Point(10.773491566142638, 59.94783508435813));
        storoKjopesenter.addPoint(new Point(10.773148243388732, 59.947577185345466 ));
        storoKjopesenter.addPoint(new Point(10.772998039683898, 59.9470936192888 ));
        storoKjopesenter.addPoint(new Point(10.773040955028136, 59.94674974580138 ));
        storoKjopesenter.addPoint(new Point(10.773555939158996, 59.9465455692305 ));
        storoKjopesenter.addPoint(new Point(10.774349873027404, 59.946341391402086 ));
        storoKjopesenter.addPoint(new Point(10.775379841289122, 59.94631989892596));

        Point pointInside = new Point(10.774585907420714, 59.94713660322393);
        Point pointOutside = new Point(10.773040955028136, 59.94742674332819);


        //System.out.println("inside: " + check.isInside(storoKjopesenter.getPointsAsArray(), pointInside));
        //System.out.println("outside: " + check.isInside(storoKjopesenter.getPointsAsArray(), pointOutside));
    }



}

