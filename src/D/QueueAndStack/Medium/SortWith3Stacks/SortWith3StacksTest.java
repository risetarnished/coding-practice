package D.QueueAndStack.Medium.SortWith3Stacks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SortWith3StacksTest {
    static SortWith3Stacks sortWith3Stacks;
    LinkedList<Integer> s1;

    @BeforeAll
    static void setInstance() {
        sortWith3Stacks = new SortWith3Stacks();
    }

    @BeforeEach
    void setUp() {
        s1 = new LinkedList<>(Arrays.asList(4, 2, -3, 6, 1));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        s1 = null;
        sortWith3Stacks.sort(s1);
        assertNull(s1);
    }

    @Test
    void testEmpty() {
        s1 = new LinkedList<>();
        sortWith3Stacks.sort(s1);
        assertEquals(new LinkedList<>(), s1);
    }

    @Test
    void test() {
        sortWith3Stacks.sort(s1);
        int[] result = exportElements(s1);
        assertArrayEquals(new int[] {-3, 1, 2, 4, 6}, result);
    }

    private int[] exportElements(LinkedList<Integer> stack) {
        if (stack == null) {
            return null;
        } else if (stack.isEmpty()) {
            return new int[] {};
        }
        int size = stack.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = stack.pollFirst();
        }
        return result;
    }
}