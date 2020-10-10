package arrays;

import java.util.List;

public class BuyAndSellStocks {

    /**
     * In this approach, we can only choose to sell after
     * buying the stock once. That is, in the array, the
     * buying index must be to the left of the selling index.
     *
     * We scan the array from left to right. At each step,
     * we choose the smallest value that has been observed so far
     * and also calculate profit that will be made if the stock is
     * sold at the current index. If the maximum profit seen so far
     * is smaller than the current profit value, it is replaced.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param input
     * @return
     */
    public int maxProfit(List<Integer> input) {
        int smallestSeenSoFar = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int num : input) {
            smallestSeenSoFar = Math.min(num, smallestSeenSoFar);
            maxProfit = Math.max(num - smallestSeenSoFar, maxProfit);
        }

        return maxProfit;
    }
}
