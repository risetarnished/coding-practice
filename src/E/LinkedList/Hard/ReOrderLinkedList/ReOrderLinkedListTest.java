package E.LinkedList.Hard.ReOrderLinkedList;

import helper.ListNode.ListNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ReOrderLinkedListTest {
    private static ReOrderLinkedList reOrderLinkedList;
    private ListNode head;

    @BeforeAll
    private static void setReOrderLinkedList() {
        reOrderLinkedList = new ReOrderLinkedList();
    }

    @BeforeEach
    void setUp() {
        head = null;
    }

    @AfterEach
    void tearDown() {
    }

    // When the linked list is null
    @Test
    void testNull() {
        ListNode result = reOrderLinkedList.reorder(head);
        assertEquals(head, result);
    }

    // When the linked list has only one node
    @Test
    void testOneNode() {
        head = new ListNode(0);
        ListNode result = reOrderLinkedList.reorder(head);
        assertEquals(head, result);
    }

    // 1 -> 2 -> 3 -> 4 -> null => 1 -> 4 -> 2 -> 3 -> null
    @Test
    void testOne() {
        head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        ListNode result = reOrderLinkedList.reorder(head);
        ListNode expected = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 4, 2, 3)));
        assertEquals(expected, result);
    }

    // 1 -> 2 -> 3 -> null => 1 -> 3 -> 2 -> null
    @Test
    void testTwo() {
        head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3)));
        ListNode result = reOrderLinkedList.reorder(head);
        ListNode expected = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 3, 2)));
        assertEquals(expected, result);
    }

    // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> null =>
    // 1 -> 10 -> 2 -> 9 -> 3 -> 8 -> 4 -> 7 -> 5 -> 6 -> null
    @Test
    void testThree() {
        head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        ListNode result = reOrderLinkedList.reorder(head);
        ListNode expected = ListNode.buildList(new ArrayList<>(Arrays.asList(
                1, 10, 2, 9, 3, 8, 4, 7, 5, 6
        )));
        assertEquals(expected, result);
    }

}
