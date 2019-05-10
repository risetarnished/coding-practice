# Number of Islands

[https://app.laicode.io/app/problem/525](https://app.laicode.io/app/problem/525)

## Description

Given a 2d grid map of 1s (land) and 0s (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

```
11110
11010
11000
00000
Answer: 1
```

Example 2:

```
11000
11000
00100
00011
Answer: 3
```

**Tags**

- Medium
- Breadth First Search
- Depth First Search
- Union Find

## Solution

### High-level Idea

- At each position/cell in the matrix, we can do a breadth-first search on its four neighboring cells
  - If the neighbor is water, continue
  - If the neighbor is an island, change it to water because it is connected to another island. E.g.,
    - The input 
      - **11**000
        **11**000
        00**1**00
        000**11**
      - is the same as:
      - **1**0000
        00000
        00**1**00
        0000**1**
    - By doing so, we can avoid re-visiting and re-calculations
- For BFS:
  - Start
    - the first cell, matrix\[0]\[0]
  - Data structure to store the visiting cells
    - FIFO queue
  - Expansion/generation rule
    - Expand the queue, if we see an island
      - check its four neighbors
      - change the neighbor to water if it is an island
      - add the neighbor to the queue
  - Terminate
    - When the queue becomes empty

### Code

```java
class Solution {
  public int numIslands(char[][] grid) {
    // Corner cases
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
      return 0;
    }
    int n = grid.length;
    int m = grid[0].length;
    int islands = 0;
    // Do a BFS on the grid for each cell
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // Check the cell if it is an island
        if (grid[i][j] == '1') {
          // Mark its four (at most) neighbors to water
          markNeighbors(grid, i, j);
          islands++;
        }
      }
    }
    return islands;
  }
  
  private void markNeighbors(char[][] grid, int row, int col) {
    // Four directions: up, down, left, right
    int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // Use a Queue to store the visiting cells
    Queue<Cell> queue = new ArrayDeque<>();
    Cell first = new Cell(row, col);
    queue.offer(first);
    while (!queue.isEmpty()) {
      Cell curr = queue.poll();
      // Check all four neighbors
      for (int[] dir : dirs) {
        int nextRow = curr.row + dir[0];
        int nextCol = curr.col + dir[1];
        if (!inBound(grid, nextRow, nextCol)) {
          continue;
        }
        Cell neighbor = new Cell(nextRow, nextCol);
        // Set the neighbor to water if it is an island to avoid re-visiting and re-calculation
        if (grid[nextRow][nextCol] == '1') {
          grid[nextRow][nextCol] = '0';
          // Offer the neighbor to the queue because it was an island and we need to
          // check until all of the neighbors are water
          queue.offer(neighbor);
        }
      }
    }
  }
  
  private boolean inBound(char[][] grid, int row, int col) {
    return row >= 0 && row < grid.length && 
           col >= 0 && col < grid[0].length;
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
```

### Complexity

- Time
  - Because we mark the connected neighboring islands to water, we avoid re-visiting
  - Therefore, each cell is visited onces and only the start cells of islands, whether the island is a single-cell island or a connected-cells island, is processed and all connected island cells are converted to 0's
  - O(n * m)
- Space
  - The queue is used to store the next visiting cells (the neighboring island cells)
  - In the worst case where the entire grid consists of islands, the size of the queue will be n * m
  - O(n * m)
  

### Alternative method

*A more generic method*:

- Instead of marking the islands (1) to water (0) whenever they get check, use a more generic way: add the checked islands to a hash table to avoid duplicate visiting

#### Code

```java
class Solution {
  public int numIslands(char[][] grid) {
    // Corner cases
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
      return 0;
    }
    int n = grid.length;
    int m = grid[0].length;
    // Use a hash table to avoid re-visiting the same islands again
    boolean[][] visited = new boolean[n][m];
    int islands = 0;
    // Do a BFS on the grid for each cell
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // Check the cell if it is an island
        if (grid[i][j] == '1' && !visited[i][j]) {
          // Check the island's neighbors, and count the connected islands as one whole island
          checkNeighboringIslands(grid, i, j, visited);
          islands++;
        }
      }
    }
    return islands;
  }
  
  private void checkNeighboringIslands(char[][] grid, int row, int col, boolean[][] visited) {
    // Only proceed if this cell has not been visited before
    if (visited[row][col]) {
      return;
    }
    // Check four neighbors: up, down, left, right
    int[][] dirs = new int[][] {{-1, 0,}, {1, 0}, {0, -1}, {0, 1}};
    // Visit any neighboring islands and skip the water because connected
    // islands count as one
    Queue<Cell> queue = new ArrayDeque<>();
    queue.offer(new Cell(row, col));
    while (!queue.isEmpty()) {
      Cell curr = queue.poll();
      visited[curr.row][curr.col] = true;
      for (int[] dir : dirs) {
        int nextRow = curr.row + dir[0];
        int nextCol = curr.col + dir[1];
        if (!inBound(grid, nextRow, nextCol) || grid[nextRow][nextCol] == '0' ||
            visited[nextRow][nextCol]) {
          continue;
        }
        // Add the neighboring island that has not been visited to the queue
        queue.offer(new Cell(nextRow, nextCol));
      }
    }
  }
  
  private boolean inBound(char[][] grid, int row, int col) {
    return row >= 0 && row < grid.length && 
           col >= 0 && col < grid[0].length;
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
```

#### Complexity

- Time
  - Same time complexity as the other solution because a traversal of the entire graph is needed
  - O(n * m)
- Space
  - A hash table of the same size as the grid/graph is used
    - The hash table can be further optimized using a HashSet by overriding the `equals()` and `hashCode()` methods in the Cell class
    - By doing this, the space complexity can be optimized to be O(# of islands)
  - O(n * m)

*This solution is not acceptable on LeetCode, but ok on LaiCode probably due to some weird test cases on Leetcode*