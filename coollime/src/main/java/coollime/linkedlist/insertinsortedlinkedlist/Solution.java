package coollime.linkedlist.insertinsortedlinkedlist;

import coollime.common.objects.ListNode;

public class Solution {

  public ListNode insert(ListNode head, int value) {
    ListNode newNode = new ListNode(value);
    // Case 1: insert before head
    if (head == null || head.value >= value) {
      newNode.next = head;
      return newNode;
    }
    // Case 2: insert in the middle/tail
    ListNode current = head;
    // Skip all the nodes whose values are less than (NOT equal to) value
    while (current.next != null && current.next.value < value) {
      current = current.next;
    }
    // current is either the tail or smaller than next, insert the new node after
    // current
    newNode.next = current.next;
    current.next = newNode;
    return head;
  }
}
