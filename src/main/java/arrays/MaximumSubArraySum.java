package arrays;

import java.util.List;

public class MaximumSubArraySum {
    /**
     * Kadane's algorithm: The solution is based on Sliding Window technique.
     * <p>
     * In this solution, the left pointer is initially set to 0 and
     * the right pointer is moved incrementally to the right, scanning
     * one cell at a time. The algorithm maintains two variables: one
     * to store the sum of the cells till the current index, and the
     * other to maintain a global maximum.
     * <p>
     * At each step, the current sum is compared with the global sum.
     * If it is greater than the max sum, its value is assigned to max sum.
     * <p>
     * If the current sum becomes less than or equal to zero, the left pointer
     * is moved to next index and the process is repeated until the last element
     * has been scanned.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param input
     * @return int
     */
    public MaxSubArrayWindow findMaxSubArraySumWithIndices(List<Integer> input) {
        int currentSum = 0, maxSum = 0;
        int startIndex = 0, endIndex = 0;

        for (int i = 0; i < input.size(); i++) {
            if (currentSum < 0) {
                startIndex = i;
                currentSum = input.get(i);
            } else {
                currentSum += input.get(i);
            }

            if (currentSum > maxSum) {
                endIndex = i;
                maxSum = currentSum;
            }
        }

        return new MaxSubArrayWindow(startIndex, endIndex, maxSum);
    }

    static class MaxSubArrayWindow {
        int startIndex, endIndex, maxSum;

        public MaxSubArrayWindow(int startIndex, int endIndex, int maxSum) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.maxSum = maxSum;
        }
    }
}
