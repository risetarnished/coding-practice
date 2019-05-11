package N.CrossTraining.I.Easy.TwoSum;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public boolean existSum(int[] array, int target) {
    // Write your solution here
    if (array ==  null || array.length == 0) {
      return false;
    }
    // Use a set that stores the corresponding pair number of the
    // current number that is being processed
    // target - current number = corresponding pair
    Set<Integer> set = new HashSet<>(array.length);
    for (int i = 0; i < array.length; i++) {
      if (set.contains(array[i])) {
        return true;
      }
      set.add(target - array[i]);
    }
    return false;
  }
}
