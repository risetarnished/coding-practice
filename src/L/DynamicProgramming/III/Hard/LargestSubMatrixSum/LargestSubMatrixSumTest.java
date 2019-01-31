package L.DynamicProgramming.III.Hard.LargestSubMatrixSum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestSubMatrixSumTest {
    private static LargestSubMatrixSum largestSubMatrixSum;
    private int[][] matrix;

    @BeforeAll
    static void setInstance() {
        largestSubMatrixSum = new LargestSubMatrixSum();
    }

    @BeforeEach
    void setUp() {
        matrix = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNullAndEmpty() {
        assertEquals(0, largestSubMatrixSum.largest(matrix));

        matrix = new int[][] {};
        assertEquals(0, largestSubMatrixSum.largest(matrix));

        matrix = new int[][] {new int[] {}};
        assertEquals(0, largestSubMatrixSum.largest(matrix));
    }

    @Test
    void testExamples() {
        matrix = new int[][] {
                {1, -2, -1, 4},
                {1, -1,  1, 1},
                {0, -1, -1, 1},
                {0,  0,  1, 1}
        };
        assertEquals(7, largestSubMatrixSum.largest(matrix));

        matrix = new int [][] {
                {-1}
        };
        assertEquals(-1, largestSubMatrixSum.largest(matrix));
    }
}