package N.CrossTraining.IV.Medium.MaximumValuesOfSizeKSlidingWindows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaximumValuesOfSizeKSlidingWindowsTest {
  private static MaximumValuesOfSizeKSlidingWindows instance;
  private int[] array;
  private int k;

  @BeforeAll
  static void setInstance() {
    instance = new MaximumValuesOfSizeKSlidingWindows();
  }

  @BeforeEach
  void setUp() {
    array = null;
    k = 0;
  }

  @Test
  void maxWindows() {
    assertEquals(new ArrayList<>(), instance.maxWindows(array, k));

    array = new int[] {1, 2, 3, 2, 4, 2, 1};
    k = 3;
    List<Integer> expected = new ArrayList<>(Arrays.asList(3, 3, 4, 4, 4));
    assertEquals(expected, instance.maxWindows(array, k));

    array = new int[] {1};
    k = 1;
    expected = new ArrayList<>(Collections.singletonList(1));
    assertEquals(expected, instance.maxWindows(array, k));

    array = new int[] {2, 1};
    k = 1;
    expected = new ArrayList<>(Arrays.asList(2, 1));
    assertEquals(expected, instance.maxWindows(array, k));
  }
}