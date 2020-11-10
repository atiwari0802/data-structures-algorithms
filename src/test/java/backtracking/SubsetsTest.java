package backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SubsetsTest {

    private Subsets subsets;

    @BeforeEach
    public void setup() {
        subsets = new Subsets();
    }

    @Test
    public void testGetSubsets() {
        int[] nums = {1, 2, 3};

        List<List<Integer>> allSubsets =  subsets.subsets(nums);

        for (List<Integer> list: allSubsets) {
            for (int i : list) {
                System.out.printf(" %d ", i);
            }
            System.out.println();
        }
    }
}
