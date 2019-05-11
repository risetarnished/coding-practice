package N.CrossTraining.I.Medium.TwoSumPairI;

import java.util.*;

public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // Write your solution here
    List<List<Integer>> result = new ArrayList<>();
    if (array == null || array.length == 0) {
      return result;
    }
    // Use a HashMap to store the <remaining target, indexex of the current number> relationship
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      List<Integer> indexes = map.getOrDefault(array[i], new ArrayList<>());
      // If this number is one of the processed number's remaining target
      // They are a pair
      if (!indexes.isEmpty()) {
        for (int index : indexes) {
          result.add(new ArrayList<>(Arrays.asList(index, i)));
        }
      }
      // Add the current index to the current number's remaining target's indexes list
      int remain = target - array[i];
      List<Integer> otherIndexes = map.getOrDefault(remain, new ArrayList<>());
      otherIndexes.add(i);
      map.put(remain, otherIndexes);
    }
    return result;
  }
}