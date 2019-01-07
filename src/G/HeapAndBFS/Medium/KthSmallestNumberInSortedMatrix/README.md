<!----- Conversion time: 0.994 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Sun Jan 06 2019 18:49:16 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1Hzd2z0PuOnM8bQxqYMN6IvzleGWjCUj-8xycDjeGRPg
----->



# Kth Smallest Number in Sorted Matrix

[https://app.laicode.io/app/problem/26](https://app.laicode.io/app/problem/26)


## Description

Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.

Assumptions



*   the matrix is not null, N > 0 and M > 0
*   K > 0 and K <= N * M

Examples

{ {1,  3,   5,  7},

  {2,  4,   8,   9},

  {3,  5, 11, 15},

  {6,  8, 13, 18} }



*   the 5th smallest number is 4
*   the 8th smallest number is 6

Medium

Binary Search

Best First Search

Heap


## Assumption

The matrix is not null or empty.

K should not exceeds the range of the matrix indices.


## Algorithm

Use [Dijkstra's algorithm](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm), aka [Best-First Search](https://en.wikipedia.org/wiki/Best-first_search)



1.  Initial state: starting node = matrix[0][0]
1.  Data structure: **priority queue**
    1.  min heap of size k
1.  Node expansion/generation rule:
    1.  expand node \[i\]\[j\]
        1.  generate \[i + 1\]\[j\]
        1.  generate \[i\]\[j + 1\]
        1.  **deduplication**
            1.  boolean\[n\]\[m\] ⇒ size(n * m)
            1.  Hash table ⇒ size(k)
1.  Termination condition: when the k-th element is popped out for expansion




## Solution


### Method 1

Use a 2-D boolean array to store the points that have already been checked


#### Code


```java
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
        if (matrix == null || matrix[0].length == 0) {
            return -1;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        // Quick check for possible quick exit
        if (k == 1) {
            return matrix[0][0];
        } else if (k == rows * cols) {
            return matrix[rows - 1][cols - 1];
        }
        // Use BFS-II (Best-First Search) and a minHeap
        // When the minHeap is popped for the k-th time
        // we get the result
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k);
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        // Use a 2-D boolean matrix to mimic a hash table and record
        // the usage of Cells
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        // Do (k - 1) iterations because we have already checked the
        // first cell
        for (int i = 0; i < k - 1; i++) {
            Cell curr = minHeap.poll();
            // Go down one cell
            if (curr.row + 1 < rows && !visited[curr.row + 1][curr.col]) {
                minHeap.offer(new Cell(
                    curr.row + 1, curr.col, matrix[curr.row + 1][curr.col]
                ));
                visited[curr.row + 1][curr.col] = true;
            }
            // Go right one cell
            if (curr.col + 1 < cols && !visited[curr.row][curr.col + 1]) {
                minHeap.offer(new Cell(
                    curr.row, curr.col + 1, matrix[curr.row][curr.col + 1]
                ));
                visited[curr.row][curr.col + 1] = true;
            }
        }
        return minHeap.peek().val;
    }
}

class Cell implements Comparable<Cell> {
    int row;
    int col;
    int val;
    public Cell(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }

    @Override
    public int compareTo(Cell another) {
        // minHeap: o1 < o2 → -1
        if (this.val == another.val) {
            return 0;
        }
        return this.val < another.val ? -1 : 1;
    }
}
```



#### Complexity

Time:

(k - 1) iterations. One poll() and two offer() operations in each iteration. In a heap, offer() and poll() cost O(log(n)). In this case, the time complexity is O(k * log(k))

Space:

A minHeap of size k and a 2D boolean matrix of size m * n (m = matrix.length, n = matrix\[0\].length) were created. So the space complexity is O(k + m * n)




### Method 2

Optimization: a hashSet instead of a 2D boolean matrix can be used to store the Cells that we have visited. By doing this, we can downgrade the space complexity from O(k + m * n) to O(k + k) = O(k). To implement this method, the equals() and hashCode() method should be override in the Cell class.


#### Code


```java
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
        if (matrix == null || matrix[0].length == 0) {
            return -1;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        // Quick check for possible quick exit
        if (k == 1) {
            return matrix[0][0];
        } else if (k == rows * cols) {
            return matrix[rows - 1][cols - 1];
        }
        // Use BFS-II (Best-First Search) and a minHeap
        // When the minHeap is popped for the k-th time
        // we get the result
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k);
        Cell first = new Cell(0, 0, matrix[0][0]);
        minHeap.offer(first);
        // Use a hashSet to record the usage of Cells
        Set<Cell> visited = new HashSet<>();
        visited.add(first);
        // Do (k - 1) iterations because we have already checked the
        // first cell
        for (int i = 0; i < k - 1; i++) {
            Cell curr = minHeap.poll();
            // Go down one cell
            if (curr.row + 1 < rows) {
                Cell next = new Cell(
                    curr.row + 1, curr.col, matrix[curr.row + 1][curr.col]
                );
                if (!visited.contains(next)) {
                    minHeap.offer(next);
                    visited.add(next);
                }
            }
            // Go right one cell
            if (curr.col + 1 < cols) {
                Cell next = new Cell(
                    curr.row, curr.col + 1, matrix[curr.row][curr.col + 1]
                );
                if (!visited.contains(next)) {
                    minHeap.offer(next);
                    visited.add(next);
                }
            }
        }
        return minHeap.peek().val;
    }
}

class Cell implements Comparable<Cell> {
    int row;
    int col;
    int val;
    public Cell(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }

    @Override
    public int compareTo(Cell another) {
        // Because the val field is Integer
        // We can use the Integer.compare method
        return Integer.compare(this.val, another.val);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cell cell = (Cell) obj;
        return this.row == cell.row &&
               this.col == cell.col &&
               this.val == cell.val;
    }

    @Override
    public int hashCode() {
        // This does not work on laicode (yet)
        // return Objects.hash(row, col, val);
        int hashResult = 17;
        hashResult = 31 * hashResult + row;
        hashResult = 31 * hashResult + col;
        hashResult = 31 * hashResult + val;
        return hashResult;
    }
}
```



#### Complexity

Time:

(k - 1) iterations. One poll() and two offer() operations in each iteration. In a heap, offer() and poll() cost O(log(n)). In this case, the time complexity is O(k * log(k))

Space:

A min heap of size k and a hash table of size k ⇒ O(k)


<!-- GD2md-html version 1.0β13 -->
