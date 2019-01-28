package L.DynamicProgramming.III.Hard.LongestCrossOfOnes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCrossOfOnesTest {
    private static LongestCrossOfOnes longestCrossOfOnes;
    private int[][] matrix;

    @BeforeAll
    static void setInstance() {
        longestCrossOfOnes = new LongestCrossOfOnes();
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
        assertEquals(0, longestCrossOfOnes.largest(matrix));

        matrix = new int[][] {};
        assertEquals(0, longestCrossOfOnes.largest(matrix));

        matrix = new int[][] {new int[] {}};
        assertEquals(0, longestCrossOfOnes.largest(matrix));
    }

    @Test
    void testExamples() {
        matrix = new int[][] {
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        assertEquals(2, longestCrossOfOnes.largest(matrix));
    }
}