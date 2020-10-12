package arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ThreeSumTest {

    private ThreeSum threeSum;

    @BeforeEach
    public void setup() {
        threeSum = new ThreeSum();
    }

    @Test
    public void testThreeSum() {
        List<Integer> input = Arrays.asList(-1, 0, 1, 2, -1, -4);

        List<List<Integer>> result = threeSum.findThreeSum(input);

        result.forEach(list -> list.forEach(num -> System.out.printf(" %d, ", num)));
    }
}
