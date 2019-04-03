package Z.FreePractice.Easy.PalindromePermutation;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
  public boolean canPermutePalindrome(String input) {
    // Write your solution here
    // Corner cases according to the assumptions
    if (input == null) {
      return false;
    } else if (input.length() <= 1) {
      return true;
    }
    Map<Character, Integer> frequency = new HashMap<>();
    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
    }
    // For all letters in the input, if there is at most one letter that
    // has an odd number of occurrences ⇒ true
    int odd = 0;
    for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
      if (entry.getValue() % 2 != 0 && ++odd > 1) {
        return false;
      }
    }
    return true;
  }
}
