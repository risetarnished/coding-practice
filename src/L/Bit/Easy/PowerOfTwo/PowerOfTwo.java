package L.Bit.Easy.PowerOfTwo;

/**
 * https://app.laicode.io/app/problem/74
 *
 * Description
 * Determine if a given integer is power of 2.
 *
 * Examples
 *
 * 16 is power of 2 (2 ^ 4)
 * 3 is not
 * 0 is not
 * -1 is not
 */

public class PowerOfTwo {
    public boolean isPowerOfTwo(int number) {
        // Write your solution here
        if (number <= 0) {
            return false;
        }
        int ones = 0;
        while (number > 0) {
            ones += (number & 1);
            number >>= 1;
        }
        return ones == 1;
    }

    public boolean isPowerOfTwoAlt(int number) {
        return number > 0 && (number & (number - 1)) == 0;
    }
}
