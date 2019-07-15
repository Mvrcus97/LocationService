package telia.cpa.location.quiz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

        user = new User("123");
        userScore = new UserScore(user);
        userScore.setScore(231);
        leaderboard.add(userScore);

        user = new User("113");
        userScore = new UserScore(user);
        userScore.setScore(253);
        leaderboard.add(userScore);

        leaderboard.sort();

        int prev = 10000;
        List<UserScore> list = leaderboard.getUserScores();
        for(UserScore s : list){
            assertTrue(s.getScore() <= prev,s.getScore() + "larger than: " + prev);
            prev = s.getScore();
        }

        list = leaderboard.getTopN(3);
        assertEquals(list.get(0).getScore(), 256);
        assertEquals(list.get(1).getScore(), 253);
        assertEquals(list.get(2).getScore(), 253);

        assertNotNull(leaderboard.getTopN(6));
        assertNotNull(leaderboard.getTopN(100));

    }

}