package coollime.recursion.fibonaccinumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FibonacciNumberTest {
  private static Solution sut;

  @BeforeAll
  static void setUp() {
    sut = new Solution();
  }

  @AfterEach
  void tearDown() {}

  @Test
  void shouldReturnCorrectFibonacciNumber() {
    long result = sut.fibonacci(0);
    assertEquals(0, result);

    result = sut.fibonacci(1);
    assertEquals(1, result);

    result = sut.fibonacci(2);
    assertEquals(1, result);

    result = sut.fibonacci(3);
    assertEquals(2, result);

    result = sut.fibonacci(6);
    assertEquals(8, result);
  }
}
