package greedy.algorithms;

import java.util.ArrayList;
import java.util.List;


public class ReorganizeString {

    /**
     * In this approach, we follow a greedy strategy of counting the
     * frequency of characters in the input. We sort them in descending order
     * of frequency.
     * <p>
     * We check if the highest frequency is greater than half of the total size (N + 1) / 2.
     * If yes, then interleaving is not possible.
     * <p>
     * If not, then, we start inserting characters with a gap by hopping two places. If the counter
     * becomes greater than the size of the string, then, jump to index 1. (not zero because we start filling
     * the new string from 0 index)
     * <p>
     * Time Complexity: O(N); sorting is going to take constant time because the character array/list size is
     * always going to be 26.
     * Space Complexity: O(N)
     *
     * @param input
     * @return
     */
    public String reorganizeString(String input) {
        char[] charIndex = new char[26];
        int length = input.length();
        char[] result = new char[length];

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            charIndex[ch - 'a']++;
        }

        List<CharacterFrequency> characterFrequencies = new ArrayList<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (charIndex[ch - 'a'] > 0) {
                characterFrequencies.add(new CharacterFrequency(charIndex[ch - 'a'], ch));
            }
        }

        characterFrequencies.sort((ch1, ch2) -> Integer.compare(ch2.frequency, ch1.frequency));

        int maxCheck = characterFrequencies.get(0).frequency;
        if (maxCheck > (length + 1) / 2) {
            return "";
        }

        int fillIndex = 0;

        for (int i = 0; i < characterFrequencies.size(); i++) {
            char ch = characterFrequencies.get(i).ch;
            int frequency = characterFrequencies.get(i).frequency;
            for (int j = 0; j < frequency; j++) {
                if (fillIndex >= length) {
                    fillIndex = 1;
                }
                result[fillIndex] = ch;
                fillIndex += 2;
            }
        }

        return new String(result);
    }


    static class CharacterFrequency {
        int frequency;
        char ch;

        public CharacterFrequency(int frequency, char ch) {
            this.frequency = frequency;
            this.ch = ch;
        }
    }
}
