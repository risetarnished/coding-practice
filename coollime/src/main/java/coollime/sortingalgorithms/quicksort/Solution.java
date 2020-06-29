package coollime.sortingalgorithms.quicksort;

public class Solution {

  public int[] quickSort(int[] array) {
    if (array == null || array.length == 0) {
      return array;
    }
    sortArray(array, 0, array.length - 1);
    return array;
  }

  private void sortArray(int[] array, int start, int end) {
    if (start >= end) {
      return;
    }
    int pivotIndex = partitionArray(array, start, end);
    sortArray(array, start, pivotIndex - 1);
    sortArray(array, pivotIndex + 1, end);
  }

  private int partitionArray(int[] array, int start, int end) {
    int pivotIndex = (int) Math.random() * (end - start + 1) + start;
    int pivot = array[pivotIndex];
    swap(array, pivotIndex, end);
    int left = start;
    int right = end - 1;
    while (left <= right) {
      if (array[left] < pivot) {
        left++;
      } else if (array[right] > pivot) {
        right--;
      } else {
        swap(array, left++, right--);
      }
    }
    swap(array, left, end);
    return left;
  }

  private void swap(int[] array, int indexOne, int indexTwo) {
    int temp = array[indexOne];
    array[indexOne] = array[indexTwo];
    array[indexTwo] = temp;
  }
}
