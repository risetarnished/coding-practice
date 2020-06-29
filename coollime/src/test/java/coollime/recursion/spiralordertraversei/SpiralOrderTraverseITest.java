package coollime.recursion.spiralordertraversei;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpiralOrderTraverseITest {
  private static Solution sut;
  private int[][] matrix;

  @BeforeAll
  static void setInstance() {
    sut = new Solution();
  }

  @BeforeEach
  void setUp() {
    matrix = null;
  }

  @AfterEach
  void tearDown() {}

  @Test
  void shouldNotTraverseWhenTheMatrixIsNotValid() {
    assertEquals(new ArrayList<>(), sut.spiral(matrix));

    matrix = new int[][] {};
    assertEquals(new ArrayList<>(), sut.spiral(matrix));
  }

  @Test
  void shouldTraverseTheMatrix() {
    matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    List<Integer> expected = new ArrayList<>(
      Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)
    );
    assertEquals(expected, sut.spiral(matrix));

    matrix =
      new int[][] {
        { 1, 2, 3, 4 },
        { 12, 13, 14, 5 },
        { 11, 16, 15, 6 },
        { 10, 9, 8, 7 },
      };
    expected =
      new ArrayList<>(
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
      );
    assertEquals(expected, sut.spiral(matrix));
  }
}
