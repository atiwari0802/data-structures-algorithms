package greedy.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static greedy.algorithms.EmployeeFreeTime.Interval;

public class EmployeeFreeTimeTest {

  private EmployeeFreeTime employeeFreeTime;

  @BeforeEach
  public void setup() {
    employeeFreeTime = new EmployeeFreeTime();
  }

  @Test
  public void testEmployeeFreeTime() {
    List<List<Interval>> schedule =
        Arrays.asList(
            Arrays.asList(new Interval(1, 2), new Interval(5, 6)),
            Arrays.asList(new Interval(1, 3), new Interval(4, 10)));

    List<Interval> result = employeeFreeTime.employeeFreeTime(schedule);

    result.forEach(interval -> System.out.printf(" %d, %d \n", interval.start, interval.end));
  }
}
