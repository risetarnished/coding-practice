package E.LinkedList.Easy.ReverseLinkedList;

import helper.ListNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {
    static ReverseLinkedList reverseLinkedList;
    ListNode head;

    @BeforeAll
    static void setInstance() {
        reverseLinkedList = new ReverseLinkedList();
    }

    @BeforeEach
    void setUp() {
        head = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        ListNode result = reverseLinkedList.reverse(head);
        assertEquals(null, result);
    }

    @Test
    void testOneNode() {
        head = new ListNode(0);
        ListNode result = reverseLinkedList.reverse(head);
        assertEquals(head, result);
    }

    @Test
    void test() {
        List<Integer> nodes = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        head = buildList(nodes);
        ListNode reversed = reverseLinkedList.reverse(head);
        List<Integer> result = listToArray(reversed);
        assertEquals(new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1)), result);
    }

    private ListNode buildList(List<Integer> nodes) {
        if (nodes == null || nodes.size() == 0) {
            return null;
        }
        head = new ListNode(nodes.get(0));
        ListNode current = head;
        for (int i = 1; i < nodes.size(); i++) {
            current.next = new ListNode(nodes.get(i));
            current = current.next;
        }
        return head;
    }

    private List<Integer> listToArray(ListNode head) {
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
