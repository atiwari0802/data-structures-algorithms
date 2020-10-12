package arrays;

import java.util.List;

public class ContainerWithMostWater {

    /**
     * This algorithm uses sliding window technique to
     * find the maximum area between two pegs(indices).
     * <p>
     * The initial position of the pegs are the 0 and the
     * end of the list.
     * The area is calculated as area = min( num[lo], num[high]) * (high -lo);
     * We keep a global variable to store the max area
     * that has been calculated. If the current area is greater than the max-area
     * seen so far, we update the max-area with the current.
     * <p>
     * We move the pegs using this logic:
     * if the left peg is smaller than the right peg, move the left peg to the right
     * else move the right peg to the left.
     * <p>
     * The reasoning behind this approach is that since we are reducing the width,
     * we want to keep the larger of the two values.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param input array containing heights
     * @return max area.
     */
    public int maxArea(List<Integer> input) {
        int leftIndex = 0;
        int rightIndex = input.size() - 1;
        int maxArea = Integer.MIN_VALUE;

        while (leftIndex < rightIndex) {
            int currentArea = Math.min(input.get(leftIndex), input.get(rightIndex)) * (rightIndex - leftIndex);
            maxArea = Math.max(maxArea, currentArea);

            if (input.get(leftIndex) < input.get(rightIndex)) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return maxArea;
    }
}
