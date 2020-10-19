package greedy.algorithms;

import java.util.List;

public class MinimumJumps {

    /**
     * The recursive approach is akin to enumerating all the solutions, except in
     * this approach we terminate the search once a solution is found.
     * <p>
     * We create a helper method that start with the starting index 0 and
     * explores all the cells that can be visited from the starting index.
     * <p>
     * For each cell that can be visited, the method will recurse for all the cells
     * that can be visited. The moment a solution is found, the method terminates
     * and returns a true.
     * <p>
     * If no solution can reach the end of the array, false is returned.
     * <p>
     * Time complexity: O(2^n), as there are 2^n subsets in a set of size n.
     * Space complexity: O(n), as the recursion could require a total of n stack frames
     *
     * @param numbers
     * @return true if end of the array can be reached. false otherwise.
     */
    public boolean canJumpRecursive(List<Integer> numbers) {
        return canJumpRecursiveHelper(numbers, 0);
    }

    /**
     * In this approach, the array is scanned from right to left.
     * An index is maintained to store the last valid position that can reach
     * the end of the array.
     *
     * If the current cell can reach that the last valid position that can
     * reach the end, we update the last valid position to the current cell.
     *
     * By the end of the iteration, if the last valid position equals the first cell,
     * then there is a path through the array. If not, return false.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param numbers
     * @return true if end of the array can be reached. false otherwise.
     */
    public boolean canReachEndGreedy(List<Integer> numbers) {
        int lastValidPosition = numbers.size() - 1;

        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) + i >= lastValidPosition) {
                lastValidPosition = i;
            }
        }

        return lastValidPosition == 0;
    }

    private boolean canJumpRecursiveHelper(List<Integer> numbers, int startIndex) {
        if (startIndex >= numbers.size() - 1) {
            return true;
        }

        int maxJump = numbers.get(startIndex) + startIndex;
        if (maxJump >= numbers.size() - 1) {
            return true;
        }

        for (int i = startIndex + 1; i <= maxJump; i++) {
            if (canJumpRecursiveHelper(numbers, i)) {
                return true;
            }
        }

        return false;
    }
}
