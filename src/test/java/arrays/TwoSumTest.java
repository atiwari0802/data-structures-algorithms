package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwoSumTest {

  private TwoSum twoSum;

  @BeforeEach
  public void setup() {
    twoSum = new TwoSum();
  }

  @Test
  public void testTwoSum() {
    int[] nums = {2, 7, 11, 15};
    int target = 9;

    Assertions.assertNotNull(twoSum.twoSum(nums, target));
  }
}
