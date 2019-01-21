package M.DynamicProgramming.II.Medium.EditDistance;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditDistanceTest {
    private static EditDistance editDistance;
    private String one, two;

    @BeforeAll
    static void setInstance() {
        editDistance = new EditDistance();
    }

    @BeforeEach
    void setUp() {
        one = null;
        two = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNullAndEmpty() {
        assertEquals(-1, editDistance.editDistance(one, two));
        one = "";
        assertEquals(-1, editDistance.editDistance(one, two));
    }

    @Test
    void testExamples() {
        one = "sigh";
        two = "asith";
        assertEquals(2, editDistance.editDistance(one, two));

        one = "abcde";
        two = "fghij";
        assertEquals(5, editDistance.editDistance(one, two));
    }
}