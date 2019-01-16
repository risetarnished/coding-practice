package J.String.I.Easy.RemoveSpaces;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveSpacesTest {
    private static RemoveSpaces removeSpaces;
    private String input;

    @BeforeAll
    static void setInstance() {
        removeSpaces = new RemoveSpaces();
    }

    @BeforeEach
    void setUp() {
        input = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNullAndEmpty() {
        assertEquals(input, removeSpaces.removeSpaces(input));
        assertEquals(input, removeSpaces.removeSpacesAlt(input));
        input = "";
        assertEquals(input, removeSpaces.removeSpaces(input));
        assertEquals(input, removeSpaces.removeSpacesAlt(input));
    }

    @Test
    void testSpace() {
        input = " ";
        assertEquals("", removeSpaces.removeSpaces(input));
        assertEquals("", removeSpaces.removeSpacesAlt(input));
    }

    @Test
    void testExamples() {
        input = "  I   Love Programming  ";
        assertEquals("I Love Programming", removeSpaces.removeSpaces(input));
        assertEquals("I Love Programming", removeSpaces.removeSpacesAlt(input));
    }
}
