# Check If Linked List Has A Cycle

[https://app.laicode.io/app/problem/37](https://app.laicode.io/app/problem/37)

## Description

Check if a given linked list has a cycle. Return true if it does, otherwise return false.

## Assumption

The input linked list should not be null.

## Algorithm

Fast/slow pointer algorithm.

- Fast moves two steps at a time while slow moves one step at a time
- If there are no cycles in the linked list, the two pointers/nodes will function like those in the previous problem [Middle Node of Linked List](../MiddleNodeOfLinkedList)
- If at any given time, the two nodes/pointers meet each other, there is a cycle in the list

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

  public boolean hasCycle(ListNode head) {
    // write your solution here
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      if (slow == fast) {
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }
}
```

### Complexity

Time: there are n nodes in the linked list and we need to check every one of them ⇒ O(n).

Space: two nodes are created ⇒ O(1).
