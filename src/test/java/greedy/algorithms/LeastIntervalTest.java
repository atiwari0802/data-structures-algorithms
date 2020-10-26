package greedy.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeastIntervalTest {

    private LeastInterval leastInterval;

    @BeforeEach
    public void setup() {
        leastInterval = new LeastInterval();
    }

    @Test
    public void testLeastInterval() {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int waitTime = 2;

        int result = leastInterval.leastInterval(tasks, waitTime);

        Assertions.assertEquals(8, result);
    }
}
