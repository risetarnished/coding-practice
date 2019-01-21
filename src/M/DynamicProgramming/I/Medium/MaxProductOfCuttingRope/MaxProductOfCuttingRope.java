package M.DynamicProgramming.I.Medium.MaxProductOfCuttingRope;

public class MaxProductOfCuttingRope {
    public int maxProduct(int length) {
        // Write your solution here
        if (length < 2) {
            // length == 0: 0 * 0
            // length == 1: 0 * 1 or 1 * 0
            return 0;
        }
        int[] product = new int[length + 1];
        product[1] = 0;
        product[2] = 1; // 1 * 1
        for (int i = 3; i <= length; i++) {
            // For every length = i, we can cut it with sub-lengths
            // from 1 to (i - 1)
            int currMax = 0;
            for (int j = 1; j < i; j++) {
                currMax = Math.max(currMax, Math.max(j, product[j]) * (i - j));
            }
            product[i] = currMax;
        }
        return product[length];
    }

    public int maxProductBetter(int length) {
        if (length < 2) {
            return 0;
        }
        int[] product = new int[length + 1];
        product[2] = 1;
        for (int i = 3; i <= length; i++) {
            // Leave the shorter part as it is
            // Only look for the max product for the longer part
            // Only need to run from 1 to i/2
            for (int j = 1; j <= i / 2; j++) {
                product[i] = Math.max(
                        product[i],
                        j * Math.max(i - j, product[i - j])
                );
            }
        }
        return product[length];
    }
}
