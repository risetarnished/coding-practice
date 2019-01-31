package J.String.I.Easy.RemoveAdjacentRepeatedCharactersI;

/**
 * https://app.laicode.io/app/problem/79
 *
 * Description
 * Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.
 *
 * Assumptions
 *
 * Try to do it in place.
 * Examples
 *
 * “aaaabbbc” is transferred to “abc”
 * Corner Cases
 *
 * If the given string is null, we do not need to do anything.
 */

public class RemoveAdjacentRepeatedCharactersI {
    public String deDup(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        // Convert the string to char[] for in-place operations
        char[] array = input.toCharArray();
        // Two pointers:
        // 1. elements before and including slow are kept for result
        // 2. elements after fast are being processed
        // 3. elements in between are useless
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            // 1. When the two characters are the same
            //    we skip the trailing one
            // 2. When the two characters are different
            //    move slow down by one into the "useless area"
            //    and copy fast to there in order to keep it for result
            if (array[fast] != array[slow]) {
                array[++slow] = array[fast];
            }
        }
        // Elements in range [0, slow] (including slow)
        return new String(array, 0, slow + 1);
    }
}
