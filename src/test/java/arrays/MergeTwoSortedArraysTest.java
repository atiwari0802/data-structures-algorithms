package arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedArraysTest {

    private MergeTwoSortedArrays mergeTwoSortedArrays;

    @BeforeEach
    public void setup() {
        mergeTwoSortedArrays = new MergeTwoSortedArrays();
    }

    @Test
    public void testMergeTwoSortedArrays() {
        List<Integer> one = Arrays.asList(1, 2, 3, 0, 0, 0);
        int m = 3;
        List<Integer> two = Arrays.asList(2, 5, 6);
        int n = 3;

        List<Integer> result = mergeTwoSortedArrays.mergeTwoSortedArrays(one, two, m, n);

        result.forEach(i -> System.out.printf(" %d, ", i));
    }
}
