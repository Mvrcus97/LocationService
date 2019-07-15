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
        User user = new User("4746443716");
        UserScore userScore = new UserScore(user);
        userScore.setScore(256);
        leaderboard.add(userScore);

        user = new User("911");
        userScore = new UserScore(user);
        userScore.setScore(125);
        leaderboard.add(userScore);

        user = new User("110");
        userScore = new UserScore(user);
        userScore.setScore(253);
        leaderboard.add(userScore);

        user = new User("112");
        userScore = new UserScore(user);
        userScore.setScore(123);
        leaderboard.add(userScore);

        //leaderboard.
    }

}