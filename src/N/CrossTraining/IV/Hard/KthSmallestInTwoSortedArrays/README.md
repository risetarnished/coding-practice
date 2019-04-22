# Kth Smallest in Two Sorted Arrays

[https://app.laicode.io/app/problem/202](https://app.laicode.io/app/problem/202)

## Description

Given two sorted arrays of integers, find the Kth smallest number.

**Assumptions**

- The two given arrays are not null and at least one of them is not empty
- K >= 1, K <= total lengths of the two sorted arrays

**Examples**

- A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.
- A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.

**Tags**

- Hard
- Array
- Binary Search

## Assumption

- The input includes
  - two arrays of integers
    - should not be null
    - at least one of them is not empty
  - k - the target to look for (k-th smallest)
    - k >= 0
    - k <= a.length + b.length

## Solution

### Method 1: Two Pointers

#### High-level Idea

- Use two pointers, one for each array
- Scan the two arrays and compare the two elements pointed to by the two pointers
- Move the pointer that points to the smaller element
- Move the pointer for (k - 1) times to get the k-th smallest element
  - when we are about to move the pointer for the k-th time, the smaller element is the result

#### Code

```java
public class Solution {
  public int kth(int[] a, int[]b, int k) {
    // Write your solution here
    // Corner case based on the assumption
    if (a == null || b == null || k < 0) {
      return Integer.MIN_VALUE;
    }
    if (a.length == 0) {
      return b[k - 1];
    } else if (b.length == 0) {
      return a[k - 1];
    }
    int i = 0;
    int j = 0;
    // round represents how many rounds we have run: run (k - 1) rounds in total
    int round = 1;
    while (round < k && i < a.length && j < b.length) {
      if (a[i] <= b[j]) {
        i++;
      } else {
        j++;
      }
      round++;
    }
    // Post-processing
    // If either of the two arrays has no more elements to compare
    // simply return the element in the other array
    if (i >= a.length) {
      return b[k - round + j];
    } else if (j >= b.length) {
      return a[k - round + i];
    }
    return a[i] <= b[j] ? a[i] : b[j];
  }
}
```

#### Complexity

- Time
  - In the worst case, when k == total length, we need to check all n elements
  - Time is O(n)
  - Generally speaking, it depends on k ==> O(k)
- Space
  - No additional data structures used
  - Space is O(1)

### Method 2: Binary Search Variation

#### High-level Idea

- Compare the first k/2 elements in each array
- Discard the k/2 that are impossible to contain the result each time
- Keep shrinking the searching range down by 1/2 each time

#### Implementation

- Keep track of two starting points of the two arrays
- Narrow down the searching range based on the two starting points
- Base case
  - when either of the two arrays has no elements left that are possible to be the k-th smallest
  - when the remaining number of elements to search has become 1
    - this is the answer, k == 1, meaning to look for the 1-th smallest element
- Recursive rule
  - a\[mid] <= b\[mid]
    - throw away **a\[start, mid]**
    - search for **(k - k/2)** elements between **a\[mid + 1, end]** and b\[start, end]
  - otherwise
    - throw away **b\[start, mid]**
    - search for **(k - k/2)** elements between a\[start, end] and **b\[mid + 1, end]**

#### Code

```java
public class Solution {
  public int kth(int[] a, int[] b, int k) {
    // Write your solution here
    // Corner case based on the assumption
    if (a == null || b == null || k < 0) {
      return Integer.MIN_VALUE;
    }
    if (a.length == 0) {
      return b[k - 1];
    } else if (b.length == 0) {
      return a[k - 1];
    }
    return kthSmallest(a, 0, b, 0, k);
  }
  
  private int kthSmallest(int[] a, int aStart, int[] b, int bStart, int k) {
    // Base case:
    // 1. When either of the two arrays has no more elements to examing
    // 2. When k has become 1, this is when the answer comes out
    if (aStart >= a.length) {
      // Return the (start + k - 1)-th element ==> understand k-th
      return b[k - 1 + bStart];
    } else if (bStart >= b.length) {
      return a[k - 1 + aStart];
    }
    if (k == 1) {
      return Math.min(a[aStart], b[bStart]);
    }
    // Compare the (k/2)th element in a's subarray and in b's subarray
    // to determine which (k/2) partition contains the smallest k elements
    // Therefore, we can discard the other partition since the result is impossible
    // to be included there
    int aMid = aStart + k / 2 - 1;
    int bMid = bStart + k / 2 - 1;
    int aVal = aMid >= a.length ? Integer.MAX_VALUE : a[aMid];
    int bVal = bMid >= b.length ? Integer.MAX_VALUE : b[bMid];
    if (aVal <= bVal) {
      return kthSmallest(a, aMid + 1, b, bStart, k - k / 2);
    } else {
      return kthSmallest(a, aStart, b, bMid + 1, k - k / 2);
    }
  }
}
```

#### Complexity

- Time
  - The search range is narrowed down by 1/2 each time
  - Time complexity is O(log(k))
- Space
  - We narrow down the search range of k by 1/2 each time
  - There will be log(k) recursive calls on the call stack
  - Space is O(log(k))