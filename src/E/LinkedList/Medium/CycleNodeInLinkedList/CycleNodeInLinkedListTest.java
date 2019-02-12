package E.LinkedList.Medium.CycleNodeInLinkedList;

import helper.ListNode.ListNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CycleNodeInLinkedListTest {
    private static CycleNodeInLinkedList cycleNodeInLinkedList;
    private ListNode head;

    @BeforeAll
    static void setInstance() {
        cycleNodeInLinkedList = new CycleNodeInLinkedList();
    }

    @BeforeEach
    void setUp() {
        head = null;
    }

    @Test
    void cycleNode() {
        assertNull(cycleNodeInLinkedList.cycleNode(head));
        head = new ListNode(0);
        assertNull(cycleNodeInLinkedList.cycleNode(head));

        head = ListNode.buildCycleList(new ArrayList<>(Arrays.asList(3, 2, 0, -4)), 1);
        assertEquals(2, cycleNodeInLinkedList.cycleNode(head).value);

        head = ListNode.buildList(new ArrayList<>(Arrays.asList(3, 2, 0, -4)));
        assertNull(cycleNodeInLinkedList.cycleNode(head));
    }
}