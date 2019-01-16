<!----- Conversion time: 0.872 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Tue Jan 15 2019 18:41:58 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1ELPhj-_WkciX_ICXoxFScv9sq47bFRYe6AnjiVwE-Ng
----->



# Sort with 3 Stacks

[https://app.laicode.io/app/problem/279](https://app.laicode.io/app/problem/279)


## Description

Given one stack with integers, sort it with two additional stacks (total 3 stacks).

After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.

Assumptions:



*   The given stack is not null.

Requirements:



*   No additional memory, time complexity = O(nlog(n)).

Medium

Recursion

Stack


## Assumption

The stacks should not be null.


## Algorithm

Given elements in stack s1, use two additional stacks, s2 and s3 respectively, recursively sort the elements in s1.



1.  Look for the min value among the current elements in s1
1.  Push the min to s3 and all others to s2
1.  Swap s2 and s1 and repeat the previous steps
1.  In the end, s3 will have all elements in descending order
1.  s1.push(s3.pop()) will transfer all elements back to s1 and eventually in ascending order


## Solution


### Code


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

  private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3) {
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

  private void transferStack(LinkedList<Integer> stackOne, LinkedList<Integer> stackTwo) {
    if (stackOne == null || stackTwo == null) {
      return;
    }
    while (!stackOne.isEmpty()) {
      stackTwo.offerFirst(stackOne.pollFirst());
    }
  }
}
```



### Complexity


#### Time

There are n levels in the recursion tree. In each level, we need to check n elements in the stack and do n push() and pop() operations ⇒ O(n^2)

This is basically like a selection sort.


#### Space

Two stacks are used ⇒ O(n)

n levels in the recursion tree ⇒ O(n)


<!-- GD2md-html version 1.0β13 -->
