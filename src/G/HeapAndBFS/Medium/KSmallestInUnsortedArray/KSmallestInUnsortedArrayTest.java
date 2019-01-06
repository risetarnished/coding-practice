package G.HeapAndBFS.Medium.KSmallestInUnsortedArray;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KSmallestInUnsortedArrayTest {
    private static KSmallestInUnsortedArray kSmallestInUnsortedArray;
    private int[] array;
    private int k;

    @BeforeAll
    static void setInstance() {
        kSmallestInUnsortedArray = new KSmallestInUnsortedArray();
    }

    @BeforeEach
    void setUp() {
        array = null;
        k = 0;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        assertEquals(array, kSmallestInUnsortedArray.kSmallest(array, k));
    }

    @Test
    void testEmpty() {
        array = new int[] {};
        assertEquals(array, kSmallestInUnsortedArray.kSmallest(array, k));
    }

    @Test
    void testValidOne() {
        array = new int[] {3, 4, 1, 2, 5};
        k = 3;
        int[] result = kSmallestInUnsortedArray.kSmallest(array, k);
        assertArrayEquals(new int[] {1, 2, 3}, result);
    }

    @Test
    void testValidTwo() {
        array = new int[] {5, 3, 4, 2, 1, 1, 2, 1, 8, 4, 4, 9, 13, 5, 8};
        k = array.length;
        int[] result = kSmallestInUnsortedArray.kSmallest(array, k);
        Arrays.sort(array);
        assertArrayEquals(array, result);
    }
}