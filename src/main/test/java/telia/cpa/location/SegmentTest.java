package no.telia.cpa.location;

import org.junit.jupiter.api.Test;

import java.beans.PersistenceDelegate;

import static org.junit.jupiter.api.Assertions.*;

class SegmentTest {

    @Test
    void maxX() {
    }

    @Test
    void maxY() {
    }

    @Test
    void minX() {
    }

    @Test
    void minY() {
    }

    @Test
    void isBetween() {

        Segment flatSeg = new Segment(new Point(0,0), new Point(2,0));
        assertTrue(flatSeg.isBetween(new Point(1,0)), "Point on segment");
        assertFalse(flatSeg.isBetween(new Point(2,3)), "Point not on segment");

        Segment verticalSeg = new Segment(new Point(0,0), new Point(0,2));
        assertTrue(verticalSeg.isBetween(new Point(0,1)), "Point on segment");
        assertFalse(verticalSeg.isBetween(new Point(2,3)), "Point not on segment");

        Segment seg = new Segment(new Point(0,0), new Point(3,3));
        assertTrue(seg.isBetween(new Point(1,1)));
        assertFalse(seg.isBetween(new Point(1,1)));

    }

    @Test
    void onSegment() {

        Point originPoint = new Point(0,0);

        Segment originSegment = new Segment(originPoint, originPoint);
        assertFalse(originSegment.onSegment(null),"Cannot handle null point");
        assertTrue(originSegment.onSegment(originPoint),"Origin point on origin segment");

        Segment verticalSeg = new Segment(originPoint, new Point(0,2));
        assertTrue(verticalSeg.onSegment(new Point(0,1)), "Point on segment");
        assertFalse(verticalSeg.onSegment(new Point(0,4)), "Point over segment");
        assertFalse(verticalSeg.onSegment(new Point(2,3)), "Point not on segment");

        Segment flatSeg = new Segment(originPoint, new Point(2,0));
        assertTrue(flatSeg.onSegment(new Point(1,0)), "Point on segment");
        assertFalse(flatSeg.onSegment(new Point(3,0)), "Point next to segment");
        assertFalse(flatSeg.onSegment(new Point(3,2)), "Point not on segment");

        Segment segment = new Segment(originPoint, new Point(3,3));
        assertTrue(segment.onSegment(new Point(2,2)), "Point on oblique segment");
        assertFalse(segment.onSegment(new Point(2,0)), "Point not on oblique segment");

        segment = new Segment(new Point(3,3), originPoint);
        assertTrue(segment.onSegment(new Point(2,2)), "Point on oblique segment");
        assertFalse(segment.onSegment(new Point(-2,0)), "Point not on oblique segment");
    }

    @Test
    void orientation() {

        Point p1 = new Point(3,1);
        Point q1 = new Point(0,4);
        Point p2 = new Point(0,0);
        Point q2 = new Point(3,5);

        Segment s = new Segment(p2,q1);
        assertEquals(0,s.orientation(new Point(0,3)), "Colinear");
        Segment s1 = new Segment(p2,q2);
        assertEquals(1, s1.orientation(q1), "Clockwise orientation");
        Segment s2 = new Segment(p2,q2);
        assertEquals(2, s1.orientation(p1), "Clockwise orientation");

    }

    @Test
    void doIntersect(){

        Point a = new Point(4,0);
        Point b = new Point(0,6);

        Segment s = new Segment(a,b);
        Segment s1 = new Segment(new Point(2,2),new Point(2,6));
        Segment s2 = new Segment(new Point(5,2), new Point(8,10));

        assertTrue(s.doIntersect(s1),"Ray intersect the segment");
        assertFalse(s.doIntersect(s2), "Ray do not intersect the segment");


        //Point p1 = new Point(5,1);

        //Segment ray = new Segment(p1, p3);
        //assertTrue(seg.doIntersect(ray),"Ray starting inside segment");

        Point p2 = new Point(3,1);
        Point p3 = new Point(9,1);
        Segment ray1 = new Segment(p2, p3);
        Segment seg = new Segment(new Point(5,1), new Point(7,1));
        assertFalse(seg.doIntersect(ray1), "Ray staring before segment");


    }

}