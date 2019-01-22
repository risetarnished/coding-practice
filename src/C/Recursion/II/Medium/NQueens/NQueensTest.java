package C.Recursion.II.Medium.NQueens;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NQueensTest {
    private static NQueens nQueens;
    private int n;

    @BeforeAll
    static void setInstance() {
        nQueens = new NQueens();
    }

    @BeforeEach
    void setUp() {
        n = 0;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNegativeAndZero() {
        assertEquals(new ArrayList<>(), nQueens.nquees(n));
        n = -1;
        assertEquals(new ArrayList<>(), nQueens.nquees(n));
    }

    @Test
    void testExamples() {
        n = 4;
        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 3, 0, 2)),
                        new ArrayList<>(Arrays.asList(2, 0, 3, 1))
                )
        );
        assertEquals(expected, nQueens.nquees(n));

        n = 3;
        assertEquals(new ArrayList<>(), nQueens.nquees(n));
    }
}