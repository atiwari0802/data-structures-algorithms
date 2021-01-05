package dynamic.programming;

public class MaximalSquare {
    /**
     * Time Complexity: O(m X n)
     * Space Complexity: O(m X n)
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxSquare = 0;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                maxSquare = 1;
            }
        }

        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                maxSquare = 1;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
                if (dp[i][j] > maxSquare) {
                    maxSquare = dp[i][j];
                }
            }
        }

        return (int) Math.pow(maxSquare, 2);
    }
}
