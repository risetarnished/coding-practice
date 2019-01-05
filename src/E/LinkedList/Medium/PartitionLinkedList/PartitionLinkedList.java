package E.LinkedList.Medium.PartitionLinkedList;

import helper.ListNode.ListNode;

/**
 * https://app.laicode.io/app/problem/42
 * Description
 * Given a linked list and a target value T, partition it such that all nodes less than T are listed before the nodes
 * larger than or equal to target value T. The original relative order of the nodes in each of the two partitions should be preserved.
 *
 * Examples
 *
 * L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null
 */

public class PartitionLinkedList {
    public ListNode partition(ListNode head, int target) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }
        // Traverse the list, put all the nodes that are less than the target to a new list,
        // all the nodes that are equal or larger than the target to another.
        // Link the two lists together
        ListNode smallDummy = new ListNode(0);
        ListNode smallCurr = smallDummy;
        ListNode largeDummy = new ListNode(0);
        ListNode largeCurr = largeDummy;
        ListNode current = head;
        // Compare the node values to the target and move the smaller pointer like what is done in quick sort
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

/**
 * Time complexity:
 * a while-loop traversing every node in the linked list ==> O(n).
 *
 * Space complexity:
 * dummy nodes created, nothing else ==> O(1).
 */
