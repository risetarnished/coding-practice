package H.DFS.Medium.AllValidPermutationsOfParenthesesI;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllValidPermutationsOfParenthesesITest {
    private static AllValidPermutationsOfParenthesesI allParentheses;
    private int n;

    @BeforeAll
    static void setInstance() {
        allParentheses = new AllValidPermutationsOfParenthesesI();
    }

    @BeforeEach
    void setUp() {
        n = 0;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNegative() {
        n = -1;
        assertEquals(new ArrayList<>(), allParentheses.validParentheses(n));
    }

    @Test
    void testZero() {
        assertEquals(new ArrayList<>(), allParentheses.validParentheses(n));
    }

    @Test
    void testOne() {
        n = 1;
        List<String> result = allParentheses.validParentheses(n);
        List<String> expected = new ArrayList<>(Collections.singletonList("()"));
        System.out.println("Test number of () pairs: " + n);
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + result);
        assertEquals(expected, result);
    }

    @Test
    void testThree() {
        n = 3;
        List<String> result = allParentheses.validParentheses(n);
        List<String> expected = new ArrayList<>(Arrays.asList(
                "((()))", "(()())", "(())()", "()(())", "()()()"
        ));
        System.out.println("Test number of () pairs: " + n);
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + result);
        assertEquals(expected, result);
    }
}
