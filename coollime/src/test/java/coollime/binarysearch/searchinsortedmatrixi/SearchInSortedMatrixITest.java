package coollime.binarysearch.searchinsortedmatrixi;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SearchInSortedMatrixITest {
  private static Solution sut;

  @BeforeAll
  static void setUp() {
    sut = new Solution();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void shouldNotFindTheTargetWhenTheArrayIsNull() {
    int[] result = sut.search(null, 0);
    assertArrayEquals(new int[] { -1, -1 }, result);
  }

  @Test
  void shouldNotFindTheTargetWhenTheArrayIsEmpty() {
    int[] result = sut.search(new int[][] {}, 0);
    assertArrayEquals(new int[] { -1, -1 }, result);
  }

  @Test
  void shouldNotFindTheTargetWhenItIsNotInTheInput() {
    int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 7 }, { 8, 9, 10 } };
    int[] result = sut.search(matrix, 6);
    assertArrayEquals(new int[] { -1, -1 }, result);
  }

  @Test
  void shouldFindTheTarget() {
    int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 7 }, { 8, 9, 10 } };
    int[] result = sut.search(matrix, 7);
    assertArrayEquals(new int[] { 1, 2 }, result);
  }
}
