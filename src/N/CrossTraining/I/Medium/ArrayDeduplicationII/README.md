<!----- Conversion time: 0.614 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Wed Jan 23 2019 19:25:19 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1EDt4-E469oCP7WNaVRi03WhLgHWwQ5Cw9GZQ28iPLUg
----->



# Array Deduplication II

[https://app.laicode.io/app/problem/116](https://app.laicode.io/app/problem/116)

[https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/)

[https://www.lintcode.com/problem/remove-duplicates-from-sorted-array-ii/description](https://www.lintcode.com/problem/remove-duplicates-from-sorted-array-ii/description)


## Description

Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep at most two of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.

Assumptions



*   The given array is not null

Examples



*   {1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}

Medium

Array




## Assumption

Because we can keep at most 2 copies of the same element ⇒ the input array should have at least 2 elements in it.


## Algorithm

Almost the same as the previous problem. But this time, since we can keep at most two copies of the duplicate elements,
we compare array\[fast] to array\[slow - 1]. In this way, we would keep at most two duplicate elements (array\[slow - 1]
and array\[slow])


## Solution


### Code


```java
public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here
    if (array == null || array.length <= 2) {
      return array;
    }
    // Two pointers
    // 1. array[0, slow]: processed for result
    // 2. array[fast, end]: yet to be processed
    // Because the array is sorted and we can keep at most two copies
    // of the duplicate elements
    // We can just compare array[fast] with array[slow - 1]
    int slow = 1;
    for (int fast = 2; fast < array.length; fast++) {
      if (array[fast] != array[slow - 1]) {
        array[++slow] = array[fast];
      }
    }
    int[] result = new int[slow + 1];
    for (int i = 0; i <= slow; i++) {
      result[i] = array[i];
    }
    return result;
  }
}
```



### Complexity

Time: iteration over the entire array of n elements ⇒ O(n)

Space: a slow pointer is created ⇒ O(1)


<!-- Docs to Markdown version 1.0β14 -->
