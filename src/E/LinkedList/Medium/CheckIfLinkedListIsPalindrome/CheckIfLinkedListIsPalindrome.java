package E.LinkedList.Medium.CheckIfLinkedListIsPalindrome;

import helper.ListNode.ListNode;

/**
 * CheckIfLinkedListIsPalindrome
 *
 * @author meng
 * @date 2/11/19
 */
public class CheckIfLinkedListIsPalindrome {
    /**
     * Check whether a linked list is a palindrome
     *
     * @param head  The head node of the input linked list
     * @return      Whether the linked list is a palindrome
     */
    public boolean isPalindrome(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return true;
        }
        // Reverse the list
        ListNode reversed = reverse(head);
        // Compare the two lists
        // head -> tail vs tail -> head in its original position
        while (head != null && reversed != null) {
            if (head.value != reversed.value) {
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }

    /**
     * Reverse a singly-linked list
     *
     * @param head  The head node of the linked list
     * @return      The new linked list that is a reversed version of the input linked list
     */
    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new ListNode(head.value);
        }
        ListNode reversed = null;
        ListNode prev = null;
        while (head != null) {
            // Make a copy of the original node
            reversed = new ListNode(head.value);
            reversed.next = prev;
            prev = reversed;
            head = head.next;
        }
        return reversed;
    }
}
