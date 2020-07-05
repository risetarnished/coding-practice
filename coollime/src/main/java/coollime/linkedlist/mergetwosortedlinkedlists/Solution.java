package coollime.linkedlist.mergetwosortedlinkedlists;

import coollime.helper.ListNode;

public class Solution {

  public ListNode merge(ListNode one, ListNode two) {
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
    // One of the two lists may still have elements left
    if (oneCurr != null) {
      current.next = oneCurr;
    } else if (twoCurr != null) {
      current.next = twoCurr;
    }
    return head.next;
  }
}
