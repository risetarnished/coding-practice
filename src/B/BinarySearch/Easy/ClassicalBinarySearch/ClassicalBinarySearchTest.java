package B.BinarySearch.Easy.ClassicalBinarySearch;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassicalBinarySearchTest {
    static ClassicalBinarySearch bs;
    int[] arrayOne;
    int[] arrayTwo;

    @BeforeAll
    static void setInstance() {
        bs = new ClassicalBinarySearch();
    }

    @BeforeEach
    void setUp() {
        arrayOne = new int[] {1, 2, 3, 4, 5};
        arrayTwo = new int[] {1, 2, 2, 2, 3, 4};
    }

    @Test
    void testNull() {
        int result = bs.binarySearch(null, 0);
        assertEquals(result, -1);
    }

    @Test
    void testEmpty() {
        int result = bs.binarySearch(new int[] {}, 0);
        assertEquals(result, -1);
    }

    @Test
    void testOneThree() {
        int result = bs.binarySearch(arrayOne, 3);
        assertEquals(result, 2);
    }

    @Test
    void testOneSix() {
        int result = bs.binarySearch(arrayOne, 6);
        assertEquals(result, -1);
    }

    @Test
    void testTwoTwo() {
        int result = bs.binarySearch(arrayTwo, 2);
        assertEquals(result, 2);
    }

}