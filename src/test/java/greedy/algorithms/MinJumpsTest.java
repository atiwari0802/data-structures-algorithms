package greedy.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MinJumpsTest {

    private MinJumps minJumps;

    @BeforeEach
    public void setup() {
        minJumps = new MinJumps();
    }

    @Test
    public void testMinimumJumps() {
        List<Integer> numbers = List.of(2, 3, 1, 1, 4);

        int result = minJumps.minimumJumpsToTheEnd(numbers);

        Assertions.assertEquals(2, result);
    }
}
