package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductOfArrayElementsExceptSelf {

  /**
   * In this approach, two intermediate arrays are used to store the product
   * of all the elements to the left and right of every cell in the input array.
   *
   * The final Product is calculated as the product of elements in the left and
   * right array for each index.
   *
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   *
   * @param input
   * @return product of all elements except self
   */
  public int[] productLinearSpace(int[] input) {
    int size = input.length;
    int[] leftProductArray = new int[size];
    int[] rightProductArray = new int[size];
    int[] answerArray = new int[size];
    leftProductArray[0] = 1;
    rightProductArray[size - 1] = 1;

    for (int i = 1; i < size; i++) {
      leftProductArray[i] = leftProductArray[i - 1] * input[i - 1];
    }
    for (int i = size - 2; i >= 0; i--) {
      rightProductArray[i] = rightProductArray[i + 1] * input[i + 1];
    }

    for (int i = 0; i < size; i++) {
      answerArray[i] = leftProductArray[i] * rightProductArray[i];
    }

    return answerArray;
  }

  /**
   * In this approach, an array is used to store the product
   * of all the elements to the left of each element.
   *
   * The final Product is calculated by maintaining a variable that stores successive
   * products of all the elements to the right of a given index.
   *
   * Time Complexity: O(n)
   * Space Complexity: O(1), if output array is ignored
   *
   * @param input
   * @return product of all elements except self
   */
  public List<Integer> productOfArrayConstantSpace(List<Integer> input) {
    List<Integer> answer = new ArrayList<>(Collections.nCopies(input.size(), 0));
    answer.set(0, 1);
    int rightProduct = 1;

    for (int i = 1; i < input.size(); i++) {
      answer.set(i, answer.get(i - 1) * input.get(i - 1));
    }

    for (int i = input.size() - 1; i >= 0; i--) {
      answer.set(i, answer.get(i) * rightProduct);
      rightProduct *= input.get(i);
    }

    return answer;
  }
}
