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

        System.out.println(client.getMultiPolygon());

        Point[] points = client.getPolygonAsPoints();
        System.out.println("List of points generated: ");
        for(int i = 0; i < points.length; i++){
            System.out.println("(" + points[i].x +", " + points[i].y + ")");
        }


        System.out.println();

    }

}

