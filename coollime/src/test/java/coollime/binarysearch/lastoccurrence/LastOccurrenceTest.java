package coollime.binarysearch.lastoccurrence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LastOccurrenceTest {
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
    int result = sut.lastOccur(null, 0);
    assertEquals(-1, result);
  }

  @Test
  void shouldNotFindTheTargetWhenTheArrayIsEmpty() {
    int result = sut.lastOccur(new int[] {}, 0);
    assertEquals(-1, result);
  }

  @Test
  void shouldNotFindTheTargetWhenItIsNotPresentInTheArray() {
    int result = sut.lastOccur(new int[] { 1, 2, 3 }, 4);
    assertEquals(-1, result);
  }

  @Test
  void shouldFindTheUniqueTarget() {
    int result = sut.lastOccur(new int[] { 1, 2, 3 }, 2);
    assertEquals(1, result);
  }

  @Test
  void shouldFindTheLastOccurrenceWhenThereAreMultipleOccurrence() {
    int result = sut.lastOccur(new int[] { 1, 2, 2, 2, 3 }, 2);
    assertEquals(3, result);
  }
}
