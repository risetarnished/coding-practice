package E.LinkedList.Medium.PartitionLinkedList;

import helper.ListNode.ListNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PartitionLinkedListTest {
    private static PartitionLinkedList partitionLinkedList;
    private ListNode head;
    private int target;

    @BeforeAll
    static void setPartitionLinkedList() {
        partitionLinkedList = new PartitionLinkedList();
    }

    @BeforeEach
    void setUp() {
        this.head = null;
        this.target = 0;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        ListNode result = partitionLinkedList.partition(head, target);
        assertEquals(head, result);
    }

    @Test
    void testOneNode() {
        head = new ListNode(0);
        ListNode result = partitionLinkedList.partition(head, target);
        assertEquals(head, result);
    }

    @Test
    void testOne() {
        head = ListNode.buildList(new ArrayList<>(Arrays.asList(2, 4, 3, 5, 1)));
        target = 3;
        ListNode result = partitionLinkedList.partition(head, target);
        ListNode expected = ListNode.buildList(new ArrayList<>(Arrays.asList(2, 1, 4, 3, 5)));
        assertEquals(expected, result);
    }
}
