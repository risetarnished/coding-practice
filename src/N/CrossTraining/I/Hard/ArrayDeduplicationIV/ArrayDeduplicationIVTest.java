package N.CrossTraining.I.Hard.ArrayDeduplicationIV;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayDeduplicationIVTest {
    private static ArrayDeduplicationIV arrayDedup;
    private int[] array;

    @BeforeAll
    static void setInstance() {
        arrayDedup = new ArrayDeduplicationIV();
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
    void dedup() {
        array = new int[] {1, 2, 3, 3, 3, 2, 2};
        assertArrayEquals(new int[] {1}, arrayDedup.dedup(array));

        array = new int[] {1, 2, 3, 3, 3, 2, 2, 1};
        assertArrayEquals(new int[] {}, arrayDedup.dedup(array));
    }
}