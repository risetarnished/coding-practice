package N.CrossTraining.I.Medium.TwoSumPairII;

import java.util.*;

public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // Write your solution here
    List<List<Integer>> result = new ArrayList<>();
    if (array == null || array.length == 0) {
      return result;
    }
    Set<Integer> occurred = new HashSet<>();
    Set<Integer> inResult = new HashSet<>();
    for (int i = 0; i < array.length; i++) {
      // Avoid duplicate pairs being added to the result
      if (inResult.contains(array[i])) {
        continue;
      }
      int diff = target - array[i];
      if (occurred.contains(diff)) {
        result.add(new ArrayList<>(Arrays.asList(array[i], diff)));
        // Add both of them to set 2
        inResult.add(array[i]);
        inResult.add(diff);
      }
      // The current element has occurred
      occurred.add(array[i]);
    }
    return result;
  }
}