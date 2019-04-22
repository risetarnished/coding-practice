package N.CrossTraining.IV.Hard.KthSmallestInTwoSortedArrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthSmallestInTwoSortedArraysTest {
  private static KthSmallestInTwoSortedArrays instance;
  private int[] a;
  private int[] b;
  private int k;

  @BeforeAll
  static void setInstance() {
    instance = new KthSmallestInTwoSortedArrays();
  }

  @BeforeEach
  void setUp() {
    a = null;
    b = null;
    k = 0;
  }

  @Test
  void kth() {
    assertEquals(Integer.MIN_VALUE, instance.kth(a, b, k));

    a = new int[] {1, 4, 6};
    b = new int[] {2, 3};
    k = 3;
    assertEquals(3, instance.kth(a, b, k));

    a = new int[] {1, 4, 5, 5, 8, 12, 12, 12};
    b = new int[] {2, 2, 3, 7, 9, 9, 9};
    k = 14;
    assertEquals(12, instance.kth(a, b, k));
  }

  @Test
  void kthImproved() {
    assertEquals(Integer.MIN_VALUE, instance.kthImproved(a, b, k));

    a = new int[] {1, 4, 6};
    b = new int[] {2, 3};
    k = 3;
    assertEquals(3, instance.kthImproved(a, b, k));

    a = new int[] {1, 4, 5, 5, 8, 12, 12, 12};
    b = new int[] {2, 2, 3, 7, 9, 9, 9};
    k = 14;
    assertEquals(12, instance.kthImproved(a, b, k));
  }
}