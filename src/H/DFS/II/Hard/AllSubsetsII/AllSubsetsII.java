package H.DFS.II.Hard.AllSubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsII {
    public List<String> subSets(String set) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        // Sort the array in order to avoid duplicate characters easier
        Arrays.sort(array);
//        findAllSubsets(array, new StringBuilder(), 0, result);
        findAllSubsetsAlt(array, new StringBuilder(), 0, result);
        return result;
    }

    private void findAllSubsets(char[] array, StringBuilder subset, int index,
                                List<String> result) {
        // Base case: when we have considered all characters
        if (index == array.length) {
            result.add(subset.toString());
            return;
        }
        // Add this character to the subset and go to the next level
        subset.append(array[index]);
        findAllSubsets(array, subset, index + 1, result);
        // Backtrack when returning back
        subset.deleteCharAt(subset.length() - 1);
        // Skip all the following duplicate characters
        while (index < array.length - 1 && array[index] == array[index + 1]) {
            index++;
        }
        findAllSubsets(array, subset, index + 1, result);
    }

    private void findAllSubsetsAlt(char[] array, StringBuilder subset, int index,
                                   List<String> result) {
        // Add every legit node in the recursion tree to the result
        result.add(subset.toString());
        // From the current level, continue doing DFS
        for (int i = index; i < array.length; i++) {
            // Skip duplicate elements
            if (i > index && array[i] == array[i - 1]) {
                continue;
            }
            subset.append(array[i]);
            findAllSubsetsAlt(array, subset, i + 1, result);
            subset.deleteCharAt(subset.length() - 1);
        }
    }
}
