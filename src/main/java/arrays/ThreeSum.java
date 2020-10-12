package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ThreeSum {
    /**
     * In this approach, the first step is to sort the array.
     * Then we fix each index as pivot and scan all the elements to
     * the right of this pivot using the sliding window technique.
     * <p>
     * Two pegs are set: one immediately to the right of the peg and the
     * other one at the end of the array. If the combined sum of the elements
     * at the pivot, left and right peg comes out to be zero, then we add these
     * entries to the output. If it is greater than zero, then, the right peg is moved
     * to the left. If the sum is less than zero, the left peg is moved to the right.
     * That's because the array is sorted and moving to the right will increase the sum
     * and moving to the left will reduce it.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n) if output is considered. O(1) otherwise
     * @param input
     * @return
     */
    public List<List<Integer>> findThreeSum(List<Integer> input) {
        List<List<Integer>> result = new ArrayList<>();

        input.sort(Comparator.comparingInt(a -> a));

        for (int i = 0; i < input.size(); i++) {
            if (i == 0 || !input.get(i - 1).equals(input.get(i))) {
                int lo = i + 1;
                int high = input.size() - 1;
                while (lo < high) {
                    int sum = input.get(i) + input.get(lo) + input.get(high);
                    if (sum == 0) {
                        result.add(List.of(input.get(i), input.get(lo++), input.get(high--)));
                        while (lo < high && input.get(lo).equals(input.get(lo - 1))) {
                            lo++;
                        }
                    } else if (sum < 0) {
                        lo++;
                    } else {
                        high--;
                    }
                }
            }
        }

        return result;
    }

}
