package N.Probability.Medium.NinetyFivePercentile;

import java.util.List;

/**
 * NinetyFivePercentile
 *
 * @author meng
 * @date 1/21/19
 */
public class NinetyFivePercentile {
    /**
     *
     * @param lengths a list of URL lengths
     * @return        URL length of the 95th percentile
     * 
     */
    public int percentile95(List<Integer> lengths) {
        // Write your solution here
        if (lengths == null || lengths.isEmpty()) {
            return 0;
        }
        // The max length of valid URL is 4096
        int maxLength = 4096;
        int[] count = new int[maxLength + 1];
        for (int length : lengths) {
            count[length]++;
        }
        int sum = 0;
        while (sum <= 0.05 * lengths.size()) {
            sum += count[maxLength--];
        }
        return maxLength + 1;
    }
}
