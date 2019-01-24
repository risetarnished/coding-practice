<!----- Conversion time: 0.649 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Fri Jan 18 2019 02:58:22 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1eZJN59r0vxVTlAI-MA_PYyjOA4byhLrdLicM3tDr1rI
----->



# Largest SubArray Sum

[https://app.laicode.io/app/problem/97](https://app.laicode.io/app/problem/97)


## Description

Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.

Assumptions



*   The given array is not null and has length of at least 1.

Examples



*   {2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5
*   {-2, -1, -3}, the largest subarray sum is -1

Medium

Array




## Assumption

The input array should not be null or empty.


## Algorithm


### Naive solution: Linear scan & look back

Simply use an array to record the largest subarray sum up to the first i elements.

Compare the currentSum after the addition of array\[i]


### Optimized solution: linear scan & look back

Only record the currentSum upto the i-th (first i) element. With a single integer variable. We do not need to record all the previous sums.




## Solution


### Method 1


#### Code


```
public class Solution {
  public int largestSum(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    int[] sum = new int[array.length];
    // sum[i] represents the subarray sum of the first i elements
    sum[0] = array[0];
    int maxSum = array[0];
    for (int i = 1; i < array.length; i++) {
      sum[i] = Math.max(sum[i - 1] + array[i], array[i]);
      maxSum = Math.max(maxSum, sum[i]);
    }
    return maxSum;
  }
}
```



#### Complexity

Time: one iteration ⇒ O(n)

Space: int[] sum ⇒ O(n)


### Method 2


#### Code


```java
public class Solution {
  public int largestSum(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return 0;
    }
    int currentSum = array[0];
    int maxSum = array[0];
    for (int i = 1; i < array.length; i++) {
      currentSum = Math.max(currentSum + array[i], array[i]);
      maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
  }
}
```



#### Complexity

Time: one iteration ⇒ O(n)

Space: int sum ⇒ O(1)


<!-- Docs to Markdown version 1.0β14 -->
