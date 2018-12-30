package E.LinkedList.Easy.InsertInSortedLinkedList;

import helper.ListNode.ListNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InsertInSortedLinkedListTest {
    private static InsertInSortedLinkedList instance;
    private ListNode head;
    private int value;

    @BeforeAll
    static void setInstance() {
        instance = new InsertInSortedLinkedList();
    }

    @BeforeEach
    void setUp() {
        head = null;
    }

    @AfterEach
    void tearDown() {
    }

    // The following two tests are testing case 1: insert before head
    @Test
    void testNull() {
        value = 0;
        ListNode result = instance.insert(head, value);
        assertEquals(new ListNode(value), result);
    }

    @Test
    void testOneNode() {
        head = new ListNode(0);
        value = 1;
        ListNode result = instance.insert(head, value);
        ListNode expected = ListNode.buildList(new ArrayList<>(Arrays.asList(0, 1)));
        assertEquals(expected, result);
    }

    // Test for inserting in the middle of the list
    @Test
    void testMiddle() {
        head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        value = 4;
        ListNode result = instance.insert(head, value);
        ListNode expected = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 4, 5, 6)));
        assertEquals(expected, result);
    }

    // Test for inserting after tail
    @Test
    void testTail() {
        head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        value = 7;
        ListNode result = instance.insert(head, value);
        ListNode expected = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
        assertEquals(expected, result);
    }
}
