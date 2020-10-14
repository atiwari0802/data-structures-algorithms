package arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RotateArrayTest {

  private RotateArray rotateArray;

  @BeforeEach
  public void setup() {
    rotateArray = new RotateArray();
  }

  @Test
  public void testRotateMatrixTranspose() {
    List<List<Integer>> matrix =
        Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));

    List<List<Integer>> rotatedMatrix = rotateArray.rotateClockwiseUsingTranspose(matrix);

    for (int i = 0; i < rotatedMatrix.size(); i++) {
      System.out.println();
      for (int j = 0; j < rotatedMatrix.size(); j++) {
        System.out.printf(" %d ", rotatedMatrix.get(i).get(j));
      }
    }
  }

  @Test
  public void testRotateMatrixRectangle() {
    List<List<Integer>> matrix =
        Arrays.asList(
            Arrays.asList(1, 2, 3, 4),
            Arrays.asList(5, 6, 7, 8),
            Arrays.asList(9, 10, 11, 12),
            Arrays.asList(13, 14, 15, 16));

    List<List<Integer>> rotatedMatrix = rotateArray.rotateMatrixUsingRectangleMethod(matrix);

    for (int i = 0; i < rotatedMatrix.size(); i++) {
      System.out.println();
      for (int j = 0; j < rotatedMatrix.size(); j++) {
        System.out.printf(" %d ", rotatedMatrix.get(i).get(j));
      }
    }
  }
}
