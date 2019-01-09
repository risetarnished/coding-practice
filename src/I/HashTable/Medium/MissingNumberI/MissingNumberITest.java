package I.HashTable.Medium.MissingNumberI;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberITest {
    private static MissingNumberI missingNumber;
    private int[] array;

    @BeforeAll
    static void setInstance() {
        missingNumber = new MissingNumberI();
    }

    @BeforeEach
    void setUp() {
        array = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        assertEquals(1, missingNumber.missing(array));
    }

    @Test
    void testEmpty() {
        array = new int[] {};
        assertEquals(1, missingNumber.missing(array));
    }

    @Test
    void testOne() {
        array = new int[] {1, 2, 3};
        assertEquals(4, missingNumber.missing(array));
    }

    @Test
    void testTwo() {
        array = new int[] {2, 1, 4};
        assertEquals(3, missingNumber.missing(array));
    }

    @Test
    void testThree() {
        array = new int[] {12, 11, 10, 9, 4, 5, 6, 7, 2, 3, 8};
        assertEquals(1, missingNumber.missing(array));
    }
}
