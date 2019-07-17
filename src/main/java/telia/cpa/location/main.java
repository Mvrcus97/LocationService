package telia.cpa.location;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        CoverageAreaInvoker client = new CoverageAreaInvoker();

        /*client.setMsisdn("4793859166");
        System.out.println("Location of number: " + client.getMsisdn() + " is:  " + client.getLocation());
        System.out.println("Country: " + client.getCountry() + ", County: " + client.getCounty() + ", Council: " + client.getCouncil());
        System.out.println();
        */


        client.setMsisdn("4740553014");
        System.out.println();
        System.out.println(client.getLocation());

        //System.out.println(client.getMultiPolygon());

        String location = client.getLocation();
        //Arthur omvendt.
        Point point = new Point(59.94848810767161, 10.768263646947957); /// DENNE SKAL ENDRES TIL DIN POSISJON!


        Polygon BI = new Polygon();
        BI.createPolygonFromWKT("POLYGON ((10.767335078204723 59.94786187677076,10.766798636401745 59.948893451923524,10.769266268695446 59.94928028432949,10.770296236957165 59.947915605435746,10.76791443535194 59.94746428194318,10.767335078204723 59.94786187677076))");
        System.out.println("Position : " + client.getLocation() + " is inside BI: " + BI.isInside(point));

        Polygon shop = new Polygon();
        shop.createPolygonFromWKT("POLYGON ((10.766352024051684 59.94932851018644,10.765617098781604 59.949231802648875,10.765547361347216 59.94901420965774,10.765622463199633 59.948855715098425,10.76573511597826 59.94880198795718,10.766180362674731 59.9488369106089,10.766609516117114 59.948906755801964,10.766550507518786 59.949118976831784,10.766352024051684 59.94932851018644))");
        System.out.println("Position : " + client.getLocation() + " is inside Shop: " + shop.isInside(point));
        System.out.println(client.getMultiPolygon());
        System.out.println(client.getLocation());


        Polygon polygon1 = new Polygon();
        ArrayList<Point> list = polygon1.getPoints();
        polygon1.createPolygonFromWKT("POLYGON ((10.774474448554315 59.94535559462372,10.774410075537957 59.94510842295711,10.775053805701532 59.94509230300179,10.775032348029412 59.945398580812395,10.774474448554315 59.94535559462372))");
        Point point3 = new Point(59.945215889125535,10.774689025275506  );
       //System.out.println("point3: " + polygon1.isInside(point3) );

    }



}

