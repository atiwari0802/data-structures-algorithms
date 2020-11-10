package backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GenerateParenthesesTest {

    private GenerateParentheses generateParentheses;

    @BeforeEach
    public void setup() {
        generateParentheses = new GenerateParentheses();
    }

    @Test
    public void testGenerateParenthesis() {
        List<String> results = generateParentheses.generateParenthesis(3);

        results.forEach(str -> System.out.printf(" %s ,", str));
    }
}
