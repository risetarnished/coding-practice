package L.DynamicProgramming.II.Hard.LargestSquareOfOnes;

public class LargestSquareOfOnes {
    public int largest(int[][] matrix) {
        // Write your solution here
        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        // The size of the matrix is N x N
        int n = matrix.length;
        int[][] length = new int[n][n];
        // length[i][j] represents the length of the side
        // of the largest square whose bottom right
        // corner is at index (i, j)
        for (int i = 0; i < n; i++) {
            length[i][0] = matrix[i][0];
            length[0][i] = matrix[0][i];
        }
        // For each index (i, j), we check its three previous
        // neighbors and pick the smallest among them
        int maxLength = length[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    length[i][j] = 0;
                } else {
                    length[i][j] = 1 + Math.min(length[i - 1][j - 1],
                                                Math.min(length[i][j - 1],
                                                         length[i - 1][j]));
                    maxLength = Math.max(maxLength, length[i][j]);
                }
            }
        }
        return maxLength;
    }
}
