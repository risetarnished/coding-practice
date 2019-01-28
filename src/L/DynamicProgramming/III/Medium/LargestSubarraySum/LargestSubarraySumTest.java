package L.DynamicProgramming.III.Medium.LargestSubarraySum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestSubarraySumTest {
    private static LargestSubarraySum largestSubarraySum;
    private int[] array;

    @BeforeAll
    static void setInstance() {
        largestSubarraySum = new LargestSubarraySum();
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
        assertEquals(new int[] {}, largestSubarraySum.largestSum(array));

        array = new int[] {};
        assertEquals(new int[] {}, largestSubarraySum.largestSum(array));
    }

    @Test
    void testExample() {
        array = new int[] {2, -1, 4, -2, 1};
        assertArrayEquals(new int[] {5, 0, 2}, largestSubarraySum.largestSum(array));

        array = new int[] {-2, -1, -3};
        assertArrayEquals(new int[] {-1, 1, 1}, largestSubarraySum.largestSum(array));
    }
}