package coollime.recursion.nqueens;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NQueensTest {
  private static Solution sut;
  private int n;

  @BeforeAll
  static void setInstance() {
    sut = new Solution();
  }

  @BeforeEach
  void setUp() {
    n = 0;
  }

  @AfterEach
  void tearDown() {}

  @Test
  void shouldNotReturnAnyResultWhenInputIsInvalid() {
    assertEquals(new ArrayList<>(), sut.nquees(n));
    n = -1;
    assertEquals(new ArrayList<>(), sut.nquees(n));
  }

  @Test
  void shouldReturnAllPossibleWays() {
    n = 4;
    List<List<Integer>> expected = new ArrayList<>(
      Arrays.asList(
        new ArrayList<>(Arrays.asList(1, 3, 0, 2)),
        new ArrayList<>(Arrays.asList(2, 0, 3, 1))
      )
    );
    assertEquals(expected, sut.nquees(n));

    n = 3;
    assertEquals(new ArrayList<>(), sut.nquees(n));
  }
}
