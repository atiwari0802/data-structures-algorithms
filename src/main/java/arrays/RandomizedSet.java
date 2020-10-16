package arrays;

import java.util.*;

/**
 * The requirements for this class is to have insertion, deletion and getting random index in
 * O(1) time.
 * <p>
 * Array-List provide O(1) additions and retrievals (if the index is known). But removal takes O(n) time.
 * <p>
 * Hash-Maps offer O(1) look-up, insertions and deletions but search and getting random index will take O(n)
 * time.
 * <p>
 * So, in this approach, we combine the best of both worlds by combining a HashMap with an ArrayList.
 * The HashMap holds the values stored as keys and their positions in the list as values.
 * <p>
 * For additions, if the value is absent from the Map, the value is added to the list and its index is updated in the map.
 *
 * For deletions, if the value is present, its position/index is picked up from the map and the last entry of list is
 * set to this index. The value of last entry in the map is updated to the index of the value being removed.
 * After this, the last element of the list is removed along with the value from the index.
 *
 * For getting random index, we simply pick an index between 0 and list size (exclusive)
 *
 */
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
