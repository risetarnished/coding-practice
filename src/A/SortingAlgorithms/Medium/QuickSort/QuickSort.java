package A.SortingAlgorithms.Medium.QuickSort;

/**
 * https://app.laicode.io/app/problem/10
 * Description
 * Given an array of integers, sort the elements in the array in ascending order. The quick sort algorithm should be used to solve this problem.
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

public class QuickSort {
    public int[] quickSort(int[] array) {
        // Write your solution here
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
        // Find the pivot index
        int pivotIndex = partitionArray(array, start, end);
        // Sort the parts on both sides of the pivot
        // Such that the pivot will be in its correct position
        // Skipping pivot because it is in its designated position
        sortArray(array, start, pivotIndex - 1);
        sortArray(array, pivotIndex + 1, end);
    }

    private int partitionArray(int[] array, int start, int end) {
        // Randomly get an index in [start + 1, end]
        // Use Math.random()
        int pivotIndex = (int) Math.random() * (end - start + 1) + start;
        int pivot = array[pivotIndex];
        // Put the pivot to the end of the array temporarily, such that we
        // can simply check the other elements in one single, continous
        // iteration: 0 → end - 1 → pivot's temporary position
        swap(array, pivotIndex, end);
        // Quick sort physical representation:
        // Two pointers/barriers that satisfy the conditions:
        // 1. Everything before the left pointer is less than pivot
        // 2. Everything after the right pointer is greater than pivot
        // 3. Things in between are unknown and need to be checked
        // 4. When the two pointers meet (left >= right) and pass each
        //    other (left == right + 1):
        //    a. array[left] is the first element that is greater
        //       than pivot
        //    b. array[right] and all elements preceding it are
        //       less than the pivot
        //    c. swap left and end (pivot's temporary position) to meet
        //       the physical representations:
        //       [a, b, c, pivot, x, y, z] where pivot is in its position
        int left = start;
        int right = end - 1; // end ⇒ pivot
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
