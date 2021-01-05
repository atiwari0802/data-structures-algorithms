package backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CombinationSumTest {

    private CombinationSum combinationSum;

    @BeforeEach
    public void setup() {
        combinationSum = new CombinationSum();
    }

    @Test
    public void testCombinationSum() {
        int[] candidates = {2, 3, 5};
        int target = 8;

        List<List<Integer>> combinations = combinationSum.combinationSum(candidates, target);

        for (List<Integer> list : combinations) {
            for (int i : list) {
                System.out.printf(" %d ", i);
            }
            System.out.println();
        }
    }
}
