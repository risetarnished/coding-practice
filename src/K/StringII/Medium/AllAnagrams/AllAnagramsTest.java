package K.StringII.Medium.AllAnagrams;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AllAnagramsTest {
    private static AllAnagrams allAnagrams;
    private String sh;
    private String lo;

    @BeforeAll
    static void setInstance() {
        allAnagrams = new AllAnagrams();
    }

    @BeforeEach
    void setUp() {
        sh = null;
        lo = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNullAndEmpty() {
        assertEquals(new ArrayList<>(), allAnagrams.allAnagrams(sh, lo));

        sh = "";
        lo = "";
        assertEquals(new ArrayList<>(), allAnagrams.allAnagrams(sh, lo));

        sh = "a";
        assertEquals(new ArrayList<>(), allAnagrams.allAnagrams(sh, lo));
    }

    @Test
    void testExamples() {
        sh = "ab";
        lo = "abcbac";
        assertEquals(new ArrayList<>(Arrays.asList(0, 3)), allAnagrams.allAnagrams(sh, lo));

        sh = "aab";
        lo = "ababacbbaac";
        assertEquals(new ArrayList<>(Arrays.asList(0, 2, 7)), allAnagrams.allAnagrams(sh, lo));
    }
}