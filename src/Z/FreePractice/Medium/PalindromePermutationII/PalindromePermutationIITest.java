package Z.FreePractice.Medium.PalindromePermutationII;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromePermutationIITest {
  private static PalindromePermutationII instance;
  private String input;

  @BeforeAll
  static void setInstance() {
    instance = new PalindromePermutationII();
  }

  @BeforeEach
  void setUp() {
    input = null;
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void generatePalindromes() {
    assertEquals(new ArrayList<>(), instance.generatePalindromes(input));

    input = "";
    assertEquals(new ArrayList<>(Collections.singletonList("")), instance.generatePalindromes(input));

    input = "aabb";
    assertEquals(new ArrayList<>(Arrays.asList("abba", "baab")), instance.generatePalindromes(input));

    input = "abc";
    assertEquals(new ArrayList<>(), instance.generatePalindromes(input));
  }
}