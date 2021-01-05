package dynamic.programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DecodeWaysTest {

    private DecodeWays decodeWays;

    @BeforeEach
    public void setup() {
        decodeWays = new DecodeWays();
    }

    @Test
    public void testDecodeWaysRecursive() {
        String input = "2326";

        Assertions.assertEquals(4, decodeWays.numDecodingsRecursive(input));
    }

    @Test
    public void testDecodeWaysMemozied() {
        String input = "2326";

        Assertions.assertEquals(4, decodeWays.numDecodingsMemoized(input));
    }

    @Test
    public void testDecodeWaysDP() {
        String input = "2326";

        Assertions.assertEquals(4, decodeWays.numDecodings(input));
    }
}
