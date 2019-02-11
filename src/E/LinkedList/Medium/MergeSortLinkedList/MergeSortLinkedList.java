package E.LinkedList.Medium.MergeSortLinkedList;

import helper.ListNode.ListNode;

/**
 * MergeSortLinkedList
 *
 * @author meng
 * @date 2/11/19
 */
public class MergeSortLinkedList {
    /**
     * Sort a linked list into ascending order using merge sort
     *
     * @param head  The head node of the input linked list
     * @return      The linked list sorted into ascending order
     */
    public ListNode sortList(ListNode head) {
        // Corner cases
        if (head == null || head.next == null) {
            return head;
        }
        // Divide the linked list into two parts evenly
        ListNode mid = findMiddleNode(head);
        ListNode secondPart = mid.next;
        // Cut the first part from the second part
        mid.next = null;
        // Recursively sort the first and second halves
        ListNode sortedFirst = sortList(head);
        ListNode sortedSecond = sortList(secondPart);
        // Merge the two sorted lists
        return mergeLists(sortedFirst, sortedSecond);
    }

    /**
     * Find the middle node of a given linked list
     * If the length of the linked list is even, return the first
     * of the two middle nodes. For example,
     * 1 -> 2 -> 3 -> 4
     * Two middle nodes are 2 and 3
     * In this case, return 2 because even if we need node 3 sometime
     * later, we still have access to it
     *
     * @param head  The head node of the given linked list
     * @return      The middle node of the linked list
     */
    private ListNode findMiddleNode(ListNode head) {
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

    /**
     * Merge two linked lists together into ascending order
     *
     * @param one  The first linked list
     * @param two  The second linked list
     * @return     A linked list of all nodes from one and two sorted in ascending order
     */
    private ListNode mergeLists(ListNode one, ListNode two) {
        // Create a new linked list to store the result
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (one != null && two != null) {
            if (one.value < two.value) {
                curr.next = one;
                one = one.next;
            } else {
                curr.next = two;
                two = two.next;
            }
            curr = curr.next;
        }
        // Post-processing of any left-over elements in either list
        if (one != null) {
            curr.next = one;
        } else if (two != null) {
            curr.next = two;
        }
        return dummy.next;
    }
}
