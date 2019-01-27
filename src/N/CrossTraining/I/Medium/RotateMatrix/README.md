<!----- Conversion time: 0.774 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Sun Jan 27 2019 03:16:19 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1jl1qSFAe02KvVPkvzStgeWSuKoxaRGAblxm0a1RtpS4
----->



# Rotate Matrix

[https://app.laicode.io/app/problem/125](https://app.laicode.io/app/problem/125)


## Description

Rotate an N * N matrix clockwise 90 degrees.

Assumptions



*   The matrix is not null and N >= 0

Examples

{ {1,  2,  3}

  {8,  9,  4},

  {7,  6,  5} }

after rotation is

{ {7,  8,  1}

  {6,  9,  2},

  {5,  4,  3} }

Medium

2 D Array




## Assumption

The matrix cannot be null or empty. The size has to be N x N so it could be rotated.


## Algorithm

This problem is pretty much the same as the [Spiral Traverse I](../../../../../C/Recursion/II/Medium/SpiralOrderTraverseI) problem.

We use the same idea of passing the remaining column/row length and offset into a helper function.

To rotate, for example, in matrix

	1 2 3

	8 9 4

	7 6 5

Rotate 7 to 1, 5 to 7, 3 to 5, and finally 1 to 3 respectively.

Next, 8 to 2, 6 to 8, 4 to 6, 2 to 4. And we finish the first round.

To go to the next level/layer, offset + 1 && length - 2




## Solution


### Code


```java
public class Solution {
  public void rotate(int[][] matrix) {
    // Write your solution here
    if (matrix == null || matrix.length == 0 ||
        matrix[0] == null || matrix[0].length == 0) {
      return;
    }
    if (matrix.length != matrix[0].length) {
      return;
    }
    // Spiral traversal of matrix trick
    rotateMatrix(matrix, 0, matrix.length);
  }

  private void rotateMatrix(int[][] matrix, int offset, int length) {
    // Base case: when we reach the center
    // There could be one or no elements
    if (length <= 1) {
      return;
    }
    // For rows and columns with length == n
    // rotate each indices:
    // record the value of (0, 0)
    // (n - 1, 0) → (0, 0), (n - 1, n - 1) → (n - 1, 0)
    // (0, n - 1) → (n - 1, n - 1), (0, 0) → (0, n - 1)
    for (int i = 0; i < length - 1; i++) {
      int origin = matrix[offset][offset + i];
      matrix[offset][offset + i] =
              matrix[offset + length - 1 - i][offset];
      matrix[offset + length - 1 - i][offset] =
              matrix[offset + length - 1][offset + length - 1 - i];
      matrix[offset + length - 1][offset + length - 1 - i] =
              matrix[offset + i][offset + length - 1];
      matrix[offset + i][offset + length - 1] = origin;
    }
    rotateMatrix(matrix, offset + 1, length - 2);
  }
}
```



### Complexity

Time: length - 2 in each layer ⇒ O(n / 2)

Space: height of the recursion tree == log(n / 2) ⇒ O(log(n / 2))


<!-- Docs to Markdown version 1.0β14 -->
