package dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public int numDecodingsRecursive(String s) {
        return numDecodingHelper(0, s);
    }

    /**
     *  Time Complexity:
     *      T(n) = 2 * T(n - 1) + 1 (roughly)
     *
     *      This translates to ~~ O(2 ^ n); Memoization will reduce the complexity to O(n)
     *  Space Complexity: O(n)
     * @param s
     * @return
     */
    public int numDecodingsMemoized(String s) {
        Map<Integer, Integer> memo = new HashMap<>();

        return numDecodingHelperMemozied(0, s, memo);
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (Integer.valueOf(s.substring(i - 2, i)) >= 10 && Integer.valueOf(s.substring(i - 2, i)) <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        for (int i : dp) {
            System.out.printf(" %d ", i);
        }
        return dp[n];
    }

    private int numDecodingHelperMemozied(int index, String input, Map<Integer, Integer> memo) {
        if (index >= input.length()) {
            return 1;
        }
        if (input.charAt(index) == '0') {
            return 0;
        }

        if (memo.containsKey(index)) {
            System.out.println("Memo Hit");
            return memo.get(index);
        }

        int totalWays = numDecodingHelperMemozied(index + 1, input, memo);
        if (index + 2 <= input.length() && Integer.valueOf(input.substring(index, index + 2)) <= 26) {
            totalWays += numDecodingHelperMemozied(index + 2, input, memo);
        }

        memo.put(index, totalWays);

        return totalWays;
    }


    private int numDecodingHelper(int index, String input) {
        if (index >= input.length() - 1) {
            return 1;
        }

        if (input.charAt(index) == '0') {
            return 0;
        }

        int totalWays = numDecodingHelper(index + 1, input);

        if (index + 2 <= input.length() && Integer.valueOf(input.substring(index, index + 2)) <= 26) {
            totalWays += numDecodingHelper(index + 2, input);
        }

        return totalWays;
    }
}
