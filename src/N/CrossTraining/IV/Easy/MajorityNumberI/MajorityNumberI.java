package N.CrossTraining.IV.Easy.MajorityNumberI;

public class MajorityNumberI {
  public int majority(int[] array) {
    // Write your solution here
    // Corner cases check based on the assumption
    if (array == null || array.length == 0) {
      return Integer.MIN_VALUE;
    }
    // candidate is the element to be compared against
    // count is the # of occurrence of the candidate
    int candidate = array[0];
    int count = 0;
    for (int i = 1; i < array.length; i++) {
      if (count == 0) {
        // 1. The candidate's count has been balanced out
        candidate = array[i];
        count++;
      } else if (candidate == array[i]) {
        // 2. The incoming element is a new instance of the candidate
        count++;
      } else {
        // 3. The incoming element is different from the candidate
        count--;
      }
    }
    return candidate;
  }
}
