package N.CrossTraining.I.Medium.RotateMatrix;

public class RotateMatrix {
    /**
     * Rotate an N x N matrix 90 degrees clockwise
     * 
     * @param matrix The input N x N matrix
     */
    public void rotate(int[][] matrix) {
        // Write your solution here
        if (matrix == null || matrix.length == 0) {
            return;
        }
        if (matrix[0] == null|| matrix[0].length == 0) {
            return;
        }
        if (matrix.length != matrix[0].length){
            return;
        }
        rotateMatrix(matrix, 0, matrix.length);
    }

    /**
     * Recursively rotate a matrix by 90 degrees clockwise
     * 
     * @param matrix The matrix to be rotated
     * @param offset The offset of the current starting point
     * @param length The length of the part that is yet to be rotated
     */
    private void rotateMatrix(int[][] matrix, int offset, int length) {
        // Base case: when we reach the center
        // there could be one or none element left
        if (length <= 1) {
            return;
        }
        // For rows and columns with length == n
        // rotate each indices:
        // record the value of (0, 0)
        // (n - 1, 0) → (0, 0), (n - 1, n - 1) → (n - 1, 0)
        // (0, n - 1) → (n - 1, n - 1), (0, 0) → (0, n - 1)
        for (int i = 0; i < length - 1; i++) {
            int origin = matrix[offset][offset + i];
            matrix[offset][offset + i] = 
                    matrix[offset + length - 1 - i][offset];
            matrix[offset + length - 1 - i][offset] =
                    matrix[offset + length - 1][offset + length - 1 - i];
            matrix[offset + length - 1][offset + length - 1 - i] = 
                    matrix[offset + i][offset + length - 1];
            matrix[offset + i][offset + length - 1] = origin;
        }
        rotateMatrix(matrix, offset + 1, length - 2);
    }
}