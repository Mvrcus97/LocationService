package telia.cpa.location;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class positionLoggerTest {
    PositionLogger logger;

    @Test
    void loggLogic(){
        String msisdn;
        logger = new PositionLogger();
        Point p = new Point(9,11);
        logger.add("911", p);

        msisdn = "4746443715";
        ArrayList<Point> fasit = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            logger.add(msisdn, new Point(i,i));
            fasit.add(new Point(i,i));
        }

        assertEquals(logger.getLatest("911").x, p.x);
        assertEquals(logger.getLatest("911").y, p.y);
        for(int i = 0; i < 100; i ++){
            //Compare fasit X and Y with loggers X and Y, of given msisdn.
            assertEquals(logger.get(msisdn).get(i).x, fasit.get(i).x);
            assertEquals(logger.get(msisdn).get(i).y, fasit.get(i).y);
        }

    }
}//en positionLoggerTest
