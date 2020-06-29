package coollime.sortingalgorithms.movezerostotheendi;

public class Solution {

  // This method does not preserve the relative position of the elements
  public int[] moveZero(int[] array) {
    if (array == null || array.length == 0) {
      return array;
    }
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      if (array[left] != 0) {
        left++;
      } else if (array[right] == 0) {
        right--;
      } else {
        array[left++] = array[right];
        array[right--] = 0;
      }
    }
    return array;
  }

  // This method keeps the relative position of the elements after switching.
  public int[] moveZeroPreservePosition(int[] array) {
    if (array == null || array.length == 0) {
      return array;
    }
    int left = 0;
    int right = 0;
    while (right < array.length) {
      if (array[right] != 0) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        left++;
      }
      right++;
    }
    return array;
  }
}
