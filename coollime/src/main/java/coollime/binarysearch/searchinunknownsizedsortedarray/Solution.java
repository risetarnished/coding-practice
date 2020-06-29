package coollime.binarysearch.searchinunknownsizedsortedarray;

/**
 * You do not need to implement the Dictionary interface. You can use it
 * directly, the implementation is provided when testing your solution.
 */
public class Solution {
  public int search(Dictionary dict, int target) {
    if (dict == null || dict.get(0) == null) {
      return -1;
    }
    int start = 0;
    int end = 1;
    while (end < Integer.MAX_VALUE / 2 && dict.get(end) != null && dict.get(end) < target) {
      start = end + 1;
      end *= 2;
    }
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (dict.get(mid) == null) {
        end = mid - 1;
        continue;
      }
      if (dict.get(mid) == target) {
        return mid;
      } else if (dict.get(mid) < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }
}
