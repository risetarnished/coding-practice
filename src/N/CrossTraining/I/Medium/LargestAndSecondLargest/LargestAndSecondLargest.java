package N.CrossTraining.I.Medium.LargestAndSecondLargest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LargestAndSecondLargest
 *
 * @author meng
 * @date 1/24/19
 */
public class LargestAndSecondLargest {
    /**
     * Find the largest and 2nd largest numbers in an array
     * using the least number of comparisons
     *
     * @param array The input array
     * @return      {largest, 2nd largest}
     */
    public int[] largestAndSecond(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return new int[] {};
        }
        int n = array.length;
        // Step 1: compare pairs
        // 1. put the larger numbers to the left
        // 2. record the comparison history using a HashMap
        Map<Integer, List<Integer>> history = new HashMap<>();
        for (int i = 0; i < n / 2; i++) {
            if (array[i] < array[n - 1 - i]) {
                swap(array, i, n - 1 - i);
            }
            // Keep track of the history of the larger number
            updateHistory(array[i], array[n - 1 - i], history);
        }
        // Step 2: find the max in array[0, n/2]
        int first = array[0];
        for (int i = 1; i <= n / 2; i++) {
            // Because we are still making comparisons
            // The history map needs to get updated, as well
            if (array[i] >= first) {
                updateHistory(array[i], first, history);
                first = array[i];
            } else {
                updateHistory(first, array[i], history);
            }
        }
        // Step 3: find the max in first's history
        int second = Integer.MIN_VALUE;
        for (int number : history.get(first)) {
            if (number > second) {
                second = number;
            }
        }
        return new int[] {first, second};
    }

    /**
     * Swap two elements in the array
     *
     * @param array The input array
     * @param left  The index of the first element
     * @param right The index of the second element
     */
    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    /**
     * Update the comparison history of elements
     *
     * @param large     the larger number
     * @param small     the smaller number
     * @param history   the HashMap recording <number, compared numbers>
     */
    private void updateHistory(int large, int small, Map<Integer, List<Integer>> history) {
        List<Integer> compared = history.getOrDefault(large, new ArrayList<>());
        compared.add(small);
        history.put(large, compared);
    }
}
