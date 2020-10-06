package arrays;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SubArraySum {

  /**
   * It is based on the principle of cumulative additions. As we iterate over the list, we keep
   * adding each entry to a running sum. Each new value of the running sum is added to a Map with a
   * value of 1. If the sum already exists, then, its value incremented by 1.
   *
   * <p>At each step, we check if there exists an entry in the map which if removed would lead to
   * the expected_sum. If yes, then we increment the count by value present in the Map for that sum.
   * (If value for the sum is more than one, that means there is more than one subset that could be
   * removed to yield the expected_sum.)
   *
   * |-------------------|--------|
   *      n - k             k
   * |_____________________________|
   *                n
   *
   * @param input
   * @param expectedSum
   * @return int
   */
  public int countSubsetsWithSpecificSum(List<Integer> input, int expectedSum) {
    int runningSum = 0, count = 0;
    Map<Integer, Integer> runningSumIndex = new HashMap<>();
    runningSumIndex.put(0, 1); // to cater for cases where sum matches exactly. Example: Expected Sum = 7 and list 3, 4, 7 ....

    for (int num : input) {
      runningSum += num;

      if (runningSumIndex.containsKey(runningSum - expectedSum)) {
        count += runningSumIndex.get(runningSum - expectedSum);
      }

      runningSumIndex.put(runningSum, runningSumIndex.getOrDefault(runningSum, 0) + 1);
    }

    return count;
  }
}
