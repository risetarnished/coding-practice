package coollime.binarysearch.closest.kclosest;

public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    if (array == null || array.length == 0 || k < 0 || k > array.length) {
      return new int[] {};
    }
    int left = 0;
    int right = array.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] > target) {
        right = mid;
      } else {
        left = mid;
      }
    }
    int[] result = new int[k];
    int index = 0;
    while (index < k && left >= 0 && right < array.length) {
      if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
        result[index++] = array[left--];
      } else {
        result[index++] = array[right++];
      }
    }
    while (index < k && right < array.length) {
      result[index++] = array[right++];
    }
    while (index < k && left >= 0) {
      result[index++] = array[left--];
    }
    return result;
  }
}
