package N.CrossTraining.I.Medium.LargestAndSecondLargest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestAndSecondLargestTest {
    private static LargestAndSecondLargest largestAndSecondLargest;
    private int[] array;

    @BeforeAll
    static void setInstance() {
        largestAndSecondLargest = new LargestAndSecondLargest();
    }

    @BeforeEach
    void setUp() {
        array = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void largestAndSecond() {
        assertArrayEquals(new int[] {}, largestAndSecondLargest.largestAndSecond(array));
        array = new int[] {};
        assertArrayEquals(new int[] {}, largestAndSecondLargest.largestAndSecond(array));

        array = new int[] {2 ,1, 5, 4, 3};
        assertArrayEquals(new int[] {5, 4}, largestAndSecondLargest.largestAndSecond(array));

        array = new int[] {3, 3, 3};
        assertArrayEquals(new int[] {3, 3}, largestAndSecondLargest.largestAndSecond(array));
    }
}