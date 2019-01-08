package H.DFS.Medium.AllValidPermutationsOfParenthesesI;

import java.util.ArrayList;
import java.util.List;

/**
 * https://app.laicode.io/app/problem/66
 *
 * Description
 * Given N pairs of parentheses “()”, return a list with all the valid permutations.
 *
 * Assumptions
 *
 * N >= 0
 * Examples
 *
 * N = 1, all valid permutations are ["()"]
 * N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
 * N = 0, all valid permutations are [""]
 */

public class AllValidPermutationsOfParenthesesI {
    public List<String> validParentheses(int n) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        permute(new StringBuilder(), n, n, result);
        return result;
    }

    private void permute(StringBuilder parentheses, int left, int right, List<String> result) {
        // Base case: when we have added n "(" and n ")"
        if (left == 0 && right == 0) {
            result.add(parentheses.toString());
            return;
        }
        // When there are still ( left, it can be added
        if (left > 0) {
            parentheses.append('(');
            // Go to the next level
            permute(parentheses, left - 1, right, result);
            // Backtracking
            parentheses.deleteCharAt(parentheses.length() - 1);
        }
        // When there are more ) than ( left, we can add a )
        if (right > left) {
            parentheses.append(')');
            permute(parentheses, left, right - 1, result);
            parentheses.deleteCharAt(parentheses.length() - 1);
        }
    }
}
