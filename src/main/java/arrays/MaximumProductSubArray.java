package arrays;

import java.util.List;

public class MaximumProductSubArray {
  /**
   * This approach uses Sliding Window technique. In this approach, two sliding windows are maintained.
   * One sliding window keeps track of maximum product, whereas the other tracks the minimum product observed thus far.
   * The array is scanned from left to right and the window size is grown as well.
   *
   * <p>The idea behind this approach is that as long as positive integers are encountered, the
   * maximum sub-array product will keep increasing.
   *
   * <p>If a zero is encountered, the starting index of both the sliding windows is reset to the to
   * the index of the zero element.
   *
   * <p>As far as negative integers are concerned, if even number of negative integers are present,
   * they will cancel each other out and might increase the max product. But if odd number of
   * negative numbers are present, they will upend the max product.
   * If a negative number is encountered which results in the maximum product becoming negative, the
   * max sliding window is reset to the current element (negative number), while the negative sliding
   * window is extended to include the current element.
   *
   * <p>In this approach a global_max_product is maintained. For each index, we maintain two
   * indices: maximum_product_ending_here and minimum_product_ending_here. These indices include the
   * number at the current index.
   *
   * <p>The formulae for calculating these indices are:
   *
   * <p>temp_max = max_ending_here
   *
   * <p>max_ending_here = max(current_number, max(current_num * max_ending_here, current_number *
   * minimum_ending_here))
   *
   * <p>min_ending_here = min(current_number, min(current_num * minimum_ending_here, current_number
   *  * temp_max))
   *
   * <p>By comparing the element independently with max and min product, we reset the starting index
   * of the sliding window
   *
   * <p>We compare the the max_ending_here with the global_max and update if global_max is
   * necessary.
   *
   * <p>Time Complexity: O(n).
   *
   * <p>Space Complexity: O(1)
   *
   * @param numbers
   * @return max product of sub-array value
   */
  public int findMaximumProduct(List<Integer> numbers) {
    int maxProduct = Integer.MIN_VALUE;
    int maxEndingHere = numbers.get(0);
    int minEndingHere = numbers.get(0);

    for (int i = 1; i < numbers.size(); i++) {
      int currentNumber = numbers.get(i);
      int tempMaxEndingHere =
          Math.max(
              currentNumber,
              Math.max(currentNumber * maxEndingHere, currentNumber * minEndingHere));

      minEndingHere =
          Math.min(
              currentNumber,
              Math.min(currentNumber * maxEndingHere, currentNumber * minEndingHere));

      maxEndingHere = tempMaxEndingHere;

      maxProduct = Math.max(maxEndingHere, maxProduct);
    }

    return maxProduct;
  }
}
