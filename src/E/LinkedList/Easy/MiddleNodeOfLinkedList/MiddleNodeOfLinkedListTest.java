package E.LinkedList.Easy.MiddleNodeOfLinkedList;

import helper.ListNode.ListNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MiddleNodeOfLinkedListTest {
    private static MiddleNodeOfLinkedList middleNodeOfLinkedList;
    private ListNode head;

    @BeforeAll
    private static void setInstance() {
        middleNodeOfLinkedList = new MiddleNodeOfLinkedList();
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
        ListNode result = middleNodeOfLinkedList.middleNode(head);
        assertEquals(null, result);
    }

    @Test
    void testOneNode() {
        head = new ListNode(0);
        ListNode result = middleNodeOfLinkedList.middleNode(head);
        assertEquals(head, result);
    }

    @Test
    void testTwoNodes() {
        head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2)));
        ListNode middle = middleNodeOfLinkedList.middleNode(head);
        assertEquals(head, middle);
    }

    @Test
    void testThreeNodes() {
        head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3)));
        ListNode middle = middleNodeOfLinkedList.middleNode(head);
        assertEquals(head.next, middle);
    }

    @Test
    void test() {
        head = ListNode.buildList(new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1, 0)));
        ListNode middle = middleNodeOfLinkedList.middleNode(head);
        // Expected output ==> node3
        assertEquals(head.next.next, middle);
    }
}