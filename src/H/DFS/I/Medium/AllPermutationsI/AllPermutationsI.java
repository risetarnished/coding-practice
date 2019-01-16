package H.DFS.I.Medium.AllPermutationsI;

import java.util.ArrayList;
import java.util.List;

/**
 * https://app.laicode.io/app/problem/64
 *
 * Description
 * Given a string with no duplicate characters, return a list with all permutations of the characters.
 *
 * Examples
 *
 * Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
 * Set = "", all permutations are [""]
 * Set = null, all permutations are []
 */

public class AllPermutationsI {
    public List<String> permutations(String set) {
        // Write your solution
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        // Convert the string to char[] for simpler operations
        permute(set.toCharArray(), 0, result);
        return result;
    }

    private void permute(char[] input, int index, List<String> result) {
        // Base case: when all positions have been placed with selected characters
        if (index == input.length) {
            result.add(new String(input));
            return;
        }
        // In each level, we need to choose all possible characters to put
        // into this position
        // At the current level/index, input[0, index] are the fixed part
        // input[index, end] are candidates to be put at position index
        for (int i = index; i < input.length; i++) {
            // Because this is a char[],
            // to put element at index i to the current index
            // we can just swap them
            swap(input, index, i);
            // Go to the next level/position/index
            permute(input, index + 1, result);
            // Backtrack: restore the original relative positions
            swap(input, i, index);
        }
    }

    private void swap(char[] input, int left, int right) {
        char temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
}
