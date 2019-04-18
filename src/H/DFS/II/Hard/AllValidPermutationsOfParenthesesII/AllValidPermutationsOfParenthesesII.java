package H.DFS.II.Hard.AllValidPermutationsOfParenthesesII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllValidPermutationsOfParenthesesII {
  public List<String> validParentheses(int l, int m, int n) {
    // Write your solution here
    List<String> result = new ArrayList<>();
    // Base case according to the assumption
    if (l <= 0 && m <= 0 && n <= 0) {
      return result;
    }
    // Build arrays
    // 1. array representing the # of parentheses left
    // 2. array representing the corresponding parentheses
    int[] pairs = new int[] {l, l, m, m, n, n};
    char[] parentheses = new char[] {'(', ')', '<', '>', '{', '}'};
    // Do a depth-first search to explore all possible combinations
    permute(new StringBuilder(), pairs, parentheses, new ArrayDeque<>(), result);
    return result;
  }

  private void permute(StringBuilder sb, int[] pairs, char[] parentheses,
                       Deque<Character> stack, List<String> result) {
    // Base case: when all parentheses have been taken
    if (allUsed(pairs)) {
      result.add(sb.toString());
      return;
    }
    // For each left parenthesis, consider the possibility of adding it
    for (int i = 0; i < pairs.length; i += 2) {
      // Case left: when there are still left parenthesis available
      if (pairs[i] > 0) {
        sb.append(parentheses[i]);
        stack.offerFirst(parentheses[i]);
        pairs[i] = pairs[i] - 1;
        permute(sb, pairs, parentheses, stack, result);
        pairs[i] = pairs[i] + 1;
        stack.pollFirst();
        sb.deleteCharAt(sb.length() - 1);
      }
      // Case right: when there are more right parentheses than left
      //             AND when the previously added left parenthesis matches its type
      if (pairs[i + 1] > pairs[i]) {
        if (stack.peekFirst() != parentheses[i]) {
          continue;
        }
        sb.append(parentheses[i + 1]);
        char left = stack.pollFirst();
        pairs[i + 1] = pairs[i + 1] - 1;
        permute(sb, pairs, parentheses, stack, result);
        pairs[i + 1] = pairs[i + 1] + 1;
        stack.offerFirst(left);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }

  private boolean allUsed(int[] pairs) {
    for (int i = 0; i < pairs.length; i++) {
      if (pairs[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
