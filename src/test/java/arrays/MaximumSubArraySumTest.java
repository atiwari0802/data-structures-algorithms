package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static arrays.MaximumSubArraySum.MaxSubArrayWindow;

public class MaximumSubArraySumTest {

    private MaximumSubArraySum maximumSubArraySum;

    @BeforeEach
    public void setup() {
        maximumSubArraySum = new MaximumSubArraySum();
    }

    @Test
    public void testMaxSubArraySum() {
        List<Integer> input = List.of(-2, 1, -3, 4, -1, 2, 1, -5, 4);

        MaxSubArrayWindow window = maximumSubArraySum.findMaxSubArraySumWithIndices(input);

        Assertions.assertEquals(6, window.maxSum);
        Assertions.assertEquals(3, window.startIndex);
        Assertions.assertEquals(6, window.endIndex);
    }
}
