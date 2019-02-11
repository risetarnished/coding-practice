package B.BinarySearch.Medium.FindMinimumInRotatedSortedArray;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMinimumInRotatedSortedArrayTest {
    private static FindMinimumInRotatedSortedArray instance;
    private int[] nums;

    @BeforeAll
    static void setInstance() {
        instance = new FindMinimumInRotatedSortedArray();
    }

    @BeforeEach
    void setUp() {
        nums = null;
    }

    @Test
    void findMin() {
        assertEquals(-1, instance.findMin(nums));

        nums = new int[] {};
        assertEquals(-1, instance.findMin(nums));

        nums = new int[] {0};
        assertEquals(0, instance.findMin(nums));

        nums = new int[] {1, 2, 3, 4, 5};
        assertEquals(1, instance.findMin(nums));

        nums = new int[] {2, 3, 4, 5, 1};
        assertEquals(1, instance.findMin(nums));

        nums = new int[] {3, 4, 5, 1, 2};
        assertEquals(1, instance.findMin(nums));

        nums = new int[] {5, 1, 2, 3, 4};
        assertEquals(1, instance.findMin(nums));
    }
}