package G.HeapAndBFS.Medium.WallsAndGates;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
  public int[][] wallsAndGates(int[][] rooms) {
    // Write your solution here
    // Corner cases according to our assumption
    if (rooms == null || rooms.length == 0 ||
        rooms[0] == null || rooms[0].length == 0) {
      return rooms;
    }
    // For every cell in the matrix, do a breadth-first search
    // on each gate to mark the distance from it to all the rooms
    // that are reachable
    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[0].length; j++) {
        if (rooms[i][j] == 0) {
          markDistance(rooms, i, j);
        }
      }
    }
    return rooms;
  }

  private void markDistance(int[][] rooms, int row, int col) {
    int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Queue<Cell> queue = new ArrayDeque<>();
    // Start from the gate
    queue.offer(new Cell(row, col));
    // Keep track of the distance of the rooms from the gate
    int distance = 0;
    while (!queue.isEmpty()) {
      // Traverse the graph level by level
      // Such that we can get the distance easily
      distance++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Cell curr = queue.poll();
        for (int[] dir : dirs) {
          int nextRow = curr.row + dir[0];
          int nextCol = curr.col + dir[1];
          // Only update the distance if the neighbor is valid
          if (isValid(rooms, distance, nextRow, nextCol)) {
            rooms[nextRow][nextCol] = distance;
            queue.offer(new Cell(nextRow, nextCol));
          }
        }
      }
    }
  }

  private boolean isValid(int[][] rooms, int distance, int row, int col) {
    // Valid case 1: the cell is in bounds
    if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length) {
      return false;
    }
    // Valid case 2 & 3: the cell is not a room or the room is closer to some other gate
    return rooms[row][col] > 1 && distance < rooms[row][col];
  }
}

class Cell {
  int row;
  int col;
  Cell (int row, int col) {
    this.row = row;
    this.col = col;
  }
}
