package E.LinkedList.Medium.AddTwoNumbers;

import helper.ListNode.ListNode;

/**
 * AddTwoNumbers
 *
 * @author meng
 * @date 2/10/19
 */
public class Solution {

  /**
   * Add each digit up in two linked lists
   *
   * @param l1  The first linked list
   * @param l2  The second linked list
   * @return    A linked list with all corresponding digits added up
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // Write your solution here
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    }
    // Create a linked list to store the result
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    // A flag indicating whether a carry should be taken
    boolean needsCarry = false;
    // The two linked lists move at the same pace
    // So the correct corresponding digits will be added
    while (l1 != null && l2 != null) {
      int value = l1.value + l2.value;
      // If there was a carry, add it to the value
      value = needsCarry ? value + 1 : value;
      // If the value is greater than 10
      // We need to carry it to the next digit
      needsCarry = value >= 10;
      value = needsCarry ? value - 10 : value;
      curr.next = new ListNode(value);
      curr = curr.next;
      l1 = l1.next;
      l2 = l2.next;
    }
    // Post-processing
    // When the two linked lists have different length
    // Continue adding the longer list to the result
    while (l1 != null) {
      int value = needsCarry ? l1.value + 1 : l1.value;
      // Set the carry flag for the next digit
      needsCarry = value >= 10;
      // Update the value
      value = needsCarry ? value - 10 : value;
      // Ready to be added to the result
      curr.next = new ListNode(value);
      curr = curr.next;
      l1 = l1.next;
    }
    while (l2 != null) {
      int value = needsCarry ? l2.value + 1 : l2.value;
      // Set the carry flag for the next digit
      needsCarry = value >= 10;
      // Update the value
      value = needsCarry ? value - 10 : value;
      // Ready to be added to the result
      curr.next = new ListNode(value);
      curr = curr.next;
      l2 = l2.next;
    }
    // Post-processing
    // When the last addition yields a carry
    if (needsCarry) {
      curr.next = new ListNode(1);
    }
    return dummy.next;
  }
}
