package coollime.linkedlist.cyclenodeinlinkedlist;

import coollime.common.objects.ListNode;

public class Solution {

  /**
   * Find the start of the cycle in a linked list
   *
   * @param head The head of the given linked list
   * @return The starting node of the cycle in the list
   */
  public ListNode cycleNode(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    boolean hasCycle = false;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        hasCycle = true;
        break;
      }
    }
    // Proceed only if there is a cycle
    if (!hasCycle) {
      return null;
    }
    // distance(head, start) == distance(meet, start)
    // So, let slow moves one step at a time from the head
    // let fast moves one step at a time from the meeting point
    // They will meet at the starting point of the cycle
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}
