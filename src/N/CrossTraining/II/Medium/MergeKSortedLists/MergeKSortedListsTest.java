package N.CrossTraining.II.Medium.MergeKSortedLists;

import helper.ListNode.ListNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeKSortedListsTest {
    private static MergeKSortedLists kWayMerge;
    private List<ListNode> listOfLists;

    @BeforeAll
    static void setInstance() {
        kWayMerge = new MergeKSortedLists();
    }

    @BeforeEach
    void setUp() {
        listOfLists = null;
    }

    @Test
    void merge() {
        assertNull(kWayMerge.merge(listOfLists));

        listOfLists = new ArrayList<>();
        assertNull(kWayMerge.merge(listOfLists));

        // Build a test list of linked lists
        ListNode one = ListNode.buildList(new ArrayList<>(Arrays.asList(4, 5, 8, 12)));
        ListNode two = new ListNode(2);
        ListNode three = ListNode.buildList(new ArrayList<>(Arrays.asList(7, 9, 10, 11, 13, 19)));
        ListNode four = ListNode.buildList(new ArrayList<>(Arrays.asList(1, 3, 5)));
        ListNode five = new ListNode(6);
        ListNode six = ListNode.buildList(new ArrayList<>(Arrays.asList(0, 11, 15, 18)));
        listOfLists = new ArrayList<>(Arrays.asList(one, two, three, four, five, six));
        ListNode expected = ListNode.buildList(
                new ArrayList<>(Arrays.asList(
                        0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10, 11, 11, 12, 13, 15, 18, 19
                ))
        );
        assertEquals(expected, kWayMerge.merge(listOfLists));
    }
}