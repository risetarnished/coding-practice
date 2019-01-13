package K.StringII.Hard.DecompressStringII;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecompressStringIITest {
    private static DecompressStringII decompressString;
    private String input;
    private String result;

    @BeforeAll
    static void setInstance() {
        decompressString = new DecompressStringII();
    }

    @BeforeEach
    void setUp() {
        input = null;
        result = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNullAndEmpty() {
        assertEquals(input, decompressString.decompress(input));
        input = "";
        assertEquals(input, decompressString.decompress(input));
    }

    @Test
    void testExamples() {
        input = "a1c0b2c4";
        result = decompressString.decompress(input);
        printInfo(input, result);
        assertEquals("abbcccc", result);

        input = "x2y0i0z3";
        result = decompressString.decompress(input);
        printInfo(input, result);
        assertEquals("xxzzz", result);
    }

    private void printInfo(String input, String output) {
        System.out.format("%s is decompressed to %s\n", input, output);
    }
}