package telia.cpa.location;

public class main {
    public static void main(String[] args) {
        CoverageAreaInvoker client = new CoverageAreaInvoker();

        client.setMsisdn("4793859166");
        System.out.println("Location of number: " + client.getMsisdn() + " is:  " + client.getLocation());
        System.out.println("Country: " + client.getCountry() + ", County: " + client.getCounty() + ", Council: " + client.getCouncil());
        System.out.println();

        client.setMsisdn("4793859166");
        System.out.println();
        System.out.println(client.toString());
        System.out.println(client.getLocation());

        System.out.println(client.getMultiPolygon());


        System.out.println();

        Point pointInside = new Point(10.751603745542183 , 59.94713660322393);
        Point pointOutside = new Point(10.751021072, 59.901842722435);


    }



}

