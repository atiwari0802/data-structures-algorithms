package greedy.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskSchedulerTest {

    private TaskScheduler taskScheduler;

    @BeforeEach
    public void setup() {
        taskScheduler = new TaskScheduler();
    }

    @Test
    public void testLeastInterval() {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int waitTime = 2;

        int result = taskScheduler.leastInterval(tasks, waitTime);

        Assertions.assertEquals(8, result);
    }
}
