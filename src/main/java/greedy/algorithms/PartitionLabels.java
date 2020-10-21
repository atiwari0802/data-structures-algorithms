package greedy.algorithms;

import java.util.List;
import java.util.ArrayList;

public class PartitionLabels {

    /**
     * In this approach, we maintain an array that stores the last index of
     * all the characters present in the string.
     *
     * We scan this string from left to right and for character, we  get the
     * last index. We also maintain a variable to store the maximum index seen
     * so far and the start index. If the current index becomes equal to the maximum index,
     * we break the string into a section at this point and calculate the length of this
     * section and increase the start index to the current index + 1.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1), if output array is ignored. The Character array will always be constant size,
     * equal to total number of characters.
     *
     * @param input String to be partitioned.
     * @return list of section lengths.
     */
    public List<Integer> partitionLabels(String input) {
        int[] lastIndices = new int[26];
        List<Integer> lengths = new ArrayList<>();
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < input.length(); i++) {
            lastIndices[input.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < input.length(); i++) {
            endIndex = Math.max(endIndex, lastIndices[input.charAt(i) - 'a']);

            if (i == endIndex) {
                int length = endIndex - startIndex + 1;
                startIndex = i + 1;
                lengths.add(length);
            }
        }

        return lengths;
    }
}
