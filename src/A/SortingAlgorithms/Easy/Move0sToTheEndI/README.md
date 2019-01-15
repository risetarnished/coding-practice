<!----- Conversion time: 0.768 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Tue Jan 15 2019 04:07:38 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1dbcSfbkaYK4mGqgFaUvF9-sUIRVVFWX-rmx2SdYXLaA
----->



# Move 0s to the End I

[https://app.laicode.io/app/problem/258](https://app.laicode.io/app/problem/258)


## Description

Given an array of integers, move all the 0s to the right end of the array.

The relative order of the elements in the original array does not need to be maintained.

Assumptions:



*   The given array is not null.

Examples:



*   {1} --> {1}
*   {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}

Easy

Array


## Assumption

The input array should not be null or empty


## Algorithm

Since the problem does not require to maintain the element's relative order after switching places, a similar algorithm to quick sort can be used.



1.  No pitovt needed because we only care about 0's and non-0's
1.  Elements before the left pointer are non-0's
1.  Elements after the right pointer are 0's
1.  Elements in between are unknown yet

If we'd like to maintain the element's relative order after switching places:



1.  Two pointers moving in the **same direction** from the** same starting index**
1.  Elements before the left pointer are non-0's
1.  Elements between the two pointers are checked and have non-0's before 0's
1.  Elements after the right pointer are unknown yet


## Solution


### Code


#### Method 1


```java
public class Solution {
    public int[] moveZero(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return array;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            if (array[left] != 0) {
                left++;
            } else if (array[right] == 0) {
                right--;
            } else {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        return array;
    }
}
```



#### Method 2


```java
public class Solution {
    public int[] moveZero(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return array;
        }
        int left = 0;
        for (int right = 0; right < array.length; right++) {
            if (array[right] != 0) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
            }
        }
        return array;
    }
}
```



### Complexity


#### Time

One iteration over n elements with only comparisons and swap operations ⇒ O(n).


#### Space

Constant spaces ⇒ O(1).


<!-- GD2md-html version 1.0β13 -->
