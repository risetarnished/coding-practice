package M.Probability.Medium.ReservoirSampling;

import java.util.Random;

/**
 * ReservoirSampling
 *
 * @author meng
 * @date 1/21/19
 */
public class ReservoirSampling {
    private int count;
    private Integer sample;

    public ReservoirSampling() {
        // Write your constructor code here if necessary
        // Variable count records the total number of input read so far
        count = 0;
        // Variable sample represents the current sample
        sample = null;
    }

    public void read(int value) {
        // Write your implementation here
        // One call to the read() method == one input read
        count++;
        // With the updated number of inputs read so far
        // Generate a random number between [0, count)
        Random random = new Random();
        int prob = random.nextInt(count);
        // The probability of any one number gets generated
        // is 1/count. Therefore, let the prob variable to be
        // any one of them, and the probability of this current
        // read value is the current sample is 1/count
        if (prob == 0) {
            sample = value;
        }
    }

    public Integer sample() {
        // Write your implementation here
        return sample;
    }
}
