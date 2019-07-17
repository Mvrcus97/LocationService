package telia.cpa.location.quiz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telia.cpa.location.*;
import telia.cpa.location.quiz.*;

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
        leaderboard.add(user);
        assertNotNull(leaderboard.getUserScores());
        assertTrue(leaderboard.getUserScores().contains(user));
    }

    @Test
    void testNullInsertion() {
        User user = new User("4746443715");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            leaderboard.add(null);
        });
        assertNotNull(leaderboard.getUserScores());
        assertTrue(leaderboard.getUserScores().isEmpty());
    }

    @Test
    void testSortedOutput() {
        User user = new User("4746443716");
        user.setScore(256);
        leaderboard.add(user);

        user = new User("911");
        user.setScore(15);
        leaderboard.add(user);

        user = new User("110");
        user.setScore(253);
        leaderboard.add(user);

        user = new User("112");
        user.setScore(123);
        leaderboard.add(user);

        user = new User("123");
        user.setScore(231);
        leaderboard.add(user);

        user = new User("113");
        user.setScore(253);
        leaderboard.add(user);

        leaderboard.sort();

        int prev = 10000;
        List<User> list = leaderboard.getUserScores();
        for(User s : list){
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