package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ContainerWithMostWaterTest {

    private ContainerWithMostWater containerWithMostWater;

    @BeforeEach
    public void setup() {
        containerWithMostWater = new ContainerWithMostWater();
    }

    @Test
    public void testMaxArea() {
        List<Integer> input = List.of(1, 8, 6, 2, 5, 4, 8, 3, 7);

        int maxArea = containerWithMostWater.maxArea(input);

        Assertions.assertEquals(49, maxArea);
    }
}
