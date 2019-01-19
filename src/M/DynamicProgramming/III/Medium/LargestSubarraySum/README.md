<!----- Conversion time: 0.538 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Sat Jan 19 2019 03:16:32 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=196HrH2NFQGEikEzY2hOgwT5-fRS5UE8d5fysHnErDLY
----->



# Largest SubArray Sum

[https://app.laicode.io/app/problem/489](https://app.laicode.io/app/problem/489)


## Description

Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum and the indices of the left and right boundaries of the subarray. If there are multiple solutions, return the leftmost subarray.

Assumptions



*   The given array is not null and has length of at least 1.

Examples



*   {2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5. The indices of the left and right boundaries are 0 and 2, respectively.
*   {-2, -1, -3}, the largest subarray sum is -1. The indices of the left and right boundaries are both 1

    Return the result in a array as \[sum, left, right]


Medium

Dynamic Programming




## Assumption

The input array cannot be null or empty


## Algorithm

This is another alternative questions of the classic _[Largest Subarray Sum](../../../II/Medium/LargestSubArraySum)_ problem.

We use linear scan and look back, too. This time, however, we need some additional variables to record the current start index, the start and end index that gives us the subarray with the maximum sum.




## Solution


### Code


```java
public class Solution {
    public int[] largestSum(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return array;
        }
        int currentSum = array[0];
        int maxSum = array[0];
        int currentStart = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 1; i < array.length; i++) {
            if (currentSum < 0) {
                currentSum = array[i];
                currentStart = i;
            } else {
                currentSum += array[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxStart = currentStart;
                maxEnd = i;
            }
        }
        return new int[] {maxSum, maxStart, maxEnd};
    }
}
```



### Complexity


#### Time

Linear scan & look back for one iteration ⇒ O(n)


#### Space:

Constant space ⇒ O(1)


<!-- Docs to Markdown version 1.0β14 -->
