package coollime.binarysearch.search.findminimuminrotatedsortedarray;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FindMinimumInRotatedSortedArrayTest {
  private static Solution sut;
  private int[] nums;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    nums = null;
  }

  @Test
  void shouldNotFindTheTargetWhenTheArrayIsNull() {
    int result = sut.findMin(nums);
    assertEquals(-1, result);
  }

  @Test
  void shouldNotFindTheTargetWhenTheArrayIsEmpty() {
    int result = sut.findMin(new int[] {});
    assertEquals(-1, result);
  }

  @Test
  void shouldFindTheMin() {
    nums = new int[] { 0 };
    assertEquals(0, sut.findMin(nums));

    nums = new int[] { 1, 2, 3, 4, 5 };
    assertEquals(1, sut.findMin(nums));

    nums = new int[] { 2, 3, 4, 5, 1 };
    assertEquals(1, sut.findMin(nums));

    nums = new int[] { 3, 4, 5, 1, 2 };
    assertEquals(1, sut.findMin(nums));

    nums = new int[] { 5, 1, 2, 3, 4 };
    assertEquals(1, sut.findMin(nums));
  }
}
