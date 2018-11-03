package A.BinarySearch.Medium;

/**
 * https://app.laicode.io/app/problem/19
 * Description
 * Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A.
 *
 * Assumptions
 *
 * A is not null
 * K is guranteed to be >= 0 and K is guranteed to be <= A.length
 * Return
 *
 * A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T.
 * Examples
 *
 * A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
 * A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
 **/

public class KClosestInSortedArray {
    public int[] kClosest(int[] array, int target, int k) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return array;
        }
        int[] result = new int[k];
        int n = array.length;
        int left = 0;
        int right = array.length - 1;
        // Narrow down the search range to the two elements that are closest
        // to the target
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // Go to both directions from the “center”
        int i = 0;
        while (i < k && left >= 0 && right < n) {
            if (Math.abs(array[left] - target)
                    < Math.abs(array[right] - target)) {
                result[i++] = array[left--];
            } else {
                result[i++] = array[right++];
            }
        }
        while (i < k && left >= 0) {
            result[i++] = array[left--];
        }
        while (i < k && right < n) {
            result[i++] = array[right++];
        }
        return result;
    }
}
