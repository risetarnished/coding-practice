package Z.FreePractice.Easy.PalindromePermutation;

import static org.junit.jupiter.api.Assertions.*;

class PalindromePermutationTest {
  private static PalindromePermutation instance;
  private String input;

  @org.junit.jupiter.api.BeforeAll
  static void setInstance() {
    instance = new PalindromePermutation();
  }

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    input = null;
  }

  @org.junit.jupiter.api.AfterEach
  void tearDown() {
  }

  @org.junit.jupiter.api.Test
  void canPermutePalindrome() {
    assertFalse(instance.canPermutePalindrome(input));

    input = "";
    assertTrue(instance.canPermutePalindrome(input));

    input = "code";
    assertFalse(instance.canPermutePalindrome(input));

    input = "aab";
    assertTrue(instance.canPermutePalindrome(input));
  }
}