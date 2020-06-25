# Merge Sort

[https://app.laicode.io/app/problem/9](https://app.laicode.io/app/problem/9)

## Description

Given an array of integers, sort the elements in the array in ascending order. The merge sort algorithm should be used to solve this problem.

Examples

- {1} is sorted to {1}
- {1, 2, 3} is sorted to {1, 2, 3}
- {3, 2, 1} is sorted to {1, 2, 3}
- {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}

Corner Cases

- What if the given array is null? In this case, we do not need to do anything.
- What if the given array is of length zero? In this case, we do not need to do anything.

Medium

Array

Sort

## Assumption

The input array should not be null or empty

## Algorithm

![algorithm](merge_sort.png "merge_sort")

## Solution

### Code

```java
public class Solution {

  public int[] quickSort(int[] array) {
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
    // because the ones in the right part are already in order.
    while (left <= mid) {
      array[index++] = temp[left++];
    }
  }
}
```

### Complexity

#### Time

O(nlog(n))

If there are n elements in the array, there will be log(n) levels when we try to divide the array. When we merge the array, it takes n steps to merge the small arrays at every level. Therefore, the time complexity is O(nlog(n))

#### Space

O(n)
