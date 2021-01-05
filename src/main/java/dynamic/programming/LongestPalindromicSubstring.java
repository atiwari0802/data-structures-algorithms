package dynamic.programming;

public class LongestPalindromicSubstring {
    /**
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int longestSoFar = 0;
        int startIndex = 0, endIndex = 0;

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            if (i <= length - 2 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && dp[i - 1][j + 1]) {
                    dp[i][j] = true;
                    if (longestSoFar < i - j + 1) {
                        longestSoFar = i - j + 1;
                        startIndex = j;
                        endIndex = i;
                    }
                }
            }
        }

        return s.substring(startIndex, endIndex + 1);
    }

}
