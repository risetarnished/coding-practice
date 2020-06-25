package src.sortingalgorithms.movezerostotheendi;

/**
 * https://app.laicode.io/app/problem/258
 * Description
 * Given an array of integers, move all the 0s to the right end of the array.
 *
 * The relative order of the elements in the original array does not need to be maintained.
 *
 * Assumptions:
 *
 * The given array is not null.
 * Examples:
 *
 * {1} --> {1}
 * {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}
 **/

public class Solution {

  /**
   * Method 1:
   * Use similar logic to quick sort algorithm
   * No pivot needed
   * Elements before the left pointer are non-0's
   * Elements after the right pointer are 0's
   * Elements in between are unknown yet
   **/
  // This method does not preserve the relative position of the elements
  public int[] moveZero(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return array;
    }

    int left = 0;
    int right = array.length - 1;
    // When the two pointers meet each other, it does not matter if that element is 0 or not since everything
    // that comes before/after it has already been sorted accordingly
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

  /**
   * Method 2:
   * Two pointers moving in the same direction, from the same starting index
   * Physical meaning of the two pointers:
   * 1. elements before the left pointer are non-0's
   * 2. elements between the pointers are checked and have non-0's before 0's
   * 3. elements after the right pointer are to be checked
   **/
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
/**
 * Time complexity:
 * One single iteration over n elements with swap operations --> O(n)
 *
 * Space complexity:
 * Constant spaces used only --> O(1)
 **/
