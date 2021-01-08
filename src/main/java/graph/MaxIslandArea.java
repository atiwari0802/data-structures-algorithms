package graph;

public class MaxIslandArea {

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, area(grid, seen, i, j));
                }
            }
        }

        return maxArea;
    }

    private int area(int[][] grid, boolean[][] seen, int r, int c) {
        if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0 ||
            grid[r][c] == 0 || seen[r][c])  {
            return 0;
        }

        seen[r][c] = true;

        return (1 + area(grid, seen, r + 1, c) + area(grid, seen, r - 1, c)
                + area(grid, seen, r, c + 1) + area(grid, seen, r, c - 1));
    }
}
