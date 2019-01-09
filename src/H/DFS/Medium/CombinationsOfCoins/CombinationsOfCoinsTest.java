package H.DFS.Medium.CombinationsOfCoins;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationsOfCoinsTest {
    private static CombinationsOfCoins combinationsOfCoins;
    private int target;
    private int[] coins;

    @BeforeAll
    static void setInstance() {
        combinationsOfCoins = new CombinationsOfCoins();
    }

    @BeforeEach
    void setUp() {
        target = 0;
        coins = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        // Make target valid
        target = 99;
        assertEquals(new ArrayList<>(), combinationsOfCoins.combinations(target, coins));
    }

    @Test
    void testEmpty() {
        // Make target valid
        target = 99;
        coins = new int[] {};
        assertEquals(new ArrayList<>(), combinationsOfCoins.combinations(target, coins));
    }

    @Test
    void testNegative() {
        // Make coins valid
        coins = new int[] {25, 10, 5, 1};
        assertEquals(new ArrayList<>(), combinationsOfCoins.combinations(target, coins));
    }

    @Test
    void test99Cents() {
        // Classical 99-cent problem
        // Not able to build the expected list because I'd rather to play a 膀胱局 than this crap
        // Just print the actual result out for reference
        target = 99;
        coins = new int[] {25, 10, 5, 1};
        List<List<Integer>> result = combinationsOfCoins.combinations(target, coins);
        System.out.println("99 Cents Problem result: \n" + result);
    }

    @Test
    void testSimple() {
        // Simpler test
        target = 4;
        coins = new int[] {2, 1};
        List<List<Integer>> result = combinationsOfCoins.combinations(target, coins);
        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(
                Arrays.asList(0, 4), Arrays.asList(1, 2), Arrays.asList(2, 0)
        ));
        System.out.println("Test target = " + target + ", and coins = " + Arrays.toString(coins));
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + result);
        assertEquals(expected, result);
    }
}
