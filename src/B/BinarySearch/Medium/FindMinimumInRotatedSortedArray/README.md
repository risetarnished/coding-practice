<!----- Conversion time: 0.89 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Mon Feb 04 2019 04:49:06 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1q5HRcB9h_NcZtvsvfxkCHqO4PXUJbRz0ysr5OIBISr8
----->



# Find Minimum in Rotated Sorted Array

[https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)


## Description

Medium

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  \[0,1,2,4,5,6,7] might become  \[4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: \[3,4,5,1,2]
Output: 1


Example 2:

Input: \[4,5,6,7,0,1,2]
Output: 0


Accepted

253,316

Submissions

598,545




## Assumption

The input array should not be null or empty.

There are no duplicate in the array.


## Algorithm

The basic idea is to use binary search to solve this problem because the array was sorted previously, but somehow got rotated. After all, it is still somewhat "sorted". And binary search (O(log(n)) is preferred compared to a single iteration to find the min (O(n)).

The key point of this problem is how to determine whether the array has been rotated. It is quite simple: compare array\[0] and array\[end]

If array\[0] > array\[end] ⇒ the array has been rotated

While we are in the binary search process, the goal is actually to look for the rotation point because the element right after the rotation point has to be the min. So, the conditions to consider are:



1.  if array\[mid] > array\[mid + 1] ⇒ return mid + 1
1.  if array\[mid] < array\[mid - 1] ⇒ return mid
1.  Because the array is guaranteed to have been rotated (this is the reason why we have entered the while loop), if array\[mid] > array\[0] ⇒ the min is still to the right. Otherwise, the min is to the left of mid


## Solution


### Code


```java
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // If the last element > the first element
        // The array is not rotated
        int start = 0;
        int end = nums.length - 1;
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        // When the array has been rotated
        // Look for the rotation point/index
        // The element next to it is the smallest one
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] > nums[0]) {
                // Because the array is rotated
                // When the mid is greater than the start
                // It means the min is still to the right
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }
}
```



### Complexity

Time: a variation of binary search is still binary search ⇒ O(log(n))

Space: constant space ⇒ O(1)


<!-- Docs to Markdown version 1.0β14 -->
