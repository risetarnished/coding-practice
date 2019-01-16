package J.String.II.Medium.LongestSubstringWithoutRepeatingCharacters;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {
    private static LongestSubstringWithoutRepeatingCharacters longestSubstring;
    private String input;

    @BeforeAll
    static void setInstance() {
        longestSubstring = new LongestSubstringWithoutRepeatingCharacters();
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
        assertEquals(0, longestSubstring.longest(input));
        input = "";
        assertEquals(0, longestSubstring.longest(input));
    }

    @Test
    void testExmaples() {
        input = "bcdfbd";
        assertEquals(4, longestSubstring.longest(input));

        input = "efhrgsayekasdanfev";
        assertEquals(9, longestSubstring.longest(input));
    }
}