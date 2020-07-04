package coollime.queueandstack.stackwithmin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackWithMinTest {
  private static Solution stack;

  @BeforeEach
  void setUp() {
    stack = new Solution();
  }

  @AfterEach
  void tearDown() {}

  @Test
  void test() {
    assertNotNull(stack);
    assertEquals(-1, stack.top());
    stack.push(3);
    stack.push(4);
    stack.push(2);
    stack.push(2);
    stack.push(2);
    stack.push(1);
    assertEquals(1, stack.min());
    assertEquals(1, stack.pop());
    assertEquals(2, stack.pop());
    assertEquals(2, stack.pop());
    assertEquals(2, stack.top());
    assertEquals(2, stack.min());
    assertEquals(2, stack.pop());
    assertEquals(3, stack.min());
    assertEquals(4, stack.top());
  }
}
