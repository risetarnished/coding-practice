package coollime.linkedlist.reorderlinkedlist;

import coollime.helper.ListNode;

public class Solution {

  public ListNode reorder(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    // 1st: head → … → middle → null
    // 2nd: middle.next → … → tail → null
    ListNode firstHalf = head;
    ListNode middle = findMiddleNode(head);
    ListNode secondHalf = middle.next;
    // Cut the link after middle
    middle.next = null;
    // Reversed second part: tail → ... → middle.next → null
    ListNode reversedSecondHalf = reverseList(secondHalf);
    ListNode reordered = mergeLists(firstHalf, reversedSecondHalf);
    return reordered;
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
    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }

  private ListNode mergeLists(ListNode one, ListNode two) {
    if (one == null) {
      return two;
    } else if (two == null) {
      return one;
    }
    ListNode head = new ListNode(0);
    ListNode current = head;
    ListNode oneCurr = one;
    ListNode twoCurr = two;
    while (oneCurr != null && twoCurr != null) {
      current.next = oneCurr;
      oneCurr = oneCurr.next;
      current = current.next;
      current.next = twoCurr;
      twoCurr = twoCurr.next;
      current = current.next;
    }
    if (oneCurr != null) {
      current.next = oneCurr;
    } else if (twoCurr != null) {
      // Redundant else-if case, but left here for clarification
      current.next = twoCurr;
    }
    return head.next;
  }
}
