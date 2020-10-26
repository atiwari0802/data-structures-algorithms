package greedy.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReorganizeStringTest {

    private ReorganizeString reorganizeString;

    @BeforeEach
    public void setup() {
        reorganizeString = new ReorganizeString();
    }

    @Test
    public void testReorganizeString() {
        String input = "aab";

        String result = reorganizeString.reorganizeString(input);

        Assertions.assertEquals("aba", result);
    }
}
