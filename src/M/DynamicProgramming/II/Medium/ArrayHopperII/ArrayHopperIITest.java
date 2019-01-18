package M.DynamicProgramming.II.Medium.ArrayHopperII;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHopperIITest {
    private static ArrayHopperII arrayHopperII;
    private int[] array;

    @BeforeAll
    static void setInstance() {
        arrayHopperII = new ArrayHopperII();
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
        assertEquals(-1, arrayHopperII.minJump(array));
        array = new int[] {};
        assertEquals(-1, arrayHopperII.minJump(array));
    }

    @Test
    void testExamples() {
        array = new int[] {3, 3, 1, 0, 4};
        assertEquals(2, arrayHopperII.minJump(array));

        array = new int[] {2, 1, 1, 0, 2};
        assertEquals(-1, arrayHopperII.minJump(array));
    }
}