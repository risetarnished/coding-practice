package C.Recursion.Easy.FibonacciNumber;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciNumberTest {
    private FibonacciNumber instance;

    @BeforeEach
    void setUp() {
        instance = new FibonacciNumber();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testZero() {
        long result = instance.fibonacci(0);
        assertEquals(0, result);
    }

    @Test
    void testOne() {
        long result = instance.fibonacci(1);
        assertEquals(1, result);
    }

    @Test
    void testTwo() {
        long result = instance.fibonacci(2);
        assertEquals(1, result);
    }

    @Test
    void testThree() {
        long result = instance.fibonacci(3);
        assertEquals(2, result);
    }

    @Test
    void testSix() {
        long result = instance.fibonacci(6);
        assertEquals(8, result);
    }
}