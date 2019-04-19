package H.DFS.II.Medium.AllSubsetsSizeOfK;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllSubsetsSizeOfKTest {
  private static AllSubsetsSizeOfK instance;
  private String set;
  private int k;

  @BeforeAll
  static void setInstance() {
    instance = new AllSubsetsSizeOfK();
  }

  @BeforeEach
  void setUp() {
    set = null;
    k = 0;
  }

  @Test
  void subSets() {
    assertEquals(new ArrayList<>(), instance.subSets(set, k));

    set = "";
    assertEquals(new ArrayList<>(Collections.singletonList("")), instance.subSets(set, k));

    set = "abcd";
    k = 2;
    List<String> expected = new ArrayList<>(Arrays.asList("ab", "ac", "ad", "bc", "bd", "cd"));
    List<String> actual = instance.subSets(set, k);
    assertEquals(expected,actual);
  }
}