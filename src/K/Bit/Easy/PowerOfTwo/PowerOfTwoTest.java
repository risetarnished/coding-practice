package K.Bit.Easy.PowerOfTwo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfTwoTest {
    private static PowerOfTwo powerOfTwo;
    private int number;

    @BeforeAll
    static void setInstance() {
        powerOfTwo = new PowerOfTwo();
    }

    @BeforeEach
    void setUp() {
        number = 0;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testInvalid() {
        assertFalse(powerOfTwo.isPowerOfTwo(-1));
    }

    @Test
    void testExample() {
        assertFalse(powerOfTwo.isPowerOfTwo(0));
        assertFalse(powerOfTwo.isPowerOfTwoAlt(0));
        assertTrue(powerOfTwo.isPowerOfTwo(2));
        assertTrue(powerOfTwo.isPowerOfTwoAlt(2));
        assertFalse(powerOfTwo.isPowerOfTwo(13));
        assertFalse(powerOfTwo.isPowerOfTwoAlt(13));
        assertTrue(powerOfTwo.isPowerOfTwo(512));
        assertTrue(powerOfTwo.isPowerOfTwoAlt(512));
    }
}