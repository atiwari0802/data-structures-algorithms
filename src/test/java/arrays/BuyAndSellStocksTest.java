package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BuyAndSellStocksTest {

    public BuyAndSellStocks buyAndSellStocks;

    @BeforeEach
    public void setup() {
        buyAndSellStocks = new BuyAndSellStocks();
    }

    @Test
    public void testMaxProfit() {
        List<Integer> input = List.of(7, 1, 5, 3, 6, 4);

        int result = buyAndSellStocks.maxProfit(input);

        Assertions.assertEquals(5, result);
    }
}
