package A.BinarySearch.Medium.KClosestInSortedArray;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KClosestInSortedArrayTest {
    private static KClosestInSortedArray instance;

    @BeforeAll
    static void setInstance() {
        instance = new KClosestInSortedArray();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        int[] result = instance.kClosest(null, 1, 1);
        assertArrayEquals(new int[] {}, result);
    }

    @Test
    void testEmpty() {
        int[] result = instance.kClosest(new int[] {}, 1, 1);
        assertArrayEquals(new int[] {}, result);
    }

    @Test
    void testOne() {
        int[] result = instance.kClosest(new int[] {1, 2, 3}, 2, 3);
        assertArrayEquals(new int[] {2, 1, 3}, result);
    }

    @Test
    void testTwo() {
        int[] result = instance.kClosest(new int[] {1, 4, 6, 8}, 3, 3);
        assertArrayEquals(new int[] {4, 1, 6}, result);
    }
}