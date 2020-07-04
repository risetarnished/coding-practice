package coollime.queueandstack.sortwithtwostacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortWith2StacksTest {
  private static Solution sut;
  private LinkedList<Integer> s1;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    s1 = new LinkedList<>();
  }

  @Test
  void shouldNotSortWhenTheStackIsNull() {
    s1 = null;
    sut.sort(s1);
    assertNull(s1);
  }

  @Test
  void shouldNotSortWhenTheStackIsEmpty() {
    s1 = new LinkedList<>();
    sut.sort(s1);
    assertEquals(new LinkedList<>(), s1);
  }

  @Test
  void shouldSortTheElementsInTheStack() {
    s1.addAll(Arrays.asList(3, 2, 4, 1, 5));
    sut.sort(s1);
    assertEquals(new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5)), s1);

    s1.clear();
    s1.addAll(Arrays.asList(4, 2, 1, 1, 3, 2));
    sut.sort(s1);
    assertEquals(new LinkedList<>(Arrays.asList(1, 1, 2, 2, 3, 4)), s1);
  }
}
