package B.BinarySearch.Medium.LastOccurrence;

/**
 * https://app.laicode.io/app/problem/16
 * Description
 * Given a target integer T and an integer array A sorted in ascending order, find the index of the last occurrence of T in A or return -1 if there is no such index.
 *
 * Assumptions
 *
 * There can be duplicate elements in the array.
 *
 * Examples
 *
 * A = {1, 2, 3}, T = 2, return 1
 * A = {1, 2, 3}, T = 4, return -1
 * A = {1, 2, 2, 2, 3}, T = 2, return 3
 * Corner Cases
 *
 * What if A is null or A is array of zero length? We should return -1 in this case.
 **/

public class LastOccurrence {
    public int lastOccur(int[] array, int target) {
        // Write your solution
        if (array == null || array.length == 0) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        // Because we are looking for the last occurrence of the target
        // Check the element pointed by the end first
        if (array[end] == target) {
            return end;
        } else if (array[start] == target) {
            return start;
        }
        return -1;
    }
}

/**
 * Time complexity:
 * Classical binary search variant: n elements to check --> cut the searching range down by 1/2 each time --> O(log(n))
 *
 * Space complexity:
 * Constant space: O(1)
 **/