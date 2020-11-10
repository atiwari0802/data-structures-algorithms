package backtracking;

import java.util.List;
import java.util.ArrayList;

public class GenerateParentheses {
  /**
   * In this approach, we use depth-first search style traversal to enumerate all possible
   * solutions.
   *
   * <p>We start with an empty string and keep two indices to track the open and closed parentheses.
   * This can be visualized as a Binary Tree, where left nodes are all open parentheses and right
   * nodes are closed parentheses.
   *
   * <p>Below is a visualization (not dissimilar to In-order traversal):
   *
   *                (
   *             (     )
   *               )     (
   *                 )     )
   *
   * In the above example, for n = 2, the results are: (()), ()()
   * <p>At each step, we add the open or closed parentheses to the result string. Once the string
   * reaches the right length, the result is added to final list and the flow backtracks to explore
   * other possibilities.
   *
   * Time Complexity: (4 ^ n); Self balancing parentheses form a Catalan sequence.
   * (https://en.wikipedia.org/wiki/Catalan_number#Generalizations)
   *
   * Space Complexity: (4 ^ n) and O(n) to store the results
   *
   * @param n, number of parentheses pairs
   * @return List which is all the Combinations of balanced parentheses.
   */
  public List<String> generateParenthesis(int n) {
      List<String> results = new ArrayList<>();

      generateParenthesisHelper("", results, 0, 0, n);

      return results;
  }

  private void generateParenthesisHelper(
      String solutionSoFar,
      List<String> results,
      int openCount,
      int closedCount,
      int maxParenthesis) {
    if (solutionSoFar.length() == 2 * maxParenthesis) {
      results.add(solutionSoFar);
    } else {
      if (openCount < maxParenthesis) {
        generateParenthesisHelper(
            solutionSoFar.concat("("), results, openCount + 1, closedCount, maxParenthesis);
      }
      if (closedCount < openCount) {
        generateParenthesisHelper(
            solutionSoFar.concat(")"), results, openCount, closedCount + 1, maxParenthesis);
      }
    }
  }
}
