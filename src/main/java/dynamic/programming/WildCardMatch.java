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
}
