package N.CrossTraining.I.Medium.ArrayDeduplicationII;

/**
 * ArrayDeduplicationII
 *
 * @author meng
 * @date 1/23/19
 */
public class ArrayDeduplicationII {
    /**
     * Remove duplicate elements from a sorted array
     * Keep at most two copies of the same elements
     *
     * @param array The input array
     * @return      An array with at most two copies of the same elements
     */
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array == null || array.length <= 2) {
            return array;
        }
        // Two pointers
        // 1. array[0, slow]: processed for result
        // 2. array[fast, end]: yet to be processed
        // Because the array is sorted and we can keep at most two copies
        // of the duplicate elements
        // We can just compare array[fast] with array[slow - 1]
        int slow = 1;
        for (int fast = 2; fast < array.length; fast++) {
            if (array[fast] != array[slow - 1]) {
                array[++slow] = array[fast];
            }
        }
        int[] result = new int[slow + 1];
        System.arraycopy(array, 0, result, 0, slow + 1);
        return result;
    }
}
