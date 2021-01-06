package dynamic.programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WildCardMatchTest {

  private WildCardMatch wildCardMatch;

  @BeforeEach
  public void setup() {
    wildCardMatch = new WildCardMatch();
  }

  @Test
  public void testWildCardMatchRecursive() {
    String s = "xyxzzxy";
    String p = "x***x?";

    Assertions.assertTrue(wildCardMatch.isMatch(s, p));
  }

  @Test
  public void testWildCardMatchMemoized() {
    String s = "aa";
    String p = "*";

    Assertions.assertTrue(wildCardMatch.isMatchMemoized(s, p));
  }

  @Test
  public void testWildCardMatchDP() {
    String s = "xyxzzxy";
    String p = "x***x?";

    Assertions.assertTrue(wildCardMatch.isMatchDP(s, p));
  }
}
