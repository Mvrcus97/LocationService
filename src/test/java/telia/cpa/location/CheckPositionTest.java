package telia.cpa.location;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckPositionTest {
    CheckPosition checkPosition = new CheckPosition();


    @Test
    void onSegment() {
    }

    @Test
    void orientation() {
    }

    @Test
    void doIntersect() {
    }

    @Test
    void isInside() {
        assertFalse(checkPosition.isInside(null, null), "True must be true");
    }
}