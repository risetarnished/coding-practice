package E.LinkedList.Medium.MergeSortLinkedList;

import helper.ListNode.ListNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortLinkedListTest {
    private static MergeSortLinkedList mergeSortLinkedList;
    private ListNode head;

    @BeforeAll
    static void setInstance() {
        mergeSortLinkedList = new MergeSortLinkedList();
    }

    @BeforeEach
    void setUp() {
        head = null;
    }

    @Test
    void sortList() {
        assertEquals(head, mergeSortLinkedList.sortList(head));
        head = new ListNode(1);
        assertEquals(head, mergeSortLinkedList.sortList(head));

        head = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3)));
        assertEquals(
                ListNode.buildList(new ArrayList<>(Arrays.asList(1, 2, 3))),
                mergeSortLinkedList.sortList(head)
        );

        head = ListNode.buildList(new ArrayList<>(Arrays.asList(4, 2, 6, -3, 5)));
        assertEquals(
                ListNode.buildList(new ArrayList<>(Arrays.asList(-3, 2, 4, 5, 6))),
                mergeSortLinkedList.sortList(head)
        );
    }
}