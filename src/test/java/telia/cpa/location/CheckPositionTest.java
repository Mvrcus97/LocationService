package telia.cpa.location;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckPositionTest {
    CheckPosition checkPosition = new CheckPosition();

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