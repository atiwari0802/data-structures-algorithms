package dynamic.programming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LongestPalindromicSubstringTest {

    private LongestPalindromicSubstring longestPalindromicSubstring;

    @BeforeEach
    public void setup() {
        longestPalindromicSubstring = new LongestPalindromicSubstring();
    }

    @Test
    public void testLongestPalindromeSubstring() {
        String result = longestPalindromicSubstring.longestPalindrome("geeks");

        System.out.printf("%s", result);
    }
}
