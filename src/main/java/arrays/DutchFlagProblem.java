package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DutchFlagProblem {

  /**
   * This approach borrows from the Partition algorithm of the Quick Sort. We divide the array in 3
   * sections: 0-section, 1-section and 2-section.
   *
   * <p>In this approach, we maintain 3 indices: one for Zeros, one for Ones and the other for Twos.
   * The Zeroth index always points to the element right after the last zero (which is a One) and
   * moves from left to right. The first index points to the last One and moves from left to right,
   * and two index points to the first two and moves from right to left.
   *
   * <p>If we encounter a 0, then, we swap the position of 0-Index with 1-Index and increment both
   * the pointers.
   *
   * <p>If we encounter a 2, then we swap the Two Index with One Index, but only decrement the 2
   * index (since we don't know what element at the two index)
   *
   * <p>If we encounter 1, we simply move on.
   *
   * <p>We repeat the above process until One-Index < Two-Index
   *
   * <p>Time Complexity: O(n) Space Complexity: O(1)
   *
   * @param nums
   * @return sorted nums;
   */
  public int[] sortColors(int[] nums) {
    List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
    int zeroIndex = 0, oneIndex = 0, twoIndex = numbers.size() - 1;

    while (oneIndex <= twoIndex) {
      if (numbers.get(oneIndex) == 0) {
        Collections.swap(numbers, zeroIndex++, oneIndex++);
      } else if (numbers.get(oneIndex) == 2) {
        Collections.swap(numbers, oneIndex, twoIndex--);
      } else {
        oneIndex++;
      }
    }
    return numbers.stream().mapToInt(Integer::intValue).toArray();
  }
}
