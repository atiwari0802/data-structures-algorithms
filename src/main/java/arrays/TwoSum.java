package arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  /**
   * In this method, the array is scanned from left to right.
   *
   * <p>For each entry in the array, we add the value and index to a Map. we also check if value
   * target - current_value has been encountered previously. If yes, then, the method returns the
   * start and the end index.
   *
   * <p>Time Complexity: O(n)
   *
   * <p>Space Complexity: O(n)
   *
   * @param nums
   * @param target
   * @return returns the start and end indices if the target is found. Null otherwise
   */
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        return new int[] {map.get(target - nums[i]), i};
      }
      map.put(nums[i], i);
    }

    return null;
  }
}
