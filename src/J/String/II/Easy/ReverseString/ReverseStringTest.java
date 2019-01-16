package J.String.II.Easy.ReverseString;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {
    private static ReverseString reverseString;
    private String input;

    @BeforeAll
    static void setInstance() {
        reverseString = new ReverseString();
    }

    @BeforeEach
    void setUp() {
        input = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        assertEquals(input, reverseString.reverse(input));
        assertEquals(input, reverseString.recursiveReverse(input));
    }

    @Test
    void testEmy() {
        input = "";
        assertEquals(input, reverseString.reverse(input));
        assertEquals(input, reverseString.recursiveReverse(input));
    }

    @Test
    void testOneChar() {
        input = "a";
        assertEquals(input, reverseString.reverse(input));
        assertEquals(input, reverseString.recursiveReverse(input));
    }

    @Test
    void testOne() {
        input = "abc";
        assertEquals("cba", reverseString.reverse(input));
        assertEquals("cba", reverseString.recursiveReverse(input));
    }

    @Test
    void testTwo() {
        input = "eggeplp";
        assertEquals("plpegge", reverseString.reverse(input));
        assertEquals("plpegge", reverseString.recursiveReverse(input));
    }
}
