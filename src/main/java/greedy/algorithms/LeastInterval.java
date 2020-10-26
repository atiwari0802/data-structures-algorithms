package greedy.algorithms;

import java.util.Arrays;

public class LeastInterval {
    /**
     * In this algorithm, we take the greedy approach.
     * <p>
     * We count the frequency of each task and sort them by the frequency.
     * <p>
     * The formula that's applied is that max_idle_time = (max_frequency - 1) * wait_time.
     * We subtract 1 from the max-frequency because there is no need to wait for the last task
     * of this character.
     *
     * Next, we iterate over the rest of the tasks, and subtract the frequency count from the max
     * idle time. We again keep in mind that if the max_frequency is equal to the another frequency
     * in the input list, then, we will subtract 1 from that as well. This is done for the same reason
     * that we don't have to wait for the last task, as there are no tasks left.
     *
     * For example, for list: A, A, B, B and wait time = 2,
     * A B _wait_ A B; wait time is 1, as we did not have to wait after the last task.
     *
     * Time Complexity: O(n); Character count array has constant size. So, sorting time is constant.
     * Space Complexity: O(1); the Character count array has a constant size
     * @param tasks
     *
     * @param tasks as a Character array and wait time in seconds.
     * @return least time taken to complete the job
     */
    public int leastInterval(char[] tasks, int waitTime) {
        int[] charCountIndex = new int[26];

        for (int i = 0; i < tasks.length; i++) {
            charCountIndex[tasks[i] - 'A']++;
        }

        Arrays.sort(charCountIndex);

        int maxFrequency = charCountIndex[25] - 1;
        int maxIdleTime = maxFrequency * waitTime;

        for (int i = 24; i >= 0 && maxIdleTime > 0; i--) {
            if (charCountIndex[i] > 0) {
                int frequency = Math.min(maxFrequency, charCountIndex[i]);
                maxIdleTime -= frequency;
            }
        }

        maxIdleTime = Math.max(0, maxIdleTime);

        return tasks.length + maxIdleTime;
    }
}
