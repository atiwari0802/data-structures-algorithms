package greedy.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MinimumJumpsTest {

    private MinimumJumps minimumJumps;

    @BeforeEach
    public void setup() {
        minimumJumps = new MinimumJumps();
    }

    @Test
    public void testMinimumJumpsRecursive() {
        List<Integer> list = List.of(2, 3, 1, 1, 4);

        boolean result = minimumJumps.canJumpRecursive(list);

        Assertions.assertTrue(result);
    }

    @Test
    public void testMinimumJumpsRecursiveFalseCondition() {
        List<Integer> list = List.of(3, 2, 1, 0, 4);

        boolean result = minimumJumps.canJumpRecursive(list);

        Assertions.assertFalse(result);
    }

    @Test
    public void testMinimumJumpsGreedy() {
        List<Integer> list = List.of(2, 3, 1, 1, 4);

        boolean result = minimumJumps.canReachEndGreedy(list);

        Assertions.assertTrue(result);
    }

    @Test
    public void testMinimumJumpsGreedyFalse() {
        List<Integer> list = List.of(3, 2, 1, 0, 4);

        boolean result = minimumJumps.canReachEndGreedy(list);

        Assertions.assertFalse(result);
    }
}
