package greedy.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GasUpProblemTest {

    private GasUpProblem gasupProblem;

    @BeforeEach
    public void setup() {
        gasupProblem = new GasUpProblem();
    }

    @Test
    public void testCanCompleteCircuit() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int result = gasupProblem.canCompleteCircuit(gas, cost);

        Assertions.assertEquals(3, result);

    }
}
