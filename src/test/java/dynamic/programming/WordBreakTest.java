package dynamic.programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class WordBreakTest {

    private WordBreak wordBreak;

    @BeforeEach
    public void setup() {
        wordBreak = new WordBreak();
    }

    @Test
    public void testWordBreakRecursive() {
        String input = "applepenapple";
        List<String> wordDict = Arrays.asList( "apple", "pen");

        Assertions.assertTrue(wordBreak.wordBreak(input, wordDict));
    }
}
