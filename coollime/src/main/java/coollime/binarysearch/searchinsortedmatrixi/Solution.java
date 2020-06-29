package coollime.binarysearch.searchinsortedmatrixi;

public class Solution {
  public int[] search(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return new int[] { -1, -1 };
    }

    int m = matrix.length;
    int n = matrix[0].length;

    int start = 0;
    int end = m * n - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      int row = mid / n;
      int col = mid % n;
      if (matrix[row][col] == target) {
        return new int[] { row, col };
      } else if (matrix[row][col] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return new int[] { -1, -1 };
  }
}
