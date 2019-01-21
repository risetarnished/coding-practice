package N.Probability.Medium.PerfectShuffle;

import java.util.Random;

/**
 * PerfectShuffle
 *
 * @author meng
 * @date 1/21/19
 */
public class PerfectShuffle {
    public void shuffle(int[] array) {
        // Write your solution here.
        if (array == null || array.length <= 1) {
            return;
        }
        Random random = new Random();
        int n = array.length;
        for (int i = 0; i < n; i++) {
            // Generate a random index from i to n
            int rand = random.nextInt(n - i) + i;
            // [0, index) are shuffled section
            // [index, end] are yet to be shuffled
            // Swap the shuffled card to the result section
            int temp = array[i];
            array[i] = array[rand];
            array[rand] = temp;
        }
    }
}
