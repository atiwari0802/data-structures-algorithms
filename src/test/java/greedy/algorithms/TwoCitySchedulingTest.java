package greedy.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwoCitySchedulingTest {

  private TwoCityScheduling twoCityScheduling;

  @BeforeEach
  public void setup() {
    twoCityScheduling = new TwoCityScheduling();
  }

  @Test
  public void testMinimumCost() {
    int[][] costs = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};

    int minCost = twoCityScheduling.twoCityScheduledCost(costs);

    Assertions.assertEquals(110, minCost);
  }
}
