package arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    /**
     * In this approach the intervals are sorted first to ensure
     * that all the intervals are in their correct places.
     *
     * Once sorted, the list is scanned is from Left to Right.
     * If the last element of the merged list has its end index
     * greater than start index of the next element, the interval
     * is merged with the existing last element, with the last
     * index being larger of the two end indices.
     *
     * Time Complexity: O(nLog(n)), sorting takes n-Log(n) time
     * Space Complexity: O(1), if output array is ignored. O(n) otherwise
     *
     * @param intervals: the list of unsorted intervals.
     * @return merged intervals list.
     */
    List<Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        intervals.sort(Comparator.comparingInt(Interval::getStart));

        for (Interval interval : intervals) {
            int lastIndex = result.size() - 1;
            if (!result.isEmpty() && result.get(lastIndex).end > interval.start) {
                result.get(lastIndex).end = Math.max(result.get(lastIndex).end, interval.end);
            } else {
                result.add(interval);
            }
        }

        return result;
    }

    static class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return this.start;
        }
    }
}
