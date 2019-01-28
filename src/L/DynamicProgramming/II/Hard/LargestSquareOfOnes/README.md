<!----- Conversion time: 1.056 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Sat Jan 19 2019 02:37:55 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=10rDtLA1zP7JOsbv7BCYyCbVTlbuIPOfW07BQqqX82QA
* This document has images: check for >>>>>  gd2md-html alert:  inline image link in generated source and store images to your server.
----->


# Largest Square of 1's

[https://app.laicode.io/app/problem/101](https://app.laicode.io/app/problem/101)


## Description

Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.

Assumptions



*   The given matrix is not null and guaranteed to be of size N * N, N >= 0

Examples

{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1}}

the largest square of 1s has length of 2



Hard

2 D Array




## Assumption

The matrix should not be null or empty. If it is null or empty, we should return 0 because there are no squares in it.


## Algorithm

2D DP.

The matrix is guaranteed to be in size of N x N. So, we can maintain a matrix of the same size, named length, to record the length of the side of squares.

At index (i, j), length\[i]\[j] represents the length of the side of the largest square formed whose bottom right corner is at (i, j).

We also need to keep track of the global largest length.



![alt_text](notes.png "image_tooltip")



### Solution


#### Code


```java
public class Solution {
    public int largest(int[][] matrix) {
        // Write your solution here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        // Size of the matrix is guaranteed to be N x N
        int N = matrix.length;
        int[][] length = new int[N][N];
        // length[i][j] represents the length of the side of the largest
        // square whose bottom right corner is at (i, j)
        int largestLength = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || j == 0) {
                    // Initialization step
                    length[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    // No squares can be formed at this corner
                    length[i][j] = 0;
                } else if (matrix[i][j] == 1) {
                    length[i][j] = Math.min(length[i - 1][j],
                                            length[i][j - 1]);
                    length[i][j] = Math.min(length[i - 1][j - 1],
                                            length[i][j]) + 1;
                }
                // Update the global largest length
                largestLength = Math.max(largestLength, length[i][j]);
            }
        }
        return largestLength;
    }
}
```



#### Complexity

Time: nested for-loops ⇒ O(N^2)

Space: int[][] ⇒ O(N^2)


<!-- Docs to Markdown version 1.0β14 -->
