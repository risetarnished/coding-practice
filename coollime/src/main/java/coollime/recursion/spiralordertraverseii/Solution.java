package coollime.recursion.spiralordertraverseii;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<Integer> spiral(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return result;
    }
    spiralTraverse(matrix, result, 0, matrix.length, matrix[0].length);
    return result;
  }

  /**
   * Recursively traverse an M x N matrix in spiral order
   *
   * @param matrix    The matrix to traverse
   * @param result    The result list to store the traversal sequence
   * @param offset    The offset of the top-left corner from the origin
   * @param rowLength The length of a row in current level
   * @param colLength The length of a column in current level
   */
  private void spiralTraverse(
    int[][] matrix,
    List<Integer> result,
    int offset,
    int rowLength,
    int colLength
  ) {
    if (rowLength == 0 || colLength == 0) {
      return;
    }
    if (rowLength == 1) {
      for (int i = 0; i < colLength; i++) {
        result.add(matrix[offset][offset + i]);
      }
      return;
    }
    if (colLength == 1) {
      for (int i = 0; i < rowLength; i++) {
        result.add(matrix[offset + i][offset]);
      }
      return;
    }
    // 1. Add the top row from left to right
    for (int i = 0; i < colLength; i++) {
      result.add(matrix[offset][offset + i]);
    }
    // 2. Add the rightmost column from top to bottom
    for (int i = 1; i < rowLength - 1; i++) {
      result.add(matrix[offset + i][offset + colLength - 1]);
    }
    // 3. Add the bottom row from right to left
    for (int i = colLength - 1; i >= 0; i--) {
      result.add(matrix[offset + rowLength - 1][offset + i]);
    }
    // 4. Add the leftmost column from bottom to top
    for (int i = rowLength - 2; i >= 1; i--) {
      result.add(matrix[offset + i][offset]);
    }
    // Go to the next layer/level: offset + 1 && rowLength - 2 && colLength - 2
    spiralTraverse(matrix, result, offset + 1, rowLength - 2, colLength - 2);
  }
}
