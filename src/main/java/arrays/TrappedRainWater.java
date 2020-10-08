package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Deque;
import java.util.ArrayDeque;


public class TrappedRainWater {
  /**
   * This approach uses Dynamic Programming. It maintains
   * 2 lists: left-max and right-max.
   * One maintains the maximum value observed from the left
   * for each cell, the other maintains the maximum value
   * observed from the right for each index.
   *
   * The idea is that water can only be trapped between two greater
   * heights on either side of a given cell. It will be limited by the
   * smaller of the two adjacent values.
   *
   * Formula: MIN(left-max, right-max) - height[cell], for each cell in
   * the input.
   *
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   *
   * @param elevationMap
   * @return total trapped rain water as integer
   */
  public int trappedRainWaterDP(List<Integer> elevationMap) {
    int totalWater = 0;
    int leftMax = Integer.MIN_VALUE;
    int rightMax = Integer.MIN_VALUE;

    List<Integer> leftMaxList = new ArrayList<>();
    List<Integer> rightMaxList = new ArrayList<>(Collections.nCopies(elevationMap.size(), 0));

    for (int i = 0; i < elevationMap.size(); i++) {
      if (elevationMap.get(i) > leftMax) {
        leftMax = elevationMap.get(i);
      }
      leftMaxList.add(leftMax);
    }

    for (int i = elevationMap.size() - 1; i >= 0; i--) {
      if (elevationMap.get(i) > rightMax) {
        rightMax = elevationMap.get(i);
      }
      rightMaxList.set(i, rightMax);
    }

    for (int i = 0; i < elevationMap.size(); i++) {
      totalWater += Math.min(leftMaxList.get(i), rightMaxList.get(i)) - elevationMap.get(i);
    }

    return totalWater;
  }

  /**
   * In this approach, a stack is used to store all the bars
   * that sandwiched between larger bars.
   *
   * The array is scanned from left to right. All the indices whose values are
   * smaller than the value of the index at the stack top are added to the stack.
   * When a bar is encountered that is larger than the value stored at the stack top
   * index, the values are popped until the stack is empty or an index is encountered that
   * holds a value larger than the current value. At each step, the distance is calculated as:
   * distance = current_index - stack.top - 1 (because the index smaller than the current is already removed)
   * The height is calculated as:
   * min (value of current index, value of index at stack top) - value of index just popped from stack.
   *
   * The area is added to a global variable.
   *
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   *
   * @param elevationMap
   * @return
   */
  public int trappedRainWaterStack(List<Integer> elevationMap) {
      int totalWater = 0;
      int currentIndex = 0;
      Deque<Integer> stack = new ArrayDeque<>();

      while (currentIndex < elevationMap.size()) {
        while (!stack.isEmpty() && elevationMap.get(stack.peekLast()) < elevationMap.get(currentIndex)) {
          int index = stack.removeLast();
          if (stack.isEmpty()) {
            break;
          }
          int distance = currentIndex - stack.peekLast() - 1;
          int height = Math.min(elevationMap.get(currentIndex), elevationMap.get(stack.peekLast())) - elevationMap.get(index);

          totalWater += distance * height;
        }
        stack.addLast(currentIndex++);
      }

      return totalWater;
  }
}
