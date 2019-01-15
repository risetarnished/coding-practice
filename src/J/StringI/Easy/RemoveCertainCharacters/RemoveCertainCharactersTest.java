package J.StringI.Easy.RemoveCertainCharacters;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveCertainCharactersTest {
    private static RemoveCertainCharacters removeCertainCharacters;
    private String input;
    private String t;

    @BeforeAll
    static void setInstance() {
        removeCertainCharacters = new RemoveCertainCharacters();
    }

    @BeforeEach
    void setUp() {
        input = null;
        t = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        assertEquals(input, removeCertainCharacters.remove(input, t));
    }

    @Test
    void testEmpy() {
        input = "";
        assertEquals(input, removeCertainCharacters.remove(input, t));
    }

    @Test
    void testOne() {
        input = "abcd";
        t = "ab";
        assertEquals("cd", removeCertainCharacters.remove(input, t));
    }

    @Test
    void testTwo() {
        input = "aaaaaa";
        t = "bbb";
        assertEquals("aaaaaa", removeCertainCharacters.remove(input, t));
    }

    @Test
    void testThree() {
        input = "student";
        t = "un";
        assertEquals("stdet", removeCertainCharacters.remove(input, t));
    }
}
