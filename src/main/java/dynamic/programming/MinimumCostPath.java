package dynamic.programming;

public class MinimumCostPath {

    /**
     * Time Complexity: O(m X n)
     * Space Complexity: O(m X n)
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int[][] costMatrix = new int[grid.length][grid[0].length];

        costMatrix[0][0] = grid[0][0];

        for (int i = 1; i < grid.length; i++) {
            costMatrix[i][0] = grid[i][0] + costMatrix[i - 1][0];
        }

        for (int j = 1; j < grid[0].length; j++) {
            costMatrix[0][j] = grid[0][j] + costMatrix[0][j - 1];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                costMatrix[i][j] = grid[i][j] + Math.min(costMatrix[i - 1][j], costMatrix[i][j -1]);
            }
        }

        return costMatrix[grid.length - 1][grid[0].length - 1];
    }

    /**
     * Time complexity : O(2 ^ (m + n))
     * Space Complexity: O(m + n)
     * @param grid
     * @return
     */
    public int minPathSumRecursive(int[][] grid) {
        return minPathHelper(grid, grid.length - 1, grid[0].length - 1);
    }

    private int minPathHelper(int[][] grid, int rowIdx, int colIdx) {
        if (rowIdx < 0 || colIdx < 0) {
            return Integer.MAX_VALUE;
        }

        if (rowIdx == 0 && colIdx == 0) {
            return grid[0][0];
        }

        return grid[rowIdx][colIdx] + Math.min(minPathHelper(grid, rowIdx - 1, colIdx), minPathHelper(grid, rowIdx, colIdx - 1));
    }
}
