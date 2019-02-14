package D.QueueAndStack.Medium.SortWith2Stacks;

import helper.ListNode.ListNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SortWith2StacksTest {
    private static SortWith2Stacks sortWith2Stacks;
    private LinkedList<Integer> s1;

    @BeforeAll
    static void setInstance() {
        sortWith2Stacks = new SortWith2Stacks();
    }

    @BeforeEach
    void setUp() {
        s1 = null;
    }

    @Test
    void sort() {
        sortWith2Stacks.sort(s1);
        assertNull(s1);

        s1 = new LinkedList<>();
        sortWith2Stacks.sort(s1);
        assertEquals(new LinkedList<>(), s1);

        s1.clear();
        s1.addAll(Arrays.asList(3, 2, 4, 1, 5));
        sortWith2Stacks.sort(s1);
        assertEquals(new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5)), s1);

        s1.clear();
        s1.addAll(Arrays.asList(4, 2, 1, 1, 3, 2));
        sortWith2Stacks.sort(s1);
        assertEquals(new LinkedList<>(Arrays.asList(1, 1, 2, 2, 3, 4)), s1);
    }
}