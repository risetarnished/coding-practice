package N.CrossTraining.I.Medium.ArrayDeduplicationIII;

import java.util.Arrays;

/**
 * ArrayDeduplicationIII
 *
 * @author meng
 * @date 1/24/19
 */
public class ArrayDeduplicationIII {
    /**
     * Remove duplicate elements from a sorted array
     * Keep no copies of elements that are duplicates
     *
     * @param array The input array
     * @return      Array with all duplicate elements removed (no copies kept)
     */
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array == null || array.length <=1) {
            return array;
        }
        // Two pointers
        // array[0, slow] ==> ready for result
        // array[fast, end] ==> to be processed
        int slow = 0;
        int fast = 0;
        // For each element in the array, check its proceeding elements
        // and see if they are duplicates
        while (fast < array.length) {
            int start = fast;
            // array[start, fast] is a subarray that we look for duplications
            // If there are multiple duplications, we skip those elements
            while (fast < array.length && array[fast] == array[start]) {
                fast++;
            }
            // When we get the duplicate subarray, check its size:
            // 1. size >= 2 ==> multiple copies of the same element ==> skip
            // 2. size == 1 ==> no duplications ==> keep
            if (fast - start == 1) {
                array[slow++] = array[start];
            }
        }
        // array[0, slow] is the result
        return Arrays.copyOf(array, slow);
    }
}
