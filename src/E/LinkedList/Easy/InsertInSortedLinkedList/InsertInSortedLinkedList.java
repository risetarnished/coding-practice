package E.LinkedList.Easy.InsertInSortedLinkedList;

import helper.ListNode.ListNode;

/**
 * https://app.laicode.io/app/problem/39
 * Description
 * Insert a value in a sorted linked list.
 *
 * Examples
 *
 * L = null, insert 1, return 1 -> null
 * L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
 * L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
 * L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null
 */

public class InsertInSortedLinkedList {
    public ListNode insert(ListNode head, int value) {
        // Write your solution here
        ListNode newNode = new ListNode(value);
        // Case 1: insert before head
        if (head == null || head.value > value) {
            newNode.next = head;
            return newNode;
        }
        // Case 2: insert in the middle/tail
        ListNode current = head;
        // Skip all the nodes whose values are less than (NOT equal to) value
        while (current.next != null && current.next.value < value) {
            current = current.next;
        }
        // Two situations now:
        // 1. current.value < value <= current.next.value
        // 2. current is tail
        // In either case, insert the new node after current
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }
}

/**
 * Time complexity:
 * Traversing the entire linked list ==> O(n).
 *
 * Space complexity:
 * Constant space: O(1).
 */
