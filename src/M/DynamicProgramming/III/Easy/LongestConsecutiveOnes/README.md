<!----- Conversion time: 0.793 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Sat Jan 19 2019 04:03:06 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1FG-JIL1akR8Qw1EP6BFjRvMazqK7XgAav_keYbw-w6U
----->



# Longest Consecutive 1's

[https://app.laicode.io/app/problem/103](https://app.laicode.io/app/problem/103)


## Description

Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.

Assumptions



*   The given array is not null

Examples



*   {0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3.

Easy

Array




## Assumption

The input array should not be null or empty


## Algorithm

This is a similar question to [Largest Subarray Sum](../../../II/Medium/LargestSubArraySum)

We also use linear scan & look back and simply just keep track of the current length of consecutive 1's and a global max length.


## Solution


### Code


```java
public class Solution {
  public int longest(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    int ones = array[0];
    int maxOnes = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] == 1) {
        maxOnes = Math.max(maxOnes, ++ones);
      } else {
        ones = 0;
      }
    }
    return maxOnes;
  }
}
```



### Complexity

Time: one iteration ⇒ O(n)

Space: int ones ⇒ O(1)


<!-- Docs to Markdown version 1.0β14 -->
