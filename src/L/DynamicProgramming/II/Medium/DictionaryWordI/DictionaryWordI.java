package L.DynamicProgramming.II.Medium.DictionaryWordI;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DictionaryWordI {
    public boolean canBreak(String input, String[] dict) {
        // Write your solution here
        if (input == null || dict == null || dict.length == 0) {
            return false;
        }
        // Convert the dictionary into a HashSet for quicker access
        Set<String> dictionary = new HashSet<>(Arrays.asList(dict));
        // Because we need to take no cuts (0 cuts) into consideration
        // We need an array with a size of n + 1
        boolean[] canCut = new boolean[input.length() + 1];
        // canCut[i] represents the fact whether the first i letters
        // of the input (input.substring(0, i)) can be formed by
        // concatenating words in the dictionary
        canCut[0] = true; // Empty string
        // Check for every substring of input with lengths from 1 to n
        for (int i = 1; i <= input.length(); i++) {
            // The substring may already be a word in the dict
            if (dictionary.contains(input.substring(0, i))) {
                canCut[i] = true;
                continue;
            }
            // Otherwise, we need to check the substring of the substring
            // with lengths from 1 to i
            for (int j = 1; j < i; j++) {
                // Check the canCut history of the first part [0, j)
                // Check the presence in dict of the 2nd part [j, i)
                if (canCut[j] && dictionary.contains(input.substring(j, i))) {
                    canCut[i] = true;
                    break;
                }
            }
        }
        return canCut[input.length()];
    }
}
