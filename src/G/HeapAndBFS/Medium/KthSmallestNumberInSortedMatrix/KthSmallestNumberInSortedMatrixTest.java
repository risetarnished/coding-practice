package G.HeapAndBFS.Medium.KthSmallestNumberInSortedMatrix;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthSmallestNumberInSortedMatrixTest {
    private static KthSmallestNumberInSortedMatrix kthSmallestNumberInSortedMatrix;
    private int[][] matrix;
    private int k;

    @BeforeAll
    static void setInstance() {
        kthSmallestNumberInSortedMatrix = new KthSmallestNumberInSortedMatrix();
    }

    @BeforeEach
    void setUp() {
        matrix = null;
        k = 0;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        // Make k valid
        k = 1;
        assertEquals(-1, kthSmallestNumberInSortedMatrix.kthSmallest(matrix, k));
    }

    @Test
    void testEmpty() {
        // Make k valid
        k = 1;
        matrix = new int[][] {};
        assertEquals(-1, kthSmallestNumberInSortedMatrix.kthSmallest(matrix, k));
    }

    @Test
    void testInvalidK() {
        // Make matrix valid
        matrix = new int[][] {{1, 2, 3}, {2, 3, 4}};
        assertEquals(-1, kthSmallestNumberInSortedMatrix.kthSmallest(matrix, k));
    }

    @Test
    void testExample() {
        //   { {1,  3,   5,  7},
        //
        //    {2,  4,   8,   9},
        //
        //    {3,  5, 11, 15},
        //
        //    {6,  8, 13, 18} }
        //
        // the 5th smallest number is 4
        // the 8th smallest number is 6
        matrix = new int[][] {
                {1, 3, 5, 7},
                {2, 4, 8, 9},
                {3, 5, 11, 15},
                {6, 8, 13, 18}
        };
        k = 5;
        assertEquals(4, kthSmallestNumberInSortedMatrix.kthSmallest(matrix, k));
        k = 8;
        assertEquals(6, kthSmallestNumberInSortedMatrix.kthSmallest(matrix, k));
    }
}
