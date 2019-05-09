package G.HeapAndBFS.Medium.NumberOfIslands;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    // Write your solution here
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
      return 0;
    }
    // For each cell/position in the grid, do a breadth-first search from there if it is an island
    // check for its four neighbors until all surrounding cells are water
    int n = grid.length;
    int m = grid[0].length;
    int islands = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == '1') {
          removeConnectedIslands(grid, i, j);
          islands++;
        }
      }
    }
    return islands;
  }

  private void removeConnectedIslands(char[][] grid, int row, int col) {
    // Four directions: up, down, left, right
    int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // Use a Queue to store the visiting cells
    Queue<Cell> queue = new ArrayDeque<>();
    // Start from the current cell
    Cell start = new Cell(row, col);
    queue.offer(start);
    while (!queue.isEmpty()) {
      Cell curr = queue.poll();
      for (int[] dir : dirs) {
        int nextRow = curr.row + dir[0];
        int nextCol = curr.col + dir[1];
        if (!isInBound(grid, nextRow, nextCol)) {
          continue;
        }
        if (grid[nextRow][nextCol] == '1') {
          grid[nextRow][nextCol] = '0';
          queue.offer(new Cell(nextRow, nextCol));
        }
      }
    }
  }

  private boolean isInBound(char[][] grid, int row, int col) {
    return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
  }
}

class Cell {
  int row;
  int col;
  Cell(int row, int col) {
    this.row = row;
    this.col = col;
  }
}
