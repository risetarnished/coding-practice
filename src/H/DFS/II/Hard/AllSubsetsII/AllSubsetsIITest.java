package H.DFS.II.Hard.AllSubsetsII;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllSubsetsIITest {
    private static AllSubsetsII allSubsetsII;

    @BeforeAll
    static void setInstance() {
        allSubsetsII = new AllSubsetsII();
    }

    @Test
    void testNullAndEmpty() {
        assertEquals(new ArrayList<>(), allSubsetsII.subSets(null));
        assertEquals(new ArrayList<>(Collections.singletonList("")), allSubsetsII.subSets(""));
    }

    @Test
    void testExamples() {
        String set = "abc";
        List<String> expected = new ArrayList<>(Arrays.asList(
                "", "a", "ab", "abc", "ac", "b", "bc", "c"
        ));
        List<String> result = allSubsetsII.subSets(set);
        Collections.sort(expected);
        Collections.sort(result);
        printInfo(set, expected, result);
        assertEquals(expected, result);

        set = "abb";
        expected = new ArrayList<>(Arrays.asList(
                "", "a", "ab", "abb", "b", "bb"
        ));
        result = allSubsetsII.subSets(set);
        Collections.sort(expected);
        Collections.sort(result);
        printInfo(set, expected, result);
        assertEquals(expected, result);
    }

    private void printInfo(String set, List<String> expected, List<String> result) {
        System.out.format("Input: %s\nExpected: %s\nActual:   %s\n",
                set, expected, result);
    }
}