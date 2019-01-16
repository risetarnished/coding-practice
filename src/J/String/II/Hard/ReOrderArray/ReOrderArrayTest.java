package J.String.II.Hard.ReOrderArray;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReOrderArrayTest {
    private static ReOrderArray reOrderArray;
    private int[] array;

    @BeforeAll
    static void setInstance() {
        reOrderArray = new ReOrderArray();
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
        assertEquals(array, reOrderArray.reorder(array));
        array = new int[] {};
        assertEquals(array, reOrderArray.reorder(array));
    }

    @Test

    void testExamples() {
        array = new int[] {1, 2, 3, 4, 5, 6};
        assertArrayEquals(new int[] {1, 4, 2, 5, 3, 6}, reOrderArray.reorder(array));

        array = new int[] {1, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(new int[] {1, 4, 2, 5, 3, 6, 7}, reOrderArray.reorder(array));
    }
}