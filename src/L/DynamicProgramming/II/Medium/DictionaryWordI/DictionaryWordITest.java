package L.DynamicProgramming.II.Medium.DictionaryWordI;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryWordITest {
    private static DictionaryWordI dictionaryWordI;
    private String input;
    private String[] dict;

    @BeforeAll
    static void setInstance() {
        dictionaryWordI = new DictionaryWordI();
    }

    @BeforeEach
    void setUp() {
        input = null;
        dict = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNullAndEmpty() {
        assertFalse(dictionaryWordI.canBreak(input, dict));
        dict = new String[] {};
        assertFalse(dictionaryWordI.canBreak(input, dict));
    }

    @Test
    void testExamples() {
        input = "robob";
        dict = new String[] {"rob", "cat", "bob"};
        boolean result = dictionaryWordI.canBreak(input, dict);
        printInfo(input, dict, false, result);
        assertFalse(result);

        input = "bobcatrob";
        result = dictionaryWordI.canBreak(input, dict);
        printInfo(input, dict, false, result);
        assertTrue(result);
    }

    private void printInfo(String input, String[] dict, boolean expected, boolean result) {
        System.out.format(
                "Can \"%s\" be formed by words from %s?\n" +
                "Expected: %s\nActual:   %s\n",
                input, Arrays.toString(dict), expected, result
        );
    }
}