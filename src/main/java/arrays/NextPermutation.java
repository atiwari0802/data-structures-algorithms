package arrays;

import java.util.Collections;
import java.util.List;

public class NextPermutation {

    /**
     * This approach is formulaic, i.e. it's difficult to deduce
     * unless it's known in advance.
     * <p>
     * Here are the steps:
     * a.) Scan the array from right to left until the elements are
     * arranged in a ascending order.
     * b.) Find the first cell/entry that's smaller than the entry to its right.
     * Lets call this index i.
     * c.) Next, iterate from i until the end of the list to find the smallest
     * element that's greater than the element at index i.
     * d.) Swap the above element with the element at i.
     * e.) Reverse the list from index i until the end.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param input of numbers
     * @return next permutation that's larger than the current or first permutation
     * if nothing greater exists.
     */
    public List<Integer> findNextPermutation(List<Integer> input) {
        int i = input.size() - 2;

        while (i >= 0 && input.get(i) > input.get(i + 1)) {
            i--;
        }

        if (i == 0) {
            Collections.reverse(input);
            return input;
        }

        int j = input.size() - 1;
        while (j >= 0 && input.get(i) > input.get(j)) {
            j--;
        }

        Collections.swap(input, i, j);
        Collections.reverse(input.subList(i + 1, input.size()));

        return input;
    }
}
