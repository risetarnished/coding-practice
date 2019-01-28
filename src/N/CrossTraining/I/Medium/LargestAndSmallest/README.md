<!----- Conversion time: 0.667 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Thu Jan 24 2019 03:25:43 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1I_KPvjSK4sXMQVPkTHxUau4_1Hypqiw-0Ot0wzDR8J0
----->



# Largest and Smallest

[https://app.laicode.io/app/problem/119](https://app.laicode.io/app/problem/119)


## Description

Use the least number of comparisons to get the largest and smallest number in the given integer array. Return the largest number and the smallest number.

Assumptions



*   The given array is not null and has length of at least 1

Examples



*   {2, 1, 5, 4, 3}, the largest number is 5 and smallest number is 1. return \[5, 1].

Medium

Array




## Assumption

The input array should not be null or empty


## Algorithm

If we use a primitive method to solve this problem:



1.  Linear scan the array and find the max value ⇒ n comparisons
1.  Linear scan the array and find the min value ⇒ n comparisons

we need 2n comparisons in total.

If we compare the elements in pairs:



1.  0 vs end, 1 vs end - 1, 2 vs end - 2, … Whenever array\[left] > array\[right], we swap them such that the left half of the array will contain the smaller values while the right half of the array will contain the larger ones. ⇒ n / 2 comparisons
    1.  if there are **odd** number of elements in the array
        1.  we can leave out the middle element in step 1 and include it in both steps 2 and 3
1.  Find the min value from the left half ⇒ n / 2 comparisons
1.  Find the max value from the right half ⇒ n / 2 comparisons
1.  3 * n / 2 = 1.5 n comparisons in total




## Solution


### Code


```java
public class Solution {
  public int[] largestAndSmallest(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return new int[] {};
    }
    int n = array.length;
    // Step 1: compare pairs
    // 1. put the smaller numbers to the left
    // 2. put the larger numbers to the right
    for (int i = 0; i < n / 2; i++) {
      if (array[i] > array[n - 1 - i]) {
        int temp = array[i];
        array[i] = array[n - 1 - i];
        array[n - 1 - i] = temp;
      }
    }
    // Step 2: look for the min in array[0, n/2]
    int min = array[0];
    for (int i = 1; i <= n / 2; i++) {
      if (array[i] < min) {
        min = array[i];
      }
    }
    // Step 3: look for the max in array[n/2, end]
    int max = array[n / 2];
    for (int i = n / 2 + 1; i < n; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }
    return new int[] {max, min};
  }
}
```



### Complexity

Time: three iterations of O(n / 2) ⇒ O(n)

Space: O(1)


<!-- Docs to Markdown version 1.0β14 -->
