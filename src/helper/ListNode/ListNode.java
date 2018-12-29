package helper.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
        this.value = value;
        next = null;
    }

    /* Methods for testing */
    // Build a linked list according to an input list of integers
    public static ListNode buildList(List<Integer> nodes) {
        if (nodes == null || nodes.size() == 0) {
            return null;
        }
        ListNode head = new ListNode(nodes.get(0));
        ListNode current = head;
        for (int i = 1; i < nodes.size(); i++) {
            current.next = new ListNode(nodes.get(i));
            current = current.next;
        }
        return head;
    }

    // Output a linked list in the form of a list of integers
    public static List<Integer> listToArray(ListNode head) {
        List<Integer> result = new ArrayList<>();
        if (head == null) {
            return result;
        }
        ListNode current = head;
        while (current != null) {
            result.add(current.value);
            current = current.next;
        }
        return result;
    }
}
