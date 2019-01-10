package J.StringI.Easy.RemoveAdjacentRepeatedCharactersI;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveAdjacentRepeatedCharactersITest {
    private static RemoveAdjacentRepeatedCharactersI removeAdjacent;
    private String input;

    @BeforeAll
    static void setInstance() {
        removeAdjacent = new RemoveAdjacentRepeatedCharactersI();
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
        assertEquals(input, removeAdjacent.deDup(input));
        input = "";
        assertEquals(input, removeAdjacent.deDup(input));
    }

    @Test
    void testExample() {
        input = "aaaabbbc";
        assertEquals("abc", removeAdjacent.deDup(input));
        input = "abccde";
        assertEquals("abcde", removeAdjacent.deDup(input));
    }
}
