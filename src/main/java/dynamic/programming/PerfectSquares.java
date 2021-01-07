package dynamic.programming;

public class PerfectSquares {

  public int numSquares(int n) {
    if (n <= 3) {
      return n;
    }

    int minSquares = n;

    for (int i = 1; i <= Math.ceil(Math.sqrt(n)); i++) {
      int square = i * i;

      if (square > n) {
        break;
      }

      minSquares = Math.min(minSquares, 1 + numSquares(n - square));
    }

    return minSquares;
  }

  public int numSquaresDP(int n) {
    int[] dp = new int[n + 1];

    for (int i = 0; i < 4; i++) {
      dp[i] = i;
    }

    for (int i = 4; i <= n; i++) {
      dp[i] = i;

      for (int j = 1; j <= Math.ceil(Math.sqrt(i)); j++) {
        int square = j * j;
        if (square > i) {
          break;
        }
        dp[i] = Math.min(dp[i], 1 + dp[i - square]);
      }
    }

    return dp[n];
  }
}
