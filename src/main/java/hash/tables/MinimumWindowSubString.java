package hash.tables;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumWindowSubString {

  /**
   * We use the Sliding Window approach to solve this problem.
   *
   * <p>The window is grown incrementally to the right until it encompasses all the required
   * characters. Once that is done, the window is shrunk from the left until it no longer contains
   * all the required characters. As the window is shrunk, the minimum length of the window is
   * stored.
   *
   * <p>To keep a track of the characters and their count, a map is used as an index. To make sure
   * that duplicates are factored for, we maintain a map for the current window as well. It stores
   * the count of each character.
   *
   * <p>If the left is slid to the left, the count is reduced by one. If the window is slid to the
   * right, the character is added if absent; else its count is increased.
   *
   * Time Complexity: O(n);
   * Space Complexity: O(n)
   * @param paragraph
   * @param text
   * @return Minimum sub-string containing the text if present. otherwise null
   */
  public String minimumWindowSubString(String paragraph, String text) {
    Map<Character, Long> textIndex =
        text.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Map<Character, Long> windowIndex = new HashMap<>();
    int leftPeg = 0;
    int rightPeg = 0;
    int currentLength = 0;
    int requiredLength = text.length();
    int minWindowLeftEdge = 0;
    int minWindowRightEdge = 0;
    int minimumSize = Integer.MAX_VALUE;

    while (rightPeg < paragraph.length()) {
      char c = paragraph.charAt(rightPeg);
      windowIndex.put(c, windowIndex.getOrDefault(c, 0L) + 1);

      if (textIndex.containsKey(c) && textIndex.get(c).equals(windowIndex.get(c))) {
        currentLength++;
      }

      while (leftPeg <= rightPeg && currentLength == requiredLength) {
        if (minimumSize > rightPeg - leftPeg + 1) {
          minimumSize = rightPeg - leftPeg + 1;
          minWindowLeftEdge = leftPeg;
          minWindowRightEdge = rightPeg;
        }

        char charAtLeft = paragraph.charAt(leftPeg);
        windowIndex.put(charAtLeft, windowIndex.get(charAtLeft) - 1);

        if (textIndex.containsKey(charAtLeft)
            &&  windowIndex.get(charAtLeft) < textIndex.get(charAtLeft)) {
          currentLength--;
        }

        leftPeg++;
      }
      rightPeg++;
    }

    return minimumSize == Integer.MAX_VALUE ? null : paragraph.substring(minWindowLeftEdge, minWindowRightEdge + 1);
  }
}
