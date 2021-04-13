package coollime.binarysearch.closest.kclosest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class KClosestInSortedArrayTest {
  private static Solution sut;

  @BeforeAll
  static void setInstance() {
    sut = new Solution();
  }

  @Test
  void shouldNotFindTheResultWhenTheArrayIsNull() {
    int[] result = sut.kClosest(null, 1, 1);
    assertArrayEquals(new int[] {}, result);
  }

  @Test
  void shouldNotFindTheResultWhenTheArrayIsEmpty() {
    int[] result = sut.kClosest(new int[] {}, 1, 1);
    assertArrayEquals(new int[] {}, result);
  }

  @Test
  void shouldFindTheResult() {
    int[] result = sut.kClosest(new int[] { 1, 2, 3 }, 2, 3);
    assertArrayEquals(new int[] { 2, 1, 3 }, result);

    result = sut.kClosest(new int[] { 1, 4, 6, 8 }, 3, 3);
    assertArrayEquals(new int[] { 4, 1, 6 }, result);
  }
}
