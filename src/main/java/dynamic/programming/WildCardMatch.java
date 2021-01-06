package dynamic.programming;

public class WildCardMatch {

  public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
      return false;
    }

    return isMatchRecursive(s.toCharArray(), p.toCharArray(), s.length(), p.length());
  }

  private boolean isMatchRecursive(char[] s, char[] p, int n, int m) {
    if (m <= 0 && n <= 0) {
      return true;
    }

    if (m <= 0) {
      return false;
    }

    if (n <= 0) {
      for (int i = 0; i < m; i++) {
        if (p[i] != '*') {
          return false;
        }
      }
    }

    if (s[n - 1] == p[m - 1] || p[m - 1] == '?') {
      return isMatchRecursive(s, p, n - 1, m - 1);
    }
    if (p[m - 1] == '*') {
      return (isMatchRecursive(s, p, n - 1, m) || isMatchRecursive(s, p, n, m - 1));
    } else {
      return false;
    }
  }

  public boolean isMatchMemoized(String s, String p) {
    if (s == null || p == null) {
      return false;
    }

    Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];

    return isMatchMemoized(s.toCharArray(), p.toCharArray(), s.length(), p.length(), memo);
  }

  private boolean isMatchMemoized(char[] s, char[] p, int n, int m, Boolean[][] memo) {
    if (m <= 0 && n <= 0) {
      return true;
    }

    if (m <= 0) {
      return false;
    }

    if (n <= 0) {
      for (int i = 0; i < m; i++) {
        if (p[i] != '*') {
          return false;
        }
      }
      return true;
    }

    if (memo[n][m] != null) {
      System.out.printf("Hit for s = %d, p = %d", n, m);
      return memo[n][m];
    }

    if (s[n - 1] == p[m - 1] || p[m - 1] == '?') {
      memo[n][m] = isMatchMemoized(s, p, n - 1, m - 1, memo);
    } else if (p[m - 1] == '*') {
      memo[n][m] = isMatchMemoized(s, p, n - 1, m, memo) || isMatchMemoized(s, p, n, m - 1, memo);
    } else {
      memo[n][m] = false;
    }

    return memo[n][m];
  }

  public boolean isMatchDP(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

    dp[0][0] = true;

    for (int i = 1; i < dp.length; i++) {
      dp[i][0] = false;
    }

    for (int j = 1; j < dp[0].length; j++) {
      if (p.charAt(j - 1) == '*') {
        dp[0][j] = dp[0][j - 1];
      }
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (p.charAt(j - 1) == '*') {
          dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
        } else {
          dp[i][j] = false;
        }
      }
    }

    return dp[s.length()][p.length()];
  }
}
