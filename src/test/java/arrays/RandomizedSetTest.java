package arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomizedSetTest {

    private RandomizedSet randomizedSet;

    @BeforeEach
    public void setup() {
        randomizedSet = new RandomizedSet();
    }

    @Test
    public void testRandomizedSet() {
        randomizedSet.insert(1);
        randomizedSet.insert(2);
        randomizedSet.insert(3);
        randomizedSet.insert(4);

        randomizedSet.getRandom();

        randomizedSet.remove(3);

    }
}
