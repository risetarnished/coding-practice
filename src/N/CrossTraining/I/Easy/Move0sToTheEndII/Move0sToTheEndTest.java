package N.CrossTraining.I.Easy.Move0sToTheEndII;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Move0sToTheEndTest {
    private static Move0sToTheEndII moveZeros;
    private int[] array;

    @BeforeAll
    static void setInstance() {
        moveZeros = new Move0sToTheEndII();
    }

    @BeforeEach
    void setUp() {
        array = null;
    }

    @Test
    void moveZero() {
        assertArrayEquals(array, moveZeros.moveZero(array));
        array = new int[] {};
        assertArrayEquals(array, moveZeros.moveZero(array));

        array = new int[] {1, 0, 3, 0, 1};
        assertArrayEquals(new int[] {1, 3, 1, 0, 0}, moveZeros.moveZero(array));

        array = new int[] {0, 0, 4, -7, 0, 8, 0};
        assertArrayEquals(new int[] {4, -7, 8, 0, 0, 0, 0}, moveZeros.moveZero(array));
    }

    @Test
    void moveZeroBySwap() {
        assertArrayEquals(array, moveZeros.moveZeroBySwap(array));
        array = new int[] {};
        assertArrayEquals(array, moveZeros.moveZeroBySwap(array));

        array = new int[] {1, 0, 3, 0, 1};
        assertArrayEquals(new int[] {1, 3, 1, 0, 0}, moveZeros.moveZeroBySwap(array));

        array = new int[] {0, 0, 4, -7, 0, 8, 0};
        assertArrayEquals(new int[] {4, -7, 8, 0, 0, 0, 0}, moveZeros.moveZeroBySwap(array));
    }
}