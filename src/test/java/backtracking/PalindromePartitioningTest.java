package backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class PalindromePartitioningTest {

    private PalindromePartitioning palindromePartitioning;

    @BeforeEach
    public void setup() {
        palindromePartitioning = new PalindromePartitioning();
    }

    @Test
    public void testPalindromePartitioning() {
        String s = "aab";

        List<List<String>> palindromes = palindromePartitioning.partition(s);

        palindromes.stream().flatMap(List::stream).collect(Collectors.toList())
        .forEach(str -> System.out.printf(" %s ", str));

    }
}
