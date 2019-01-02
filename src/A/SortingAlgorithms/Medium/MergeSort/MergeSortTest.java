package A.SortingAlgorithms.Medium.MergeSort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    private static MergeSort mergeSort;
    private int[] array;
    private List<Integer> list;

    @BeforeAll
    static void setInstance() {
        mergeSort = new MergeSort();
    }

    @BeforeEach
    void setUp() {
        array = null;
        list = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        int[] arrayResult = mergeSort.mergeSort(array);
        assertArrayEquals(array, arrayResult);
        List<Integer> listResult = mergeSort.mergeSort(list);
        assertEquals(new ArrayList<>(), listResult);
    }

    @Test
    void testEmpty() {
        array = new int[] {};
        int[] arrayResult = mergeSort.mergeSort(array);
        assertArrayEquals(array, arrayResult);
        list = new ArrayList<>();
        List<Integer> listResult = mergeSort.mergeSort(list);
        assertEquals(new ArrayList<>(), listResult);
    }

    @Test
    void testOne() {
        array = new int[] {1};
        int[] arrayResult = mergeSort.mergeSort(array);
        assertArrayEquals(new int[] {1}, arrayResult);
        list = new ArrayList<>(Collections.singletonList(1));
        List<Integer> listResult = mergeSort.mergeSort(list);
        assertEquals(new ArrayList<>(Collections.singletonList(1)), listResult);
    }

    @Test
    void testTwo() {
        array = new int[] {1, 2, 3};
        int[] arrayResult = mergeSort.mergeSort(array);
        assertArrayEquals(new int[] {1, 2, 3}, arrayResult);
        list = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        List<Integer> listResult = mergeSort.mergeSort(list);
        assertEquals(new ArrayList<>(Arrays.asList(1, 2, 3)), listResult);
    }

    @Test
    void testThree() {
        array = new int[] {3, 2, 1};
        int[] arrayResult = mergeSort.mergeSort(array);
        assertArrayEquals(new int[] {1, 2, 3}, arrayResult);
        list = new ArrayList<>(Arrays.asList(3, 2, 1));
        List<Integer> listResult = mergeSort.mergeSort(list);
        assertEquals(new ArrayList<>(Arrays.asList(1, 2, 3)), listResult);
    }

    @Test
    void testFour() {
        array = new int[] {4, 2, -3, 6, 1};
        int[] arrayResult = mergeSort.mergeSort(array);
        assertArrayEquals(new int[] {-3, 1, 2, 4, 6}, arrayResult);
        list = new ArrayList<>(Arrays.asList(4, 2, -3, 6, 1));
        List<Integer> listResult = mergeSort.mergeSort(list);
        assertEquals(new ArrayList<>(Arrays.asList(-3, 1, 2, 4, 6)), listResult);
    }
}