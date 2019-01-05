package E.LinkedList.Easy.MiddleNodeOfLinkedList;

import helper.ListNode.ListNode;

/**
 * https://app.laicode.io/app/problem/36
 * Description
 * Find the middle node of a given linked list.
 *
 * Examples
 *
 * L = null, return null
 * L = 1 -> null, return 1
 * L = 1 -> 2 -> null, return 1
 * L = 1 -> 2 -> 3 -> null, return 2
 * L = 1 -> 2 -> 3 -> 4 -> null, return 2
 */

public class MiddleNodeOfLinkedList {
    public ListNode middleNode(ListNode head) {
        // Write your solution here
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
}
