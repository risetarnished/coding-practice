# Walls and Gates

<https://app.laicode.io/app/problem/503>

## Description

You are given a *m x n* 2D grid initialized with these three possible values.

1. `-1` - A wall or an obstacle.
2. `0` - A gate.
3. `INF` - Infinity means an empty room. We use the value `231 - 1 = 2147483647` to represent `INF` as you may assume that the distance to a gate is less than `2147483647`.

Fill each empty room with the distance to its *nearest* gate. If it is impossible to reach a gate, it should be filled with `INF`.

For example, given the 2D grid:

```
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
```



After running your function, the 2D grid should be:

```
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
```



**Tags**

- Medium
- Breadth-first search

## Assumption

- The input 2-D matrix shall not be null or empty
  - If matrix is null or empty
    - return {}
  - If matrix[0] is null or empty
    - return { {} }
  - In either case, simply return whatever gets passed in
- Changes can be made on the input matrix
  - May not be a very good practice
  - But if we'd like to restore the original data, we can just change any cells that are not 0 or -1 back to INF

## Solution

### High-level Idea

- Traverse the matrix, treat it like a graph, when we see a 0 (gate), try to do a breadth-first search on its 4 directions
- Starting point: every gate (0) in the graph/matrix --> offered to a FIFO queue
- Data structure: FIFO queue
- Expansion/Generation
  - Expand the queue and get a starting point (initially a gate)
  - Generate the starting point's 4 neighboring cells
    - If the neighboring cell is ***not -1 (wall)*** or ***has not been visited*** yet or ***has been visited but with a longer distance to its previous starting gate***
      - Mark the cell with the distance to the current gate
      - Put the neighbor to the queue for traversing later
  - Terminate when the queue becomes empty for each gate
- Terminate the entire search when all gates have been examined

### Code

```java
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
```

