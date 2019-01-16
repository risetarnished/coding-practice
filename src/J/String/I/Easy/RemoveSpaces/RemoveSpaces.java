package J.String.I.Easy.RemoveSpaces;

/**
 * https://app.laicode.io/app/problem/281
 *
 * Description
 * Given a string, remove all leading/trailing/duplicated empty spaces.
 *
 * Assumptions:
 *
 * The given string is not null.
 * Examples:
 *
 * “  a” --> “a”
 * “   I     love MTV ” --> “I love MTV”
 */

public class RemoveSpaces {
    public String removeSpaces(String input) {
        // Write your solution here
        if (input == null || input.length() == 0) {
            return input;
        }
        // Convert the string to char[] for in-place operations
        char[] array = input.toCharArray();
        // Two pointers moving in the same direction
        // 1. elements before the slow pointers are ready for result
        // 2. elements between slow and fast are useless
        // 3. elements after and including fast are to be processed
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (array[fast] == ' ') {
                if (slow == 0) {
                    // Leading space
                    fast++;
                } else if (array[slow - 1] == ' ') {
                    // Multiple spaces
                    fast++;
                } else {
                    // Keep the space/word split
                    array[slow++] = array[fast++];
                }
            } else {
                // Keep the character
                array[slow++] = array[fast++];
            }
        }
        // Post-processing:
        // There could be one and only one extra space at the end
        if (slow > 0 && array[slow - 1] == ' ') {
            slow--;
        }
        return new String(array, 0, slow);
    }

    // The code above is clear but redundant in some places
    // This one is prettier
    public String removeSpacesAlt(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        // Convert the string to char[] for in-place operations
        char[] array = input.toCharArray();
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ' && (i == 0 || array[i - 1] == ' ')) {
                // Skip all leading or duplicated spaces
                continue;
            }
            // Otherwise, this character is either a letter
            // or a single space that functions as a word split
            array[end++] = array[i];
        }
        if (end > 0 && array[end - 1] == ' ') {
            end--;
        }
        return new String(array, 0, end);
    }
}
