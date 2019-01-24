package L.DynamicProgramming.III.Easy.LongestConsecutiveOnes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveOnesTest {
    private static LongestConsecutiveOnes longestConsecutiveOnes;
    private int[] array;

    @BeforeAll
    static void setInstance() {
        longestConsecutiveOnes = new LongestConsecutiveOnes();
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
        assertEquals(0, longestConsecutiveOnes.longest(array));

        array = new int[] {};
        assertEquals(0, longestConsecutiveOnes.longest(array));
    }

    @Test
    void testExamples() {
        array = new int[] {0, 1, 0, 1, 1, 1, 0};
        assertEquals(3, longestConsecutiveOnes.longest(array));
        array = new int[] {1, 0, 1, 0, 0, 1, 1, 1, 1, 0};
        assertEquals(4, longestConsecutiveOnes.longest(array));
    }
}