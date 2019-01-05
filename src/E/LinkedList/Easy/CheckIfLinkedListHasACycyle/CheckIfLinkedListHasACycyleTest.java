package E.LinkedList.Easy.CheckIfLinkedListHasACycyle;

import helper.ListNode.ListNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfLinkedListHasACycyleTest {
    private static CheckIfLinkedListHasACycyle instance;
    private ListNode head;

    @BeforeAll
    static void setInstance() {
        instance = new CheckIfLinkedListHasACycyle();
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
        assertFalse(instance.hasCycle(head));
    }

    @Test
    void testOneNode() {
        head = new ListNode(0);
        assertFalse(instance.hasCycle(head));
    }

    @Test
    void test() {
        // Build a linked list with a cycle: 1 -> 2 -> 3 -> 4 -> 5 ---> 2
        head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = two;
        assertTrue(instance.hasCycle(head));
    }
}
