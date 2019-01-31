package H.DFS.I.Medium.AllSubsetsI;

import java.util.ArrayList;
import java.util.List;

/**
 * https://app.laicode.io/app/problem/62
 *
 * Description
 * Given a set of characters represented by a String, return a list containing all subsets of the characters.
 *
 * Assumptions
 *
 * There are no duplicate characters in the original set.
 * ​Examples
 *
 * Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
 * Set = "", all the subsets are [""]
 * Set = null, all the subsets are []
 */

public class AllSubsetsI {
    public List<String> subSets(String set) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        // findSubsets(set, new StringBuilder(), 0, result);
        findSubsetsAlt(set, new StringBuilder(), 0, result);
        return result;
    }

    private void findSubsets(String set, StringBuilder sb, int index, List<String> result) {
        // Base case: when all the characters have been checked
        if (index == set.length()) {
            result.add(sb.toString());
            return;
        }
        // Recursive rule:
        // State 1: add the character in current level and move on to the next level
        sb.append(set.charAt(index));
        findSubsets(set, sb, index + 1, result);
        // State 2: skip this character and move on to the next level directly
        // Backtracking before moving on
        sb.deleteCharAt(sb.length() - 1);
        findSubsets(set, sb, index + 1, result);
    }

    private void findSubsetsAlt(String set, StringBuilder sb, int index, List<String> result) {
        result.add(sb.toString());
        // Use index to control the level
        for (int i = index; i < set.length(); i++) {
            sb.append(set.charAt(i));
            // Go to the next level
            findSubsetsAlt(set, sb, i + 1, result);
            // Backtracking
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
