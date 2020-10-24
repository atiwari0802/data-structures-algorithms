package greedy.algorithms;

import java.util.Arrays;

public class TwoCityScheduling {

  /**
   * In this approach, we are given a 2-D array that represents the cost of travelling to city A and
   * B in the respective cells.
   *
   * <p>The approach we take here is to sort the list based on the difference between the cost of
   * travelling to city A and city B.
   *
   * <p>What this gives us is a list that is sorted in way where the cost of sending a person to
   * city A is is lower than cost of sending the person to city B. Lower the difference between the
   * cost of travelling to city A and city B, the more it makes sense to send the person to city A.
   *
   * <p>Since we are required to send half the people to city A and the other half to B, using the
   * above greedy approach, we iterate over the sorted list until the mid point, adding the cost
   * associated with city for the first half and also adding the cost associated with city B for the
   * second half of the list.
   *
   * Time Complexity: O(nLog(n))
   * Space Complexity: O(1)
   *
   * @param costs
   * @return minimum cost of sending equal number of people to either city.
   */
  public int twoCityScheduledCost(int[][] costs) {
    Arrays.sort(costs, (a, b) -> Integer.compare(a[0] - a[1], b[0] - b[1]));

    int midPoint = costs.length / 2;
    int minimumCost = 0;

    for (int i = 0; i < midPoint; i++) {
      minimumCost += costs[i][0] + costs[i + midPoint][1];
    }

    return minimumCost;
  }
}
