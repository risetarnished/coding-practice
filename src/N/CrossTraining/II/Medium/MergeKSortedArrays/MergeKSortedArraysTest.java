package N.CrossTraining.II.Medium.MergeKSortedArrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeKSortedArraysTest {
    private static MergeKSortedArrays kWayMerge;
    private int[][] arrayOfArrays;

    @BeforeAll
    static void setInstance() {
        kWayMerge = new MergeKSortedArrays();
    }

    @BeforeEach
    void setUp() {
        arrayOfArrays = null;
    }

    @Test
    void merge() {
        assertArrayEquals(new int[] {}, kWayMerge.merge(arrayOfArrays));

        arrayOfArrays = new int[][] {};
        assertArrayEquals(new int[] {}, kWayMerge.merge(arrayOfArrays));

        arrayOfArrays = new int[][] {
                {4, 5, 8, 12},
                {2},
                {7, 9, 10, 11, 13, 19},
                {1, 3, 5},
                {6},
                {0, 11, 15, 18}
        };
        assertArrayEquals(
                new int[] {0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10, 11, 11, 12, 13, 15, 18, 19},
                kWayMerge.merge(arrayOfArrays)
        );
    }
}