# Middle Node of Linked List

[https://app.laicode.io/app/problem/36](https://app.laicode.io/app/problem/36)

## Description

Find the middle node of a given linked list.

Examples

- L = null, return null
- L = 1 -> null, return 1
- L = 1 -> 2 -> null, return 1
- L = 1 -> 2 -> 3 -> null, return 2
- L = 1 -> 2 -> 3 -> 4 -> null, return 2

## Assumption

The input head node (linked list) should not be null

## Algorithm

A classical fast/slow pointer example.

- slow node is initialized to the head node
- fast node is initialized to head.next
- slow moves one step at a time
- fast moves two steps at a time
- when fast reaches the end of the list or just gets out, slow points to the middle node of the list

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

  public ListNode middleNode(ListNode head) {
    // Write your solution here
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
}
```

**If we'd like the second node to be returned if there are two middle nodes, we could start the fast pointer from the same node pointed to by slow.**
**For example, 1 -> 2 -> 3 -> 4, if we want node 3 to be returned.**
**This is the requirement of [the same problem on LeetCode](https://leetcode.com/problems/middle-of-the-linked-list/description/)**

```java
public class Solution {

  public ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
```

### Complexity

Time: there are n nodes in the linked list and we need to traverse the whole list. The fast node moves two steps at a time ⇒ O(n/2) ⇒ O(n).

Space: two ListNode objects ⇒ O(1).
