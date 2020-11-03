package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LetterPermutationOfPhoneNumber {

  private static final Map<String, String> LETTER_MAP =
      Map.of(
          "2", "abc", "3", "def", "4", "ghi", "5", "jkl", "6", "mno", "7", "pqrs", "8", "tuv", "9",
          "wxyz");

  /**
   * In this solution, we enumerate all the possible permutations of every character that's
   * encountered. Since the order of the characters are important, we scan the string from left to
   * right and for every character, we iterate over all possible alphabets for that digit and do the
   * same for the rest of the String until the end of the string.
   *
   * <p>In essence, this is a depth-first search, where each possibility of every character is
   * explored.
   *
   * <p>Time Complexity: 3^N X 4^M (where N maps to 3 possible characters and M maps to 4 possible
   * characters).
   * <p>Space Complexity: 3^N X 4^M (where N maps to 3 possible characters and M maps to 4 possible
   * characters)
   *
   * @param digits
   * @return List enumerating all possible character permutations of the digits
   */
  public List<String> letterPermutations(String digits) {
    if (digits == null || digits.length() == 0) {
      return Collections.emptyList();
    }

    List<String> answers = new ArrayList<>();
    letterPermutationsHelper(digits, "", answers);

    return answers;
  }

  private void letterPermutationsHelper(
      String digitsRemaining, String permutationSoFar, List<String> answers) {
    if (digitsRemaining.length() == 0) {
      answers.add(permutationSoFar);
    } else {
      String number = digitsRemaining.substring(0, 1);
      String letters = LETTER_MAP.get(number);

      for (int i = 0; i < letters.length(); i++) {
        String letter = letters.substring(i, i + 1);
        letterPermutationsHelper(
            digitsRemaining.substring(1), permutationSoFar.concat(letter), answers);
      }
    }
  }
}
