package E.LinkedList.Hard.ReOrderLinkedList;

import helper.ListNode.ListNode;

/**
 * https://app.laicode.io/app/problem/41
 * Description
 * Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null
 *
 * Examples
 *
 * L = null, is reordered to null
 * L = 1 -> null, is reordered to 1 -> null
 * L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
 * L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null
 */

public class ReOrderLinkedList {
    public ListNode reorder(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }
        /* Step 1: Find the middle node of the list */
        // We can safely assign middle.next to be the head of the 2nd half
        // and separate the two parts apart
        // This way, we have firstHalf.size() >= secondHalf.size()
        // 1st: head → … → middle → null
        // 2nd: middle.next → … → tail → null
        ListNode firstHalf = head;
        ListNode middle = findMiddleNode(head);
        // Assign middle.next to be the head of the second part
        ListNode secondHalf = middle.next;
        // Cut the link after middle
        middle.next = null;
        /* Step 2: Reverse the second part */
        // Reversed second part: tail → ... → middle.next → null
        ListNode reversedSecondHalf = reverseList(secondHalf);
        /* Step 3: Merge the two linked list into one */
        ListNode reordered = mergeLists(firstHalf, reversedSecondHalf);
        return reordered;
    }

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

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode mergeLists(ListNode one, ListNode two) {
        if (one == null) {
            return two;
        } else if (two == null) {
            return one;
        }
        ListNode head = new ListNode(0);
        ListNode current = head;
        ListNode oneCurr = one;
        ListNode twoCurr = two;
        while (oneCurr != null && twoCurr != null) {
            // Connect a node from the first half
            current.next = oneCurr;
            oneCurr = oneCurr.next;
            current = current.next;
            // Connect a node from the second half
            current.next = twoCurr;
            twoCurr = twoCurr.next;
            current = current.next;
        }
        // There could be left-over elements in the first half, but not in the second half because we assigned middle.next
        // to be the head of the second half (# of nodes in the second half <= # of nodes in the first half || line #27)
        if (oneCurr != null) {
            current.next = oneCurr;
        } else if (twoCurr != null) { // Redundant code, but left here for clarification
            current.next = twoCurr;
        }
        return head.next;
    }
}

/**
 * Time complexity:
 * Find the middle node ==> O(n)
 * Reverse the second half ==> O(n)
 * Merge the two halves ==> O(n)
 * ==> O(n)
 *
 * Space complexity:
 * Find the middle node ==> O(1)
 * Reverse the second half ==> O(1) if iteration || O(n) if recursion
 * Merge the two halves ==> O(1)
 * ==> O(1) or O(n)
 */
