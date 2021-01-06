package graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberOfProvincesTest {

    private NumberOfProvinces numberOfProvinces;

    @BeforeEach
    public void setup() {
        numberOfProvinces = new NumberOfProvinces();
    }

    @Test
    public void testCountProvinces() {
        int[][] M = {{1,1,0},{1,1,0},{0,0,1}};

        int count = numberOfProvinces.findCircleNum(M);

        Assertions.assertEquals(2, count);
    }
}
