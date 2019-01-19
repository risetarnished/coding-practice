package M.DynamicProgramming.III.Medium.LargestSubarraySum;

public class LargestSubarraySum {
    public int[] largestSum(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return new int[] {};
        }
        int currentSum = array[0];
        int maxSum = array[0];
        int currentStart = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int currentEnd = 1; currentEnd < array.length; currentEnd++) {
            if (currentSum < 0) {
                currentSum = array[currentEnd];
                currentStart = currentEnd;
            } else {
                currentSum += array[currentEnd];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxStart = currentStart;
                maxEnd = currentEnd;
            }
        }
        return new int[] {maxSum, maxStart, maxEnd};
    }
}
