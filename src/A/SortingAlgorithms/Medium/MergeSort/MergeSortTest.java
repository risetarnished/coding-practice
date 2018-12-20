package A.SortingAlgorithms.Medium.MergeSort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    static MergeSort mergeSort;

    @BeforeEach
    void setUp() {
        mergeSort = new MergeSort();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        int[] result = mergeSort.mergeSort(null);
        assertArrayEquals(null, result);
    }

    @Test
    void testEmpty() {
        int[] result = mergeSort.mergeSort(new int[] {});
        assertArrayEquals(new int[] {}, result);
    }

    @Test
    void testOne() {
        int[] result = mergeSort.mergeSort(new int[] {1});
        assertArrayEquals(new int[] {1}, result);
    }

    @Test
    void testTwo() {
        int[] result = mergeSort.mergeSort(new int[] {1, 2, 3});
        assertArrayEquals(new int[] {1, 2, 3}, result);
    }

    @Test
    void testThree() {
        int[] result = mergeSort.mergeSort(new int[] {3, 2, 1});
        assertArrayEquals(new int[] {1, 2, 3}, result);
    }

    @Test
    void testFour() {
        int[] result = mergeSort.mergeSort(new int[] {4, 2, -3, 6, 1});
        assertArrayEquals(new int[] {-3, 1, 2, 4, 6}, result);
    }
}