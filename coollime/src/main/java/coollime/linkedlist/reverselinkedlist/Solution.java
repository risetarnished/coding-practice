package coollime.linkedlist.reverselinkedlist;

import coollime.common.objects.ListNode;

public class Solution {

  /**
   * Reverse a linked list iteratively
   *
   * @param head - the head node of the linked list
   * @return the head of the reversed linked list
   */
  public ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
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

  /**
   * Reverse a linked list recursively
   *
   * @param head - the head node of the linked list
   * @return - the head of the reversed linked list
   */
  public ListNode reverseRecursively(ListNode head) {
    // Base case: when we reach the last node in the original order
    if (head == null || head.next == null) {
      // The real case happens only when head.next == null
      return head;
    }
    ListNode reversedHead = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return reversedHead;
  }
}
