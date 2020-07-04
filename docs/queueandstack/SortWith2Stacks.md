# Sort with 2 Stacks

[https://app.laicode.io/app/problem/280](https://app.laicode.io/app/problem/280)

## Description

Given an array that is initially stored in one stack, sort it with one additional stacks (total 2 stacks).

After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.

Assumptions:

- The given stack is not null.

Requirements:

- No additional memory, time complexity = O(n ^ 2).

Medium

Stack

## Assumption

The given stack is not null.

## Algorithm

The high level idea of this problem is to use an extra stack to sort the elements in a given stack. A selection-sort-like
algorithm can be implemented with this helper stack just like what is done in the
[Sort with 3 Stack](../SortWith3Stacks) problem. In this problem, however, s2 can be used as both the buffer and storing
the result.

1.  Just like selection sort, we pop all elements from s1 and push them onto s2 while looking for the min value among them
1.  Pop all elements from s2 back to s1 while keeping the sorted elements
    1.  if s2.top > current min ⇒ pop and push
    1.  if s2.top == current min ⇒ pop, but not push it back to s1. Push it onto s2 after the transfer of other elements back to s1 is done. If there are duplicate elements in the given stack, count the number of the current min, such that none of them would be missed when pushing them onto the sorted section of s2.
    1.  if s2.top < current min ⇒ indicating that we have entered the sorted section of s2, which should be kept for storing the result. In this case, the transfer of elements back to s1 is finished.
1.  Push all instances of the current min onto s2 for result
1.  Transfer all elements from s2 back to s1 such that the elements in s1 will be sorted in ascending order from top to bottom

## Solution

### Code

```java
public class Solution {

  public void sort(LinkedList<Integer> s1) {
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    // Write your solution here.
    if (s1 == null || s1.size() <= 1) {
      return;
    }
    int n = s1.size();
    // There are in total n elements to sort
    for (int i = 0; i < n; i++) {
      int currentMin = Integer.MAX_VALUE;
      // Transfer elements from s1 to s2
      // while looking for the current min
      while (!s1.isEmpty()) {
        int current = s1.pollFirst();
        currentMin = Math.min(currentMin, current);
        s2.offerFirst(current);
      }
      // Transfer elements that are greater than current min
      // back to s1
      // Push all elements == current min onto s2
      int minCount = 0;
      while (!s2.isEmpty()) {
        int current = s2.peekFirst();
        if (current < currentMin) {
          // Case 1: entering the sorted section
          break;
        } else if (current > currentMin) {
          // Case 2: transfer back to s1
          s1.offerFirst(s2.pollFirst());
        } else {
          // Case 3: count the number of current min
          // such that none of them would be missed
          s2.pollFirst();
          minCount++;
        }
      }
      // Push all instances of current min onto s2 for result
      // and we are done with this level
      for (int j = 0; j < minCount; j++) {
        s2.offerFirst(currentMin);
      }
    }
    // Transfer all elements from s2 back to s1 such that
    // all elements in s1 are sorted in ascending order
    // from top to bottom
    while (!s2.isEmpty()) {
      s1.offerFirst(s2.pollFirst());
    }
  }
}
```

### Complexity

#### Time

In total, there are n elements in s1 to sort. We can only use s2 as the buffer to find and sort the min value among all remaining elements in s1 each time. Therefore, the total time complexity is O(n^2) which is the same as selection sort of an array.

#### Space

An extra stack, s2, is used as buffer and also temporarily storing the result (we need to transfer all elements back to s1 because they are sorted in descending order from top to bottom in s2 at the end). Other than that, all variables created are constant spaces. Therefore, the total space complexity is O(n).
