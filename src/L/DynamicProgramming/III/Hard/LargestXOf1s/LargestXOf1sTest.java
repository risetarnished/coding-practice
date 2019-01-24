package L.DynamicProgramming.III.Hard.LargestXOf1s;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestXOf1sTest {
    private static LargestXOf1s largestXOf1s;
    private int[][] matrix;

    @BeforeAll
    static void setInstance() {
        largestXOf1s = new LargestXOf1s();
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
        assertEquals(0, largestXOf1s.largest(matrix));

        matrix = new int[][] {};
        assertEquals(0, largestXOf1s.largest(matrix));

        matrix = new int[][] {new int[] {}};
        assertEquals(0, largestXOf1s.largest(matrix));
    }

    @Test
    void testExamples() {
        matrix = new int[][] {
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        assertEquals(2, largestXOf1s.largest(matrix));

        matrix = new int[][] {
                {1,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,1,0,0},
                {0,0,0,1,0,1,0,0,0},
                {0,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,1,0,0,0},
                {0,0,1,0,0,0,1,0,0},
                {0,1,0,0,0,0,0,1,0},
                {1,0,0,0,0,0,0,0,1}
        };
        assertEquals(3, largestXOf1s.largest(matrix));
    }
}