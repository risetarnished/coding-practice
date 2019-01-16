package J.String.II.Hard.DecompressStringII;

/**
 * https://app.laicode.io/app/problem/175
 *
 * Description
 * Given a string in compressed form, decompress it to the original string. The adjacent repeated
 * characters in the original string are compressed to have the character followed by the number
 * of repeated occurrences.
 *
 * Assumptions
 *
 * The string is not null
 *
 * The characters used in the original string are guaranteed to be ‘a’ - ‘z’
 *
 * There are no adjacent repeated characters with length > 9
 *
 * Examples
 *
 * “a1c0b2c4” → “abbcccc”
 */

public class DecompressStringII {
    public String decompress(String input) {
        // Write your solution here
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        // Allocate enough space for the output
        int decompressedSize = decompressSize(array);
        char[] result = new char[decompressedSize];
        int outputIndex = 0;
        // Populate the output according to the input
        for (int i = 0; i < array.length - 1; i += 2) {
            int charCount = getDigit(array[i + 1]);
            for (int j = 0; j < charCount; j++) {
                result[outputIndex++] = array[i];
            }
        }
        return new String(result);
    }

    private int decompressSize(char[] array) {
        int size = 0;
        for (int i = 1; i < array.length; i += 2) {
            size += getDigit(array[i]);
        }
        return size;
    }

    private int getDigit(char ch) {
        // We can also use the digit() method in Character class
        // return Character.digit(ch, 10);
        return ch - '0';
    }
}
