package greedy.algorithms;

import java.util.List;

public class MinJumps {

    /**
     * In this approach, we apply a greedy strategy to select the largest
     * jump that can be made from the current index.
     * <p>
     * We keep a pointer of the maximum number of steps that can be traversed
     * from the last visited element. We decrement it as we move forward. We also
     * keep track of the maximum number of cells that can be jumped from all
     * the cells that are reachable from the last visited element.
     * <p>
     * As we scan the array from left to right; when the maximum number of steps becomes 0,
     * we check if the current index can be reached from the last visited element.
     * <p>
     * If yes, we increment the number of jumps by 1 (as we will have to make a jump
     * since we cannot go any further with the last element) and increase the
     * total number of steps that can be taken from the current index by subtracting
     * the current index from the maximum position that can be reached from the last
     * visited element.
     * <p>
     * If the current index cannot be reached from the last visited element,
     * we return INT_MAX, as the maximum displacement cannot reach the current
     * element.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param numbers: list of numbers
     * @return minimum number of jumps to reach the end.
     */
    public int minimumJumpsToTheEnd(List<Integer> numbers) {
        int maxDisplacement = numbers.get(0);
        int steps = numbers.get(0);
        int jumps = 1;
        int size = numbers.size();

        if (maxDisplacement >= size - 1) {
            return jumps;
        }

        for (int i = 1; i < size; i++) {
            if (maxDisplacement >= size - 1) {
                return jumps + 1;
            }

            maxDisplacement = Math.max(maxDisplacement, i + numbers.get(i));

            steps--;

            if (steps == 0) {
                if (maxDisplacement <= i) {
                    return Integer.MAX_VALUE;
                }
                jumps++;
                steps = maxDisplacement - i;
            }
        }

        return jumps;
    }
}
