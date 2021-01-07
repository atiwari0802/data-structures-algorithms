package dynamic.programming;

import java.util.*;

public class FrogJump {

  public boolean canCross(int[] stones) {
    return canCrossRecursive(stones, 0, 0);
  }

  /**
   * Time Complexity: O(3 ^ N), as the recursion tree could have 3 recursive calls of almost the same size.
   *
   * @param stones
   * @param index
   * @param jumpSize
   * @return
   */
  private boolean canCrossRecursive(int[] stones, int index, int jumpSize) {
    if (index >= stones.length - 1) {
      return true;
    }

    int nextIndex = Arrays.binarySearch(stones, index + 1, stones.length, stones[index] + jumpSize);

    if (nextIndex > 0 && canCrossRecursive(stones, nextIndex, jumpSize)) {
      return true;
    }

    nextIndex = Arrays.binarySearch(stones, index + 1, stones.length, stones[index] + jumpSize - 1);

    if (nextIndex > 0 && canCrossRecursive(stones, nextIndex, jumpSize - 1)) {
      return true;
    }

    nextIndex = Arrays.binarySearch(stones, index + 1, stones.length, stones[index] + jumpSize + 1);

    if (nextIndex > 0 && canCrossRecursive(stones, nextIndex, jumpSize + 1)) {
      return true;
    }

    return false;
  }

  /**
   * Time Complexity: O(n ^ 2)
   * Space Complexity: O(n ^ 2)
   * @param stones
   * @return
   */
  public boolean canCrossDP(int[] stones) {
    Map<Integer, Set<Integer>> dp = new HashMap<>();

    for (int stone : stones) {
      dp.put(stone, new HashSet<>());
    }

    dp.get(stones[0]).add(0);

    for (int i = 0; i < stones.length; i++) {
      for (int jumpSize : dp.get(stones[i])) {
        for (int k = jumpSize - 1; k <= jumpSize + 1; k++) {
          if (k > 0 && dp.containsKey(stones[i] + k)) {
            dp.get(stones[i] + k).add(k);
          }
        }
      }
    }

    return !dp.get(stones[stones.length - 1]).isEmpty();
  }
}
