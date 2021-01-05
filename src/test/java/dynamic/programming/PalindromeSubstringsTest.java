package dynamic.programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PalindromeSubstringsTest {

    private PalindromeSubstrings palindromeSubstrings;

    @BeforeEach
    public void setup() {
        palindromeSubstrings = new PalindromeSubstrings();
    }

    @Test
    public void testPalindromeSubstrings() {
        String s = "aabc";

        int count = palindromeSubstrings.countSubstrings(s);

        Assertions.assertEquals(5, count);
    }
}
