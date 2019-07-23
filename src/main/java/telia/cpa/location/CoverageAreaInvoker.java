package telia.cpa.location;

import no.differitas._2015._10.coveragearea.*;
import telia.cpa.location.Point;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

public class CoverageAreaInvoker {
    CoverageAreaService_Service service;
    CoverageAreaService port;
    CoverageAreaReq request;
    CoverageAreaRsp result;
    long lastCalled;


    public CoverageAreaInvoker(){
        this.service =  new CoverageAreaService_Service();
        this.port = service.getCoverageAreaServicePort();
        this.request = new CoverageAreaReq();
        request.setUsername("Summer Intern Tes");
        request.setRef("Nydaln");
        lastCalled = -10;
        //System.out.println("Client Successfully Created\n ");
    }

    public CoverageAreaInvoker(String nr){
        this.service =  new CoverageAreaService_Service();
        this.port = service.getCoverageAreaServicePort();
        this.request = new CoverageAreaReq();
        request.setUsername("Summer Intern Test");
        request.setRef("Nydalen");
        System.out.println("Client Successfully Created\n ");

        setMsisdn(nr);
        try{
            this.result = port.coverage(request);
            this.lastCalled = System.currentTimeMillis();
        } catch (Exception e){System.out.println("Client error: API CALL CONSTRUCTOR");}
    }


    //This method makes a new call to API if more than 10 sec since last update.
    public void updateResult(){
        if(System.currentTimeMillis() - lastCalled > 10000){
            try{
                    //System.out.println("Updating Result...");
                    this.result = port.coverage(request);
                    this.lastCalled = System.currentTimeMillis();
                    //System.out.println("After update");
                } catch (Exception e){System.out.println("UpdateResult error: ");}
        }
        if(result == null){
            System.out.println("Response error: Response is null.");
            return;
        }
        if(result.getStatus().getCode() != 200){
            System.out.println("Response error HTTP code: " + result.getStatus().getCode() + " value: " + result.getStatus().getValue());
        }

    }
    public void forceUpdateResult(){
        this.lastCalled = -10;
        updateResult();
    }

    public void setMsisdn(String nr){
        this.request.setMsisdn(nr);
        forceUpdateResult();
    }

    public String getMsisdn(){return request.getMsisdn();}


    // This method returns Latitude and Longitude in a String array.
    public String getLocation(){
        updateResult();
        String location = "(" +result.getLatitude() + ", " + result.getLongitude() + ")";
        return location;
    }

    public Point getPoint(){
        updateResult();
        String x_s = result.getLatitude().replaceAll(",",".");
        String y_s = result.getLongitude().replaceAll(",",".");

        double x = Double.valueOf(x_s);
        double y = Double.valueOf(y_s);
        Point point = new Point(x, y);
        return point;
    }

    public String getCountry(){
            updateResult();
            return result.getCountry();
    }

    public String getCounty(){
            updateResult();
            return  result.getCounty();
    }

    public String getCouncil(){
            updateResult();
            String ret = null;
            if(result.getCouncil() != null) {
                ret =  result.getCouncil().getValue();
            }
        return ret;
    }

    public String getSubPartArea(){
        updateResult();
        return result.getSubPartArea();
    }

    public String getMultiPolygon(){
        updateResult();
        return result.getCoverage();

    }

    public String getLocationTime(){
        updateResult();
        return result.getLocationTime();
    }

    public String toString(){
        updateResult();
        String ret = "Current Location of " + getMsisdn() + " is: \n";
        ret += result.getCountry() + ", " + result.getCounty() + ", " + getCouncil()
                + ", " + result.getPartArea() + ", " + result.getSubPartArea();
        return ret;
    }


    /*
      Returns a Point array of *47* points, as received by the SOAP API.
      Points are currently returned in the (x,y) notation, aka (Latitude, Longitude)
     */
    public Point[] getPolygonAsPoints(){
        updateResult();
        Point[] points = new Point[47]; // Seems like the SOAP server only returns 47 Points.
        Point p;
        //Parse the string into pairs of x and y values.
        String polygon = result.getCoverage();
        if(polygon == null) return null;
        System.out.println(polygon);
        polygon = polygon.replaceAll(",", "");
        polygon = polygon.replaceAll("[((]", "");
        polygon = polygon.replaceAll("[))]", "");

        Scanner scanner = new Scanner(polygon);
        int pair_pos = 0;
        double[] pair = new double[2];
        int  idx = 0;
        while (scanner.hasNext()){
            if (scanner.hasNextDouble()) {
                pair[pair_pos] = scanner.nextDouble();
                //System.out.println("Found: " + pair[pair_pos%2]);
                pair_pos ++;
                if(pair_pos == 2){
                    points[idx++] = new Point(pair[1], pair[0]);
                    //System.out.println("New pair: "+ pair[1] + ", " + pair[0]);
                    pair_pos = 0;
                }
            }
            else{
                scanner.next();
            }
        }
        scanner.close();
        return points;
    }








}//end CoverageAreaInvoker
