package coollime.binarysearch.firstoccurrence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FirstOccurrenceTest {
  private static Solution sut;

  @BeforeEach
  void setUp() {
    sut = new Solution();
  }

  @AfterEach
  void tearDown() {}

  @Test
  void shouldNotFindTargetWhenTheInputIsNull() {
    int result = sut.firstOccur(null, 0);
    assertEquals(-1, result);
  }

  @Test
  void shouldNotFindTargetWhenTheInputIsEmpty() {
    int result = sut.firstOccur(new int[] {}, 0);
    assertEquals(-1, result);
  }

  @Test
  void shouldNotFindTheTargetWhenItIsNotInTheArray() {
    int result = sut.firstOccur(new int[] { 1, 2, 3 }, 4);
    assertEquals(-1, result);
  }

  @Test
  void shouldFindTheTargetWhenItIsUnique() {
    int result = sut.firstOccur(new int[] { 1, 2, 3 }, 2);
    assertEquals(1, result);
  }

  @Test
  void shouldFindTheFirstTargetWhenThereAreMultipleOccurrences() {
    int result = sut.firstOccur(new int[] { 1, 2, 2, 2, 3 }, 2);
    assertEquals(1, result);
  }
}
