# Sort with 3 Stacks

[https://app.laicode.io/app/problem/279](https://app.laicode.io/app/problem/279)

## Description

Given one stack with integers, sort it with two additional stacks (total 3 stacks).

After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.

Assumptions:

- The given stack is not null.

Requirements:

- No additional memory, time complexity = O(nlog(n)).

Medium

Recursion

Stack

## Assumption

The stacks should not be null.

## Algorithm

1. Selection sort: given elements in stack s1, use two additional stacks, s2 and s3 respectively, recursively sort the elements in s1. S2 functions as a buffer to hold the elements temporarily while s3 is used to store the results temporarily in descending order from top to bottom
   1. Look for the min value among the current elements in s1
   2. Push the min to s3 and all others to s2
   3. Swap s2 and s1 and repeat the previous steps
   4. In the end, s3 will have all elements in descending order
   5. s1.push(s3.pop()) will transfer all elements back to s1 and eventually in ascending order
2. Merge sort: given elements in stack s1, use s2 as buffer and s3 as temporary storage for the results, implement a merge sort method to sort the elements in s1 such that s1 has all elements sorted in ascending order from top to bottom
   1. Divide the input stack into two
      1. determined by the specified number of elements to sort in s1
      2. half = # to sort / 2
      3. transfer half of the elements from s1 to s2
      4. s1 are left with # to sort - half amount of elements
   2. Sort the elements left in s1
   3. Sort the elements transferred to s2
   4. Merge the sorted part of s1 and s2 into s3
      1. s3.push(smaller(s1.peek(), s2.peek()))
      2. by doing this, s3 will have all elements sorted in descending order from top to bottom
   5. Transfer the sorted part from s3 back to s1
      1. s1 will have the specified number of elements sorted in ascending order from top to bottom

## Solution

### Method 1: Selection Sort

#### Code

```java
public class Solution {

  public void sort(LinkedList<Integer> s1) {
    if (s1 == null || s1.isEmpty()) {
      return;
    }

    LinkedList<Integer> s2 = new LinkedList<Integer>();
    LinkedList<Integer> s3 = new LinkedList<Integer>();
    // Write your solution here.
    // Recursively sort the elements on s1 with the help of s2
    // Pick the min value on s1 each time and push it onto s3
    // Such that s3 will have all the original elements sorted in descending order
    // from top to bottom
    // We then transfer the elements back to s1 such that s1
    // have all the original elements sorted in ascending order from top to bottom
    sort(s1, s2, s3);
    transferStack(s3, s1);
  }

  private void sort(
    LinkedList<Integer> s1,
    LinkedList<Integer> s2,
    LinkedList<Integer> s3
  ) {
    // Base case: when all the elements on s1 have been sorted
    if (s1.isEmpty()) {
      return;
    }
    // Look for the min value among all the elements that are still on s1
    Integer min = s1.pollFirst();
    while (!s1.isEmpty()) {
      if (s1.peekFirst().compareTo(min) < 0) {
        // Push the old min onto s2 so we will not miss it
        s2.offerFirst(min);
        // Record the new min
        min = s1.pollFirst();
      } else {
        // Push s1's current top element onto s2 directly
        s2.offerFirst(s1.pollFirst());
      }
    }
    // Upon exiting the while-loop, we have found the min value in s1
    // Push it onto s3
    s3.offerFirst(min);
    // Recursively sort the rest of the elements that are originally on s1
    // Trick: flip s1 and s2 in the argument
    sort(s2, s1, s3);
  }

  private void transferStack(
    LinkedList<Integer> stackOne,
    LinkedList<Integer> stackTwo
  ) {
    if (stackOne == null || stackTwo == null) {
      return;
    }
    while (!stackOne.isEmpty()) {
      stackTwo.offerFirst(stackOne.pollFirst());
    }
  }
}
```

#### Complexity

##### Time

There are n levels in the recursion tree. In each level, we need to check n elements in the stack and do n push() and pop() operations ⇒ O(n^2)

This is basically like a selection sort.

##### Space

Two stacks are used ⇒ O(n)

n levels in the recursion tree ⇒ O(n)

### Method 2: Merge Sort

#### Code

```java
public class Solution {

  public void sort(LinkedList<Integer> s1) {
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    LinkedList<Integer> s3 = new LinkedList<Integer>();
    // Write your solution here.
    // Corner case:
    if (s1 == null || s1.size() <= 1) {
      return;
    }
    // Sort elements in s1 using s2 as buffer and s3 as
    // temporary storage for the results
    // Specify the number of elements to get sorted in s1
    sortStack(s1, s2, s3, s1.size());
  }

  private void sortStack(
    LinkedList<Integer> s1,
    LinkedList<Integer> s2,
    LinkedList<Integer> s3,
    int length
  ) {
    // Base case: when there are only one element left to be sorted
    if (length == 1) {
      return;
    }
    // Divide the input s1 into two halves and sort them respectively:
    // Put 1/2 of the elements in s1 to the buffer s2
    // Sort the elements in s1 and the transfered elements in s2
    int half = length / 2;
    for (int i = 0; i < half; i++) {
      s2.offerFirst(s1.pollFirst());
    }
    // There are (length - half) elements left in s1
    sortStack(s1, s2, s3, length - half);
    sortStack(s2, s1, s3, half);
    // Merge the newly sorted part in s1 and s2 into s3
    mergeStacks(s1, s2, s3, length - half, half);
    // Transfer the sorted part from s3 back to s1
    transferStacks(s3, s1, length);
  }

  private void mergeStacks(
    LinkedList<Integer> s1,
    LinkedList<Integer> s2,
    LinkedList<Integer> s3,
    int lengthOne,
    int lengthTwo
  ) {
    // Put the smaller number in s1 and s2 into s3 first
    // Such that s3 will have the elements sorted in
    // descending order from top to bottom
    int one = 0;
    int two = 0;
    while (one < lengthOne && two < lengthTwo) {
      if (s1.peekFirst() < s2.peekFirst()) {
        s3.offerFirst(s1.pollFirst());
        one++;
      } else {
        s3.offerFirst(s2.pollFirst());
        two++;
      }
    }
    while (one < lengthOne) {
      s3.offerFirst(s1.pollFirst());
      one++;
    }
    while (two < lengthTwo) {
      s3.offerFirst(s2.pollFirst());
      two++;
    }
  }

  private void transferStacks(
    LinkedList<Integer> s1,
    LinkedList<Integer> s2,
    int length
  ) {
    for (int i = 0; i < length; i++) {
      s2.offerFirst(s1.pollFirst());
    }
  }
}
```

#### Complexity

##### Time

There are n elements in s1 and the recursion tree has log(n) levels. The merge process takes O(n) time in each level. So does the transfer of stacks. Therefore, the total time complexity is O(n log(n))

##### Space

The recursion tree reaches its max number levels when we reach the base case of dividing the input stacks (when the elements left to be sorted become 1). The max number of levels is log(n). Therefore, the space complexity is O(log(n)). However, if we take the two extra stacks used, it is O(n).
