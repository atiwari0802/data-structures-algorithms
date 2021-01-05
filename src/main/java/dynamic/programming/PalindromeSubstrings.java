package dynamic.programming;

public class PalindromeSubstrings {

    /**
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(n ^2)
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int length = s.length();
        int totalPalindromes = 0;

        boolean[][] dp = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            totalPalindromes++;
        }

        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                totalPalindromes++;
            }
        }

        for (int range = 2; range < length; range++) {
            int i = 0;
            int j = i + range;
            while (j < length) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                totalPalindromes += dp[i][j] ? 1: 0;
                i++;
                j++;
            }
        }

        return totalPalindromes;
    }
}
