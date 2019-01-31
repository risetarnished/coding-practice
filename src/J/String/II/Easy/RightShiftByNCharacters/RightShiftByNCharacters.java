package J.String.II.Easy.RightShiftByNCharacters;

/**
 * https://app.laicode.io/app/problem/397
 *
 * Description
 * Right shift a given string by n characters.
 *
 * Assumptions
 *
 * The given string is not null.
 * n >= 0.
 */

public class RightShiftByNCharacters {
    public String rightShift(String input, int n) {
        // Write your solution here
        if (input == null || input.length() <= 1) {
            return input;
        }
        int offset = n % input.length();
        char[] array = input.toCharArray();
        // Step 1: reverse the entire string
        reverse(array, 0, array.length - 1);
        // Step 2: reverse the two parts separated at index offset
        reverse(array, 0, offset - 1);
        reverse(array, offset, array.length - 1);
        return new String(array);
    }

    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
