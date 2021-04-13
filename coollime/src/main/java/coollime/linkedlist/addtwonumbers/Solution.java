package coollime.linkedlist.addtwonumbers;

import coollime.common.objects.ListNode;

public class Solution {

  /**
   * Add each digit up in two linked lists
   *
   * @param l1 The first linked list
   * @param l2 The second linked list
   * @return A linked list with all corresponding digits added up
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    }
    // Create a linked list to store the result
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    boolean[] shouldCarry = new boolean[] { false };
    while (l1 != null && l2 != null) {
      int value = getAddedValue(l1.value, l2.value, shouldCarry);
      curr.next = new ListNode(value);
      curr = curr.next;
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      int value = getAddedValue(l1.value, 0, shouldCarry);
      curr.next = new ListNode(value);
      curr = curr.next;
      l1 = l1.next;
    }
    while (l2 != null) {
      int value = getAddedValue(0, l2.value, shouldCarry);
      curr.next = new ListNode(value);
      curr = curr.next;
      l2 = l2.next;
    }
    // Post-processing
    // When the last addition yields a carry
    if (shouldCarry[0]) {
      curr.next = new ListNode(1);
    }
    return dummy.next;
  }

  private int getAddedValue(int one, int two, boolean[] shouldCarry) {
    int result = shouldCarry[0] ? one + two + 1 : one + two;
    shouldCarry[0] = result >= 10;
    return shouldCarry[0] ? result - 10 : result;
  }
}
