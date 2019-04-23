package N.CrossTraining.VI.Medium.LongestAscendingSubsequence;

public class LongestAscendingSubsequence {
  public int longest(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    // longest[i] represents the length of the longest ascending subsequence
    // that ends at index i
    int[] longest = new int[array.length];
    longest[0] = 1;
    // Keep a record of the largest length among all for result
    int maxLen = 1;
    // For the element at index i, compare its previous elements at index j
    // where j is in (i, 1] and array[j] < array[i]
    // longest[i] = max(longest[j]) + 1
    for (int i = 1; i < array.length; i++) {
      longest[i] = 1;
      for (int j = i - 1; j >= 0; j--) {
        if (array[i] > array[j]) {
          longest[i] = Math.max(longest[i], longest[j] + 1);
        }
      }
      maxLen = Math.max(maxLen, longest[i]);
    }
    return maxLen;
  }
}
