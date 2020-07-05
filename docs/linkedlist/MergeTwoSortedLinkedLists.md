# Merge Two Sorted Linked Lists

[https://app.laicode.io/app/problem/40](https://app.laicode.io/app/problem/40)

## Description

    Merge two sorted lists into one large sorted list.


    Examples

- L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
- L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
- L1 = null, L2 = null, merge L1 and L2 to null

Easy

Linked List

## Assumption

The input nodes/lists should not be null or empty.

## Algorithm

This is when a dummy node is needed: when we need to build a linked list from scratch, we would like to have something to help us prevent null pointer exception.

ListNode dummy = new ListNode(0);

dummy.next = head;

ListNode curr = dummy;

Create a dummy node, use the dummy node/pointer and do the merging process like the merge section in merge sort (_move the smaller pointer_).

## Solution

```java
/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {

  public ListNode merge(ListNode one, ListNode two) {
    // Write your solution here
    if (one == null) {
      return two;
    } else if (two == null) {
      return one;
    }
    ListNode head = new ListNode(0);
    ListNode current = head;
    ListNode oneCurr = one;
    ListNode twoCurr = two;
    // Traversing both lists and move the smaller pointer after each comparison
    while (oneCurr != null && twoCurr != null) {
      if (oneCurr.value < twoCurr.value) {
        current.next = oneCurr;
        oneCurr = oneCurr.next;
      } else {
        current.next = twoCurr;
        twoCurr = twoCurr.next;
      }
      current = current.next;
    }
    // One of the lists may still have elements left
    if (oneCurr != null) {
      current.next = oneCurr;
    } else if (twoCurr != null) {
      current.next = twoCurr;
    }
    return head.next;
  }
}
```

## Complexity

Time: traversing both lists and check every single node ⇒ O(2n) ⇒ O(n).

Space: only dummy and helper nodes are created ⇒ O(1).
