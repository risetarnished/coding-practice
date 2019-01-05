package D.QueueAndStack.Medium.QueueByTwoStacks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueByTwoStacksTest {
    private static QueueByTwoStacks queue;

    @BeforeAll
    static void setQueue() {
        queue = new QueueByTwoStacks();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test() {
        assertAll("offer and test the rest",
                () -> {
                    queue.offer(1);
                    queue.offer(2);
                    queue.offer(3);
                    assertNotNull(queue);
                    assertAll("test all features",
                            () -> assertFalse(queue.isEmpty()),
                            () -> assertEquals(3, queue.size()),
                            () -> assertEquals(Integer.valueOf(1), queue.poll()),
                            () -> assertEquals(Integer.valueOf(2), queue.peek()),
                            () -> assertEquals(2, queue.size()),
                            () -> assertEquals(Integer.valueOf(2), queue.poll()),
                            () -> assertEquals(Integer.valueOf(3), queue.poll()),
                            () -> assertTrue(queue.isEmpty()));
                }
        );
    }

    /*
    @Test
    void test() {
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertFalse(queue.isEmpty());
        assertEquals(3, queue.size());
        assertEquals(Integer.valueOf(1), queue.poll());
        assertEquals(Integer.valueOf(2), queue.peek());
        assertEquals(2, queue.size());
        assertEquals(Integer.valueOf(2), queue.poll());
        assertEquals(Integer.valueOf(3), queue.poll());
        assertTrue(queue.isEmpty());
    }
    */
}