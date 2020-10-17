package arrays;

import java.util.Collections;
import java.util.List;

public class MoveZeros {

  /**
   * The idea is borrowed from Quick Sort algorithm. We maintain an index for that points to zeroes.
   *
   * <p>As we scan the array, if we encounter a non-zero, we swap it with the zero index and
   * increment the zero index.
   *
   * <p>Time Complexity: O(n)
   *
   * <p>Space Complexity: O(1)
   *
   * @param numbers
   * @return array with all zeros moved to the right
   */
  public List<Integer> moveZeroes(List<Integer> numbers) {
    int zeroIndex = 0;
    int i = 0;

    while (i < numbers.size()) {
      if (numbers.get(i) != 0) {
        Collections.swap(numbers, i++, zeroIndex++);
      } else {
        i++;
      }
    }

    return numbers;
  }
}
