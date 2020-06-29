package coollime.sortingalgorithms.movezerostotheendi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Move0sToTheEndITest {
  static Solution sut;

  @BeforeEach
  void setUp() {
    sut = new Solution();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void shouldNotMoveZerosWhenInputIsNull() {
    int[] result = sut.moveZero(null);
    assertArrayEquals(null, result);

    int[] resultKeptOrder = sut.moveZeroPreservePosition(null);
    assertArrayEquals(null, resultKeptOrder);
  }

  @Test
  void shouldNotMoveZerosWhenInputIsEmpty() {
    int[] result = sut.moveZero(new int[] {});
    assertArrayEquals(new int[] {}, result);

    int[] resultKeptOrder = sut.moveZeroPreservePosition(new int[] {});
    assertArrayEquals(new int[] {}, resultKeptOrder);
  }

  @Test
  void testOne() {
    int[] result = sut.moveZero(new int[] { 1 });
    assertArrayEquals(new int[] { 1 }, result);
    int[] resultKeptOrder = sut.moveZeroPreservePosition(new int[] { 1 });
    assertArrayEquals(new int[] { 1 }, resultKeptOrder);
  }

  @Test
  void shouldMoveZerosToTheEnd() {
    int[] result = sut.moveZero(new int[] { 1, 0, 3, 0, 1 });
    assertArrayEquals(new int[] { 1, 1, 3, 0, 0 }, result);

    result = sut.moveZero(new int[] { 0, 0, 1, 1, 0, 1, 0 });
    assertArrayEquals(new int[] { 1, 1, 1, 0, 0, 0, 0 }, result);

    int[] resultKeptOrder = sut.moveZeroPreservePosition(new int[] { 1, 0, 3, 0, 1 });
    assertArrayEquals(new int[] { 1, 3, 1, 0, 0 }, resultKeptOrder);

    resultKeptOrder = sut.moveZeroPreservePosition(new int[] { 0, 0, 1, 1, 0, 1, 0 });
    assertArrayEquals(new int[] { 1, 1, 1, 0, 0, 0, 0 }, resultKeptOrder);
  }
}
