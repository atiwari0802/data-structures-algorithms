package arrays;

import java.util.List;

public class SearchInSortedAndRotatedArray {
  /**
   * In this approach, instead of finding the pivot position, we work with the existing structure of
   * the array.
   *
   * <p>There are two types of possibilities: 1.) The pivot is right of the mid point: In this case,
   * we check if the target is greater than the start and less than the middle. If yes, then the
   * target must exist between start and mid - 1. So, we reduce the search indices between start and
   * mid - 1. If no, then the target would exist to the right of the mid point. So, we set the start
   * to mid + 1
   *
   * <p>2.) The pivot is to the left of the mid point. In this case, we compare the target value
   * with mid point and the end elements. If the target is greater than middle element but less than
   * end element, then, the target must exist between mid + 1 and end.
   *
   * <p>So, we set the start = mid + 1. Else target must exist between start and mid - 1;
   * So we set end = mid - 1.
   *
   * Time Complexity: O(log(n))
   * Space Complexity: O(1)
   * @param numbers
   * @return
   */
  public int search(List<Integer> numbers, int target) {
    int start = 0;
    int end = numbers.size() - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (numbers.get(mid) == target) {
        return mid;
      } else if (numbers.get(start) <= numbers.get(mid)) {
        if (target >= numbers.get(start) && target < numbers.get(mid)) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        if (target > numbers.get(mid) && target <= numbers.get(end)) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }

    return Integer.MIN_VALUE;
  }
}
