package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SubArraySumTest {

    private SubArraySum subArraySum;

    @BeforeEach
    public void setup() {
        subArraySum = new SubArraySum();
    }

    @Test
    public void testSubArraySum() {
        List<Integer> list = List.of(3, 4, 7, 2, -3, 1, 4, 2);
        int expectedSum = 7;

        int count = subArraySum.countSubsetsWithSpecificSum(list, expectedSum);

        Assertions.assertEquals(4, count);
    }
}
