package K.StringII.Medium.ReverseWordsInASentenceI;

/**
 * https://app.laicode.io/app/problem/84
 *
 * Description
 * Reverse the words in a sentence.
 *
 * Assumptions
 *
 * Words are separated by single space
 *
 * There are no heading or tailing white spaces
 *
 * Examples
 *
 * “I love Google” → “Google love I”
 *
 * Corner Cases
 *
 * If the given string is null, we do not need to do anything.
 */

public class ReverseWordsInASentenceI {
    public String reverseWords(String input) {
        // Write your solution here
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        // Step 1: reverse the whole sentence character by character
        reverseCharacters(array, 0, array.length - 1);
        // Step 2: reverse each word separated by space in the reversed sentence
        int start = 0;
        for (int end = 1; end < array.length; end++) {
            if (array[end] == ' ') {
                // When we see a space, reverse the word [start, end - 1]
                // And update the start and end pointers
                reverseCharacters(array, start, end - 1);
                start = ++end;
            } else if (end == array.length - 1) {
                // The string does not have leading/trailing spaces
                // So we need to reverse the last portion when we
                // reach the end
                reverseCharacters(array, start, end);
            }
        }
        return new String(array);
    }

    private void reverseCharacters(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
