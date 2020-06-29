package coollime.binarysearch.searchinunknownsizedsortedarray;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SearchInUnknownSizedSortedArrayTest {
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
    int result = sut.search(null, 0);
    assertEquals(-1, result);
  }

  @Test
  void shouldNotFindTheTargetWhenTheArrayIsEmpty() {
    int result = sut.search(new Dictionary(new ArrayList<Integer>(0)), 0);
    assertEquals(-1, result);
  }

  @Test
  void shouldNotFindTheTargetWhenItIsNotInTheInput() {
    int result = sut.search(new Dictionary(new ArrayList<Integer>(Arrays.asList(1, 2, 5, 9, 12, 15))), 7);
    assertEquals(-1, result);
  }

  @Test
  void shouldNotFindTheTargetWhenItIsOutsideTheRange() {
    int result = sut.search(new Dictionary(new ArrayList<Integer>(Arrays.asList(1, 2, 5, 9, 12, 15))), 17);
    assertEquals(-1, result);
  }

  @Test
  // When the target is in the array
  void shouldFindTheTarget() {
    int result = sut.search(new Dictionary(new ArrayList<Integer>(Arrays.asList(1, 2, 5, 9, 11, 12, 15))), 5);
    assertEquals(2, result);
  }
}
