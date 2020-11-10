package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

  /**
   * This is a classic backtracking problem. In this problem, the solution space is explored in a
   * Depth-first manner.
   *
   * <p>We start with the first element and swap it with every other element in the list that comes
   * after it. The same process is repeated for each subsequent element until we reach the end of
   * the list.
   *
   * <p>After each swap, the solution is constructed incrementally. Once the solution is fully
   * constructed, the input is restored back to its original state by swapping the elements back.
   *
   * Time Complexity: O(n X n!); there are n! permutations of the number of size n and it takes n iterations
   * to copy these values to the output array list.
   * Space Complexity: O(n!); since there are n! permutations.
   *
   * @param nums
   * @return List of all permutations of the number
   */
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    int first = 0;
    List<Integer> input = Arrays.stream(nums).boxed().collect(Collectors.toList());

    backtrack(input, output, first);

    return output;
  }

  private void backtrack(List<Integer> input, List<List<Integer>> output, int first) {
    if (first == input.size()) {
      output.add(new ArrayList<>(input));
    } else {
      for (int i = first; i < input.size(); i++) {
        Collections.swap(input, first, i);
        backtrack(input, output, first + 1);
        Collections.swap(input, first, i);
      }
    }
  }
}
