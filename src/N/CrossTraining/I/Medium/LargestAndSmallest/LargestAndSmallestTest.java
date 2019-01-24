package N.CrossTraining.I.Medium.LargestAndSmallest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestAndSmallestTest {
    private static LargestAndSmallest largestAndSmallest;
    private int[] array;

    @BeforeAll
    static void setInstance() {
        largestAndSmallest = new LargestAndSmallest();
    }

    @BeforeEach
    void setUp() {
        array = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void largestAndSmallest() {
        assertArrayEquals(new int[] {}, largestAndSmallest.largestAndSmallest(array));
        array = new int[] {};
        assertArrayEquals(new int[] {}, largestAndSmallest.largestAndSmallest(array));

        array = new int[] {2, 1, 5, 4, 3};
        assertArrayEquals(new int[] {5, 1}, largestAndSmallest.largestAndSmallest(array));

        array = new int[] {3, 3, 3, 3, 3};
        assertArrayEquals(new int[] {3, 3}, largestAndSmallest.largestAndSmallest(array));
    }
}