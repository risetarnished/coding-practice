package coollime.linkedlist.checkiflinkedlistispalindrome;

import coollime.common.objects.ListNode;

public class Solution {

  /**
   * Check whether a linked list is a palindrome
   *
   * @param head The head node of the input linked list
   * @return Whether the linked list is a palindrome
   */
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    ListNode mid = findMiddleNode(head);
    ListNode reversedSecond = reverse(mid);
    ListNode first = head;
    ListNode second = reversedSecond;
    while (first != null && second != null) {
      if (first.value != second.value) {
        // Restore the original linked list before returning
        reverse(reversedSecond);
        return false;
      }
      first = first.next;
      second = second.next;
    }
    // Restore the original linked list
    reverse(reversedSecond);
    return true;
  }

  /**
   * Find the middle node of a linked list
   *
   * @param head The head node of the linked list
   * @return The middle node of the linked list In the case where there are two
   *         middle nodes in the list (when there are even number of nodes),
   *         return the first one
   */
  private ListNode findMiddleNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  /**
   * Reverse a singly-linked list
   *
   * @param head The head node of the linked list
   * @return The new linked list that is a reversed version of the input linked
   *         list
   */
  private ListNode reverse(ListNode head) {
    if (head == null) {
      return null;
    } else if (head.next == null) {
      return new ListNode(head.value);
    }
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
}
