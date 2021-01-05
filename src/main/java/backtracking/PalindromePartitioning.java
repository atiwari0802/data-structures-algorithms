package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    /**
     *
     * T(n) = N * [ T(n - 1) + T(n - 2) + T(n - 3) + .... + T(0)]
     * T(n) = N * 2 [T(n - 2) + T(n - 3) + .... + T(0)]
     * T(n) = N * 2 ^ 2 * [T(n - 3) + .... + T(0)]
     * T(n) = N * 2 ^ 3 * [T(n - 4) + .... + T(0)]
     * .....
     * T(n) = N * 2 ^ N (T(0))
     * Time Complexity: O(N * 2 ^ N)
     * Space Complexity: O(N)
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> completeSolution = new ArrayList<>();
        List<String> currentSolution = new ArrayList<>();

        palindromePartitionHelper(0, s, currentSolution, completeSolution);

        return completeSolution;
    }

    private void palindromePartitionHelper(int startIndex, String input, List<String> currentSolution, List<List<String>> completeSolution) {
        if (startIndex >= input.length()) {
            completeSolution.add(new ArrayList<>(currentSolution));
            return;
        }

        for (int end = startIndex; end < input.length(); end++) {
            if (isPalindrome(input, startIndex, end)) {
                currentSolution.add(input.substring(startIndex, end + 1));
                palindromePartitionHelper(end + 1, input, currentSolution, completeSolution);
                currentSolution.remove(currentSolution.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String input, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            if (input.charAt(startIndex++) != input.charAt(endIndex--)) {
                return false;
            }
        }
        return true;
    }
}
