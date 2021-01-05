package dynamic.programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaximalSquareTest {

    private MaximalSquare maximalSquare;

    @BeforeEach
    public void setup() {
        maximalSquare = new MaximalSquare();
    }

    @Test
    public void testMaxSquare() {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

        int maxSquareArea = maximalSquare.maximalSquare(matrix);

        Assertions.assertEquals(4, maxSquareArea);
    }
}
