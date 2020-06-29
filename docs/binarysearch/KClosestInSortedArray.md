<!----- Conversion time: 0.766 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Tue Jan 15 2019 04:41:58 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1iKSwzTKD2HshgWFx8LpVp8sEmWj6x92moyI9SugWdfA
----->

## K Closest in Sorted Array

[https://app.laicode.io/app/problem/19](https://app.laicode.io/app/problem/19)

## Description

Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A.

Assumptions

- A is not null
- K is guranteed to be >= 0 and K is guranteed to be <= A.length

Return

- A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T.

Examples

- A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
- A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}

Medium

Array

Binary Search

## Assumption

The input array should not be null or empty and the number k should not exceeds the size of the array.

## Algorithm

Do a binary search with neighboring exit condition. Find the two positions that are closest to the target in the array. Then, do a merge-sort like comparison and move the pointers.

## Solution

### Code

```java
public class Solution {

  public int[] kClosest(int[] array, int target, int k) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return array;
    }
    int[] result = new int[k];
    int n = array.length;
    int left = 0;
    int right = array.length - 1;
    // Narrow down the search range to the two elements that are closest
    // to the target
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    // Go to both directions from the "center"
    int i = 0;
    while (i < k && left >= 0 && right < n) {
      if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
        result[i++] = array[left--];
      } else {
        result[i++] = array[right++];
      }
    }
    while (i < k && left >= 0) {
      result[i++] = array[left--];
    }
    while (i < k && right < n) {
      result[i++] = array[right++];
    }
    return result;
  }
}
```

### Complexity

Time

Binary search to narrow down to the two closest elements ⇒ O(log(n))

"Flower" style merge sort method ⇒ O(k)

⇒ O(k + log(n))

Space

O(1)

<!-- GD2md-html version 1.0β13 -->
