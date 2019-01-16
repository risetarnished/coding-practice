package J.String.II.Hard.StringReplace;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringReplaceTest {
    private static StringReplace stringReplace;
    private String input;
    private String source;
    private String target;

    @BeforeAll
    static void setInstace() {
        stringReplace = new StringReplace();
    }

    @BeforeEach
    void setUp() {
        input = null;
        source = null;
        target = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNullAndEmpty() {
        assertEquals(input, stringReplace.replace(input, source, target));
        assertEquals(input, stringReplace.replaceNaive(input, source, target));
        assertEquals(input, stringReplace.replaceAlt(input, source, target));

        input = "";
        assertEquals(input, stringReplace.replace(input, source, target));
        assertEquals(input, stringReplace.replaceNaive(input, source, target));
        assertEquals(input, stringReplace.replaceAlt(input, source, target));
    }

    @Test
    void testExamples() {
        input = "appledogapple";
        source = "apple";
        target = "cat";
        assertEquals("catdogcat", stringReplace.replace(input, source, target));
        assertEquals("catdogcat", stringReplace.replaceNaive(input, source, target));
        assertEquals("catdogcat", stringReplace.replaceAlt(input, source, target));

        input = "dodododo";
        source = "dod";
        target = "a";
        assertEquals("aoao", stringReplace.replace(input, source, target));
        assertEquals("aoao", stringReplace.replaceNaive(input, source, target));
        assertEquals("aoao", stringReplace.replaceAlt(input, source, target));

        input = "catdogcat";
        source = "cat";
        target = "apple";
        assertEquals("appledogapple", stringReplace.replace(input, source, target));
        assertEquals("appledogapple", stringReplace.replaceNaive(input, source, target));
        assertEquals("appledogapple", stringReplace.replaceAlt(input, source, target));

        input = "aaa";
        source = "a";
        target = "bb";
        assertEquals("bbbbbb", stringReplace.replace(input, source, target));
        assertEquals("bbbbbb", stringReplace.replaceNaive(input, source, target));
        assertEquals("bbbbbb", stringReplace.replaceAlt(input, source, target));
    }
}
