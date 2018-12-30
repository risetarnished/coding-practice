package E.LinkedList.Easy.CheckIfLinkedListHasACycyle;

import helper.ListNode.ListNode;

/**
 * https://app.laicode.io/app/problem/37
 * Description
 * Check if a given linked list has a cycle. Return true if it does, otherwise return false.
 */

public class CheckIfLinkedListHasACycyle {
    public boolean hasCycle(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}

/**
 * Time complexity: n nodes in the linked list and we need to check every one of them ==> O(n)
 * Space complexity: two nodes are created ==> O(1).
 */
