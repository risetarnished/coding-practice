package C.Recursion.I.Medium.AToThePowerOfB;

/**
 * https://app.laicode.io/app/problem/13
 *
 * Description
 * Evaluate a to the power of b, assuming both a and b are integers and b is non-negative.
 *
 * Examples
 *
 * power(2, 0) = 1
 * power(2, 3) = 8
 * power(0, 10) = 0
 * power(-2, 5) = -32
 * Corner Cases
 *
 * What if the result is overflowed? We can assume the result will not be overflowed when we solve this problem on this online judge.
 **/

public class AToThePowerOfB {
    public long power(int a, int b) {
        // Write your solution here
        // Base case: when we do a^0 (b == 0)
        if (b == 0) {
            return 1;
        }
        // Divide b by 1/2 each time and do result * result
        long half = power(a, b / 2);
        // We need to differentiate the situations where b is odd or even
        if (b % 2 == 0) {
            return half * half;
        }
        return half * half * a;
    }

    /**
     * There are two simpler but more naive ways to do this problem
     **/
    public long naivePower(int a, int b) {
        // Method 1: directly computation one level at a time
        /*
        if (b == 0) {
            return 1;
        }
        return a * power(a, b - 1);
        */

        // Method 2: use a mid point (b/2) and compute the left and right halves
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;
        }
        int mid = b / 2;
        return power(a, mid) * power(a, b - mid);
    }
}
