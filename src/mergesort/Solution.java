package src.mergesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

public class Solution {

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
    // Base case: when the array cannot be divided in half any more
    if (start >= end) {
      return;
    }
    // Divide the array into two halves each time
    // And sort the two parts respectively
    int mid = start + (end - start) / 2;
    sortArray(array, temp, start, mid);
    sortArray(array, temp, mid + 1, end);
    // Merge the two sorted halves into one big sorted array
    mergeArray(array, temp, start, mid, end);
  }

  private void mergeArray(
    int[] array,
    int[] temp,
    int start,
    int mid,
    int end
  ) {
    // Copy the array to temp such that we can do comparisons only on the temp array,
    // while operating on the original array to make it like in-place operations
    temp = Arrays.copyOf(array, array.length);
    // Merge the two parts according to their values: smaller --> larger
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
    // When there are left-over elements, only the ones in the left part should be concerned
    // because the ones in the right part will always be greater.
    while (left <= mid) {
      array[index++] = temp[left++];
    }
  }

  /* This method solves data in List interface (ArrayList in this case) */
  public List<Integer> mergeSort(List<Integer> list) {
    if (list == null || list.isEmpty()) {
      return new ArrayList<>();
    }
    return sortArray(list, 0, list.size() - 1);
  }

  private List<Integer> sortArray(List<Integer> list, int start, int end) {
    List<Integer> result = new ArrayList<>();
    // Base case: when all elements in the list have been sorted
    if (start >= end) {
      // Add the last or ONLY element in the list to the result
      result.add(list.get(start));
      return result;
    }
    int mid = start + (end - start) / 2;
    List<Integer> left = sortArray(list, start, mid);
    List<Integer> right = sortArray(list, mid + 1, end);
    mergeArray(left, right, result);
    return result;
  }

  private void mergeArray(
    List<Integer> left,
    List<Integer> right,
    List<Integer> result
  ) {
    int leftIndex = 0;
    int rightIndex = 0;
    while (leftIndex < left.size() && rightIndex < right.size()) {
      if (left.get(leftIndex) < right.get(rightIndex)) {
        result.add(left.get(leftIndex++));
      } else {
        result.add(right.get(rightIndex++));
      }
    }
    // Left-over elements
    while (leftIndex < left.size()) {
      result.add(left.get(leftIndex++));
    }
    while (rightIndex < right.size()) {
      result.add(right.get(rightIndex++));
    }
  }
}
/**
 * Time complexity:
 * There are in total n elements, log(n) levels in the recursion tree --> O(n log(n))
 *
 * Space complexity:
 * Merging elements number of n, n/2, n/4, ... 1 --> O(n)
 **/
