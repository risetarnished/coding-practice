package J.StringI.Easy.RemoveCertainCharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * https://app.laicode.io/app/problem/395
 *
 * Description
 * Remove given characters in input string, the relative order of other characters should be remained. Return the new string after deletion.
 *
 * Assumptions
 *
 * The given input string is not null.
 * The characters to be removed is given by another string, it is guaranteed to be not null.
 * Examples
 *
 * input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".
 */

public class RemoveCertainCharacters {
    public String remove(String input, String t) {
        // Write your solution here
        if (input == null || input.length() == 0 || t == null) {
            return input;
        }
        // Store the characters to be removed in a HashSet
        Set<Character> toRemove = new HashSet<>(t.length());
        for (int i = 0; i < t.length(); i++) {
            toRemove.add(t.charAt(i));
        }
        // Convert the input string to char[] for in-place operations
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (!toRemove.contains(array[fast])) {
                // when we do not need to delete the char at fast
                // we keep it in the ready-for-result portion
                // [0, slow)
                array[slow++] = array[fast];
            }
            // Whenever we delete the char at fast, we need to move on
            fast++;
        }
        // Use the String constructor with offset and length count
        return new String(array, 0, slow);
    }
}
