package A.SortingAlgorithms.Medium.MergeSort;

import java.util.Arrays;

/**
 * https://app.laicode.io/app/problem/9
 * Description
 * Given an array of integers, sort the elements in the array in ascending order. The merge sort algorithm should be used to solve this problem.
 *
 * Examples
 *
 * {1} is sorted to {1}
 * {1, 2, 3} is sorted to {1, 2, 3}
 * {3, 2, 1} is sorted to {1, 2, 3}
 * {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
 * Corner Cases
 *
 * What if the given array is null? In this case, we do not need to do anything.
 * What if the given array is of length zero? In this case, we do not need to do anything.
 **/

public class MergeSort {
    public int[] mergeSort(int[] array) {
        // Write your solution here
        // Corner cases
        if (array == null || array.length == 0) {
            return array;
        }
        sortArray(array, new int[array.length], 0, array.length - 1);
        return array;
    }

    private void sortArray(int[] array, int[] temp, int start, int end) {
        // Base case: when the subarray cannot be divided in half anymore
        if (start >= end) {
            return;
        }
        // Divide the array in half, sort the two subarrays respectively
        int mid = start + (end - start) / 2;
        sortArray(array, temp, start, mid);
        sortArray(array, temp, mid + 1, end);
        // Merge the two subarrays into one sorted array
        mergeArray(array, temp, start, mid, end);
    }

    private void mergeArray(int[] array, int[] temp, int start, int mid, int end) {
        // Copy the array to temp such that we can do comparisons on the temp array
        // while operating the original array --> make it look like in-place
        temp = Arrays.copyOf(array, array.length);
        // Merge the two halves
        int left = start;
        int right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (temp[left] < temp[right]) {
                array[index++] = temp[left++];
            } else {
                array[index++] = temp[right++];
            }
        }
        // Only the left side is possible to be left with unsorted elements because the right hand side will always be greater
        while (left <= mid) {
            array[index++] = temp[left++];
        }
    }
}
