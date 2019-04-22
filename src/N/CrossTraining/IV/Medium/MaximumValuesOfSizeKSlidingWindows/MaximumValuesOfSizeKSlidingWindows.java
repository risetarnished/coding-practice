package N.CrossTraining.IV.Medium.MaximumValuesOfSizeKSlidingWindows;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaximumValuesOfSizeKSlidingWindows {
  public List<Integer> maxWindows(int[] array, int k) {
    // Write your solution here
    // Corner cases based on the assumptions
    List<Integer> result = new ArrayList<>();
    if (array == null || array.length == 0 ||
        k < 0 || k > array.length) {
      return result;
    }
    // E.g. A = {1, 2, 3, 2, 4, 2, 1}, K = 3
    // Use a deque to keep track of the index of current max element in the sliding window
    // The head of the deque is the max of the current sliding window
    Deque<Integer> deque = new ArrayDeque<>(k);
    int start = 0;
    for (int end = 0; end < array.length; end++) {
      // Check the new element against the current max of the window
      // Remove all previous max values if the new element is greater
      while (!deque.isEmpty() && array[end] > array[deque.peekLast()]) {
        deque.pollLast();
      }
      // And add the new max to the deque if the deque is empty
      // or the new element is smaller than the previous max
      deque.offerLast(end);
      // When the window size == k, add the current max to the result
      if (end - start + 1 == k) {
        result.add(array[deque.peekFirst()]);
        // Remove the old max if it is the start of the current window
        // and move the sliding window to the right by 1
        if (deque.peekFirst() == start++) {
          deque.pollFirst();
        }
      }
    }
    return result;
  }
}
