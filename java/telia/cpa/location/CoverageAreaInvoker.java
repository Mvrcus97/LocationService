package no.telia.cpa.location;

import no.differitas._2015._10.coveragearea.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        request.setUsername("Summer Intern Test");
        request.setRef("Nydalen");
        lastCalled = -10;
        System.out.println("Client Successfully Created\n ");
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
                    System.out.println("Updating Result...");
                    this.result = port.coverage(request);
                    this.lastCalled = System.currentTimeMillis();
                } catch (Exception e){System.out.println("UpdateResult error.");}
        }
        if(result == null){
            System.out.println("Response error: Response is null.");
            return;
        }
        if(result.getStatus().getCode() != 200){
            System.out.println("Response error: " + result.getStatus().getValue());
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









}//end CoverageAreaInvoker
