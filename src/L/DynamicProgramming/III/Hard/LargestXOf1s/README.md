<!----- Conversion time: 0.699 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Sun Jan 20 2019 03:53:53 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=19CdGUBjts4KHXDYJEIQ87IN8VJydvje7GTgVpvZihRA
----->



# Largest X of 1's

[https://app.laicode.io/app/problem/105](https://app.laicode.io/app/problem/105)


## Description

Description

Given a matrix that contains only 1s and 0s, find the largest X shape which contains only 1s, with the same arm lengths and the four arms joining at the central point.

Return the arm length of the largest X shape.

Assumptions



*   The given matrix is not null, has size of N * M, N >= 0 and M >= 0.

Examples

{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1} }

the largest X of 1s has arm length 2.



Hard

2 D Array




## Assumption

As stated in the description.


## Algorithm

This problem is similar to [Largest Cross of 1's](../LongestCrossOfOnes)

In that problem, we maintain 4 matrices generated from 4 directions: left → right, right → left, top → bottom, and bottom → top. In this problem, similarly, we generate 4 matrices recording the length of 1's in 4 directions: top-left ←→ bottom-right, and top-right ←→ bottom-left.

After getting the four matrices, like what we did to get the largest length of the cross, we take the minimum value in the 4 matrices for an index (i, j).

A global max is maintained during the process such that we can keep track of what we eventually need.


## Solution


### Code


```java
public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here
    if (matrix == null || matrix.length == 0 ||
        matrix[0] == null || matrix[0].length == 0) {
      return 0;
    }
    int m = matrix.length;
    int n = matrix[0].length;
    // 4 matrices storing the length of X's formed from 4 directions
    // 1. top-left --> bottom-right ==> tl2br
    // 2. bottom-right --> top-left ==> br2tl
    // 3. top-right --> bottom-left ==> tr2bl
    // 4. bottom-left --> top-right ==> bl2tr
    int[][] topLeft = tl2br(matrix, m, n);
    int[][] bottomRight = br2tl(matrix, m, n);
    int[][] topRight = tr2bl(matrix, m, n);
    int[][] bottomLeft = bl2tr(matrix, m, n);
    // For each cell (i, j) in the 4 matrices, if matrix[i][j] == 1
    // take the min from all 4 directions:
    // top-left (i - 1, j - 1), top-right (i - 1, j + 1),
    // bottom-left (i + 1, j - 1), bottom-right (i + 1, j + 1)
    // and plus 1
    // Keep track of the global maximum
    int maxCross = 0;
    for (int i = 1; i < m - 1; i++) {
      for (int j = 1; j < n - 1; j++) {
        if (matrix[i][j] == 0) {
          continue;
        }
        maxCross = Math.max(maxCross,
                            Math.min(topLeft[i][j],
                                     Math.min(bottomRight[i][j],
                                              Math.min(topRight[i][j],
                                                       bottomLeft[i][j]))));
      }
    }
    return maxCross;
  }

  private int[][] tl2br(int[][] matrix, int row, int col) {
    // Calculate the longest consecutive 1s from top-left to bottom-right
    int[][] topLeft = new int[row][col];
    // Compare each cell (i, j) to the cell at its top-left (i - 1, j - 1)
    // rows: top --> bottom
    for (int i = 0; i < row; i++) {
      // cols: left --> right
      for (int j = 0; j < col; j++) {
        if (i == 0 || j == 0) {
          // Initialize the top row and the leftmost column
          topLeft[i][j] = matrix[i][j];
        } else if (matrix[i][j] == 1) {
          // Look back to the top-left
          topLeft[i][j] = topLeft[i - 1][j - 1] + 1;
        } // Otherwise, topLeft[i][j] = 0
      }
    }
    return topLeft;
  }

  private int[][] br2tl(int[][] matrix, int row, int col) {
    // Calculate the longest consecutive 1s from bottom-right to top-left
    int[][] bottomRight = new int[row][col];
    // Compare each cell (i, j) to the cell at its bottom-right (i + 1, j + 1)
    // rows: bottom --> top
    for (int i = row - 1; i >= 0; i--) {
      // cols: right --> left
      for (int j = col - 1; j >= 0; j--) {
        if (i == row - 1 || j == col - 1) {
          // Initialize the bottom row and the rightmost column
          bottomRight[i][j] = matrix[i][j];
        } else if (matrix[i][j] == 1) {
          // Look back to the bottom-right
          bottomRight[i][j] = bottomRight[i + 1][j + 1] + 1;
        } // Otherwise, bottomRight[i][j] = 0
      }
    }
    return bottomRight;
  }

  private int[][] tr2bl(int[][] matrix, int row, int col) {
    // Calculate the longest consecutive 1s from top-right to bottom-left
    int[][] topRight = new int[row][col];
    // Compare each cell (i, j) to the cell at its top-right (i - 1, j + 1)
    // rows: top --> bottom
    for (int i = 0; i < row; i++) {
      // cols: right --> left
      for (int j = col - 1; j >= 0; j--) {
        if (i == 0 || j == col - 1) {
          // Initialize the top row and the bottom column
          topRight[i][j] = matrix[i][j];
        } else if (matrix[i][j] == 1) {
          // Look back to the top-right
          topRight[i][j] = topRight[i - 1][j + 1] + 1;
        } // Otherwise, topRight[i][j] = 0
      }
    }
    return topRight;
  }

  private int[][] bl2tr(int[][] matrix, int row, int col) {
    // Calculate the longest consecutive 1s from bottom-left to top-right
    int[][] bottomLeft = new int[row][col];
    // Compare each cell (i, j) to the cell at its bottom-left (i + 1, j - 1)
    // rows: bottom --> top
    for (int i = row - 1; i >= 0; i--) {
      // cols: left --> right
      for (int j = 0; j < col; j++) {
        if (i == row - 1 || j == 0) {
          // Initialize the bottom row and the leftmost column
          bottomLeft[i][j] = matrix[i][j];
        } else if (matrix[i][j] == 1) {
          // Look back to the bottom-left
          bottomLeft[i][j] = bottomLeft[i + 1][j - 1] + 1;
        } // Otherwise, bottomLeft[i][j] = 0
      }
    }
    return bottomLeft;
  }
}
```



### Complexity

Time: 4 nested for-loops for the 4 directions + one nested for-loop for the final computation

⇒ O(4n^2 + n^2) = O(n^2)

Space: 5 int[][] created ⇒ O(5n^2) = O(n^2)


<!-- Docs to Markdown version 1.0β14 -->
