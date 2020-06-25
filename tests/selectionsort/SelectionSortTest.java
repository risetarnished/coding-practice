package tests.selectionsort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SelectionSortTest {
  static SelectionSort selectionSort;

  @BeforeEach
  void setUp() {
    selectionSort = new SelectionSort();
  }

  @AfterEach
  void tearDown() {}

  @Test
  void testNull() {
    int[] result = selectionSort.sort(null);
    assertArrayEquals(null, result);
  }

  @Test
  void testEmpty() {
    int[] result = selectionSort.sort(new int[] {});
    assertArrayEquals(new int[] {}, result);
  }

  @Test
  void testOne() {
    int[] result = selectionSort.sort(new int[] { 1 });
    assertArrayEquals(new int[] { 1 }, result);
  }

  @Test
  void testTwo() {
    int[] result = selectionSort.sort(new int[] { 1, 2, 3 });
    assertArrayEquals(new int[] { 1, 2, 3 }, result);
  }

  @Test
  void testThree() {
    int[] result = selectionSort.sort(new int[] { 3, 2, 1 });
    assertArrayEquals(new int[] { 1, 2, 3 }, result);
  }

  @Test
  void testFour() {
    int[] result = selectionSort.sort(new int[] { 4, 2, -3, 6, 1 });
    assertArrayEquals(new int[] { -3, 1, 2, 4, 6 }, result);
  }
}
