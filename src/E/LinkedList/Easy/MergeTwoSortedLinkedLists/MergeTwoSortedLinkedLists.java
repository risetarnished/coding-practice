package E.LinkedList.Easy.MergeTwoSortedLinkedLists;

import helper.ListNode.ListNode;

/**
 * https://app.laicode.io/app/problem/40
 * Description
 * Merge two sorted lists into one large sorted list.
 *
 * Examples
 *
 * L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
 * L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
 * L1 = null, L2 = null, merge L1 and L2 to null
 */

public class MergeTwoSortedLinkedLists {
    public ListNode merge(ListNode one, ListNode two) {
        // Write your solution here
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

/**
 * Time complexity: check every single node in both lists ==> O(2n) ==> O(n).
 * Space complexity: dummy nodes created ==> O(1).
 */
