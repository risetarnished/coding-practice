package C.Recursion.II.Medium.NQueens;

import java.util.ArrayList;
import java.util.List;

/**
 * NQueens
 *
 * @author meng
 * @date 1/22/19
 */
public class NQueens {
    /**
     * Get all valid ways to put N queens on a N x N chessboard
     *
     * @param n The number of queens
     * @return  A list of all the ways (indicated by a list of the queen's y indices)
     */
    public List<List<Integer>> nquees(int n) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        // Do DFS on each row
        // There can be at most one queen per row
        // So, in each row, we try all opening columns and
        // see if placing a queen there is valid
        dfsPlaceQueens(n, new ArrayList<>(), result);
        return result;
    }

    /**
     * DFS method to try all possible positions and find the valid ones
     *
     * @param n         The number of queens
     * @param current   The current combination of queens placed so far
     * @param result    All the ways to put the queens
     */
    private void dfsPlaceQueens(int n, List<Integer> current, List<List<Integer>> result) {
        // Base case: when we have placed all n queens
        if (current.size() == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        // Each level is represented by each row: one queen per row
        // In each row, we try all possible positions for the queen
        for (int i = 0; i < n; i++) {
            // Only place the queen at valid columns
            if (canPlaceQueen(current, i)) {
                current.add(i);
                // Go to the next level and try to place the next queen
                dfsPlaceQueens(n, current, result);
                // Backtracking
                current.remove(current.size() - 1);
            }
        }
    }

    /**
     * Test to see if a column in the current level is a valid position
     *
     * @param queens    Queen placement up to the current level
     * @param column    The column to try
     */
    private boolean canPlaceQueen(List<Integer> queens, int column) {
        // # of rows processed == # of queens placed == row #
        int row = queens.size();
        // There are "row" number of queens on the board so far
        for (int i = 0; i < row; i++) {
            // Two situations will fail the placement
            // 1. there are some other queens in the same column
            // 2. there are some other queens on the diagonal
            if (queens.get(i) == column ||
                    Math.abs(queens.get(i) - column) == row - i) {
                // Case 2 is expressed by the slope of diff(col) / diff(row)
                // We cannot simply use diff(col) / diff(row) since
                // diff(row) can be 0
                return false;
            }
        }
        return true;
    }
}
