package arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MoveZerosTest {

  private MoveZeros moveZeros;

  @BeforeEach
  public void setup() {
    moveZeros = new MoveZeros();
  }

  @Test
  public void testMoveZeroes() {
    List<Integer> numbers = Arrays.asList(0, 1, 0, 3, 12);

    List<Integer> result = moveZeros.moveZeroes(numbers);

    result.forEach(i -> System.out.printf(" %d, ", i));
  }
}
