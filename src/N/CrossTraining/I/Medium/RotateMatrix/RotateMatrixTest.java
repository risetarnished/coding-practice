package N.CrossTraining.I.Medium.RotateMatrix;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateMatrixTest {
    private static RotateMatrix rotation;
    private int[][] matrix;

    @BeforeAll
    static void setInstance() {
        rotation = new RotateMatrix();
    }

    @BeforeEach
    void setUp() {
        matrix = null;
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void rotate() {
        int[][] original = matrix;
        rotation.rotate(matrix);
        assertArrayEquals(original, matrix);
        
        matrix = new int[][] {};
        original = matrix;
        rotation.rotate(matrix);
        assertArrayEquals(original, matrix);

        matrix = new int[][] {
            {1, 2, 3},
            {8, 9, 4},
            {7, 6, 5}
        };
        rotation.rotate(matrix);
        int[][] expected = new int[][] {
            {7, 8, 1},
            {6, 9, 2},
            {5, 4, 3}
        };
        assertArrayEquals(expected, matrix);
    }
}