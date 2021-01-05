package dynamic.programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinimumCostPathTest {

    private MinimumCostPath minimumCostPath;

    @BeforeEach
    public void setup() {
        minimumCostPath = new MinimumCostPath();
    }

    @Test
    public void testMinPathRecursive() {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};

        int minPath = minimumCostPath.minPathSumRecursive(grid);

        Assertions.assertEquals(12, minPath);
    }

    @Test
    public void testMinPathDP() {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};

        int minPath = minimumCostPath.minPathSum(grid);

        Assertions.assertEquals(12, minPath);

    }
}
