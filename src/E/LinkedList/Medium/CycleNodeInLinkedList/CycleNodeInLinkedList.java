package E.LinkedList.Medium.CycleNodeInLinkedList;

import helper.ListNode.ListNode;

/**
 * CycleNodeInLinkedList
 *
 * @author meng
 * @date 2/12/19
 */
public class CycleNodeInLinkedList {
    /**
     * Find the start of the cycle in a linked list
     *
     * @param head  The head of the given linked list
     * @return      The starting node of the cycle in the list
     */
    public ListNode cycleNode(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return null;
        }
        // Step 1: determine if there is a cycle in the linked list
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        // Proceed only if there is a cycle
        if (!hasCycle) {
            return null;
        }
        // Step 2: look for the starting node of the cycle
        // distance(head, start) == distance(meet, start)
        // So, let slow moves one step at a time from the head
        //     let fast moves one step at a time from the meeting point
        // They will meet at the starting point of the cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
