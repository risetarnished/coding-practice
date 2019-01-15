package K.StringII.Medium.AllAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://app.laicode.io/app/problem/398
 *
 * Description
 * Find all occurrence of anagrams of a given string s in a given string l. Return the list of
 * starting indices.
 *
 * Assumptions
 *
 * s is not null or empty.
 * l is not null.
 * Examples
 *
 * l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 starting from index 0/3
 * are all anagrams of "ab" ("ab", "ba").
 */

public class AllAnagrams {
    public List<Integer> allAnagrams(String sh, String lo) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if (sh == null || lo == null) {
            return result;
        }
        if (sh.length() > lo.length()) {
            return result;
        }
        // Use a map to store the frequency of each letter in sh
        Map<Character, Integer> frequency = countMap(sh);
        // We need to count the number of matches happened such that
        // when there are map.size() number of matches, we get a result
        int match = 0;
        // Maintain a sliding window of size sh.length()
        // When moving the window from left to right by 1 step:
        // 1. remove the leftmost character out
        // 2. add the next character in
        int size = sh.length();
        for (int i = 0; i < lo.length(); i++) {
            char newChar = lo.charAt(i);
            // Get the frequency of this char in sh
            Integer newFreq = frequency.get(newChar);
            if (newFreq != null) {
                // When this char has also appeared in sh
                // decrement its count in the map by 1
                // If the frequency of it becomes 0
                // which means an equal number of it have appeared
                // in lo ==> we have a match
                frequency.put(newChar, --newFreq);
                if (newFreq == 0) {
                    match++;
                }
            }
            // Deal with the leftmost character
            if (i >= sh.length()) {
                char oldChar = lo.charAt(i - size);
                Integer oldFreq = frequency.get(oldChar);
                if (oldFreq != null) {
                    // We need to restore the character back to
                    // its original state
                    // If the frequency becomes 1, which means
                    // this char was matched, but not now
                    frequency.put(oldChar, ++oldFreq);
                    if (oldFreq == 1) {
                        match--;
                    }
                }
            }
            // For the current sliding window, if all characters from sh
            // have been matched, add the start index to result
            if (match == frequency.size()) {
                result.add(i - size + 1);
            }
        }
        return result;
    }

    private Map<Character, Integer> countMap(String sh) {
        Map<Character, Integer> frequency = new HashMap<>(sh.length());
        for (int i = 0; i < sh.length(); i++) {
            frequency.put(sh.charAt(i), frequency.getOrDefault(sh.charAt(i), 0) + 1);
        }
        return frequency;
    }
}
