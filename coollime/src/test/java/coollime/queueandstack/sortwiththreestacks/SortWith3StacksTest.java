package coollime.queueandstack.sortwiththreestacks;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortWith3StacksTest {
  private static Solution sut;
  private LinkedList<Integer> s1;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    s1 = new LinkedList<>();
  }

  @AfterEach
  void tearDown() {}

  @Test
  void shouldNotSortWhenTheStackIsNull() {
    s1 = null;
    sut.sort(s1);
    assertNull(s1);
  }

  @Test
  void shouldNotSortWhenTheStackIsEmpty() {
    sut.sort(s1);
    assertEquals(new LinkedList<>(), s1);
  }

  @Test
  void shouldSortTheElementsInTheStack() {
    s1 = new LinkedList<>(Arrays.asList(4, 2, 1, 3));
    sut.sort(s1);
    int[] result = getElements(s1);
    assertArrayEquals(new int[] { 1, 2, 3, 4 }, result);

    s1 = new LinkedList<>(Arrays.asList(4, 2, -3, 6, 1));
    sut.sort(s1);
    result = getElements(s1);
    assertArrayEquals(new int[] { -3, 1, 2, 4, 6 }, result);
  }

  private int[] getElements(LinkedList<Integer> stack) {
    if (stack == null) {
      return null;
    } else if (stack.isEmpty()) {
      return new int[] {};
    }
    int size = stack.size();
    int[] result = new int[size];
    for (int i = 0; i < size; i++) {
      result[i] = stack.pollFirst();
    }
    return result;
  }
}
