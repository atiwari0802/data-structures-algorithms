package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MaximalRectangleTest {

    private MaximalRectangle maximalRectangle;

    @BeforeEach
    public void setup() {
        maximalRectangle = new MaximalRectangle();
    }

    @Test
    public void testMaxRectangleArea() {
        List<List<Character>> input = List.of(
                List.of('1', '0', '1', '0', '0'),
                List.of('1', '0', '1', '1', '1'),
                List.of('1', '1', '1', '1', '1'),
                List.of('1', '0', '0', '1', '0')
        );

        int maxArea = maximalRectangle.maxRectangleArea(input);

        Assertions.assertEquals(6, maxArea);
    }
}
