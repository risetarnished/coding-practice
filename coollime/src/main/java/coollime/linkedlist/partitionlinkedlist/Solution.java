package coollime.linkedlist.partitionlinkedlist;

import coollime.common.objects.ListNode;

public class Solution {

  public ListNode partition(ListNode head, int target) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode smallDummy = new ListNode(0);
    ListNode smallCurr = smallDummy;
    ListNode largeDummy = new ListNode(0);
    ListNode largeCurr = largeDummy;
    ListNode current = head;
    // Compare the node values to the target and move the smaller pointer like what
    // is done in quick sort
    while (current != null) {
      if (current.value < target) {
        smallCurr.next = current;
        smallCurr = smallCurr.next;
      } else {
        largeCurr.next = current;
        largeCurr = largeCurr.next;
      }
      current = current.next;
    }
    // Concatenate the two lists
    // smallHead -> ... smallCurr -> largeHead -> largeCurr -> null
    smallCurr.next = largeDummy.next;
    largeCurr.next = null;
    return smallDummy.next;
  }
}
