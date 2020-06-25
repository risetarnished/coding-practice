package tests.quicksort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuickSortTest {
  static QuickSort quickSort;

  @BeforeEach
  void setUp() {
    quickSort = new QuickSort();
  }

  @AfterEach
  void tearDown() {}

  @Test
  void testNull() {
    int[] result = quickSort.quickSort(null);
    assertArrayEquals(null, result);
  }

  @Test
  void testEmpty() {
    int[] result = quickSort.quickSort(new int[] {});
    assertArrayEquals(new int[] {}, result);
  }

  @Test
  void testOne() {
    int[] result = quickSort.quickSort(new int[] { 1 });
    assertArrayEquals(new int[] { 1 }, result);
  }

  @Test
  void testTwo() {
    int[] result = quickSort.quickSort(new int[] { 1, 2, 3 });
    assertArrayEquals(new int[] { 1, 2, 3 }, result);
  }

  @Test
  void testThree() {
    int[] result = quickSort.quickSort(new int[] { 3, 2, 1 });
    assertArrayEquals(new int[] { 1, 2, 3 }, result);
  }

  @Test
  void testFour() {
    int[] result = quickSort.quickSort(new int[] { 4, 2, -3, 6, 1 });
    assertArrayEquals(new int[] { -3, 1, 2, 4, 6 }, result);
  }
}
