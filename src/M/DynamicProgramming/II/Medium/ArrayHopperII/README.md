<!----- Conversion time: 0.796 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Fri Jan 18 2019 02:24:58 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1UW0oIebpvAeaqobXak-x2pToyewMT05UXx6BaL-FlNY
----->



# Array Hopper II

[https://app.laicode.io/app/problem/89](https://app.laicode.io/app/problem/89)


## Description

Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from index i (you can only jump towards the end of the array). Determine the minimum number of jumps you need to reach the end of array. If you can not reach the end of the array, return -1.

Assumptions



*   The given array is not null and has length of at least 1.

Examples



*   {3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)
*   {2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.

Medium

Greedy




## Assumption

Array is not null or not empty.


## Algorithm

This is similar to[ Array Hopper I](../../../I/Medium/ArrayHopperI) where we are supposed to maintain a boolean array recording whether it is possible to reach the last index of the array from index i. In this case, however, we maintain an integer array to record the number of steps it takes to get to the end of the array from current index i.

We can do this in the direction of end → 0 again and initialize the minimum jumps at index i to Integer.MAX_VALUE such that when we increment it, there will be overflow and the number becomes Integer.MIN_VALUE which kind of look like a "flag" that we set and check to mark it is not possible to reach the end from there.




## Solution


### Code


```java
public class Solution {
  public int minJump(int[] array) {
    // Write your solution here
    // Assumption
    if (array == null || array.length == 0) {
      return -1;
    }
    int n = array.length;
    int[] jumps = new int[n];
    // Initialization: it takes 0 jumps when we are at the end already
    jumps[n - 1] = 0;
    // Iterate over the whole array: end → 0
    for (int i = n - 2; i >= 0; i--) {
      // When array[i] == 0, we cannot get to the end from where
      // we are. Set jumps[i] to MIN_VALUE as if it were a flag
      if (array[i] == 0) {
        jumps[i] = Integer.MIN_VALUE;
        continue;
      }
      // minJump represents the minimum number of jumps it takes
      // to get to the end from i
      int minJump = Integer.MAX_VALUE;
      // Because array[i] != 0, we need to check all the possible
      // number of jumps it could make [1, array[i]]
      for (int j = 1; j <= array[i]; j++) {
        if (i + j > n - 1) {
          // Out of bounds
          break;
        }
        if (jumps[i + j] == Integer.MIN_VALUE) {
          // Not able to reach the end from there
          continue;
        }
        // When we reach an index where we can get to the end,
        // update minJump
        minJump = Math.min(minJump, jumps[i + j]);
      }
      jumps[i] = minJump + 1;
    }
    return jumps[0] == Integer.MIN_VALUE ? -1 : jumps[0];
  }
}
```



####


#### Alternative method:

Same algorithm, but instead of using the trick Integer.MAX_VALUE + 1 == Integer.MIN_VALUE, we simply use -1 to mark the position where we cannot get to the end. By doing this, we can simplify our return statement.


```java
public class Solution {
  public int minJump(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return -1;
    }
    int n = array.length;
    int[] jumps = new int[n];
    // jumps[i] represents the min # of jumps it takes
    // from i to get to the end
    // Base case: 0 jumps when jumping from the end
    jumps[n - 1] = 0;
    // Iterate in the direction from end to start
    for (int i = n - 2; i >= 0; i--) {
      if (array[i] == 0) {
        // Case 1
        // max # of jumps is 0 ==> jump to nowhere
        jumps[i] = -1;
      } else if (i + array[i] >= n - 1) {
        // Case 2
        // max # of jumps takes us out of bounds
        jumps[i] = 1;
      } else {
        // Case 3
        // Check all possible jumps that we can get to
        // And find the min among the ones that can
        // take us to the end
        int minJumps = Integer.MAX_VALUE;
        for (int j = 1; j <= array[i]; j++) {
          if (jumps[i + j] == -1) {
            // Skip the ones that cannot make it
            continue;
          }
          minJumps = Math.min(minJumps, jumps[i + j]);
        }
        jumps[i] = minJumps == Integer.MAX_VALUE ? -1 : minJumps + 1;
      }
    }
    return jumps[0];
  }
}
```



#### Complexity

Time: one iteration from n - 2 → 0, in which an iteration from 1 → array[i] happens for each index. So O(n^2)

Space: int[] jumps. So O(n).


<!-- Docs to Markdown version 1.0β14 -->
