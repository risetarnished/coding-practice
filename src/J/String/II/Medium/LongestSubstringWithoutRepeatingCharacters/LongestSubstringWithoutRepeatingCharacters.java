package J.String.II.Medium.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * https://app.laicode.io/app/problem/253
 *
 * Description
 * Given a string, find the longest substring without any repeating characters and return the
 * length of it. The input string is guaranteed to be not null.
 *
 * For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should
 * return 4 in this case.
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int longest(String input) {
        // Write your solution here
        if (input == null || input.length() == 0) {
            return 0;
        }
        // The slow pointer only increments when a duplicate is seen
        // The fast pointer moves when there has not been a duplication
        int slow = 0;
        int fast = 0;
        int maxLen = 0;
        // Use a HashSet to record the letters that have been seen
        Set<Character> seen = new HashSet<>();
        while (fast < input.length()) {
            if (!seen.contains(input.charAt(fast))) {
                // Increment fast and update max
                seen.add(input.charAt(fast++));
                maxLen = Math.max(maxLen, fast - slow);
            } else {
                // Increment slow and remove the char from the set
                seen.remove(input.charAt(slow++));
            }
        }
        return maxLen;
    }
}
