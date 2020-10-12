package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;


public class MaximalRectangle {
    /**
     * In this approach, we convert each row into a corresponding 1-D
     * histogram, where value of each column is calculated cumulatively
     * based on the previous row.
     * <p>
     * For each row, we calculate the maximum histogram area, which is
     * explained in @{@link LargestHistogramArea} code.
     *
     * Time Complexity: O(N * M) (rows X columns)
     * Space Complexity: O(M)
     *
     * @param input
     * @return
     */
    public int maxRectangleArea(List<List<Character>> input) {
        int rows = input.size();
        int columns = input.get(0).size();
        int maxArea = Integer.MIN_VALUE;
        List<Integer> heights = new ArrayList<>(Collections.nCopies(columns, 0));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (input.get(i).get(j) == '1') {
                    heights.set(j, heights.get(j) + 1);
                } else {
                    heights.set(j, 0);
                }
            }
            maxArea = Math.max(maxArea, maxArea(heights));
        }

        return maxArea;
    }

    private int maxArea(List<Integer> heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = Integer.MIN_VALUE;
        int index = 0;
        int size = heights.size();

        while (index < size) {
            if (stack.isEmpty() || heights.get(stack.peekLast()) <= heights.get(index)) {
                stack.addLast(index++);
            } else {
                while (!stack.isEmpty() && heights.get(stack.peekLast()) >= heights.get(index)) {
                    int currentIndex = stack.pollLast();
                    int height = heights.get(currentIndex);
                    int width = stack.isEmpty() ? index : index - 1 - stack.peekLast();
                    maxArea = Math.max(maxArea, height * width);
                }
            }
        }

        while (!stack.isEmpty()) {
            int currentIndex = stack.pollLast();
            int height = heights.get(currentIndex);
            int width = stack.isEmpty() ? size : size - 1 - stack.peekLast();

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
