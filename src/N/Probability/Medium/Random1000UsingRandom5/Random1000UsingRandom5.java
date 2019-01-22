package N.Probability.Medium.Random1000UsingRandom5;

import java.util.Random;

/**
 * Random1000UsingRandom5
 *
 * @author meng
 * @date 1/21/19
 */
public class Random1000UsingRandom5 {
    public int random1000() {
        // Write your solution here
        // You can use RandomFive.random5() for generating
        // 0 - 4 with equal probability
        // Method: count the number of digits of radix 5 numbers needed
        //         ==> the first power of 5 that exceeds 1000
        int digits = 1;
        int base = 5;
        while (base < 1000) {
            digits++;
            base *= base;
        }
        while (true) {
            int num = 0;
            for (int i = 0; i <= digits; i++) {
                num = num * 5 + RandomFive.random5();
            }
            // If the number falls in the range [0, 5^digits > 1000)
            if (num < 1000) {
                return num % 1000;
            }
        }
    }
}

/**
 * Manually implement a RandomFive.random5()
 */
class RandomFive {
    private static Random random;

    RandomFive() {
        random = new Random();
    }

    static int random5() {
        return random.nextInt(5);
    }
}
