package arrays;

import java.util.List;

public class MergeTwoSortedArrays {

    /**
     * The idea behind this approach is that since the first list
     * has enough space to accommodate combined elements of one and two.
     * <p>
     * Since we are doing it in-place, we start filling the arrays from
     * from the end of the first array, so as to not displace/overwrite elements.
     * <p>
     * Let size of valid elements in the first array be m and the size of
     * valid elements in the second array be n.
     * <p>
     * We set pointers to point to the last valid element each array.
     * oneIndex = m - 1
     * twoIndex = n - 1
     * <p>
     * The mergedIndex will be m + n - 1 ((m - 1) + (n - 1) + 1 (to compensate for extra - 1))
     * <p>
     * We compare the elements at oneIndex and twoIndex and insert the larger of the
     * two elements at the mergedIndex, while decrementing both the indices involved.
     *
     * When the smaller of the two array index runs out, we simply shift/displace
     * the elements from the larger array in the correct locations, pointed to by
     * the mergedIndex.
     *
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     *
     * @param one
     * @param two
     * @return Merged and sorted array
     */
    public List<Integer> mergeTwoSortedArrays(List<Integer> one, List<Integer> two, int m, int n) {
        int oneIndex = m - 1;
        int twoIndex = n - 1;
        int mergedIndex = oneIndex + twoIndex + 1;

        while (oneIndex >= 0 && twoIndex >= 0) {
            if (one.get(oneIndex) >= two.get(twoIndex)) {
                one.set(mergedIndex--, one.get(oneIndex--));
            } else {
                one.set(mergedIndex--, two.get(twoIndex--));
            }
        }
        while (oneIndex >= 0) {
            one.set(mergedIndex--, one.get(oneIndex--));
        }
        while (twoIndex >= 0) {
            one.set(mergedIndex--, two.get(twoIndex--));
        }

        return one;
    }
}
