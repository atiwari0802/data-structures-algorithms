package arrays;

public class FindRangeInSortedArray {

  /**
   * This approach has been modelled after the Binary search.
   *
   * <p>In this approach, instead of stopping when we find the target, we continue to sweep left and
   * right in two separate passes to find the starting and the ending index of the target.
   *
   * <p>We first try to find the left starting index, followed by the right ending index. To find
   * the left starting index, if we find the target, we scan the section of the array from the start
   * until the index where the target has been found. We do this by setting the right limit (high)
   * to the current_index - 1, while storing the result.
   *
   * <p>To ascertain the right boundary, we start scanning right until the end of the array. We do
   * this by incrementing the starting index to the right of the current index and continue until
   * the high < low. If there is a match, we store the index in a variable.
   *
   * <p>Time Complexity: O(nLog(n)); we perform two binary searches, so the time complexity is 2 X
   * O(nLog(n)), which equates to O(nLog(n))
   *
   * <p>Space Complexity: O(1)
   *
   * @param nums
   * @param target
   * @return Range of the target or {-1, -1}, if target is absent
   */
  public int[] searchRange(int[] nums, int target) {
    int[] range = {-1, -1};

    int leftPeg = search(nums, target, true);

    if (leftPeg < 0) {
      return range;
    }

    int rightPeg = search(nums, target, false);

    range[0] = leftPeg;
    range[1] = rightPeg;

    return range;
  }

  private int search(int[] nums, int target, boolean moveLeft) {
    int lo = 0, high = nums.length - 1, mid = 0, result = Integer.MIN_VALUE;

    while (lo <= high) {
      mid = lo + (high - lo) / 2;
      if (nums[mid] < target) {
        lo = mid + 1;
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else if (moveLeft) {
        result = mid;
        high = mid - 1;
      } else {
        result = mid;
        lo = mid + 1;
      }
    }

    return result;
  }
}
