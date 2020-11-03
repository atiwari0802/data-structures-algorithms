package arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DutchFlagProblemTest {

  private DutchFlagProblem dutchFlagProblem;

  @BeforeEach
  public void setup() {
    dutchFlagProblem = new DutchFlagProblem();
  }

  @Test
  public void testDutchFlagProblem() {
    int[] nums = {2, 0, 2, 1, 1, 0};

    nums = dutchFlagProblem.sortColors(nums);

    for (int num : nums) {
        System.out.printf(" %d ", num);
    }
  }
}
