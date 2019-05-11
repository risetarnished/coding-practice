package N.CrossTraining.I.Medium.TwoSumPairI;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  private static Solution solution;
  private int[] array;
  private int target;

  @BeforeAll
  static void setInstance() {
    solution = new Solution();
  }

  @BeforeEach
  void setUp() {
    array = null;
    target = 0;
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void allPairs() {
    assertEquals(new ArrayList<>(), solution.allPairs(array, target));

    array = new int[] {1, 3, 2, 4};
    target = 5;
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(new ArrayList<>(Arrays.asList(1, 2)));
    expected.add(new ArrayList<>(Arrays.asList(0, 3)));
    assertEquals(expected, solution.allPairs(array, target));

    array = new int[] {3, 5, 3, 2, 4, 4};
    target = 7;
    expected.clear();
    expected.add(new ArrayList<>(Arrays.asList(1, 3)));
    expected.add(new ArrayList<>(Arrays.asList(0, 4)));
    expected.add(new ArrayList<>(Arrays.asList(2, 4)));
    expected.add(new ArrayList<>(Arrays.asList(0, 5)));
    expected.add(new ArrayList<>(Arrays.asList(2, 5)));
    assertEquals(expected, solution.allPairs(array, target));
  }
}