package M.DynamicProgramming.III.Medium.LargestSubarraySum;

public class LargestSubarraySum {
    public int[] largestSum(int[] array) {
        if (array == null || array.length == 0) {
            return new int[] {};
        }
        int currentSum = array[0];
        int maxSum = array[0];
        int currentStart = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 1; i < array.length; i++) {
            if (currentSum < 0) {
                currentSum = array[i];
                currentStart = i;
            } else {
                currentSum += array[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxStart = currentStart;
                maxEnd = i;
            }
        }
        return new int[] {maxSum, maxStart, maxEnd};
    }
}
