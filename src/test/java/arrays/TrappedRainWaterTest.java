package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TrappedRainWaterTest {

  private TrappedRainWater trappedRainWater;

  @BeforeEach
  public void setup() {
    trappedRainWater = new TrappedRainWater();
  }

  @Test
  public void testTrappedRainWaterDP() {
    List<Integer> elevationMap = List.of(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1);

    int totalWater = trappedRainWater.trappedRainWaterDP(elevationMap);

    Assertions.assertEquals(6, totalWater);
  }

  @Test
  public void testTrappedRainWaterStack() {
    List<Integer> elevationMap = List.of(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1);

    int totalWater = trappedRainWater.trappedRainWaterStack(elevationMap);

    Assertions.assertEquals(6, totalWater);
  }
}
