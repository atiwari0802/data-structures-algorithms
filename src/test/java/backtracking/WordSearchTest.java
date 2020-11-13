package backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WordSearchTest {

  private WordSearch wordSearch;

  @BeforeEach
  public void setup() {
    wordSearch = new WordSearch();
  }

  @Test
  public void testIsPresent() {
    char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    String word = "SEE";

    Assertions.assertTrue(wordSearch.isPresent(board, word));
  }
}
