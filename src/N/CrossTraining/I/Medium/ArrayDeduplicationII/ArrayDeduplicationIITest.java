package N.CrossTraining.I.Medium.ArrayDeduplicationII;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayDeduplicationIITest {
    private static ArrayDeduplicationII arrayDedup;
    private int[] array;

    @BeforeAll
    static void setInstance() {
        arrayDedup = new ArrayDeduplicationII();
    }

    @BeforeEach
    void setUp() {
        array = null;
    }

    @Test
    void testNullAndEmpty() {
        assertArrayEquals(array, arrayDedup.dedup(array));

        array = new int[] {};
        assertArrayEquals(array, arrayDedup.dedup(array));
    }

    @Test
    void testExamples() {
        array = new int[] {1, 2, 2, 3, 3, 3};
        assertArrayEquals(new int[] {1, 2, 2, 3, 3}, arrayDedup.dedup(array));

        array = new int[] {1, 1, 2, 3, 3, 3, 4, 5, 5, 5};
        assertArrayEquals(new int[] {1, 1, 2, 3, 3, 4, 5, 5}, arrayDedup.dedup(array));

        array = new int[] {1, 1, 1};
        assertArrayEquals(new int[] {1, 1}, arrayDedup.dedup(array));
    }
}