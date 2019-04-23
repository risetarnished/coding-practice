# Longest Ascending Subsequence

[https://app.laicode.io/app/problem/1](https://app.laicode.io/app/problem/1)

## Description

Given an array A\[0]...A\[n-1] of integers, find out the length of the longest ascending subsequence.

**Assumptions**

- A is not null

**Examples**
Input: A = {5, 2, 6, 3, 4, 7, 5}
Output: 4
Because \[2, 3, 4, 5] is the longest ascending subsequence.

**Tags**

- Medium
- Array
- Binary Search

## Solution

### Method 1 (Not Optimized)

#### High-level Idea

- Use dynamic programming to record the length of ascending subsequence which ends at each index
- E.g., A = {5, 2, 6, 3, 4, 7, 5}
  - final M = {1, 1, 2, 2, 3, 4, 4}
  - Step 1: 5
    - l = 1
  - Step 2: 2
    - l = 1 because nothing before 2 is smaller 
  - Step 3: 6
    - l = 2
    - either \[2, 6] or \[5, 6]
  - Step 4: 3
    - l = 2 because the 2 in \[5, 2, 6] is smaller than 3
  - Step 5: 4
    - l = 3 because 3 is smaller than 4 and we check M\[index of 3] = 2
    - l = M\[max(M\[index of the element that is smaller than the current element])]
  - Step 6: 7
    - l = 4
    - \[2, 3, 4] or \[5, 6]
    - Because M\[index of 4] > M\[index of 6]
    - M\[index of 7] = M\[index of 4] + 1
  - Step 7: 5
    - M\[index of 5] = M\[index of 4] + 1
  - Final result is 4

#### Code

```java
public class Solution {
  public int longest(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    // longest[i] represents the length of the longest ascending subsequence
    // that ends at index i
    int[] longest = new int[array.length];
    longest[0] = 1;
    // Keep a record of the largest length among all for result
    int maxLen = 1;
    // For the element at index i, compare its previous elements at index j
    // where j is in (i, 1] and array[j] < array[i]
    // longest[i] = max(longest[j]) + 1
    for (int i = 1; i < array.length; i++) {
      longest[i] = 1;
      for (int j = i - 1; j >= 0; j--) {
        if (array[i] > array[j]) {
          longest[i] = Math.max(longest[i], longest[j] + 1);
        }
      }
      maxLen = Math.max(maxLen, longest[i]);
    }
    return maxLen;
  }
}
```

#### Complexity

- Time
  - One iteration over the n elements in the array
  - For each element at index i, another iteration from (i - 1) to 0 is performed
  - Total time is O(n^2)
- Space
  - An array with length n is used
  - Total space is O(n)

### Method 2 (Optimized Time)

#### High-level Idea

- TODO (Should be able to solve with binary search)