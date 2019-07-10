package telia.cpa.location;

public class main {
    public static void main(String[] args) {
        no.telia.cpa.location.CoverageAreaInvoker client = new no.telia.cpa.location.CoverageAreaInvoker();


        client.setMsisdn("4793859166");
        System.out.println("Location of number: " + client.getMsisdn() + " is:  " + client.getLocation());
        System.out.println("Country: " + client.getCountry() + ", County: " + client.getCounty() + ", Council: " + client.getCouncil());
        System.out.println();

        client.setMsisdn("4798437400");
        System.out.println("Location of number: " + client.getMsisdn() + " is:  " + client.getLocation());
        System.out.println("Country: " + client.getCountry() + ", County: " + client.getCounty() + ", Council: " + client.getCouncil() + ", SubPart Area: " + client.getSubPartArea());
        System.out.println("Coverage Area: " + client.getMultiPolygon());
        System.out.println("Location time: "  + client.getLocationTime());

        System.out.println();
        System.out.println(client.toString());

    }

}

