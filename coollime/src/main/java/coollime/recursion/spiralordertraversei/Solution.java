package coollime.recursion.spiralordertraversei;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<Integer> spiral(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return result;
    }
    spiralTraverse(matrix, result, 0, matrix.length);
    return result;
  }

  /**
   * Recursively traverse a matrix in spiral order
   *
   * @param matrix    The input matrix to traverse
   * @param result    The list to store the traversal sequence
   * @param offset    The offset of the top-left corner from the origin
   * @param length    The length of the the side in the current level
   */
  private void spiralTraverse(
    int[][] matrix,
    List<Integer> result,
    int offset,
    int length
  ) {
    if (length == 0) {
      return;
    } else if (length == 1) {
      result.add(matrix[offset][offset]);
      return;
    }
    // Top row: left → right
    for (int i = 0; i < length; i++) {
      result.add(matrix[offset][offset + i]);
    }
    // Rightmost column: top → bottom
    for (int i = 1; i < length - 1; i++) {
      result.add(matrix[offset + i][offset + length - 1]);
    }
    // Bottom row: right → left
    for (int i = length - 1; i >= 0; i--) {
      result.add(matrix[offset + length - 1][offset + i]);
    }
    // Leftmost column: bottom → top
    for (int i = length - 2; i >= 1; i--) {
      result.add(matrix[offset + i][offset]);
    }
    spiralTraverse(matrix, result, offset + 1, length - 2);
  }
}
