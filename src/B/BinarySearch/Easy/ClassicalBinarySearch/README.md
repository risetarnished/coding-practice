<!----- Conversion time: 0.622 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Tue Jan 15 2019 04:18:40 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1QIUOo33EVFQAyP4386DiJ-jNksXJYWsn-N145lG8ObA
----->



# Classical Binary Search

[https://app.laicode.io/app/problem/14](https://app.laicode.io/app/problem/14)


## Description

Given a target integer T and an integer array A sorted in ascending order, find the index i such that A[i] == T or return -1 if there is no such index.

Assumptions



*   There can be duplicate elements in the array, and you can return any of the indices i such that A[i] == T.

Examples



*   A = {1, 2, 3, 4, 5}, T = 3, return 2
*   A = {1, 2, 3, 4, 5}, T = 6, return -1
*   A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3

Corner Cases



*   What if A is null or A is of zero length? We should return -1 in this case.


## Assumption

The input array should not be null or empty.


## Algorithm

Method 1: **Classical Binary Search**



1.  Termination condition: **start <= end**
1.  Three different states:
    1.  array\[mid\] == target ⇒ return mid
    1.  array\[mid\] < target ⇒ start = mid + 1
    1.  array\[mid\] > target ⇒ end = mid - 1
1.  The while-loop will either find the target or not
1.  There are never post-processing steps after the while loop

Method 2: **Binary Search Variant**



1.  Termination condition: **start + 1 < end** (exit when they are neighbors)
1.  Three different states:
    1.  array\[mid\] == target ⇒ return mid
    1.  array\[mid\] < target ⇒ start = mid
    1.  array\[mid\] > target ⇒ end = mid
1.  The while-loop may or may not finish looking for the target because when start and end are neighbors, we will exit the loop
1.  Post-processing step is required to check the neighboring array\[start\] and array\[end\] elements


## Solution


### Method 1: classical binary search

Pay attention to the while loop condition (start <= end)


#### Code


```java
public class Solution {
    public int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
```





### Method 2: exit when start/left and end/right are neighboring each other


#### Code


```java
public class Solution {
    public int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (array[left] == target) {
            return left;
        } else if (array[right] == target) {
            return right;
        }
        return -1;
    }
}
```



#### Complexity

Time:

Both of these two methods are straightforward binary search algorithms. The search range is narrowed down by half each time ⇒ O(log(n))

Space:

Only two pointers are used ⇒ O(1)


<!-- GD2md-html version 1.0β13 -->
