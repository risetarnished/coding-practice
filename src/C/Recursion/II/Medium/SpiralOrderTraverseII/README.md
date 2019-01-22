<!----- Conversion time: 0.686 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Tue Jan 22 2019 03:17:09 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1G90wSQpfyARPOhUBynMTzmzdiFnRxqWSR8Owy1ZXA3g
----->



# Spiral Order Traverse II

[https://app.laicode.io/app/problem/122](https://app.laicode.io/app/problem/122)


## Description

Traverse an M x N  2D array in spiral order clockwise starting from the top left corner. Return the list of traversal sequence.

_Assumptions_



*   _The 2D array is not null and has size of M _ N where M, N >= 0

Examples

{ {1,  2,  3,  4},

  {5,  6,  7,  8},

  {9, 10, 11, 12} }

the traversal sequence is \[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]



Medium

2 D Array




## Assumption

The input matrix should not be null or empty. The size of the matrix is M x N.


## Algorithm

This problem is similar to [Spiral Order Traverse I](../SpiralOrderTraverseI)

By doing this recursively.



1.  Base case:
    1.  When there are no more elements left in the matrix to be checked ⇒ this can happen when M == N ⇒ this is the same situation in _Spiral Order Traverse I_
    1.  When there is only one row left to be checked ⇒ add the remaining row in left → right order
    1.  When there is only one column left to be checked ⇒ add the remaining column in top → bottom order
1.  Recursive rule:
    1.  Add the elements level by level, in the order of top row (left → right) → rightmost column (top → bottom) → bottom row (right → left) → leftmost column (bottom → top).
    1.  Go to the next level (inside):
        1.  offset + 1: the new top-left corner of the spiral array (i', j') compared to the top-left corner of the previous spiral array (i, j) ⇐ ⇒ i' = i + 1 && j' = j + 1
        1.  rowLength - 2 && colLength - 2: the length of the edge in the new spiral array l' is 2 less than that of the previous array l (l' = l - 2) because we are cutting both ends off




## Solution


### Code


```java
public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return result;
    }
    spiralTraverse(matrix, result, 0, matrix.length, matrix[0].length);
    return result;
  }

  private void spiralTraverse(int[][] matrix, List<Integer> result,
                              int offset, int rowLength, int colLength) {
    // Base case:
    // 1. When there are no more elements left
    if (rowLength == 0 || colLength == 0) {
      return;
    }
    // 2. When there is only one row left
    // Add the row from left to right
    if (rowLength == 1) {
      for (int i = 0; i < colLength; i++) {
        result.add(matrix[offset][offset + i]);
      }
      return;
    }
    // 3. When there is only one column left
    // Add the column from top to bottom
    if (colLength == 1) {
      for (int i = 0; i < rowLength; i++) {
        result.add(matrix[offset + i][offset]);
      }
      return;
    }
    // Recursive rule
    // 1. Add the top row from left to right
    for (int i = 0; i < colLength; i++) {
      result.add(matrix[offset][offset + i]);
    }
    // 2. Add the rightmost column from top to bottom
    for (int i = 1; i < rowLength - 1; i++) {
      result.add(matrix[offset + i][offset + colLength - 1]);
    }
    // 3. Add the bottom row from right to left
    for (int i = colLength - 1; i >= 0; i--) {
      result.add(matrix[offset + rowLength - 1][offset + i]);
    }
    // 4. Add the leftmost column from bottom to top
    for (int i = rowLength - 2; i >= 1; i--) {
      result.add(matrix[offset + i][offset]);
    }
    // Go to the next layer/level: offset + 1 && rowLength - 2 && colLength - 2
    spiralTraverse(matrix, result, offset + 1, rowLength - 2, colLength - 2);
  }
}
```



### Complexity

Time:

The size of the matrix is M x N, we are checking every single element in it ⇒ O(M x N) ⇒ O(n)

Space:

rowLength - 2 && colLength - 2 in each level ⇒ O(n / 2)


<!-- Docs to Markdown version 1.0β14 -->
