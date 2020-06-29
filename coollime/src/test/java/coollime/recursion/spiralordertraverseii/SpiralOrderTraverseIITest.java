package coollime.recursion.spiralordertraverseii;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpiralOrderTraverseIITest {
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
  void shouldNotTraverseWhenTheMatrixIsInvalid() {
    assertEquals(new ArrayList<>(), sut.spiral(matrix));

    matrix = new int[][] {};
    assertEquals(new ArrayList<>(), sut.spiral(matrix));
  }

  @Test
  void shouldTraverseTheMatrix() {
    matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
    assertEquals(
      new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)),
      sut.spiral(matrix)
    );

    matrix =
      new int[][] { { 1, 2, 3 }, { 10, 11, 4 }, { 9, 12, 5 }, { 8, 7, 6 } };
    assertEquals(
      new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)),
      sut.spiral(matrix)
    );
  }
}
