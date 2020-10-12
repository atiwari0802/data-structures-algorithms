package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LargestHistogramAreaTest {

    private LargestHistogramArea largestHistogramArea;

    @BeforeEach
    public void setup() {
        largestHistogramArea = new LargestHistogramArea();
    }

    @Test
    public void testLargestArea() {
        List<Integer> heights = Arrays.asList(2, 1, 5, 6, 2, 3);

        int maxArea = largestHistogramArea.largestHistogramArea(heights);

        Assertions.assertEquals(10, maxArea);
    }
}
