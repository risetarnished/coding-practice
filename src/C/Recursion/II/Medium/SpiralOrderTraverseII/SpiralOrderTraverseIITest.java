package C.Recursion.II.Medium.SpiralOrderTraverseII;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SpiralOrderTraverseIITest {
    private static SpiralOrderTraverseII spiralOrderTraverseII;
    private int[][] matrix;

    @BeforeAll
    static void setInstance() {
        spiralOrderTraverseII = new SpiralOrderTraverseII();
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
        assertEquals(new ArrayList<>(), spiralOrderTraverseII.spiral(matrix));

        matrix = new int[][] {};
        assertEquals(new ArrayList<>(), spiralOrderTraverseII.spiral(matrix));
    }

    @Test
    void testExamples() {
        matrix = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        assertEquals(
                new ArrayList<>(Arrays.asList(
                        1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7
                )),
                spiralOrderTraverseII.spiral(matrix)
        );

        matrix = new int[][] {
                {1, 2, 3},
                {10, 11, 4},
                {9, 12, 5},
                {8, 7, 6}
        };
        assertEquals(
                new ArrayList<>(Arrays.asList(
                        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
                )),
                spiralOrderTraverseII.spiral(matrix)
        );
    }
}