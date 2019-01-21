package M.DynamicProgramming.III.Hard.LargestSubMatrixSum;

public class LargestSubMatrixSum {
    public int largest(int[][] matrix) {
        // Write your solution here
        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int result = Integer.MIN_VALUE;
        // Compute the prefix sum for each row (column-wise)
        for (int row = 0; row < rows; row++) {
            // Column-wisely, compute the sum of
            // all following rows
            int[] prefixRow = new int[cols];
            for (int i = row; i < rows; i++) {
                // For each column in this row, add up the
                // same column in all following rows
                addColumns(prefixRow, matrix[i]);
                // Look for the max subarray sum in this
                // column-wise prefix row sums
                result = Math.max(result, maxSubarraySum(prefixRow));
            }
        }
        return result;
    }

    private void addColumns(int[] prefixRow, int[] currentRow) {
        for (int i = 0; i < prefixRow.length; i++) {
            // Add up the corresponding columns in all following rows
            prefixRow[i] += currentRow[i];
        }
    }

    private int maxSubarraySum(int[] array) {
        int currentSum = array[0];
        int maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            currentSum = Math.max(currentSum + array[i], array[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}