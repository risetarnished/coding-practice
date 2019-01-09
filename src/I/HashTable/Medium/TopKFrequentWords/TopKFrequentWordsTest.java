package I.HashTable.Medium.TopKFrequentWords;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentWordsTest {
    private static TopKFrequentWords topKFrequentWords;
    private String[] combo;
    private int k;

    @BeforeAll
    static void setInstance() {
        topKFrequentWords = new TopKFrequentWords();
    }

    @BeforeEach
    void setUp() {
        combo = null;
        k = 0;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        // Null array
        k = 2;
        assertEquals(combo, topKFrequentWords.topKFrequent(combo, k));
    }

    @Test
    void testEmpty() {
        // Empty array
        combo = new String[] {};
        k = 2;
        assertEquals(combo, topKFrequentWords.topKFrequent(combo, k));
    }

    @Test
    void testInvalidK() {
        // Negative K
        k = -1;
        combo = new String[] {"a", "a", "b", "b", "b", "b", "c", "c", "c", "d"};
        assertArrayEquals(new String[] {}, topKFrequentWords.topKFrequent(combo, k));
    }

    @Test
    void testTop2() {
        k = 2;
        combo = new String[] {"a", "a", "b", "b", "b", "b", "c", "c", "c", "d"};
        assertArrayEquals(new String[] {"b", "c"}, topKFrequentWords.topKFrequent(combo, k));
    }

    @Test
    void testTop4() {
        k = 4;
        combo = new String[] {"a", "a", "b", "b", "b", "b", "c", "c", "c", "d"};
        String[] result = topKFrequentWords.topKFrequent(combo, k);
        assertArrayEquals(new String[] {"b", "c", "a", "d"}, result);
    }

    @Test
    void testLargeK() {
        // K > number of distinct words
        k = 5;
        combo = new String[] {"a", "a", "b", "b", "b", "b", "c", "c", "c", "d"};
        String[] result = topKFrequentWords.topKFrequent(combo, k);
        assertArrayEquals(new String[] {"b", "c", "a", "d"}, result);
    }
}
