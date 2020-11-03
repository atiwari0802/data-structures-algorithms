package arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FindRangeInSortedArrayTest {

  private FindRangeInSortedArray findRangeInSortedArray;

  @BeforeEach
  public void setup() {
    findRangeInSortedArray = new FindRangeInSortedArray();
  }

  @Test
  public void testFindRange() {
    int[] nums = {5, 7, 7, 8, 8, 10};
    int target = 8;

    int[] result = findRangeInSortedArray.searchRange(nums, target);

    Arrays.stream(result)
        .boxed()
        .collect(Collectors.toList())
        .forEach(i -> System.out.printf(" %d ", i));
  }
}
