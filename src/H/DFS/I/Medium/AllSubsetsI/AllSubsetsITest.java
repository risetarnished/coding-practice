package H.DFS.I.Medium.AllSubsetsI;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AllSubsetsITest {
    private static AllSubsetsI allSubsets;
    private String set;

    @BeforeAll
    static void setInstance() {
        allSubsets = new AllSubsetsI();
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
        assertEquals(new ArrayList<>(), allSubsets.subSets(set));
    }

    @Test
    void testEmpty() {
        set = "";
        assertEquals(new ArrayList<>(Collections.singletonList("")), allSubsets.subSets(set));
    }

    @Test
    void testOne() {
        // abc
        set = "abc";
        List<String> result = allSubsets.subSets(set);
        // To come up with this expected result requires a bit of brain function
        // It may be easier if we just sort them since the order does not matter
        List<String> expected = new ArrayList<>(Arrays.asList(
                "abc", "ab", "ac", "a", "bc", "b", "c", ""
        ));
        Collections.sort(result);
        Collections.sort(expected);
        System.out.println("Test input: " + set);
        System.out.println("Expected all subsets: " + expected);
        System.out.println("Actual all subsets: " + result);
        assertEquals(expected, result);
    }

    @Test
    void testTwo() {
        // qwer
        set = "qwer";
        List<String> result = allSubsets.subSets(set);
        List<String> expected = new ArrayList<>(Arrays.asList(
                "qwer", "qwe", "qwr", "qer", "qw", "qe", "qr", "q",
                "wer", "we", "wr", "w", "er", "e", "r", ""
        ));
        Collections.sort(result);
        Collections.sort(expected);
        System.out.println("Test input: " + set);
        System.out.println("Expected all subsets: " + expected);
        System.out.println("Actural all subsets: " + result);
        assertEquals(expected, result);
    }
}
