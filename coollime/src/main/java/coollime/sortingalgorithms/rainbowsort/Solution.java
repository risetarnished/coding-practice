package coollime.sortingalgorithms.rainbowsort;

public class Solution {

  /**
   * Given an array that has only three types of elements (-1, 0, and 1) in it,
   * sort the elements such that elements of the same group are grouped together
   *
   * @param array  The input array
   * @return       The array with the elements grouped accordingly
   */
  public int[] rainbowSort(int[] array) {
    if (array == null || array.length <= 1) {
      return array;
    }
    int i = 0;
    int j = 0;
    int k = array.length - 1;
    while (j <= k) {
      if (array[j] == -1) {
        swap(array, i++, j++);
      } else if (array[j] == 0) {
        j++;
      } else if (array[j] == 1) {
        swap(array, j, k--);
      }
    }
    return array;
  }

  private void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
