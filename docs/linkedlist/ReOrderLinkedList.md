<!----- Conversion time: 0.732 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Tue Jan 15 2019 19:58:27 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1Ys6WATXiRy9Ni2eTrTCCJ5m7UMIWvXkWzDyIaECQ91Q
----->

# Reorder Linked List

[https://app.laicode.io/app/problem/41](https://app.laicode.io/app/problem/41)

## Description

Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null

Examples

- L = null, is reordered to null
- L = 1 -> null, is reordered to 1 -> null
- L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
- L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null

Hard

Linked List

## Assumption

The input linked list should not be null or empty.

## Algorithm

The algorithm can be divided into three steps:

1.  Find the middle node of the list
    1.  slow/fast pointer algorithm in [Middle Node of Linked List](../../Easy/MiddleNodeOfLinkedList)
    1.  assign middle.next to be the head of the second part
    1.  the original linked list is partitioned to two parts:
        1.  head → … → mid → null
        1.  mid.next → … → tail → null
1.  Reverse the second part of the list
    1.  iterative/recursive method in [Reverse Linked List](../../Easy/ReverseLinkedList)
    1.  original second part: mid.next → … → tail → null
    1.  reversed second part: tail → … → mid.next → null
1.  Merge the two parts into one
    1.  similar to _move the smaller pointer_ method in [Merge Two Sorted Linked Lists](../../Easy/MergeTwoSortedLinkedLists)
    1.  result looks like **head → tail → … → null**

## Solution

### Code

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

  public ListNode reorder(ListNode head) {
    // Write your solution here
    if (head == null || head.next == null) {
      return head;
    }
    /* Step 1: find the middle node in the list and cut the list into two parts */
    ListNode first = head;
    ListNode mid = findMiddleNode(first);
    // Assign mid.next to be the head of the second part such that
    // first.size() >= second.size()
    ListNode second = mid.next;
    // Cut the link after mid
    mid.next = null;
    /* Step 2: reverse the second part */
    ListNode reversedSecond = reverseList(second);
    /* Step 3: merge the two parts into one list */
    ListNode result = mergeLists(first, reversedSecond);
    return result;
  }

  private ListNode findMiddleNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    /* Recursive method */
    /*
    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
    */
    /* Iterative method */
    ListNode previous = null;
    ListNode current = head;
    while (current != null) {
      ListNode next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    return previous;
  }

  private ListNode mergeLists(ListNode one, ListNode two) {
    if (one == null) {
      return two;
    } else if (two == null) {
      return one;
    }
    // Dummy head node
    ListNode head = new ListNode(0);
    ListNode current = head;
    ListNode oneCurr = one;
    ListNode twoCurr = two;
    while (oneCurr != null && twoCurr != null) {
      // Connect a node from the first part
      current.next = oneCurr;
      oneCurr = oneCurr.next;
      current = current.next;
      // Connect a node from the second part
      current.next = twoCurr;
      twoCurr = twoCurr.next;
      current = current.next;
    }
    // Left-over elements
    // Because first.size() >= second.size()
    // There could only be left-over elements in the first half if there are any
    if (oneCurr != null) {
      current.next = oneCurr;
    }
    return head.next;
  }
}
```

### Complexity

Time: all 3 steps need to check every node in the list ⇒ O(n).

Space: steps 1 & 3 use constant space; step two uses constant space if using iterative method, but O(n) space if using recursive method. ⇒ O(1) or O(n).

<!-- GD2md-html version 1.0β13 -->
