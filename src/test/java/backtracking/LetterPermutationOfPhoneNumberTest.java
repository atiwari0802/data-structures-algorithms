package backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LetterPermutationOfPhoneNumberTest {

  private LetterPermutationOfPhoneNumber letterPermutationOfPhoneNumber;

  @BeforeEach
  public void setup() {
    letterPermutationOfPhoneNumber = new LetterPermutationOfPhoneNumber();
  }

  @Test
  public void testPrintAllPermutations() {
      String text = "23";

      List<String> answers = letterPermutationOfPhoneNumber.letterPermutations(text);

      answers.forEach(str -> System.out.printf(" %s ,", str));
  }
}
