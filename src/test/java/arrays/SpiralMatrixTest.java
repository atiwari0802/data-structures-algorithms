package arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SpiralMatrixTest {

  private SpiralMatrix spiralMatrix;

  @BeforeEach
  public void setup() {
    spiralMatrix = new SpiralMatrix();
  }

  @Test
  public void testSpiralOrderOddMatrix() {
    List<List<Integer>> matrix = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));

    List<Integer> spiralOrder = spiralMatrix.printSpiralOrder(matrix);

    spiralOrder.forEach(i -> System.out.printf(" %d, ", i));
  }

  @Test
  public void testSpiralOrderEvenMatrix() {
    List<List<Integer>> matrix = List.of(List.of(1, 2, 3, 4), List.of(5, 6, 7, 8), List.of(9, 10, 11, 12));

    List<Integer> spiralOrder = spiralMatrix.printSpiralOrder(matrix);

    spiralOrder.forEach(i -> System.out.printf(" %d, ", i));
  }
}
