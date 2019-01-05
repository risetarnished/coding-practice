package E.LinkedList.Easy.MergeTwoSortedLinkedLists;

import helper.ListNode.ListNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedLinkedListsTest {
    private static MergeTwoSortedLinkedLists instance;
    private ListNode one, two;

    @BeforeAll
    static void setInstance() {
        instance = new MergeTwoSortedLinkedLists();
    }

    @BeforeEach
    void setUp() {
        one = null;
        two = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testOneNull() {
        two = new ListNode(1);
        ListNode result = instance.merge(one, two);
        assertEquals(new ListNode(1), result);
    }

    @Test
    void testTwoNull() {
        one = new ListNode(0);
        ListNode result = instance.merge(one, two);
        assertEquals(new ListNode(0), result);
    }

    @Test
    void testBothNull() {
        ListNode result = instance.merge(one, two);
        assertEquals(null, result);
    }

    @Test
    void testOne() {
        one = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 4, 6)));
        two = ListNode.buildList(new ArrayList<>(Arrays.asList(2, 5)));
        ListNode result = instance.merge(one, two);
        ListNode expected = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 4, 5, 6)));
        assertEquals(expected, result);
    }

    @Test
    void testTwo() {
        one = ListNode.buildList(new ArrayList<>(Arrays.asList(0, 5, 5, 5, 8, 10)));
        two = ListNode.buildList(new ArrayList<>(Arrays.asList(2, 3, 4, 4, 5, 7)));
        ListNode result = instance.merge(one, two);
        ListNode expected = ListNode.buildList(new ArrayList<>(Arrays.asList(0, 2, 3, 4, 4, 5, 5, 5, 5, 7, 8, 10)));
        assertEquals(expected, result);
    }
}
