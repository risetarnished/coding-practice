package coollime.queueandstack.queuebytwostacks;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueByTwoStacksTest {
  private static Solution queue;

  @BeforeEach
  void setUp() {
    queue = new Solution();
  }

  @AfterEach
  void tearDown() {}

  @Test
  void test() {
    assertAll(
      "offer and test the rest",
      () -> {
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertNotNull(queue);
        assertAll(
          "test all features",
          () -> assertFalse(queue.isEmpty()),
          () -> assertEquals(3, queue.size()),
          () -> assertEquals(Integer.valueOf(1), queue.poll()),
          () -> assertEquals(Integer.valueOf(2), queue.peek()),
          () -> assertEquals(2, queue.size()),
          () -> assertEquals(Integer.valueOf(2), queue.poll()),
          () -> assertEquals(Integer.valueOf(3), queue.poll()),
          () -> assertTrue(queue.isEmpty())
        );
      }
    );
  }
}
