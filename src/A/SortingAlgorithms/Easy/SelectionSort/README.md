<!----- Conversion time: 0.595 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Tue Jan 15 2019 03:54:07 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1oywpTKVr8DV17Whnl7g9cr1Cm8yW2lPfOQPPW0Kjf_Y
----->



# Selection Sort

[https://app.laicode.io/app/problem/4](https://app.laicode.io/app/problem/4)


## Description

Given an array of integers, sort the elements in the array in ascending order. The selection sort algorithm should be used to solve this problem.

Examples



*   {1} is sorted to {1}
*   {1, 2, 3} is sorted to {1, 2, 3}
*   {3, 2, 1} is sorted to {1, 2, 3}
*   {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}

Corner Cases



*   What if the given array is null? In this case, we do not need to do anything.
*   What if the given array is of length zero? In this case, we do not need to do anything.



Easy

Array

Sort


## Assumption

The input array should not be null or empty.


## Algorithm



1.  Let the first element in the current iteration be the current min element
1.  Iterate over the rest of the elements in the current iteration and find the real min element
1.  Swap the min element with the first element
1.  Move on to the next iteration
1.  Everything to the left of the starting point of the current iteration has been sorted


## Solution


### Code


```java
public class Solution {
  public int[] solve(int[] array) {
    // Write your solution here
    // Corner cases check
    if (array == null || array.length == 0) {
      return array;
    }
    for (int i = 0; i < array.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      int temp = array[i];
      array[i] = array[minIndex];
      array[minIndex] = temp;
    }
  }
}
```



### Complexity


#### Time

n elements to check, n - 1 elements to compare and find the current min in each iteration →

in total, there are n, n - 1, n - 2, ... , 2, 1 operations → n * (n+1) / 2 → O(n^2)


#### Space

O(1)


<!-- GD2md-html version 1.0β13 -->
