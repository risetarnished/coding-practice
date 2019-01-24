<!----- Conversion time: 0.851 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Thu Jan 24 2019 01:27:40 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1wCmOorbq0YPAIlFoAZRHkXI2WTV3opi3TGy3BC9FSAo
----->



# Array Deduplication III

[https://app.laicode.io/app/problem/117](https://app.laicode.io/app/problem/117)


## Description

Given a sorted integer array, remove duplicate elements. For each group of elements with the same value do not keep any of them. Do this in-place, using the left side of the original array and and maintain the relative order of the elements of the array. Return the array after deduplication.

Assumptions



*   The given array is not null

Examples



*   {1, 2, 2, 3, 3, 3} → {1}

Medium

Array




## Assumption

Because we cannot keep a single duplicate element, the length of the array should be at least 1.


## Algorithm

This time, when we see duplicate elements, we need two pointers, start and end respectively, to record the start and end points of the range for the duplications.

Check the length of the range, if there are more than 2 copies of the element, we should increment the slow pointer to the "useless" section. Therefore, this time, everything to the left of the slow pointer, not including it, is the ones to be returned.


## Solution


### Code


```java
public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return array;
    }
    // Two pointers
    // array[0, slow] ==> processed for result
    // array[fast, end] ==> yet to be processed
    int slow = 0;
    int fast = 0;
    // For each element in the array, check its proceeding elements
    // and skip the duplicate ones
    while (fast < array.length) {
      int start = fast;
      // array[start, fast] is a subarray that contains the same elements
      // Check the size of the subarray upon exit:
      // 1. size >= 2: multiple duplications ==> skip these elements
      // 2. size == 1: only one element ==> keep this element
      while (fast < array.length && array[fast] == array[start]) {
        fast++;
      }
      if (fast - start == 1) {
        array[slow++] = array[start];
      }
    }
    return Arrays.copyOf(array, slow);
  }
}
```



### Complexity

Time:

Check every single element in the array ⇒ O(n)

Space:

Constant/pointers used ⇒ O(1)


<!-- Docs to Markdown version 1.0β14 -->
