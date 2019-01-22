package C.Recursion.II.Medium.SpiralOrderTraverseI;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Order Traverse I
 *
 * @author meng
 * @date 1/22/19
 */
public class SpiralOrderTraverseI {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here
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
    private void spiralTraverse(int[][] matrix, List<Integer> result,
                                int offset, int length) {
        // Base case:
        // 1. When we reach the center, but there is nothing left
        // 2. When we reach the center, and there is ONE element
        if (length == 0) {
            return;
        } else if (length == 1) {
            result.add(matrix[offset][offset]);
            return;
        }
        // Recursive rule:
        // 1. Add the elements level by level, in the order of:
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
        // 2. Go to the next level (inside)
        //    a. offset + 1: moving one layer inside ⇒ row++ && col++
        //    b. length - 2: cutting both ends off
        spiralTraverse(matrix, result, offset + 1, length - 2);
    }
}
