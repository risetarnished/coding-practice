# Maximum Values of Size K Sliding Window

[https://app.laicode.io/app/problem/204](https://app.laicode.io/app/problem/204)

## Description

Given an integer array A and a sliding window of size K, find the maximum value of each window as it slides from left to right.

**Assumptions**

- The given array is not null and is not empty
- K >= 1, K <= A.length

**Examples**

A = {1, 2, 3, 2, 4, 2, 1}, K = 3, the windows are {{1,2,3}, {2,3,2}, {3,2,4}, {2,4,2}, {4,2,1}},

and the maximum values of each K-sized sliding window are \[3, 3, 4, 4, 4]

**Tags**

- Medium
- Queue

## Assumption

- The input array contains integers only and should not be null
- 1 <= K <= A.length

## Solution

### High-level Idea

- E.g. A = {1, 2, 3, 2, 4, 2, 1}, K = 3
  - Maintain a data structure to store the current max of the sliding window
  - window = \[1]
    - max = \[1] 
  - window = \[1, 2]
    - prev_max = \[1], but 2 > 1
    - max = \[2]
  - window = \[1, 2, 3]
    - prev_max = \[2], but 3 > 2
    - max = \[3]
    - result = \[3]
  - window = \[2, 3, 2]
    - prev_max = \[3], and 2 < 3
    - max = \[3, 2]
    - result = \[3, 3]
  - window = \[3, 2, 4]
    - prev_max = \[3, 2], but 4 > 3 and 4 > 2
    - max = \[4]
    - result = \[3, 3, 4]
  - window = \[2, 4, 2]
    - prev_max = \[4], and 2 < 4
    - max = \[4, 2]
    - result = \[3, 3, 4, 4]
  - window = \[4, 2, 1]
    - prev_max = \[4, 2], and 1 < 2
    - max = \[4, 2, 1]
    - result = \[3, 3, 4, 4, 4]
- Because we have operations like
  - insert from the end
  - remove from the end
  - remove from the head
- This data structure sounds pretty much like a deque
  - Instead of keep track of the element, we can keep track of the index of the element
  - By doing so, it is easier to determine if it has dropped out of the sliding window
- Every time when the sliding window moves and takes in a new element
  - if (new element > deque.end): deque.popEnd() and deque.insertEnd(new element)
    - because the old max will not stay in the window longer than the new element
  - if (new element < deque.end): deque.insertEnd(new element)
    - because the old max has a shorter lifespan than the new element
    - the new element may become max in later windows
- When the windows size == k
  - Add the current max to the result
  - Remove the old max if it is the start of the current window
  - Move the sliding window down by one

### Code

```java
public class Solution {
  public List<Integer> maxWindows(int[] array, int k) {
    // Write your solution here
    // Corner cases based on the assumptions
    List<Integer> result = new ArrayList<>();
    if (array == null || array.length == 0 ||
        k < 0 || k > array.length) {
      return result;
    }
    // E.g. A = {1, 2, 3, 2, 4, 2, 1}, K = 3
    // Use a deque to keep track of the index of current max element in the sliding window
    // The head of the deque is the max of the current sliding window
    Deque<Integer> deque = new ArrayDeque<>(k);
    int start = 0;
    for (int end = 0; end < array.length; end++) {
      // Check the new element against the current max of the window
      // Remove all previous max values if the new element is greater
      while (!deque.isEmpty() && array[end] > array[deque.peekLast()]) {
        deque.pollLast();
      }
      // And add the new max to the deque if the deque is empty
      // or the new element is smaller than the previous max
      deque.offerLast(end);
      // When the window size == k, add the current max to the result
      if (end - start + 1 == k) {
        result.add(array[deque.peekFirst()]);
        // Remove the old max if it is the start of the current window
        // and move the sliding window to the right by 1
        if (deque.peekFirst() == start++) {
          deque.pollFirst();
        }
      }
    }
    return result;
  }
}
```

### Complexity

- Time
  - One iteration over the n elements in the array
  - Although there is a while loop, each element in the array gets added into or removed from the array once. That's it
  - Total time is O(n)
- Space
  - A deque of size k is used
  - Total space is O(k)