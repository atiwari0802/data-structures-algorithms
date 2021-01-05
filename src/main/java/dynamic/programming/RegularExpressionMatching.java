package dynamic.programming;

public class RegularExpressionMatching {

    /**
     * Time Complexity: O(m X n);
     * Space Complexity: O(m X n);
     * @param s
     * @param p
     * @return
     */
    public boolean isMatchDP(String s, String p) {
        boolean[][] table = new boolean[s.length() + 1][p.length() + 1];

        table[0][0] = true;

        for (int j = 1; j < table[0].length; j++) {
            if (p.charAt(j - 1) == '*') {
                table[0][j] = table[0][j -2];
            }
        }

        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    table[i][j] = table[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) == s.charAt(i - 1)) {
                        table[i][j] = table[i - 1][j];
                    } else {
                        table[i][j] = table[i][j - 2];
                    }
                } else {
                    table[i][j] = false;
                }
            }
        }

        return table[s.length()][p.length()];
    }

    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];

        return isMatchHelper(s, p, 0, 0, memo);
    }

    private boolean isMatchHelper(String s, String p, int strIndex, int pIndex, Boolean[][] memo) {
        boolean answer;

        if (pIndex == p.length()) {
            answer = strIndex == s.length();
            return answer;
        }

        if (memo[strIndex][pIndex] != null) {
            return memo[strIndex][pIndex];
        }

        boolean doesCharMatch = strIndex < s.length() && (p.charAt(pIndex) == s.charAt(strIndex) || p.charAt(pIndex) == '.');

        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            answer = isMatchHelper(s, p, strIndex, pIndex + 2, memo)
                || doesCharMatch && isMatchHelper(s, p, strIndex + 1, pIndex, memo);
        } else {
            answer = doesCharMatch && isMatchHelper(s, p, strIndex + 1, pIndex + 1, memo);
        }

        memo[strIndex][pIndex] = answer;

        return answer;
    }

    /**
     * Time Complexity: 2 ^ N (Recurrence Relation would roughly be T(n) = 2 X T(n - 1))
     * @param s
     * @param p
     * @return
     */
    public boolean isMatchRecursive(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean doesCharMatch = (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatchRecursive(s, p.substring(2)) || doesCharMatch && isMatchRecursive(s.substring(1), p);
        } else {
            return isMatchRecursive(s.substring(1), p.substring(1));
        }
    }


}
