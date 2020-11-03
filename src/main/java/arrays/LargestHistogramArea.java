package arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class LargestHistogramArea {

    /**
     * In this approach, a stack is maintained to store the indices of heights.
     * The input array is scanned from left to right and if the element encountered
     * is greater than the value of the element pointed to by the top index in the stack,
     * then the index of the element is added to the stack.
     *
     * <p>
     * If the element is smaller than the element being pointed to by the top index in the stack,
     * then the indices are popped until all the elements that are greater than the current element
     * are popped.
     * <p>
     * For each pop, we calculate the area of the rectangle using the following logic:
     * Let current-element-index be i. The width is:
     * <p>
     * width = i - 1 - stack.top, if stack is not empty; i otherwise
     * (i - 1 is used because the current element is one position ahead of the index in consideration.
     * <p>
     * And i is used if stack is empty because the start index is 0 and stack being empty means
     * that the width spans until the beginning of the array, which comes out to be i - 1 + 1 = i.)
     * <p>
     * If end of the list is reached without stack being empty,
     * the same logic as above is applied except i is replaced by the last index of the array.
     * <p>
     * height = height of index that was popped.
     * <p>
     * area = width * height;
     * (For the last element, the width spans the entire size of the array)
     * We maintain a global variable to store the max area that has been encountered.
     * <p>
     * The rationale behind this approach is that area is limited by the height of the of the bar
     * and as bars are popped the width increases but the height of the rectangle decreases.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param heights of bars in the histogram
     * @return largest area of Rectangle.
     */
    public int largestHistogramArea(List<Integer> heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        int size = heights.size();
        int maxArea = Integer.MIN_VALUE;

        while (index < size) {
            if (stack.isEmpty() || heights.get(stack.peekLast()) < heights.get(index)) {
                stack.addLast(index++);
            } else {
                while (!stack.isEmpty() && heights.get(stack.peekLast()) > heights.get(index)) {
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
