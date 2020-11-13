package backtracking;

public class NumberOfIslands {

  /**
   * This is a classic depth first search. We start by inspecting each cell.
   * If it happens to be 1, then, we increment the count of number of islands by 1 and
   * start searching the adjacent cells. The movements that are allowed from each cell are
   * in horizontal and vertical directions only. For all the adjacent cells that are 1, we set
   * their values to 0, as they are part of the same island.
   *
   * The above process is repeated for every cell in the grid.
   *
   * Time Complexity: O( m X n); m and n are rows and columns respectively
   * Space Complexity: O(m X n); as the maximum depth of recursion could be
   * all the cells in the grid in case grid has all 1s.
   *
   * @param grid
   * @return number of islands
   */
  public int numberOfIslands(char[][] grid) {
    int numberOfIslands = 0;
    int rows = grid.length;
    int columns = grid[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (grid[i][j] == '1') {
          numberOfIslands++;
          depthFirstSearch(grid, i, j);
        }
      }
    }

    return numberOfIslands;
  }

  private void depthFirstSearch(char[][] grid, int row, int column) {
    if (row < 0
        || row >= grid.length
        || column < 0
        || column >= grid[0].length
        || grid[row][column] != '1') {
      return;
    }

    grid[row][column] = '0';

    depthFirstSearch(grid, row - 1, column);
    depthFirstSearch(grid, row + 1, column);
    depthFirstSearch(grid, row, column - 1);
    depthFirstSearch(grid, row, column + 1);
  }
}
