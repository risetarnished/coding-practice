package K.Bit.Medium.NumberOfDifferentBits;

/**
 * https://app.laicode.io/app/problem/75
 *
 * Description
 * Determine the number of bits that are different for two given integers.
 *
 * Examples
 *
 * 5(“0101”) and 8(“1000”) has 3 different bits
 */

public class NumberOfDifferentBits {
    public int diffBits(int a, int b) {
        // Write your solution here
        int result = a ^ b;
        int ones = 0;
        while (result != 0) {
            ones += result & 1;
            result = result >>> 1;
        }
        return ones;
    }
}
