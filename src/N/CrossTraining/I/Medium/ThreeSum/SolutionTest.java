package N.CrossTraining.I.Medium.ThreeSum;

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

  @Test
  void allTriples() {
    assertEquals(new ArrayList<>(), solution.allTriples(array, target));

    array = new int[] {1, 2, 2, 3, 2, 4};
    target = 8;
    List<List<Integer>> expected = new ArrayList<>(
        Arrays.asList(
            Arrays.asList(1, 3, 4),
            Arrays.asList(2, 2, 4)
        )
    );
    assertEquals(expected, solution.allTriples(array, target));

    array = new int[] {1, 1, 1};
    target = 3;
    expected = new ArrayList<>(Arrays.asList(Arrays.asList(1, 1, 1)));
    assertEquals(expected, solution.allTriples(array, target));
  }
}