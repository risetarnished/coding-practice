package M.DynamicProgramming.III.Hard.LongestCrossOfOnes;

public class LongestCrossOfOnes {
    public int largest(int[][] matrix) {
        // Write your solution here
        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // Use four m x n matrices to record the max length of
        // consecutive 1s at index (i, j) from four directions
        int[][] left = left2right(matrix, m, n);
        int[][] right = right2left(matrix, m, n);
        int[][] top = top2bottom(matrix, m, n);
        int[][] bottom = bottom2top(matrix, m, n);
        // For each index (i, j), we compare the length of
        // consecutive 1s formed from the 4 directions
        // Take the min of them because it is the only viable one
        // Return the max among all m x n indices
        int maxLength = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                maxLength = Math.max(maxLength,
                                     Math.min(left[i][j], Math.min(right[i][j],
                                              Math.min(top[i][j], bottom[i][j]))));
            }
        }
        return maxLength;
    }

    private int[][] left2right(int[][] matrix, int row, int col) {
        // Calculate the longest consecutive 1s from left to right
        // for each cell in each row
        int[][] left = new int[row][col];
        // rows: top --> bottom
        for (int i = 0; i < row; i++) {
            // cols: left --> right
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    // Initialize the top row and leftmost column
                    left[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    // Look back to one column on the left
                    left[i][j] = left[i][j - 1] + 1;
                }   // Otherwise, left[i][j] = 0
            }
        }
        return left;
    }

    private int[][] right2left(int[][] matrix, int row, int col) {
        // Calculate the longest consecutive 1s from right to left
        // for each cell in each row
        int[][] right = new int[row][col];
        // rows: top --> bottom
        for (int i = 0; i < row; i++) {
            // cols: right --> left
            for (int j = col - 1; j >= 0; j--) {
                if (i == 0 || j == col - 1) {
                    // Initialize the top row and rightmost column
                    right[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    // Look back to one column on the right
                    right[i][j] = right[i][j + 1] + 1;
                }   // Otherwise, right[i][j] = 0
            }
        }
        return right;
    }

    private int[][] top2bottom(int[][] matrix, int row, int col) {
        // Calculate the longest consecutive 1s from top to bottom
        // for each cell in each column
        int[][] top = new int[row][col];
        // rows: top --> bottom
        for (int i = 0; i < row; i++) {
            // cols: left --> right
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    // Initialize the top row and leftmost column
                    top[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    // Look back to one row above
                    top[i][j] = top[i - 1][j] + 1;
                }   // Otherwise, top[i][j] = 0
            }
        }
        return top;
    }

    private int[][] bottom2top(int[][] matrix, int row, int col) {
        // Calculate the longest consecutive 1s from bottom to top
        // for each cell in each column
        int[][] bottom = new int[row][col];
        // rows: bottom --> top
        for (int i = row - 1; i >= 0; i--) {
            // cols: left --> right
            for (int j = 0; j < col; j++) {
                if (i == row - 1 || j == 0) {
                    // Initialize the bottom row and leftmost column
                    bottom[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    // Look back to one column below
                    bottom[i][j] = bottom[i + 1][j] + 1;
                }
            }
        }
        return bottom;
    }
}
