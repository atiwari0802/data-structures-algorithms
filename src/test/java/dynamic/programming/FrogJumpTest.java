package dynamic.programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FrogJumpTest {

  private FrogJump frogJump;

  @BeforeEach
  public void setup() {
    frogJump = new FrogJump();
  }

  @Test
  public void testRecursive() {
    int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};

    Assertions.assertTrue(frogJump.canCross(stones));
  }

  @Test
  public void testDP() {
    int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};

    Assertions.assertTrue(frogJump.canCrossDP(stones));
  }
}
