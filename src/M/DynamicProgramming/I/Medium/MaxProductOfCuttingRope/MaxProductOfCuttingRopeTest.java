package M.DynamicProgramming.I.Medium.MaxProductOfCuttingRope;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxProductOfCuttingRopeTest {
    private static MaxProductOfCuttingRope maxProductOfCuttingRope;

    @BeforeAll
    static void setInstance() {
        maxProductOfCuttingRope = new MaxProductOfCuttingRope();
    }

    @Test
    void testCornerCases() {
        assertEquals(0, maxProductOfCuttingRope.maxProduct(0));
        assertEquals(0, maxProductOfCuttingRope.maxProductBetter(0));
        assertEquals(0, maxProductOfCuttingRope.maxProduct(1));
        assertEquals(0, maxProductOfCuttingRope.maxProductBetter(1));
    }

    @Test
    void testExamples() {
        assertEquals(4, maxProductOfCuttingRope.maxProduct(4));
        assertEquals(4, maxProductOfCuttingRope.maxProductBetter(4));
        assertEquals(6, maxProductOfCuttingRope.maxProduct(5));
        assertEquals(6, maxProductOfCuttingRope.maxProductBetter(5));
        assertEquals(81, maxProductOfCuttingRope.maxProduct(12));
        assertEquals(81, maxProductOfCuttingRope.maxProductBetter(12));
    }
}