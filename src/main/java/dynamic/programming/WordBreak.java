package dynamic.programming;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty()) {
            return false;
        }

        return wordBreakMemo(s, new HashSet<>(wordDict), 0, new HashMap<>());
    }

    /**
     * T(n) = N X [T(n - 1) + T(n - 2) + ......]
     * = N X 2 [ T(n - 2) + T(n - 3) + T(n -4) + ... ]
     * = N X 2 ^ 2 [T(n - 3) + T(n -4)]
     * .
     * .
     * .
     * = N X 2 ^ N (T(0))
     * = N X 2 ^ N
     * <p>
     * Time Complexity = O (N X 2 ^ N)
     * Space Complexity = O(N)
     *
     * @param input
     * @param dictionary
     * @param startIndex
     * @return
     */
    private boolean wordBreakRecursive(String input, Set<String> dictionary, int startIndex) {
        int length = input.length();

        if (startIndex >= length) {
            return true;
        }

        for (int i = startIndex; i < length; i++) {
            if (dictionary.contains(input.substring(startIndex, i + 1))
                    && wordBreakRecursive(input, dictionary, i + 1)) {
                return true;
            }
        }

        return false;
    }

    /**
     *
     * @param input
     * @param dictionary
     * @param startIndex
     * @param memo
     * @return
     */
    private boolean wordBreakMemo(String input, Set<String> dictionary, int startIndex, Map<String, Boolean> memo) {
        int length = input.length();

        if (startIndex >= length) {
            return true;
        }

        if (memo.containsKey(input.substring(startIndex))) {
            return memo.get(input.substring(startIndex));
        }

        for (int i = startIndex; i < length; i++) {
            if (dictionary.contains(input.substring(startIndex, i + 1))
                    && wordBreakMemo(input, dictionary, i + 1, memo)) {
                memo.put(input.substring(startIndex), true);
                return true;
            }
        }

        memo.put(input.substring(startIndex), false);
        return false;
    }


}
