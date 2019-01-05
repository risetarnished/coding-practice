package B.BinarySearch.Medium.FirstOccurrence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstOccurrenceTest {
    static FirstOccurrence firstOccurrence;

    @BeforeEach
    void setUp() {
        firstOccurrence = new FirstOccurrence();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        int result = firstOccurrence.firstOccur(null, 0);
        assertEquals(-1, result);
    }

    @Test
    void testEmpty() {
        int result = firstOccurrence.firstOccur(new int[] {}, 0);
        assertEquals(-1, result);
    }

    @Test
    // When there is only one instance of the target in the array
    void testUnique() {
        int result = firstOccurrence.firstOccur(new int[] {1, 2, 3}, 2);
        assertEquals(1, result);
    }

    @Test
    // When there are no instance of the target in the array
    void testAbsent() {
        int result = firstOccurrence.firstOccur(new int[] {1, 2, 3}, 4);
        assertEquals(-1, result);
    }

    @Test
    // When there are multiple instances of the target in the array
    void testMultiple() {
        int result = firstOccurrence.firstOccur(new int[] {1, 2, 2, 2, 3}, 2);
        assertEquals(1, result);
    }
}