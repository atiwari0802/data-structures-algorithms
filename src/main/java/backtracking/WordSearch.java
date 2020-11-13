package backtracking;

public class WordSearch {

  /**
   * This approach uses Depth First Search concept.
   *
   * <p>In this approach, each character in the board is examined. If there is a match, then, the
   * adjacent characters are searched. The movements are restricted to up, down, left and right.
   *
   * <p>For every match, we replace that character on the board with a # (this is to avoid it from
   * being counted again).
   *
   * <p>After this, we search the adjacent cells in the board to check if there are subsequent
   * matches. An index variable is used to keep a track of the character that is to be matched.
   *
   * <p>If the entire word matches, we return true. If not, the # is replaced by the original
   * character at the index.
   *
   * <p>Time Complexity: O(m X n X 4 ^ L); m and n are rows and columns and L is the length of the
   * string. So, for each character we have 4 choices. Total no. of characters are L, where L is the
   * length of the input string. So one invocation of search function of your implementation would
   * take (4 ^ L) time. The worst case would be to search all the cells (m X n).
   *
   * <p>Space Complexity: O(L); L is the Length of the string. (max height of the recursion tree)
   *
   * @param board
   * @param word
   * @return true if the word is present; false otherwise
   */
  public boolean isPresent(char[][] board, String word) {
    int rows = board.length;
    int columns = board[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (isWordPresent(board, word, 0, i, j)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean isWordPresent(char[][] board, String word, int index, int row, int column) {
    if (index >= word.length()) {
      return true;
    }

    if (row < 0
        || row >= board.length
        || column < 0
        || column >= board[0].length
        || board[row][column] != word.charAt(index)) {
      return false;
    }

    int[] rowOffsets = {0, 0, -1, 1};
    int[] colOffsets = {-1, 1, 0, 0};

    board[row][column] = '#';

    for (int i = 0; i < 4; i++) {
      if (isWordPresent(board, word, index + 1, row + rowOffsets[i], column + colOffsets[i])) {
        return true;
      }
    }

    board[row][column] = word.charAt(index);

    return false;
  }
}
