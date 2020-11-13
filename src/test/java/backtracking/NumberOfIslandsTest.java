package backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberOfIslandsTest {

  private NumberOfIslands numberOfIslands;

  @BeforeEach
  public void setup() {
    numberOfIslands = new NumberOfIslands();
  }

  @Test
  public void testNumberOfIslands() {
    char[][] grid = {
      {'1', '1', '0', '0', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '1', '0', '0'},
      {'0', '0', '0', '1', '1'}
    };

    int numberOfIsles = numberOfIslands.numberOfIslands(grid);

    Assertions.assertEquals(3, numberOfIsles);
  }
}
