package K.StringII.Easy.RightShiftByNCharacters;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RightShiftByNCharactersTest {
    private static RightShiftByNCharacters rightShiftByNCharacters;
    private String input;
    private int n;

    @BeforeAll
    static void setInstance() {
        rightShiftByNCharacters = new RightShiftByNCharacters();
    }

    @BeforeEach
    void setUp() {
        input = null;
        n = 0;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNullAndEmpty() {
        assertEquals(input, rightShiftByNCharacters.rightShift(input, n));
        input = "";
        assertEquals(input, rightShiftByNCharacters.rightShift(input, n));
    }

    @Test
    void testExamples() {
        input = "abcdef";
        n = 2;
        assertEquals("efabcd", rightShiftByNCharacters.rightShift(input, n));
        input = "abcdefg";
        n = 39;
        assertEquals("defgabc", rightShiftByNCharacters.rightShift(input, n));
    }
}
