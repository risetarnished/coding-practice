package N.CrossTraining.I.Medium.ThreeSum;

import java.util.*;

public class Solution {
  public List<List<Integer>> allTriples(int[] array, int target) {
    // Write your solution here
    List<List<Integer>> result = new ArrayList<>();
    if (array == null || array.length <= 2) {
      return result;
    }
    // Sort the array to avoid duplicate easily
    Arrays.sort(array);
    // Use three pointers, i, j, k which point to the three triplets
    for (int i = 0; i < array.length; i++) {
      // [i] is fixed to be the first element in the potential triplet
      // So, skip any duplicate that have been checked already
      if (i > 0 && array[i] == array[i - 1]) {
        continue;
      }
      int start = i + 1;
      int end = array.length - 1;
      // Check until there are less than 2 elements left
      int diff = target - array[i];
      while (start < end) {
        if (array[start] + array[end] == diff) {
          result.add(new ArrayList<>(Arrays.asList(array[i], array[start], array[end])));
          // Increment start and skip any duplicate
          while (start < array.length - 1 && array[start] == array[start + 1]) {
            start++;
          }
          start++;
        } else if (array[start] + array[end] < diff) {
          // Increment start to make it greater
          while (start < array.length - 1 && array[start] == array[start + 1]) {
            start++;
          }
          start++;
        } else {
          // Decrement end to make it smaller
          while (end > 0 && array[end] == array[end - 1]) {
            end--;
          }
          end--;
        }
      }
    }
    return result;
  }


  /**
   * This method along with the next private method are doing nested TwoSum to solve the problem
   */
  public List<List<Integer>> allTriplesUsingTwoSum(int[] array, int target) {
    // Write your solution here
    List<List<Integer>> result = new ArrayList<>();
    if (array == null || array.length == 0) {
      return result;
    }
    // Since we are going to do a nested two sum process which costs O(n^2)
    // It does not matter that much if we sort the array first in order to
    // simplify the de-duplication process
    Arrays.sort(array);
    // Do a TwoSum for the target on each element in the array
    // while getting the differences, use the differences as new
    // targets and do TwoSums for the new targets
    for (int i = 0; i < array.length; i++) {
      // Skip the element if it is a repeat of the previous element
      if (i > 0 && array[i] == array[i - 1]) {
        continue;
      }
      // Do a two sum process with the current diff as target
      List<List<Integer>> current = twoSum(array, target - array[i], i);
      if (!current.isEmpty()) {
        result.addAll(current);
      }
    }
    return result;
  }

  /**
   * Given the target number, find two elements in the array that sums up to the target
   *
   * @param array The input array
   * @param target The target sum
   * @param index The index in the input that should be skipped
   * @return A List of Lists of pairs that sums up to the target
   */
  private List<List<Integer>> twoSum(int[] array, int target, int index) {
    // Inputs are guaranteed to be valid
    List<List<Integer>> result = new ArrayList<>();
    // Set stores the corresponding pair that has occurred
    Set<Integer> set = new HashSet<>();
    for (int i = index; i < array.length; i++) {
      List<Integer> triple = new ArrayList<>();
      if (set.contains(target - array[i])) {
        triple.add(array[index]);
        triple.add(target - array[i]);
        triple.add(array[i]);
        result.add(triple);
      }
      set.add(array[i]);
    }
    return result;
  }
}
