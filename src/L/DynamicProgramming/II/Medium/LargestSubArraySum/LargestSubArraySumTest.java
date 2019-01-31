package L.DynamicProgramming.II.Medium.LargestSubArraySum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestSubArraySumTest {
    private static LargestSubArraySum largestSubArraySum;
    private int[] array;

    @BeforeAll
    static void setInstance() {
        largestSubArraySum = new LargestSubArraySum();
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
        assertEquals(0, largestSubArraySum.largestSum(array));
        assertEquals(0, largestSubArraySum.largestSumOptimized(array));
        array = new int[] {};
        assertEquals(0, largestSubArraySum.largestSum(array));
        assertEquals(0, largestSubArraySum.largestSumOptimized(array));
    }

    @Test
    void testExamples() {
        array = new int[] {2, -1, 4, -2, 1};
        assertEquals(5, largestSubArraySum.largestSum(array));
        assertEquals(5, largestSubArraySum.largestSumOptimized(array));

        array = new int[] {-2, -1, -3};
        assertEquals(-1, largestSubArraySum.largestSum(array));
        assertEquals(-1, largestSubArraySum.largestSumOptimized(array));
    }
}