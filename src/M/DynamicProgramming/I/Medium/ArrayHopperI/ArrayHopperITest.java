package M.DynamicProgramming.I.Medium.ArrayHopperI;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHopperITest {
    private static ArrayHopperI arrayHopperI;
    private int[] array;

    @BeforeAll
    static void setInstance() {
        arrayHopperI = new ArrayHopperI();
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
        assertFalse(arrayHopperI.canJump(array));
        array = new int[] {};
        assertFalse(arrayHopperI.canJump(array));
    }

    @Test
    void testExamples() {
        array = new int[] {1, 3, 2, 0, 3};
        assertTrue(arrayHopperI.canJump(array));

        array = new int[] {2, 1, 1, 0, 2};
        assertFalse(arrayHopperI.canJump(array));
    }
}