package telia.cpa.location.quiz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LeaderboardTest {

    Leaderboard leaderboard;

    @BeforeEach
    void beforeEach() {
        leaderboard = new Leaderboard();
    }

    @Test
    void testInsertion() {
        User user = new User("4746443715");
        UserScore userScore = new UserScore(user);
        leaderboard.add(userScore);
        assertNotNull(leaderboard.getUserScores());
        assertTrue(leaderboard.getUserScores().contains(userScore));
    }

    @Test
    void testNullInsertion() {
        User user = new User("4746443715");
        UserScore userScore = new UserScore(user);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            leaderboard.add(null);
        });
        assertNotNull(leaderboard.getUserScores());
        assertTrue(leaderboard.getUserScores().isEmpty());
    }

    @Test
    void testSortedOutput() {


    }

}