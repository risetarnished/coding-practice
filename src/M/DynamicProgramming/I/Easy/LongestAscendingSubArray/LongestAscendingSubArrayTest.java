package M.DynamicProgramming.I.Easy.LongestAscendingSubArray;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestAscendingSubArrayTest {
    private static LongestAscendingSubArray longestAscendingSubArray;
    private int[] array;

    @BeforeAll
    static void setInstance() {
        longestAscendingSubArray = new LongestAscendingSubArray();
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
        assertEquals(0, longestAscendingSubArray.longest(array));
        assertEquals(0, longestAscendingSubArray.longestAlt(array));
        array = new int[] {};
        assertEquals(0, longestAscendingSubArray.longest(array));
        assertEquals(0, longestAscendingSubArray.longestAlt(array));
    }

    @Test
    void testExamples() {
        array = new int[] {7, 2, 3, 1, 5, 8, 9, 6};
        assertEquals(4, longestAscendingSubArray.longest(array));
        assertEquals(4, longestAscendingSubArray.longestAlt(array));
        array = new int[] {1, 2, 3, 3, 4, 4, 5};
        assertEquals(3, longestAscendingSubArray.longest(array));
        assertEquals(3, longestAscendingSubArray.longestAlt(array));
        array = new int[] {1, 2, 3, 4, 5};
        assertEquals(5, longestAscendingSubArray.longest(array));
        assertEquals(5, longestAscendingSubArray.longestAlt(array));
    }
}