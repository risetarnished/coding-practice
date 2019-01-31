package J.String.II.Hard.AllPermutationsII;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllPermutationsIITest {
    private static AllPermutationsII allPermutations;
    private String set;

    @BeforeAll
    static void setInstance() {
        allPermutations = new AllPermutationsII();
    }

    @BeforeEach
    void setUp() {
        set = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNullAndEmpty() {
        assertEquals(new ArrayList<>(), allPermutations.permutations(set));
        set = "";
        assertEquals(new ArrayList<>(Collections.singletonList("")), allPermutations.permutations(set));
    }

    @Test
    void testExamples() {
        set = "abc";
        List<String> result = allPermutations.permutations(set);
        List<String> expected = new ArrayList<>(Arrays.asList(
                "abc", "acb", "bac", "bca", "cab", "cba"
        ));
        printInfo(set, expected, result);

        set = "abbc";
        result = allPermutations.permutations(set);
        expected = new ArrayList<>(Arrays.asList(
                "abbc","abcb","acbb","babc","bacb","bbac","bbca","bcab","bcba","cabb","cbab","cbba"
        ));
        printInfo(set, expected, result);
    }

    private void printInfo(String set, List<String> expected, List<String> result) {
        System.out.println("Test input = " + set);
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result  : " + result);
    }
}