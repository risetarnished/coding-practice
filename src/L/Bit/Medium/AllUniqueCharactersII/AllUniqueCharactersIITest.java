package L.Bit.Medium.AllUniqueCharactersII;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllUniqueCharactersIITest {
    private static AllUniqueCharactersII allUnique;
    private String word;

    @BeforeAll
    static void setInstance() {
        allUnique = new AllUniqueCharactersII();
    }

    @BeforeEach
    void setUp() {
        word = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNullAndEmpty() {
        assertTrue(allUnique.allUnique(word));
        word = "";
        assertTrue(allUnique.allUnique(word));
    }

    @Test
    void testExamples() {
        word = "abA+\\8";
        assertTrue(allUnique.allUnique(word));

        word = "abA+\\88";
        assertFalse(allUnique.allUnique(word));

        word = "\\n/b10{-aAM\\n/b90}{-MPO";
        assertFalse(allUnique.allUnique(word));
    }
}