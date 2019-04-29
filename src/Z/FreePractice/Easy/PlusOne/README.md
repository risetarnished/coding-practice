# Plus One

<https://app.laicode.io/app/problem/162>

<https://leetcode.com/problems/plus-one/>

## Description

Given a non-negative number represented as an array of digits, plus one to the number.

Input:\[2, 5, 9]

Output: \[2, 6, 0]

**Tags**

- Easy
- Array
- Math

## Assumption

- The input is a non-negative integer array
- The array should not be null or empty

## Solution

### High-level Idea

- From the least significant digit, add one to the existing digit each time
- Check if there is a carry happening
  - If there was a carry during the previous addition, add another one to the current digit
- Post-processing
  - If the most significant digit results in a carry
    - Expand the current array by 1
    - new array\[0] = 1
    - new array\[1...end] = old array

### Code

```java
public class Solution {
  public int[] plus(int[] digits) {
    // Write your solution here
    if (digits == null || digits.length == 0) {
      return digits;
    }
    // carry represents the fact whether the previous digits yielded a carry-over 10
    boolean hasCarry = false;
    for (int i = digits.length - 1; i >= 0; i--) {
      // Add 1 to the digit if
      // 1. it is the least significant digit
      // 2. there was a carry
      if (i == digits.length - 1 || hasCarry) {
        digits[i] += 1;
      }
      hasCarry = digits[i] >= 10;
      digits[i] %= 10;
    }
    // Post-processing
    // If the most significant digit yielded a carry-over
    // We need to create a new digit and expand the array
    if (hasCarry) {
      int[] expanded = new int[digits.length + 1];
      for (int i = 0; i < expanded.length; i++) {
        if (i == 0) {
          expanded[i] = 1;
        } else {
          expanded[i] = digits[i - 1];
        }
      }
      digits = expanded;
    }
    return digits;
  }
}
```

### Complexity

- Time
  - Every single digit has to be checked ==> O(n)
  - If the post-processing is needed, it is another O(n)
  - Total time is O(n)
- Space
  - O(1) if no post-processing
  - O(n) if post-processing

