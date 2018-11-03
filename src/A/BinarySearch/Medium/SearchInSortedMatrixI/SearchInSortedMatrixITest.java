package A.BinarySearch.Medium.SearchInSortedMatrixI;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInSortedMatrixITest {
    static SearchInSortedMatrixI instance;

    @BeforeAll
    static void setInstance() {
        instance = new SearchInSortedMatrixI();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        int[] result = instance.search(null, 0);
        assertArrayEquals(new int[] {-1, -1}, result);
    }

    @Test
    void testEmpty() {
        int[] result = instance.search(new int[][] {}, 0);
        assertArrayEquals(new int[] {-1, -1}, result);
    }

    @Test
    void testSeven() {
        int[][] matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 7},
                {8, 9, 10}
        };
        int[] result = instance.search(matrix, 7);
        assertArrayEquals(new int[] {1, 2}, result);
    }

    @Test
    void testSix() {
        int[][] matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 7},
                {8, 9, 10}
        };
        int[] result = instance.search(matrix, 6);
        assertArrayEquals(new int[] {-1, -1}, result);
    }
}