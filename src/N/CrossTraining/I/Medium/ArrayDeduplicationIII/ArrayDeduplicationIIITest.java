package N.CrossTraining.I.Medium.ArrayDeduplicationIII;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayDeduplicationIIITest {
    private static ArrayDeduplicationIII arrayDedup;
    private int[] array;

    @BeforeAll
    static void setInstance() {
        arrayDedup = new ArrayDeduplicationIII();
    }

    @BeforeEach
    void setUp() {
        array = null;
    }

    @AfterEach
    void tearDown() {
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
        assertArrayEquals(new int[] {1}, arrayDedup.dedup(array));

        array = new int[] {1, 1, 2, 3, 3, 4, 5, 5, 5};
        assertArrayEquals(new int[] {2, 4}, arrayDedup.dedup(array));
    }
}