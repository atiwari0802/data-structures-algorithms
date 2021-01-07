package dynamic.programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PerfectSquaresTest {

  private PerfectSquares perfectSquares;

  @BeforeEach
  public void setup() {
    perfectSquares = new PerfectSquares();
  }

  @Test
  public void testRecursive() {
    int n = 12;

    int answer = perfectSquares.numSquares(n);

    Assertions.assertEquals(3, answer);
  }

  @Test
  public void testDP() {
    int n = 12;

    int answer = perfectSquares.numSquaresDP(n);

    Assertions.assertEquals(3, answer);
  }
}
