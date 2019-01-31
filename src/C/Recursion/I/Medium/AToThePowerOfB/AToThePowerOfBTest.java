package C.Recursion.I.Medium.AToThePowerOfB;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AToThePowerOfBTest {
    private static AToThePowerOfB instance;

    @BeforeEach
    void setUp() {
        instance = new AToThePowerOfB();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testZero() {
        long result = instance.power(2, 0);
        assertEquals(1, result);
        long naiveResult = instance.naivePower(2, 0);
        assertEquals(1, naiveResult);
    }

    @Test
    void testOne() {
        long result = instance.power(2, 1);
        assertEquals(2, result);
        long naiveResult = instance.naivePower(2, 1);
        assertEquals(2, naiveResult);
    }

    @Test
    void testTwo() {
        long result = instance.power(2, 2);
        assertEquals(4, result);
        long naiveResult = instance.naivePower(2, 2);
        assertEquals(4, naiveResult);
    }

    @Test
    void testZeroPower() {
        long result = instance.power(0, 10);
        assertEquals(0, result);
        long naiveResult = instance.naivePower(0, 10);
        assertEquals(0, naiveResult);
    }

    @Test
    void testNegative() {
        long result = instance.power(-2, 5);
        assertEquals(-32, result);
        long naiveResult = instance.naivePower(-2, 5);
        assertEquals(-32, naiveResult);
    }
}
