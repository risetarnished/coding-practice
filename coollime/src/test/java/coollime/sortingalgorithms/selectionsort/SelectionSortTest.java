package coollime.sortingalgorithms.selectionsort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SelectionSortTest {
  private static Solution sut;

  @BeforeEach
  void setUp() {
    sut = new Solution();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void shouldNotSortTheArrayIfItIsNull() {
    int[] result = sut.sort(null);
    assertArrayEquals(null, result);
  }

  @Test
  void shouldNotSortTheArrayIfItIsEmpty() {
    int[] result = sut.sort(new int[] {});
    assertArrayEquals(new int[] {}, result);
  }

  @Test
  void shouldSortTheArray() {
    int[] result = sut.sort(new int[] { 1 });
    assertArrayEquals(new int[] { 1 }, result);

    result = sut.sort(new int[] { 1, 2, 3 });
    assertArrayEquals(new int[] { 1, 2, 3 }, result);

    result = sut.sort(new int[] { 3, 2, 1 });
    assertArrayEquals(new int[] { 1, 2, 3 }, result);

    result = sut.sort(new int[] { 4, 2, -3, 6, 1 });
    assertArrayEquals(new int[] { -3, 1, 2, 4, 6 }, result);
  }
}
