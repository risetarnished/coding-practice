package coollime.sortingalgorithms.mergesort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MergeSortTest {
  private static Solution sut;
  private int[] array;
  private List<Integer> list;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    array = null;
    list = null;
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void shouldNotSortTheArrayIfItIsNull() {
    int[] arrayResult = sut.mergeSort(array);
    assertArrayEquals(array, arrayResult);

    List<Integer> listResult = sut.mergeSort(list);
    assertEquals(new ArrayList<>(), listResult);
  }

  @Test
  void shouldNotSortTheArrayIfItIsEmpty() {
    array = new int[] {};
    int[] arrayResult = sut.mergeSort(array);
    assertArrayEquals(array, arrayResult);

    list = new ArrayList<>();
    List<Integer> listResult = sut.mergeSort(list);
    assertEquals(new ArrayList<>(), listResult);
  }

  @Test
  void shouldSortTheArray() {
    array = new int[] { 4, 2, -3, 6, 1 };
    int[] arrayResult = sut.mergeSort(array);
    assertArrayEquals(new int[] { -3, 1, 2, 4, 6 }, arrayResult);
    list = new ArrayList<>(Arrays.asList(4, 2, -3, 6, 1));
    List<Integer> listResult = sut.mergeSort(list);
    assertEquals(new ArrayList<>(Arrays.asList(-3, 1, 2, 4, 6)), listResult);
  }
}
