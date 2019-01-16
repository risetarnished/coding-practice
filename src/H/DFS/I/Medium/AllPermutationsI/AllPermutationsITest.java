package H.DFS.I.Medium.AllPermutationsI;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllPermutationsITest {
    private static AllPermutationsI allPermutations;
    private String set;

    @BeforeAll
    static void setInstance() {
        allPermutations = new AllPermutationsI();
    }

    @BeforeEach
    void setUp() {
        set = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        assertEquals(new ArrayList<>(), allPermutations.permutations(set));
    }

    @Test
    void testEmpty() {
        set = "";
        assertEquals(new ArrayList<>(Collections.singletonList("")),
                allPermutations.permutations(set));
    }

    @Test
    void testAbc() {
        set = "abc";
        List<String> result = allPermutations.permutations(set);
        List<String> expected = new ArrayList<>(Arrays.asList(
                "abc", "acb", "bac", "bca", "cba", "cab"
        ));
        System.out.println("Test input = " + set);
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result:   " + result);
        assertEquals(expected, result);
    }

    @Test
    void testAbcd() {
        set = "abcd";
        List<String> result = allPermutations.permutations(set);
        List<String> expected = new ArrayList<>(Arrays.asList(
                "abcd", "abdc", "acbd", "acdb", "adbc", "adcb", "bacd", "badc",
                "bcad", "bcda", "bdac", "bdca", "cabd", "cadb", "cbad", "cbda",
                "cdab", "cdba", "dabc", "dacb", "dbac", "dbca", "dcab", "dcba"
        ));
        Collections.sort(result);
        Collections.sort(expected);
        System.out.println("Test input = " + set);
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result:   " + result);
        assertEquals(expected, result);
    }
}
