package coollime.sortingalgorithms.mergesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public int[] mergeSort(int[] array) {
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
    temp = Arrays.copyOf(array, array.length);
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
    while (left <= mid) {
      array[index++] = temp[left++];
    }
  }

  // Solution using List interface
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
    while (leftIndex < left.size()) {
      result.add(left.get(leftIndex++));
    }
    while (rightIndex < right.size()) {
      result.add(right.get(rightIndex++));
    }
  }
}
