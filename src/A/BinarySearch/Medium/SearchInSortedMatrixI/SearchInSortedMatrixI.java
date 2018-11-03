package A.BinarySearch.Medium.SearchInSortedMatrixI;

/**
 * Description
 * Given a 2D matrix that contains integers only, which each row is sorted in an ascending order. The first element of next row is larger than (or equal to) the last element of previous row.
 *
 * Given a target number, returning the position that the target locates within the matrix. If the target number does not exist in the matrix, return {-1, -1}.
 *
 * Assumptions:
 *
 * The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.
 * Examples:
 *
 * matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }
 *
 * target = 7, return {1, 2}
 *
 * target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
 **/

public class SearchInSortedMatrixI {
    public int[] search(int[][] matrix, int target) {
        // Write your solution here
        if (matrix == null || matrix.length == 0 ||
            matrix[0] == null || matrix[0].length == 0) {
            return new int[] {-1, -1};
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // Treat the indices as if they were in an array
        int start = 0;
        int end = m * n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // Array index / # of columns in a row ==> row number
            // Array index % # of columns in a row ==> column number
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                return new int[] {row, col};
            } else if (matrix[row][col] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return new int[] {-1, -1};
    }
}
