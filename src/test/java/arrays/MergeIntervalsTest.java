package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static arrays.MergeIntervals.Interval;

public class MergeIntervalsTest {

    private MergeIntervals mergeIntervals;

    @BeforeEach
    public void setup() {
        mergeIntervals = new MergeIntervals();
    }

    @Test
    public void testMergeIntervals() {
        List<Interval> intervals = Arrays.asList(new Interval(1, 3), new Interval(2, 6),
                new Interval(8, 10), new Interval(15, 18));

        List<Interval> mergedIntervals = mergeIntervals.mergeIntervals(intervals);

        Assertions.assertEquals(3, mergedIntervals.size());
    }
}
