package Z.FreePractice.Medium.PalindromePermutationII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromePermutationII {
  public List<String> generatePalindromes(String input) {
    // Write your solution here
    List<String> result = new ArrayList<>();
    if (input == null) {
      return result;
    }
    permutePalindromes(input.toCharArray(), 0, result);
    return result;
  }

  private void permutePalindromes(char[] array, int index,
                                  List<String> result) {
    // Base case: when letters for all positions have been picked
    if (index == array.length) {
      // Only keep the ones that are palindromes
      if (isPalindrome(array)) {
        result.add(new String(array));
      }
      return;
    }
    // For each index, pick one from [index + 1, end]
    // use a HashSet to deduplicate
    Set<Character> picked = new HashSet<>(array.length - index + 1);
    for (int i = index; i < array.length; i++) {
      if (picked.contains(array[i])) {
        continue;
      }
      // Put the candidate to the current position
      swap(array, index, i);
      picked.add(array[index]);
      // Go to the next index
      permutePalindromes(array, index + 1, result);
      // Restore to the previous state
      swap(array, index, i);
    }
  }

  private boolean isPalindrome(char[] array) {
    int n = array.length;
    for (int i = 0; i < n / 2; i++) {
      if (array[i] != array[n - 1 - i]) {
        return false;
      }
    }
    return true;
  }

  private void swap(char[] array, int left, int right) {
    char temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
