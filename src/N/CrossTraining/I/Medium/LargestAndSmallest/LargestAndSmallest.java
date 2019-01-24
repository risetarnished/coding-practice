package N.CrossTraining.I.Medium.LargestAndSmallest;

/**
 * LargestAndSmallest
 *
 * @author meng
 * @date 1/24/19
 */
public class LargestAndSmallest {
    /**
     * Find the max and min value in an array
     * Use the least number of comparisons
     *
     * @param array the input array
     * @return      [max, min]
     */
    public int[] largestAndSmallest(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return new int[] {};
        }
        int n = array.length;
        // Debugging helper variables
        int run = 0;
        System.out.println("Total number of elements in the array: " + n);
        // Step 1: compare pairs
        // 1. put the smaller numbers to the left
        // 2. put the larger numbers to the right
        for (int i = 0; i < n / 2; i++) {
            run++;
            if (array[i] > array[n - 1 - i]) {
                int temp = array[i];
                array[i] = array[n - 1 - i];
                array[n - 1 - i] = temp;
            }
        }
        // Step 2:
        // Look for the min in the smaller half array[0, n/2]
        int min = array[0];
        for (int i = 1; i <= n / 2; i++) {
            run++;
            if (array[i] < min) {
                min = array[i];
            }
        }
        // Step 3:
        // Look for the max in the larger half array[n/2, end]
        int max = array[n / 2];
        for (int i = n / 2 + 1; i < n; i++) {
            run++;
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Total number of runs: " + run);
        return new int[] {max, min};
    }
}
