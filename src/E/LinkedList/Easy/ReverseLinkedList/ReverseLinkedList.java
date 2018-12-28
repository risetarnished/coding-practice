package E.LinkedList.Easy.ReverseLinkedList;

import helper.ListNode;

/**
 * https://app.laicode.io/app/problem/34
 * Description
 * Reverse a singly-linked list.
 *
 * Examples
 *
 * L = null, return null
 * L = 1 -> null, return 1 -> null
 * L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
 */

public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        // Write your solution here
        /* Method 1: iteration */
        /*
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
        */

        /* Method 2: recursion */
        // Base case: when we reach the last node in the original order
        if (head == null || head.next == null) {
            // The real case happens only when head.next == null
            return head;
        }
        ListNode current = head;
        ListNode next = current.next;
        ListNode newHead = reverse(next);
        // Link the nodes in the reversed order: null <-- current <-- next <-- ... <-- newHead
        // We also need to cut the link between current and its previous node
        next.next = current;
        current.next = null;
        return newHead;
    }
}

/**
 * Iteration
 * Time complexity:
 * n nodes to check and reverse --> O(n)
 *
 * Space complexity:
 * constant space --> O(1)
 *
 * Recursion
 * Time complexity:
 * There are n nodes --> there are n levels in the recursion tree --> O(n)
 *
 * Space complexity:
 * O(n)
 */
