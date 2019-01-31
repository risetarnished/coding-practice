package N.CrossTraining.I.Hard.ArrayDeduplicationIV;

import java.util.Arrays;

/**
 * ArrayDeduplicationIV
 *
 * @author meng
 * @date 1/24/19
 */
public class ArrayDeduplicationIV {
    /**
     * Repeatedly remove duplicate elements from a sorted array
     * Keep no copies of elements of the same value
     *
     * @param array the input array
     * @return      array without duplications*/
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array == null || array.length <= 1) {
            return array;
        }
        // Use a pointer to make array[0, stack] work like a real stack
        int stack = 0;
        for (int i = 1; i < array.length; i++) {
            if (stack < 0 || array[i] != array[stack]) {
                // As if we were doing stack.push(array[i])
                array[++stack] = array[i];
            } else {
                // Skip consecutive duplications and pop the element from stack
                while (i < array.length - 1 && array[i] == array[i + 1]) {
                    i++;
                }
                stack--;
            }
        }
        // Array[0, stack]
        return Arrays.copyOf(array, stack + 1);
    }
}
