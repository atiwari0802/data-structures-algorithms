package greedy.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFreeTime {
  /**
   * This approach is modelled after the Merge Intervals approach.
   *
   * <p>The first step is to create a unified flat list from the 2-D input list. We use java-8
   * streams and flat map to do it.
   *
   * <p>Once the list is converted into a unified list, the next step is to merge all the
   * overlapping intervals. To do that, we have to sort the list by the start time in ascending
   * order. One sorted, the criteria for an overlap is that the end of the last merged interval must
   * be greater than the start of the next interval.
   *
   * <p>Once the list has been merged, the free time intervals are the time frames between the
   * consecutive entries of the merged lists. To find those, we iterate over the sorted and merged
   * list and add intervals by picking end time of the first entry and the start time of the second.
   *
   * <p>Time Complexity: O(nLog(n)), where n is the total number of elements; Sorting the list has
   * average time complexity of O(nLog(n))
   *
   * <p>Space Complexity: O(n), n is the total number of elements in the input.
   *
   * @param schedule
   * @return intervals of free time for all the employees
   */
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> unifiedIntervals =
        schedule.stream().flatMap(List::stream).collect(Collectors.toList());
    List<Interval> mergedIntervals = new ArrayList<>();
    List<Interval> freeTimeIntervals = new ArrayList<>();

    unifiedIntervals.sort(
        (i1, i2) ->
            i1.start == i2.start
                ? Integer.compare(i1.end, i2.end)
                : Integer.compare(i1.start, i2.start));

    for (Interval interval : unifiedIntervals) {
      int size = mergedIntervals.size();
      if (mergedIntervals.isEmpty() || mergedIntervals.get(size - 1).end < interval.start) {
        mergedIntervals.add(interval);
      } else {
        mergedIntervals.get(size - 1).end =
            Math.max(mergedIntervals.get(size - 1).end, interval.end);
      }
    }

    for (int i = 0; i < mergedIntervals.size() - 1; i++) {
      freeTimeIntervals.add(
          new Interval(mergedIntervals.get(i).end, mergedIntervals.get(i + 1).start));
    }

    return freeTimeIntervals;
  }

  static class Interval {
    public int start, end;

    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
