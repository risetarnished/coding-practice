package coollime.sortingalgorithms.rainbowsort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RainbowSortTest {
  private static Solution sut;
  private int[] array;

  @BeforeAll
  static void setInstance() {
    sut = new Solution();
  }

  @BeforeEach
  void setUp() {
    array = null;
  }

  @Test
  void shouldNotSortTheArrayIfItIsNull() {
    int[] result = sut.rainbowSort(array);
    assertArrayEquals(array, result);
  }

  @Test
  void shouldNotSortTheArrayIfItIsEmpty() {
    array = new int[] {};
    int[] result = sut.rainbowSort(array);
    assertArrayEquals(array, result);
  }

  @Test
  void shouldSortTheArray() {
    array = new int[] { 1 };
    assertArrayEquals(array, sut.rainbowSort(array));

    array = new int[] { 1, 0 };
    assertArrayEquals(new int[] { 0, 1 }, sut.rainbowSort(array));

    array = new int[] { 1, 0, 1, -1, 0 };
    assertArrayEquals(new int[] { -1, 0, 0, 1, 1 }, sut.rainbowSort(array));

    array = new int[] { 1, 1, 0, -1, 0, 1, -1 };
    assertArrayEquals(new int[] { -1, -1, 0, 0, 1, 1, 1 }, sut.rainbowSort(array));
  }
}
