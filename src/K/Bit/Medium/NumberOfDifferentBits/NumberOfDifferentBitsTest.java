package K.Bit.Medium.NumberOfDifferentBits;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfDifferentBitsTest {
    private static NumberOfDifferentBits numberOfDifferentBits;

    @BeforeAll
    static void setInstance() {
        numberOfDifferentBits = new NumberOfDifferentBits();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test() {
        assertEquals(3, numberOfDifferentBits.diffBits(5, 8));
        assertEquals(2, numberOfDifferentBits.diffBits(2, 4));
        assertEquals(1, numberOfDifferentBits.diffBits(-1, Integer.MAX_VALUE));
    }
}