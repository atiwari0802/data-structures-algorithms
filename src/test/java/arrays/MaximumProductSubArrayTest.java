package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MaximumProductSubArrayTest {

  private MaximumProductSubArray maximumProductSubArray;

  @BeforeEach
  public void setup() {
    maximumProductSubArray = new MaximumProductSubArray();
  }

  @Test
  public void testMaxProduct() {
    List<Integer> numbers = List.of(2, -5, 3, 1, -4, 0, -10, 2, 8);

    int maxProduct = maximumProductSubArray.findMaximumProduct(numbers);

    Assertions.assertEquals(120, maxProduct);
  }
}
