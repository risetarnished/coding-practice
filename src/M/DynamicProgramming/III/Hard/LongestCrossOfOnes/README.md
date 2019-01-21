<!----- Conversion time: 1.166 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Sun Jan 20 2019 03:11:43 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=157oUrrKr0YBL2HRbsbB07qM3tWPHSrBzwwNmWs8B_KM
* This document has images: check for >>>>>  gd2md-html alert:  inline image link in generated source and store images to your server.
----->


# Longest Cross of 1's

[https://app.laicode.io/app/problem/104](https://app.laicode.io/app/problem/104)


## Description

Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, with the same arm lengths and the four arms joining at the central point.

Return the arm length of the largest cross.

Assumptions



*   The given matrix is not null, has size of N * M, N >= 0 and M >= 0.

Examples

{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1} }

the largest cross of 1s has arm length 2.



Hard

2 D Array




## Assumption

The matrix should not be null or empty.

If there are no elements in the matrix, return 0.


## Algorithm

For each cell at index (i, j) in the matrix, we need to check the length of consecutive 1's ended there from 4 different directions: left → right, right → left, top → bottom, and bottom → top

For example,




![alt_text](longestcross.png "image_tooltip")


For each direction, we use the classic linear scan & look back method.

After we get the result from all 4 directions, we take the minimum among the 4 for that cell. At the end, return the global max maintained.


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
    // Use 4 (m x n) matrices to record the length of
    // consecutive 1s at (i, j) from 4 directions
    int[][] left = left2right(matrix, m, n);
    int[][] right = right2left(matrix, m, n);
    int[][] top = top2bottom(matrix, m, n);
    int[][] bottom = bottom2top(matrix, m, n);
    // At each index (i, j), we compare the length of
    // consecutive 1s from 4 directions
    // Take the min of them because it is the only
    // viable one.
    // Return the max value in the m x n matrix
    int maxLength = 0;
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        // Start from 1 because with only row 0 and column 0
        // There cannot be any crosses formed
        maxLength = Math.max(maxLength,
                             Math.min(left[i][j], Math.min(right[i][j],
                                      Math.min(top[i][j], bottom[i][j]))));
      }
    }
    return maxLength;
  }

  private int[][] left2right(int[][] matrix, int row, int col) {
    // Calculate the length of consecutive 1s from left to right
    // for each cell in each row
    int[][] left = new int[row][col];
    // rows: top --> bottom
    for (int i = 0; i < row; i++) {
      // cols: left --> right
      for (int j = 0; j < col; j++) {
        if (i == 0 || j == 0) {
          // Initialize the top row and the leftmost column
          left[i][j] = matrix[i][j];
        } else if (matrix[i][j] == 1) {
          // Look back to one column on the left
          left[i][j] = left[i][j - 1] + 1;
        } // Otherwise, left[i][j] = 0
      }
    }
    return left;
  }

  private int[][] right2left(int[][] matrix, int row, int col) {
    // Calculate the length of consecutive 1s from right to left
    // for each cell in each row
    int[][] right = new int[row][col];
    // rows: top --> bottom
    for (int i = 0; i < row; i++) {
      //cols: right --> left
      for (int j = col - 1; j >= 0; j--) {
        if (i == 0 || j == col - 1) {
          // Initialize the top row and the rightmost column
          right[i][j] = matrix[i][j];
        } else if (matrix[i][j] == 1) {
          // Look back to one column on the right
          right[i][j] = right[i][j + 1] + 1;
        }
      }
    }
    return right;
  }

  private int[][] top2bottom(int[][] matrix, int row, int col) {
    // Calculate the length of consecutive 1s from top to bottom
    // for each cell in each row
    int[][] top = new int[row][col];
    // rows: top --> bottom
    for (int i = 0; i < row; i++) {
      // cols: left --> right
      for (int j = 0; j < col; j++) {
        if (i == 0 || j == 0) {
          // Initialize the top row and the leftmost column
          top[i][j] = matrix[i][j];
        } else if (matrix[i][j] == 1) {
          // Look back to one row above
          top[i][j] = top[i - 1][j] + 1;
        }
      }
    }
    return top;
  }

  private int[][] bottom2top(int[][] matrix, int row, int col) {
    // Calculate the length of consecutive 1s from bottom to top
    // for each cell in each row
    int[][] bottom = new int[row][col];
    // rows: bottom --> top
    for (int i = row - 1; i >= 0; i--) {
      // cols: left --> right
      for (int j = 0; j < col; j++) {
        if (i == row - 1 || j == 0) {
          // Initialize the bottom row and the leftmost column
          bottom[i][j] = matrix[i][j];
        } else if (matrix[i][j] == 1) {
          // Look back to one row below
          bottom[i][j] = bottom[i + 1][j] + 1;
        }
      }
    }
    return bottom;
  }
}
```



### Complexity

Time: 4 nested for-loops for the 4 directions + one nested for-loop for the final computation

⇒ O(4n^2 + n^2) = O(n^2)

Space: 5 int[][] created ⇒ O(5n^2) = O(n^2)


<!-- Docs to Markdown version 1.0β14 -->
