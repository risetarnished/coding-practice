package A.SortingAlgorithms.Easy.SelectionSort;

/**
 * https://app.laicode.io/app/problem/4
 * Description
 * Given an array of integers, sort the elements in the array in ascending order. The selection sort algorithm should be used to solve this problem.
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

public class SelectionSort {
    public int[] sort(int[] array) {
        // Write your solution here
        // Corner cases check
        if (array == null || array.length == 0) {
            return array;
        }
        // Selection sort algorithm: ascending order
        // 1. pick the min value in the current iteration
        // 2. put the current min value to the left hand side of the pointer
        // 3. everything to the left of the pointer is sorted
        // 4. continue to the next iteration
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }
}
