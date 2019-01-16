package J.String.I.Hard.RemoveAdjacentRepeatedCharactersIV;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveAdjacentRepeatedCharactersIVTest {
    private static RemoveAdjacentRepeatedCharactersIV removeAdjacent;
    private String input;

    @BeforeAll
    static void setInstance() {
        removeAdjacent = new RemoveAdjacentRepeatedCharactersIV();
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
        input = "abbbaaccz";
        assertEquals("z", removeAdjacent.deDup(input));
        input = "aabccdc";
        assertEquals("bdc", removeAdjacent.deDup(input));
        input = "aababab";
        assertEquals("babab", removeAdjacent.deDup(input));
        input = "abbcddca";
        assertEquals("", removeAdjacent.deDup(input));
    }
}
