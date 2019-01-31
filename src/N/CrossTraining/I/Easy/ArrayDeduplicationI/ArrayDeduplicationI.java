package N.CrossTraining.I.Easy.ArrayDeduplicationI;

/**
 * ArrayDeduplicationI
 *
 * @author meng
 * @date 1/23/19
 */
public class ArrayDeduplicationI {
    /**
     * Remove the duplicate elements from an array with in-place operations
     *
     * @param array The input array
     * @return      Array with duplicate elements removed
     */
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array == null || array.length <= 1) {
            return array;
        }
        // Two pointers:
        // 1. array[0, slow]: processed for result
        // 2. array(slow, fast): processed useless
        // 3. array[fast, end]: yet to be processed
        int slow = 0;
        for (int fast = 1; fast < array.length; fast++) {
            // We are only interested in the case
            // when two elements are different
            if (array[slow] != array[fast]) {
                array[++slow] = array[fast];
            }
        }
        // array[0, slow] is the part for result
        int[] result = new int[slow + 1];
        /*
        for (int i = 0; i <= slow; i++) {
            result[i] = array[i];
        }
        */
        // Array copy can also be done by:
        System.arraycopy(array, 0, result, 0, slow + 1);
        return result;
    }
}
