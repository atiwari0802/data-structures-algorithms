package hash.tables;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinimumWindowSubStringTest {

  private MinimumWindowSubString minimumWindowSubString;

  @BeforeEach
  public void setup() {
    minimumWindowSubString = new MinimumWindowSubString();
  }

  @Test
  public void testMinWindowSubString() {
    String paragraph = "ADOBECODEBANC";
    String text = "ABC";

    String result = minimumWindowSubString.minimumWindowSubString(paragraph, text);

    System.out.printf("Min Window: %s", result);
  }
}
