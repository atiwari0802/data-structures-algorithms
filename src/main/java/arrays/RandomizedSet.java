package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    private Map<Integer, Integer> keyIndex;

    private List<Integer> numbers;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        keyIndex = new HashMap<>();
        numbers = new ArrayList<>();
    }

    /**
     * Inserts a value to the set.
     * Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (keyIndex.containsKey(val)) {
            return false;
        }

        numbers.add(val);

        keyIndex.put(val, numbers.size() - 1);

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!keyIndex.containsKey(val)) {
            return false;
        }

        int index = keyIndex.get(val);

        numbers.set(index, numbers.get(numbers.size() - 1));
        keyIndex.put(numbers.get(numbers.size() - 1), index);

        numbers.remove(numbers.size() - 1);
        keyIndex.remove(val);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random random = new Random();

        return numbers.get(random.nextInt(numbers.size()));
    }

}
