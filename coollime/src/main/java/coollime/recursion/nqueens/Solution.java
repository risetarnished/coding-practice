package coollime.recursion.nqueens;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  /**
   * Get all valid ways to put N queens on a N x N chessboard
   *
   * @param n The number of queens
   * @return  A list of all the ways (indicated by a list of the queen's y indices)
   */
  public List<List<Integer>> nquees(int n) {
    List<List<Integer>> result = new ArrayList<>();
    if (n <= 0) {
      return result;
    }
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
  private void dfsPlaceQueens(
    int n,
    List<Integer> current,
    List<List<Integer>> result
  ) {
    if (current.size() == n) {
      result.add(new ArrayList<>(current));
      return;
    }
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
    for (int i = 0; i < row; i++) {
      if (
        queens.get(i) == column || Math.abs(queens.get(i) - column) == row - i
      ) {
        return false;
      }
    }
    return true;
  }
}
