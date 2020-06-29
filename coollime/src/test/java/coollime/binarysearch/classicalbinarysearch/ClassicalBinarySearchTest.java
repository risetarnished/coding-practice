package coollime.binarysearch.classicalbinarysearch;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClassicalBinarySearchTest {
  private static Solution sut;
  int[] arrayOne;
  int[] arrayTwo;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    arrayOne = new int[] { 1, 2, 3, 4, 5 };
    arrayTwo = new int[] { 1, 2, 2, 2, 3, 4 };
  }

  @Test
  void shouldNotFindTheTargetWhenTheArrayIsNull() {
    int result = sut.binarySearch(null, 0);
    assertEquals(-1, result);
  }

  @Test
  void shouldNotFindTheTargetWhenTheArrayIsEmpty() {
    int result = sut.binarySearch(new int[] {}, 0);
    assertEquals(-1, result);
  }

  @Test
  void shouldNotFindTheTargetWhenItIsNotPresentInTheArray() {
    int result = sut.binarySearch(arrayOne, 6);
    assertEquals(-1, result);
  }

  @Test
  void shouldFindTheTargetWhenItIsPresentInTheArray() {
    int result = sut.binarySearch(arrayOne, 3);
    assertEquals(2, result);
    result = sut.binarySearch(arrayTwo, 2);
    assertEquals(2, result);
  }
}
