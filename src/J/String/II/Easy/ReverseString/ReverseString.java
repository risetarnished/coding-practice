package J.String.II.Easy.ReverseString;

/**
 * https://app.laicode.io/app/problem/396
 *
 * Description
 * Reverse a given string.
 *
 * Assumptions
 *
 * The given string is not null.
 */

public class ReverseString {
    public String reverse(String input) {
        // Write your solution here
        if (input == null || input.length() <= 1) {
            return input;
        }
        // Convert the string to char[] for easier operations
        // Also, we can consider using char[] to mimic in-place
        // operations in all string related problems and no need
        // to take the extra space into consideration
        char[] array = input.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            swap(array, left++, right--);
        }
        return new String(array);
    }

    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    // We can also do it reversively
    public String recursiveReverse(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        recursiveReverseCharacters(array, 0, input.length() - 1);
        return new String(array);
    }

    private void recursiveReverseCharacters(char[] array, int left, int right) {
        // Base case: when left meets right ==> all chars have been swapped
        if (left >= right) {
            return;
        }
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        recursiveReverseCharacters(array, left + 1, right - 1);
    }
}
