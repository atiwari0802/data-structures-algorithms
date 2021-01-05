package dynamic.programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegularExpressionMatchingTest {

    private RegularExpressionMatching regularExpressionMatching;

    @BeforeEach
    public void setup() {
        regularExpressionMatching = new RegularExpressionMatching();
    }

    @Test
    public void testRegexMatchRecursive() {
        String s = "aab";
        String p = "c*a*b";

        Assertions.assertTrue(regularExpressionMatching.isMatchRecursive(s, p));
    }

    @Test
    public void testRegexMatchMemo() {
        String s = "aab";
        String p = "c*a*b";

        Assertions.assertTrue(regularExpressionMatching.isMatch(s, p));
    }

    @Test
    public void testRegexMatchDP() {
        String s = "aab";
        String p = "c*a*b";

        Assertions.assertTrue(regularExpressionMatching.isMatchDP(s, p));
    }
}
