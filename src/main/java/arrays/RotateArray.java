package arrays;

import java.util.Collections;
import java.util.List;

public class RotateArray {
    /**
     * In this approach, we first transpose the matrix and then reverse all the rows
     * to get a clockwise rotation. In case we wanted a counter-clockwise rotation,
     * we will reverse all the columns.
     *
     * Example: Upon transposing:
     * [ 1, 2, 3 ]                [ 1, 4, 7 ]
     * [ 4, 5, 6 ]    ======>     [ 2, 5, 8 ]
     * [ 7, 8, 9 ]                [ 3, 6, 9 ]
     *
     * Upon Reversing the rows, we get a matrix that has been rotated by 90 degrees in clockwise direction:
     *
     * [ 7, 4, 1 ]
     * [ 8, 5, 2 ]
     * [ 9, 6, 3 ]
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     *
     * @param matrix
     * @return matrix that has been rotated by 90 degrees
     */
    public List<List<Integer>> rotateClockwiseUsingTranspose(List<List<Integer>> matrix) {
        int size = matrix.size();

        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                int temp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(j).get(i));
                matrix.get(j).set(i, temp);
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size / 2; j++) {
                int temp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(i).get(size - j - 1));
                matrix.get(i).set(size -j - 1, temp);
            }
        }

        return matrix;
    }

    /**
     * Each square matrix has exactly N / 2 cycles of rectangles.
     * In this approach, starting with the outermost cycle, we identify four corners of
     * the matrix as rectangle.
     *
     * Regardless of the direction of the rotation (clockwise v/s counter clockwise),
     * we can divide each cycle into 4 rectangles, with each corner representing
     * the starting point of that rectangle. Each rectangle can contain only of corner
     * and spans along the length of the rows and columns, excluding the other corner
     * which is not included. A good way would be to start from the top left edge and
     * moving in clockwise direction to define 4 rectangles for each cycle.
     *
     * Once the rectangles are defined, start swapping corresponding cells
     * in adjacent rectangles in the direction of the rotation. Starting from the
     * corner, each cell corresponds to a cell in the adjacent rectangle that has the
     * same distance from its corner, counting in the direction of the rotation.
     *
     * Pictorial Representation can be found in the resource directory.
     *
     * Once the above is defined, identify the cell that need to be swapped.
     *
     * For example, for counter clockwise rotation, two iterations for the outermost
     * cycle would transform the matrix as follows:
     *
     *           1  2  3 4
                 5  6  7 8
                 9 10 11 12
                 13 14 15 16
     *
     *           4  2  3 16
                 5  6  7 8
                 9 10 11 12
                 1 14  15 13

                 4  8  3 16
                 5  6  7  15
                 2  10 11 12
                 1  14  9 13

     * Identify the cell pattern for swapping. For counter clockwise direction, the pattern
     * will be:
     *   i, j <--- j, n - 1 - i
     *   j, n - 1 - i <--- n - 1 - i, n - 1 - j
     *   n - 1 - i, n - 1 - j <--- n - 1 -j, i
     *   n - 1 - j, i <--- i, j
     *
     * Complete such iterations for all the rings.
     * @param matrix
     */
    public List<List<Integer>> rotateMatrixUsingRectangleMethod(List<List<Integer>> matrix) {
        int size = matrix.size();
        int cycles = size / 2;

        for (int i = 0; i < cycles; i++) {
            for (int j = i; j < size - i - 1; j++) {
                int temp = matrix.get(i).get(j);

                matrix.get(i).set(j, matrix.get(j).get(size - 1 - i));
                matrix.get(j).set(size - 1 - i, matrix.get(size - 1 - i).get(size - 1 - j));
                matrix.get(size - 1 - i).set(size - 1 - j, matrix.get(size - 1 - j).get(i));
                matrix.get(size - 1 - j).set(i, temp);
            }
        }

        return matrix;
    }

}
