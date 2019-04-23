# Majority Number I

[https://app.laicode.io/app/problem/206](https://app.laicode.io/app/problem/206)

## Description

Given an integer array of length L, find the number that occurs **more than** 0.5 * L times.

**Assumptions**

- The given array is not null or empty
- It is guaranteed there exists such a majority number

**Examples**

- A = {1, 2, 1, 2, 1}, return 1

**Tags**

- Easy
- Array

## Assumption

- Input array is not null or empty
- There is guaranteed to be an element that appears more than 50% of the time

## Solution

### High-level Idea

- Use a hash map which keep track of the relationship between <element, # of occurrence>
  - Literally a frequency map
  - But the size can be 1
- The hash map will store only one element's frequency
- Whenever a different element comes into play
  - If the current element's frequency >= 1
    - decrement its frequency
  - If the current element's frequency < 1
    - replace it with the new element (with a frequency of 1)
- When we finish the iteration over the array, the element that is in the map is the majority number
- This is able to be done using just a count variable by mimicking the frequency map

### Code

```java
public class Solution {
  public int majority(int[] array) {
    // Write your solution here
    // Corner cases based on assumption
    if (array == null || array.length == 0) {
      return Integer.MIN_VALUE;
    }
    // candidate represents the current element to be compared against
    // count represents the number of occurrence of the candidate
    int candidate = array[0];
    int count = 1;
    // For the rest elements in the array, compare each one of them against the candidate
    for (int i = 1; i < array.length; i++) {
      if (count == 0) {
        // 1. The candidate's count has been balanced out by the competitors
        //    Replace with a new candidate and its count should be 1 now
        candidate = array[i];
        count++;
      } else if (candidate == array[i]) {
        // 2. The incoming element is an instance of the candidate
        count++;
      } else {
        // 3. The incoming element is different from the candidate
        count--;
      }
    }
    return candidate;
  }
}

```

### Complexity

- Time
  - One direct iteration over the whole array
  - O(n)
- Space
  - No additional data structure used
    - Even if a hash map were used, it would have a size of 1
  - O(1)