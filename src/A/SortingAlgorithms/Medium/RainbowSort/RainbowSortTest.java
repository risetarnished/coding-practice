package A.SortingAlgorithms.Medium.RainbowSort;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RainbowSortTest {
    private static RainbowSort instance;
    private int[] array;

    @BeforeAll
    static void setInstance() {
        instance = new RainbowSort();
    }

    @BeforeEach
    void setUp() {
        array = null;
    }

    @Test
    void rainbowSort() {
        assertArrayEquals(array, instance.rainbowSort(array));
        array = new int[] {1};
        assertArrayEquals(array, instance.rainbowSort(array));

        array = new int[] {1, 0};
        assertArrayEquals(new int[] {0, 1}, instance.rainbowSort(array));

        array = new int[] {1, 0, 1, -1, 0};
        assertArrayEquals(new int[] {-1, 0, 0, 1, 1}, instance.rainbowSort(array));

        array = new int[] {1, 1, 0, -1, 0, 1, -1};
        assertArrayEquals(new int[] {-1, -1, 0, 0, 1, 1, 1}, instance.rainbowSort(array));
    }
}