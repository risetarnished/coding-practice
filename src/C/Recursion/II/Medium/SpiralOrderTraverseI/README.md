<!----- Conversion time: 0.712 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Tue Jan 22 2019 03:01:46 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1wblBipyNxtyoYhqhY7PboKnQiR7GFxgxNNyTAC1RhxM
----->



## Spiral Order Traverse I

[https://app.laicode.io/app/problem/121](https://app.laicode.io/app/problem/121)


# Description

Traverse an N x N _2D array_ in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

_Assumptions_



*   _The 2D array is not null and has size of N _N where N >= 0

_Examples_

    { {1,  2,  3},

      {4,  5,  6},

      {7,  8,  9} }

the traversal sequence is \[1, 2, 3, 6, 9, 8, 7, 4, 5]



Medium

2 D Array




## Assumption

The input matrix should not be null or empty. The size of the matrix is N x N.


## Algorithm

Recursion.



1.  Base case: when we reach the center element in the matrix
1.  Recursive rule:
    1.  Add the elements level by level, in the order of top row (left → right) → rightmost column (top → bottom) → bottom row (right → left) → leftmost column (bottom → top).
    1.  Go to the next level (inside):
        1.  offset + 1: the new top-left corner of the spiral array (i', j') compared to the top-left corner of the previous spiral array (i, j) ⇐ ⇒ i' = i + 1 && j' = j + 1
        1.  length - 2: the length of the edge in the new spiral array l' is 2 less than that of the previous array l (l' = l - 2) because we are cutting both ends off




## Solution


### Code


```java
public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return result;
    }
    spiralTraverse(matrix, result, 0, matrix.length);
    return result;
  }

  private void spiralTraverse(int[][] matrix, List<Integer> result,
                              int offset, int length) {
    // Base case:
    // 1. When we reach the center element, but there is nothing left
    if (length == 0) {
      return;
    }
    // 2. When we reach the center and there is one element
    if (length == 1) {
      result.add(matrix[offset][offset]);
      return;
    }
    // Recursive rule:
    // 1. Add the elements level by level, in the order of:
    // Top row: left → right
    for (int i = 0; i < length; i++) {
      result.add(matrix[offset][offset + i]);
    }
    // Rightmost column: top → bottom
    for (int i = 1; i < length - 1; i++) {
      result.add(matrix[offset + i][offset + length - 1]);
    }
    // Bottom row: right → left
    for (int i = length - 1; i >= 0; i--) {
      result.add(matrix[offset + length - 1][offset + i]);
    }
    // Leftmost column: bottom → top
    for (int i = length - 2; i >= 1; i--) {
      result.add(matrix[offset + i][offset]);
    }
    // 2. Go to the next level (inside):
    //    a. offset + 1: moving one layer inside ⇒ row++ && col++
    //    b. length - 2: cutting both ends off
    spiralTraverse(matrix, result, offset + 1, length - 2);
  }
}
```



### Complexity

Time:

matrix size is N x N, we check every single element of it ⇒ O(number of elements) ⇒ O(n)

Space:

length - 2 each time ⇒ **O(n / 2)**


<!-- Docs to Markdown version 1.0β14 -->
