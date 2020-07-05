<!----- Conversion time: 0.846 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Tue Jan 15 2019 19:49:44 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1Hp2EhM63LheqAf8z9xWDrlwQqQEkOq9Jd-1heOEvFDc
----->

# Reverse Linked List

[https://app.laicode.io/app/problem/34](https://app.laicode.io/app/problem/34)

## Description

Reverse a singly-linked list.

Examples

- L = null, return null
- L = 1 -> null, return 1 -> null
- L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null

## Assumption

The input linked list should not be null.

The ListNode class is provided.

## Algorithm

1.  Iteration
    1.  set prevNode → currNode → nextNode → … → tailNode → null
    1.  while-loop check every node and flip the links
        1.  let nextNode = currNode.next
        1.  currNode.next = prevNode // prevNode ← currNode
        1.  prevNode = currNode
        1.  currNode = next
1.  Recursion
    1.  Deal with the subproblems of the next node (curr.next)
    1.  The result of the subproblems could be considered as one whole list and should point to curr
    1.  cut curr's link to its original next node
    1.  The result of the subproblems AND this problem should be the new head node of the reversed list

## Solution

### Method 1: iteration

#### Code

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

  public ListNode reverse(ListNode head) {
    // Write your solution here
    if (head == null || head.next == null) {
      return head;
    }
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
```

#### Complexity

Time: n nodes to check and reverse ⇒ O(n).

Space: constant space ⇒ O(1).

### Method 2: recursion

#### Code

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

  public ListNode reverse(ListNode head) {
    // Write your solution here
    /* Recursion method */
    // Base case: when we reach the last node in the original list
    if (head == null || head.next == null) {
      // head.next == null is the real base case
      return head;
    }
    ListNode current = head;
    // Recursively get the new head node of the reversed list from the subproblems
    ListNode newHead = reverse(current.next);
    // Connect the new list to current and cut current's original next
    current.next.next = current;
    current.next = null;
    return newHead;
  }
}
```

#### Complexity

Time: n levels in the recursion tree and O(1) operations in each level ⇒ O(n).

Space: n levels in the recursion tree ⇒ O(n).

<!-- GD2md-html version 1.0β13 -->
