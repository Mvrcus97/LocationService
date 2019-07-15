package telia.cpa.location;

import java.util.ArrayList;
import java.util.HashMap;


/*
 * This class can be used to logg the position of a given phone number.
 */

public class PositionLogger {
    HashMap<String, ArrayList<Point>> logg;

    public PositionLogger(){
        this.logg = new HashMap<>();
    }

    public void add(String msisdn, Point point){
        ArrayList<Point> currLogg;
        currLogg = logg.get(msisdn);

        if(currLogg == null) currLogg = new ArrayList<Point>();

        currLogg.add(point);
        logg.put(msisdn, currLogg);
    }


    public ArrayList<Point> get(String msisdn){
        return logg.get(msisdn);
    }
    public Point getLatest(String msisdn){
        ArrayList<Point> currLogg = logg.get(msisdn);
        return currLogg.get(currLogg.size()-1);
    }


}

