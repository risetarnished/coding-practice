package A.SortingAlgorithms.Easy.Move0sToTheEndI;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Move0sToTheEndITest {
    static Move0sToTheEndI move0sToTheEndI;

    @BeforeEach
    void setUp() {
        move0sToTheEndI = new Move0sToTheEndI();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        int[] result = move0sToTheEndI.moveZero(null);
        assertArrayEquals(null, result);
        int[] resultKeptOrder = move0sToTheEndI.moveZeroPreservePosition(null);
        assertArrayEquals(null, resultKeptOrder);
    }

    @Test
    void testEmpty() {
        int[] result = move0sToTheEndI.moveZero(new int[] {});
        assertArrayEquals(new int[] {}, result);
        int[] resultKeptOrder = move0sToTheEndI.moveZeroPreservePosition(new int[] {});
        assertArrayEquals(new int[] {}, resultKeptOrder);
    }

    @Test
    void testOne() {
        int[] result = move0sToTheEndI.moveZero(new int[] {1});
        assertArrayEquals(new int[] {1}, result);
        int[] resultKeptOrder = move0sToTheEndI.moveZeroPreservePosition(new int[] {1});
        assertArrayEquals(new int[] {1}, resultKeptOrder);
    }

    @Test
    void testTwo() {
        int[] result = move0sToTheEndI.moveZero(new int[] {1, 0, 3, 0, 1});
        assertArrayEquals(new int[] {1, 1, 3, 0, 0}, result);
        int[] resultKeptOrder = move0sToTheEndI.moveZeroPreservePosition(new int[] {1, 0, 3, 0, 1});
        assertArrayEquals(new int[] {1, 3, 1, 0, 0}, resultKeptOrder);
    }

    @Test
    void testThree() {
        int[] result = move0sToTheEndI.moveZero(new int[] {0, 0, 1, 1, 0, 1, 0});
        assertArrayEquals(new int[] {1, 1, 1, 0, 0, 0, 0}, result);
        int[] resultKeptOrder = move0sToTheEndI.moveZeroPreservePosition(new int[] {0, 0, 1, 1, 0, 1, 0});
        assertArrayEquals(new int[] {1, 1, 1, 0, 0, 0, 0}, resultKeptOrder);
    }
}