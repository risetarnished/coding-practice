package J.String.II.Hard.AllPermutationsII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://app.laicode.io/app/problem/65
 *
 * Description
 * Given a string with possible duplicate characters, return a list with all permutations of the characters.
 *
 * Examples
 *
 * Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
 * Set = "aba", all permutations are ["aab", "aba", "baa"]
 * Set = "", all permutations are [""]
 * Set = null, all permutations are []
 */

public class AllPermutationsII {
    public List<String> permutations(String set) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        permute(set.toCharArray(), 0, result);
        return result;
    }

    private void permute(char[] array, int index, List<String> result) {
        // Base case: when all positions have been considered
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        // Use a HashSet to record the letters picked at this position
        // to avoid duplications
        Set<Character> used = new HashSet<>(array.length);
        // For each level/position, try all the possible letters
        // Candidates are in [index, end]
        for (int i = index; i < array.length; i++) {
            if (used.contains(array[i])) {
                continue;
            }
            used.add(array[i]);
            swap(array, index, i);
            permute(array, index + 1, result);
            swap(array, i, index);
        }
    }

    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
