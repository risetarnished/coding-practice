package J.String.II.Hard.ReOrderArray;

/**
 * https://app.laicode.io/app/problem/197
 *
 * Description
 * Given an array of elements, reorder it as follow:
 *
 * { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }
 *
 * { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }
 *
 * Try to do it in place.
 *
 * Assumptions
 *
 * The given array is not null
 * Examples
 *
 * { 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }
 *
 * { 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 }
 *
 * { 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }
 */

public class ReOrderArray {
    public int[] reorder(int[] array) {
        // Write your solution here
        if (array == null || array.length <= 2) {
            return array;
        }
        // If the array has odd # of elements
        // Ignore the last element and reorder the rest of it
        if (array.length % 2 != 0) {
            reorderArray(array, 0, array.length - 2);
        } else {
            reorderArray(array, 0, array.length - 1);
        }
        return array;
    }

    private void reorderArray(int[] array, int left, int right) {
        int length = right - left + 1; // size of the subarray
        // Base case: when subarray has less than 2 elements
        // Corresponding to the corner case above
        if (length <= 2) {
            return;
        }
        // Make sure the mid points divides the chunks correctly
        // 0 1 2 3 4 5 6 | 7 8 9 0 1 2 3
        // A B C D E F G | 1 2 3 4 5 6 7
        // chunk 1: A B C
        // chunk 2: D E F G
        // chunk 3: 1 2 3
        // chunk 4: 4 5 6 7
        // Only in this way can chunk 1 and 3, 2 and 4 match up each other
        int mid = left + length / 2;
        int lmid = left + length / 4;
        int rmid = left + length * 3 / 4;
        // I love Google trick
        reverse(array, lmid, mid - 1);  // G F E D
        reverse(array, mid, rmid - 1);  // 3 2 1
        reverse(array, lmid, rmid - 1); // 1 2 3 | D E F G
        // lmid - left = size of left/2
        reorderArray(array, left, left + (lmid - left) * 2 - 1);
        reorderArray(array, left + (lmid - left) * 2, right);
    }

    private void reverse(int[] array, int left, int right) {
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
