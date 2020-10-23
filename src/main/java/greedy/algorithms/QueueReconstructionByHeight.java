package greedy.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class QueueReconstructionByHeight {

  /**
   * In this algorithm, the task is to ensure that each height-index pair is placed in the right
   * position.
   *
   * <p>The algorithm works by sorting the array by height in descending order. In case of a tie,
   * the values are sorted based on the index value in ascending order.
   *
   * Once that is done, the array is scanned from left to right and values are inserted according
   * to their indices. Since the array is sorted in descending order, this ensures that in case of
   * two values have the index, the smaller one will be added later. And since the ArrayList add at
   * index method moves the existing values to the right, the smaller value always ends up getting
   * in front/ahead/to the left of the larger value, thereby still satisfying the required condition
   *
   * @param people: each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of
   *              people in front of this person who have a height greater than or equal to h
   * @return List of people arranged according to their height and index.
   *
   * Time complexity: O(n^2). Add method of list can take up to O(n) time in case of collision;
   * Space Complexity: O(n)
   *
   */
  public int[][] reconstructQueue(int[][] people) {
      Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

      int length = people.length;
      List<int[]> output = new ArrayList<>(length);

      for (int[] person : people) {
          output.add(person[1], person);
      }

      return output.toArray(new int[length][2]);
  }
}
