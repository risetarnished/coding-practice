package J.StringI.Medium.DetermineIfOneStringIsAnothersSubstring;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetermineIfOneStringIsAnothersSubstringTest {
    private static DetermineIfOneStringIsAnothersSubstring strStr;
    private String large, small;

    @BeforeAll
    static void setInstance() {
        strStr = new DetermineIfOneStringIsAnothersSubstring();
    }

    @BeforeEach
    void setUp() {
        large = null;
        small = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNullAndEmpty() {
        assertEquals(-1, strStr.strstr(large, small));
        assertEquals(-1, strStr.rabinKarp(large, small));
        large = "a";
        assertEquals(-1, strStr.strstr(large, small));
        assertEquals(-1, strStr.rabinKarp(large, small));
        large = null;
        small = "a";
        assertEquals(-1, strStr.strstr(large, small));
        assertEquals(-1, strStr.rabinKarp(large, small));
        large = "a";
        small = "aa";
        assertEquals(-1, strStr.strstr(large, small));
        assertEquals(-1, strStr.rabinKarp(large, small));
        small = "";
        assertEquals(0, strStr.strstr(large, small));
        assertEquals(0, strStr.rabinKarp(large, small));
    }

    @Test
    void testExamples() {
        large = "bcabc";
        small = "ab";
        assertEquals(2, strStr.strstr(large, small));
        assertEquals(2, strStr.rabinKarp(large, small));
        small = "bcd";
        assertEquals(-1, strStr.strstr(large, small));
        assertEquals(-1, strStr.rabinKarp(large, small));
        large = "mississippi";
        small = "issip";
        assertEquals(4, strStr.strstr(large, small));
        assertEquals(4, strStr.rabinKarp(large, small));
    }
}