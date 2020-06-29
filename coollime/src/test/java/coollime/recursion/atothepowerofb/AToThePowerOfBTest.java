package coollime.recursion.atothepowerofb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AToThePowerOfBTest {
  private static Solution sut;

  @BeforeAll
  static void setUp() {
    sut = new Solution();
  }

  @AfterEach
  void tearDown() {}

  @Test
  void shouldReturnOneIfRaisedToPowerOfZero() {
    long result = sut.power(2, 0);
    assertEquals(1, result);
    long naiveResult = sut.naivePower(2, 0);
    assertEquals(1, naiveResult);
  }

  @Test
  void shouldReturnTheSameNumberIfRaisedToPowerOfOne() {
    long result = sut.power(2, 1);
    assertEquals(2, result);
    long naiveResult = sut.naivePower(2, 1);
    assertEquals(2, naiveResult);
  }

  @Test
  void shouldReturnTheCorrectResult() {
    long result = sut.power(2, 2);
    assertEquals(4, result);
    long naiveResult = sut.naivePower(2, 2);
    assertEquals(4, naiveResult);

    result = sut.power(0, 10);
    assertEquals(0, result);
    naiveResult = sut.naivePower(0, 10);
    assertEquals(0, naiveResult);

    result = sut.power(-2, 5);
    assertEquals(-32, result);

    naiveResult = sut.naivePower(-2, 5);
    assertEquals(-32, naiveResult);
  }
}
