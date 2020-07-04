package coollime.queueandstack.sortwithtwostacks;

import java.util.LinkedList;

public class Solution {

  /**
   * Sort the element in a stack with the help of another stack
   *
   * @param s1  The stack to sort
   */
  public void sort(LinkedList<Integer> s1) {
    LinkedList<Integer> s2 = new LinkedList<>();
    if (s1 == null || s1.size() == 1) {
      return;
    }
    // Use the two stacks to simulate the features of selection sort
    int n = s1.size();
    for (int i = 0; i < n; i++) {
      int min = Integer.MAX_VALUE;
      // Transfer the elements from s1 to s2
      while (!s1.isEmpty()) {
        int element = s1.pollFirst();
        min = Math.min(min, element);
        s2.offerFirst(element);
      }
      int count = 0;
      while (!s2.isEmpty()) {
        int element = s2.peekFirst();
        if (element < min) {
          break;
        } else if (element > min) {
          s1.offerFirst(s2.pollFirst());
        } else {
          count++;
          s2.pollFirst();
        }
      }
      // Push the current min value to s2
      for (int j = 0; j < count; j++) {
        s2.offerFirst(min);
      }
    }
    transferStack(s2, s1);
  }

  private void transferStack(LinkedList<Integer> s1, LinkedList<Integer> s2) {
    if (s1 == null || s2 == null) {
      return;
    }
    while (!s1.isEmpty()) {
      s2.offerFirst(s1.pollFirst());
    }
  }
}
