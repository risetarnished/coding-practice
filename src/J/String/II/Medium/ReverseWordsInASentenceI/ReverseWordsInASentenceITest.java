package J.String.II.Medium.ReverseWordsInASentenceI;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsInASentenceITest {
    private static ReverseWordsInASentenceI reverseWordsInASentence;
    private String input;

    @BeforeAll
    static void setInstance() {
        reverseWordsInASentence = new ReverseWordsInASentenceI();
    }

    @BeforeEach
    void setUp() {
        input = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNullAndEmpty() {
        assertEquals(input, reverseWordsInASentence.reverseWords(input));
        input = "";
        assertEquals(input, reverseWordsInASentence.reverseWords(input));
        input = "a";
        assertEquals(input, reverseWordsInASentence.reverseWords(input));
    }

    @Test
    void testExamples() {
        input = "I love Google";
        assertEquals("Google love I", reverseWordsInASentence.reverseWords(input));
        input = "A B C D";
        assertEquals("D C B A", reverseWordsInASentence.reverseWords(input));
    }
}
