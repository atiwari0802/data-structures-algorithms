package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SearchInSortedAndRotatedArrayTest {

  private SearchInSortedAndRotatedArray searchInSortedAndRotatedArray;

  @BeforeEach
  public void setup() {
    searchInSortedAndRotatedArray = new SearchInSortedAndRotatedArray();
  }

  @Test
  public void testSearch() {
    List<Integer> numbers = List.of(4, 5, 6, 7, 0, 1, 2);
    int target = 0;

    int result = searchInSortedAndRotatedArray.search(numbers, target);

      Assertions.assertEquals(4, result);
  }
}
