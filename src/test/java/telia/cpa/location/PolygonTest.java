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

    @Test
    void isInside(){
        polygon = new Polygon();
        polygon.addPoint(new Point(3,4));
        polygon.addPoint(new Point(7,2));
        polygon.addPoint(new Point(10.14,5.19));
        polygon.addPoint(new Point(8.08,9.16));
        polygon.addPoint(new Point(3.67,8.42));

        Point point = new Point(6,6);
        assertTrue(polygon.isInside(point),"Point is inside polygon");
        Point point1 = new Point(4,2);
        assertFalse(polygon.isInside(point1),"Point is outside polygon");
        Point point2 = new Point(5,3);
        assertTrue(polygon.isInside(point2),"Point is on the edge of polygon");polygon = new Polygon();

        Polygon polygon1 = new Polygon();
        polygon1.addPoint(new Point(4,3));
        polygon1.addPoint(new Point(8,3));
        polygon1.addPoint(new Point(9.24,6.8));
        polygon1.addPoint(new Point(6,9.16));
        polygon1.addPoint(new Point(2.76,6.8));

        Point point3 = new Point(5.63,5.03);
        assertTrue(polygon1.isInside(point3),"Point is inside polygon");
        Point point4 = new Point(2.51,1.59);
        assertFalse(polygon1.isInside(point4),"Point is outside polygon");
        Point point5 = new Point(5.65,3);
        assertTrue(polygon1.isInside(point5),"Point is on the edge of polygon");
        Point point6 = new Point(2,3);
        assertFalse(polygon1.isInside(point6),"Point is outside but on same line");
        Point point7 = new Point(5,2);
        assertFalse(polygon1.isInside(point7),"Point is outside ");

    }

}
