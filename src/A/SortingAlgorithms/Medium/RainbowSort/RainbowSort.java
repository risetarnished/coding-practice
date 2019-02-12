package A.SortingAlgorithms.Medium.RainbowSort;

/**
 * RainbowSort
 *
 * @author meng
 * @date 2/11/19
 */
public class RainbowSort {
    /**
     * Given an array that has only three types of elements (-1, 0, and 1) in it,
     * sort the elements such that elements of the same group are grouped together
     *
     * @param array  The input array
     * @return       The array with the elements grouped accordingly
     */
    public int[] rainbowSort(int[] array) {
        // Write your solution here
        if (array == null || array.length <= 1) {
            return array;
        }
        int i = 0;
        int j = 0;
        int k = array.length - 1;
        // array[0, i]: -1
        // array(i, j]: 0
        // array[k, n]: 1
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
