package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
  /**
   * The idea behind this approach is parse the matrix in a layered order.
   *
   * <p>Initially we set the pegs at the 4 corners of the matrix. This makes the first layer of the
   * matrix.
   *
   * <p>We squeeze these corners inwards with every iteration, which takes us to the next layer.
   * This is done by incrementing and decrementing values left and right corners respectively.
   *
   * <p>As far as traversing the matrix is concerned, we move from top left corner to the bottom
   * right corner, then from top right corner to the bottom right. After that, we traverse from the
   * bottom right to bottom left and finally move up from bottom left to top right. All these
   * traversals avoid visiting the same elements twice.
   *
   * Time Complexity: O(R X C)
   * Space Complexity: O(R X C) if output is considered. O(1) otherwise
   * @param matrix
   * @return Spiral Order Traversal
   */
  public List<Integer> printSpiralOrder(List<List<Integer>> matrix) {
    List<Integer> spiralOrder = new ArrayList<>();

    int rowStart = 0;
    int rowEnd = matrix.size() - 1;
    int colStart = 0;
    int colEnd = matrix.get(0).size() - 1;

    while (rowStart <= rowEnd && colStart <= colEnd) {
      for (int j = colStart; j <= colEnd; j++) {
        spiralOrder.add(matrix.get(rowStart).get(j));
      }

      for (int i = rowStart + 1; i <= rowEnd; i++) {
        spiralOrder.add(matrix.get(i).get(colEnd));
      }

      for (int j = colEnd - 1; j > colStart; j--) {
        spiralOrder.add(matrix.get(rowEnd).get(j));
      }

      for (int i = rowEnd; i > rowStart; i--) {
        spiralOrder.add(matrix.get(i).get(colStart));
      }

      rowStart++;
      rowEnd--;
      colStart++;
      colEnd--;
    }

    return spiralOrder;
  }
}
