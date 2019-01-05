package B.BinarySearch.Medium.SearchInUnknownSizedSortedArray;

import A.SortingAlgorithms.Easy.SelectionSort.SelectionSort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SearchInUnknownSizedSortedArrayTest {
    static SearchInUnknownSizedSortedArray instance;

    @BeforeEach
    void setUp() {
        instance = new SearchInUnknownSizedSortedArray();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        int result = instance.search(null, 0);
        assertEquals(-1, result);
    }

    @Test
    void testEmpty() {
        int result = instance.search(new Dictionary(new ArrayList<Integer>(0)), 0);
        assertEquals(-1, result);
    }

    @Test
    // When the target is in the array
    void testPresent() {
        int result = instance.search(new Dictionary(new ArrayList<Integer>(Arrays.asList(1, 2, 5, 9, 11, 12, 15))), 5);
        assertEquals(2, result);
    }

    @Test
    // When the target is not in the array
    void testAbsent() {
        int result = instance.search(new Dictionary(new ArrayList<Integer>(Arrays.asList(1, 2, 5, 9, 12, 15))), 7);
        assertEquals(-1, result);
    }

    @Test
    // When the target is not in the array and outside the range (larger than the last element)
    void testOutside() {
        int result = instance.search(new Dictionary(new ArrayList<Integer>(Arrays.asList(1, 2, 5, 9, 12, 15))), 17);
        assertEquals(-1, result);
    }
}