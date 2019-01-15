package L.Bit.Easy.HexadecimalRepresentation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HexadecimalRepresentationTest {
    private static HexadecimalRepresentation hexadecimalRepresentation;

    @BeforeAll
    static void setInstance() {
        hexadecimalRepresentation = new HexadecimalRepresentation();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test() {
        assertEquals("0x0", hexadecimalRepresentation.hex(0));
        assertEquals("0xFF", hexadecimalRepresentation.hex(255));
        assertEquals("0xF", hexadecimalRepresentation.hex(15));
    }
}