package telia.cpa.location;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckPositionTest {
    CheckPosition checkPosition = new CheckPosition();

    @Test
    void onSegment() {
        assertFalse(checkPosition.onSegment(null, null),"Cannot tolerate null input");

        Point originPoint = new Point(0, 0);
        Segment originSegment = new Segment(originPoint, originPoint);
        assertFalse(checkPosition.onSegment(originSegment,null),"Don't have a valid point");
        assertFalse(checkPosition.onSegment(null, originPoint),"Don't have a valid segment");
        assertTrue(checkPosition.onSegment(originSegment, originPoint),"Origin on origin");

        Segment flatSegment = new Segment(originPoint,new Point(0,3));
        assertTrue(checkPosition.onSegment(flatSegment,originPoint), "Check point in the beginning of segment");
        assertTrue(checkPosition.onSegment(flatSegment,new Point(0,2)), "Check point in the middle of segment");
        assertTrue(checkPosition.onSegment(flatSegment,new Point(0,3)), "Check point in the end of segment");
        assertFalse(checkPosition.onSegment(flatSegment,new Point(0,4)), "Check point outside of segment");

        Segment segment = new Segment(originPoint, new Point(2,2));
        assertTrue(checkPosition.onSegment(segment,new Point(1,1)), "Point on line");
        assertFalse(checkPosition.onSegment(segment,new Point(1,1.5)), "Point not on line");

    }

    @Test
    void orientation() {
    }

    @Test
    void doIntersect() {
    }

    @Test
    void isInside() {
        assertFalse(checkPosition.isInside(null, null), "Cannot tolerate null input");
        //assertTrue();
    }
}