package M.DynamicProgramming.II.Medium.LargestSubArraySum;

public class LargestSubArraySum {
    public int largestSum(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] sum = new int[array.length];
        // sum[i] represents the sum of the first i elements
        sum[0] = array[0];
        int maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum[i] = Math.max(array[i], array[i] + sum[i - 1]);
            maxSum = Math.max(maxSum, sum[i]);
        }
        return maxSum;
    }

    public int largestSumOptimized(int[] array) {
        // Same time complexity
        // But O(1) space instead of O(n)
        if (array == null || array.length == 0) {
            return 0;
        }
        // sum represents the sum of the first i elements
        int sum = array[0];
        int maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum = Math.max(array[i], sum + array[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
