package telia.cpa.location;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PolygonTest {

    Polygon polygon;
    Point p;


    @Test
    void add(){
        // add 5 points, check if max and min is correct. Also check size.
        polygon = new Polygon();
        polygon.addPoint(new Point(3.232, 3.24245));
        polygon.addPoint(new Point(5.1313, 1.1241));
        polygon.addPoint(new Point(5.1232312, 4.5544));
        polygon.addPoint(new Point(7.000324, 3.3334));
        polygon.addPoint(new Point(2.2424, 5.23424));

        assertEquals(polygon.getMaxX(),7.000324 );
        assertEquals(polygon.getMaxY(), 5.23424);
        assertEquals(polygon.getMinX(), 2.2424);
        assertEquals(polygon.getMinY(), 1.1241);
        assertEquals(polygon.size(), 5);

    }



    @Test
    void getPointsAsArray(){
        polygon = new Polygon();
        Point[] fasit = new Point[100];
        for(int i = 0; i < 100; i ++){
            p = new Point(i,i);
            polygon.addPoint(p);
            fasit[i] = p;

        }
        assertArrayEquals(polygon.getPointsAsArray(), fasit);

        polygon = new Polygon(fasit);
        assertArrayEquals(polygon.getPointsAsArray(), fasit);
    }
}
