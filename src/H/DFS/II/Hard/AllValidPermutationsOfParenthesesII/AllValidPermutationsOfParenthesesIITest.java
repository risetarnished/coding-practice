package H.DFS.II.Hard.AllValidPermutationsOfParenthesesII;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllValidPermutationsOfParenthesesIITest {
  private static AllValidPermutationsOfParenthesesII instance;
  private int l, m, n;

  @BeforeAll
  static void setInstance() {
    instance = new AllValidPermutationsOfParenthesesII();
  }

  @BeforeEach
  void setUp() {
  }

  @Test
  void validParentheses() {
    assertEquals(new ArrayList<>(), instance.validParentheses(l, m, n));

    // Case 1: 1, 1, 0
    l = 1;
    m = 1;
    n = 0;
    List<String> expected = new ArrayList<>(Arrays.asList("()<>", "(<>)", "<()>", "<>()"));
    List<String> actual = instance.validParentheses(l, m, n);
    assertEquals(expected, actual);
  }
}