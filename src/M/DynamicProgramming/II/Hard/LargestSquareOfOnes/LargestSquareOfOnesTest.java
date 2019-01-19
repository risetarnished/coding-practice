package M.DynamicProgramming.II.Hard.LargestSquareOfOnes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestSquareOfOnesTest {
    private static LargestSquareOfOnes largestSquareOfOnes;
    private int[][] matrix;

    @BeforeAll
    static void setInstance() {
        largestSquareOfOnes = new LargestSquareOfOnes();
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
        assertEquals(0, largestSquareOfOnes.largest(matrix));

        matrix = new int[][] {};
        assertEquals(0, largestSquareOfOnes.largest(matrix));

        matrix = new int[][] {new int[] {}};
        assertEquals(0, largestSquareOfOnes.largest(matrix));
    }

    @Test
    void testExamples() {
        matrix = new int[][] {
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        assertEquals(2, largestSquareOfOnes.largest(matrix));

        matrix = new int[][] {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 0, 0},
                {1, 1, 1, 0, 0},
        };
        assertEquals(3, largestSquareOfOnes.largest(matrix));
    }
}