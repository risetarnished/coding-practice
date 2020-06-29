<!----- Conversion time: 0.594 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Tue Jan 15 2019 04:29:49 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=14d3-_1Jm3KntVfv8XLVLAVnIsDi4SM644Z34Be0cINc
----->

# Closest in Sorted Array

[https://app.laicode.io/app/problem/17](https://app.laicode.io/app/problem/17)

## Description

Given a target integer T and an integer array A sorted in ascending order, find the index i in A such that A\[i\] is closest to T.

Assumptions

- There can be duplicate elements in the array, and we can return any of the indices with same value.

Examples

- A = {1, 2, 3}, T = 2, return 1
- A = {1, 4, 6}, T = 3, return 1
- A = {1, 4, 6}, T = 5, return 1 or 2
- A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2

Corner Cases

- What if A is null or A is of zero length? We should return -1 in this case.

Medium

Array

Binary Search

## Assumption

The input array should not be null or empty. There could be duplicate elements in the array.

## Algorithm

Inside the binary search while-loop, we can still return mid if array\[mid\] is the target. However, since we need to know the closest element to the target if there is not an exact match, we need to use the BS variant algorithm such that we will find two elements that are closer to the target than any other elements in the array. We then do a post-processing on the two elements to get the closest among all.

## Solution

### Code

```java
public class Solution {

  public int closest(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
      return left;
    }
    return right;
  }
}
```

### Complexity

Time:

Binary search ⇒ O(n)

Space:

Constant ⇒ O(1)

<!-- GD2md-html version 1.0β13 -->
