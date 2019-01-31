package M.Probability.Medium.Random7UsingRandom5;

import java.util.Random;

/**
 * Random7UsingRandom5
 *
 * @author meng
 * @date 1/21/19
 */
public class Random7UsingRandom5 {
    public int random7() {
        // Write your solution here
        // You can use RandomFive.random5() for generating
        // 0 - 4 with equal probability
        int result = 0;
        while (true) {
            int rand = 5 * RandomFive.random5() + RandomFive.random5();
            if (rand < 21) {
                result = rand % 7;
                break;
            }
        }
        return result;
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
