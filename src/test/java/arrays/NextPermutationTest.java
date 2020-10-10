package arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class NextPermutationTest {

    private NextPermutation nextPermutation;

    @BeforeEach
    public void setup() {
        nextPermutation = new NextPermutation();
    }

    @Test
    public void testNextPermuation() {
        List<Integer> input = Arrays.asList(1, 2, 3);

        List<Integer> output = nextPermutation.findNextPermutation(input);

        output.forEach(i -> System.out.printf(" %d,", i));
    }
}
