package N.CrossTraining.I.Easy.ArrayDeduplicationI;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayDeduplicationITest {
    private static ArrayDeduplicationI arrayDedup;
    private int[] array;

    @BeforeAll
    static void setInstance() {
        arrayDedup = new ArrayDeduplicationI();
    }

    @BeforeEach
    void setUp() {
        array = null;
    }

    @Test
    void testNullAndEmpty() {
        assertEquals(array, arrayDedup.dedup(array));

        array = new int[] {};
        assertEquals(array, arrayDedup.dedup(array));
    }

    @Test
    void testExamples() {
        array = new int[] {1, 2, 2, 3, 3, 3};
        assertArrayEquals(new int[] {1, 2, 3}, arrayDedup.dedup(array));

        array = new int[] {1, 1, 1};
        assertArrayEquals(new int[] {1}, arrayDedup.dedup(array));
    }
}