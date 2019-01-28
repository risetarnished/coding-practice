package N.CrossTraining.II.Medium.DeepCopyLinkedListWithRandomPointer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeepCopyLinkedListWithRandomPointerTest {
    private static DeepCopyLinkedListWithRandomPointer deepCopy;
    private RandomListNode head;

    @BeforeAll
    static void setInstance() {
        deepCopy = new DeepCopyLinkedListWithRandomPointer();
    }

    @BeforeEach
    void setUp() {
        head = null;
    }

    @Test
    void copy() {
        assertNull(deepCopy.copy(head));

        head = new RandomListNode(0);
        assertEquals(new RandomListNode(0), deepCopy.copy(head));

        head = buildListForTest();
        RandomListNode expected = buildListForTest();
        RandomListNode result = deepCopy.copy(head);
        assertEquals(expected, result);
    }

    private RandomListNode buildListForTest() {
        RandomListNode zero = new RandomListNode(0);
        RandomListNode one = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        RandomListNode three = new RandomListNode(3);
        RandomListNode four = new RandomListNode(4);

        zero.next = one;
        zero.random = three;
        one.next = two;
        two.next = three;
        three.next = four;

        four.random = one;

        return zero;
    }
}