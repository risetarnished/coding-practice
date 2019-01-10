package J.StringI.Hard.RemoveAdjacentRepeatedCharactersIV;

/**
 * https://app.laicode.io/app/problem/82
 *
 * Description
 * Repeatedly remove all adjacent, repeated characters in a given string from left to right.
 *
 * No adjacent characters should be identified in the final string.
 *
 * Examples
 *
 * "abbbaaccz" → "aaaccz" → "ccz" → "z"
 * "aabccdc" → "bccdc" → "bdc"
 */

public class RemoveAdjacentRepeatedCharactersIV {
    public String deDup(String input) {
        // Write your solution here
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        // Instead of using a real stack
        // Use a pointer to split the array into two parts:
        // [0, stackPointer] --> stack
        // [stackPointer + 1, end] --> processing part
        int stackPointer = 0;
        for (int i = 1; i < array.length; i++) {
            if (stackPointer < 0 || array[i] != array[stackPointer]) {
                // Case 1: when we need to push
                //    1.1: stack is/has become empty
                //    1.2: the element is not a duplication
                array[++stackPointer] = array[i];
            } else {
                // Case 2: when we need to pop
                //    2.1: when the element is a duplicate (== stack top)
                while (i < array.length - 1 && array[i] == array[i + 1]) {
                    // Skip multiple duplications
                    i++;
                }
                // Pop the stack
                stackPointer--;
            }
        }
        // Everything in [0, stack] are used for result
        return new String(array, 0, stackPointer + 1);
    }
}
