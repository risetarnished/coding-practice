package I.HashTable.Medium.MissingNumberI;

/**
 * https://app.laicode.io/app/problem/68
 *
 * Description
 * Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.
 *
 * Assumptions
 *
 * The given array is not null, and N >= 1
 * Examples
 *
 * A = {2, 1, 4}, the missing number is 3
 * A = {1, 2, 3}, the missing number is 4
 * A = {}, the missing number is 1
 */

public class MissingNumberI {
    public int missing(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return 1;
        }
        // 3 Methods
//        return solveByHashtable(array);
//        return solveByMath(array);
        return solveByXor(array);
    }

    private int solveByHashtable(int[] array) {
        // Use a hash table of size (n + 1) because the array has n numbers
        boolean[] exists = new boolean[array.length + 1];
        // Iterate over the array
        // mark the number's corresponding index to true
        // Because the number starts from 1
        // index = number - 1
        for (int number : array) {
            exists[number - 1] = true;
        }
        // Iterate the (n + 1) numbers
        // Look for the missing one
        for (int i = 0; i < array.length + 1; i++) {
            if (!exists[i]) {
                return i + 1;   // index = number - 1
            }
        }
        return -1;
    }

    private int solveByMath(int[] array) {
        // Method 1
        // sum(1 to n) - sum(array)
        /*
        int expectedSum = 0;
        for (int i = 1; i <= array.length + 1; i++) {
            expectedSum += i;
        }
        int actualSum = 0;
        for (int number : array) {
            actualSum += number;
        }
        return expectedSum - actualSum;
        */

        // Method 2
        // Subtraction on the fly
        // Variable diff represents the difference between all the elements
        // from 1 to n - 1
        int diff = 0;
        for (int i = 0; i < array.length; i++) {
            diff += (i + 1) - array[i];
        }
        // The last number is n
        // And if we use the difference among the previous (n - 1) numbers plus n
        // We get the final difference
        return array.length + 1 + diff;
    }

    private int solveByXor(int[] array) {
        // 1 xor 2 xor ... xor n
        int xor = 0;
        for (int i = 1; i <= array.length + 1; i++) {
            xor ^= i;
        }
        for (int number : array) {
            xor ^= number;
        }
        return xor;
    }
}
