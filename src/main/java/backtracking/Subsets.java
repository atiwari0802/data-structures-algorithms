package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets {

  /**
   * This approach uses standard backtracking algorithm.
   *
   * <p>We start by enumerating all the subsets of all possibles sizes (from 0 to the the size of
   * the set). This approach preserves the order of the elements in the subsets.
   *
   * <p>We select every element and backtrack until we get the subset of the desired size. Only
   * subsequent elements are chosen. This ensures that all the elements following this element are
   * chosen. For example, for set {1, 2, 3} with subset size 2, for element 1, 2 and 3 will be
   * chosen ({1, 2} and {1, 3}). But for element 2, only 3 will be chosen ({2, 3}).
   *
   * <p>This process is repeated for all the sizes (from 0 to n).
   *
   * <p>Time Complexity: O(n X 2 ^ n); There are 2 ^ n subsets for a set with n elements. And we are
   * adding all the elements to a new array list once the requisite size is reached. This operation
   * takes O(n) time. Hence the time complexity: O(n X 2 ^ n).
   *
   * <p>Space Complexity: O(n X 2 ^ n)
   *
   * @param nums list of numbers as a set
   * @return All the subsets
   */
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    List<Integer> input = Arrays.stream(nums).boxed().collect(Collectors.toList());
    List<Integer> currentSolution = new ArrayList<>();

    for (int i = 0; i <= input.size(); i++) {
      currentSolution.clear();
      subsetsUtil(i, output, currentSolution, input, 0);
    }

    return output;
  }

  private void subsetsUtil(
      int maxSize,
      List<List<Integer>> output,
      List<Integer> currentSolution,
      List<Integer> input,
      int startIndex) {
    if (maxSize == currentSolution.size()) {
      output.add(new ArrayList<>(currentSolution));
    } else {
      for (int i = startIndex; i < input.size(); i++) {
        currentSolution.add(input.get(i));
        subsetsUtil(maxSize, output, currentSolution, input, i + 1);
        currentSolution.remove(currentSolution.size() - 1);
      }
    }
  }
}
