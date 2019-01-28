<!----- Conversion time: 1.094 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Thu Jan 24 2019 02:34:46 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1aKUy1CurwRGiP1y0e5SOhEL-WSgPjvjAzpzIcinPS-Q
----->



# Move 0s To The End II

[https://app.laicode.io/app/problem/259](https://app.laicode.io/app/problem/259)


## Description

Given an array of integers, move all the 0s to the right end of the array.

The relative order of the elements in the original array need to be maintained.

Assumptions:



*   The given array is not null.

Examples:



*   {1} --> {1}
*   {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}

Easy

Array

Sister problem:

[https://app.laicode.io/app/problem/258](https://app.laicode.io/app/problem/258)




## Assumption

The input array cannot be null and should have at least 1 element


## Algorithm

Because we need to maintain the relative order of the elements in the original array, quickSort variant method will not work since two pointers moving towards each other cannot guarantee the relative order being maintained. Therefore, we have to use two pointers moving in the same direction.



1.  We can copy array\[fast] to array\[slow] whenever array\[fast] != 0
1.  We can also swap array\[slow] with array\[fast] whenever array\[fast] != 0




## Solution


### Method 1


#### Code


```java
public class Solution {
    public int[] moveZero(int[] array) {
        // Write your solution here
        if (array == null || array.length < 2) {
            return array;
        }
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] != 0) {
                array[slow++] = array[fast];
            }
        }
        // Upon exiting the loop, slow points to the first position
        // where it is supposed to be a zero (the start of the 0's)
        for (int i = slow; i < array.length; i++) {
            array[i] = 0;
        }
        return array;
    }
}
```



#### Complexity

Time: one iteration over the entire array + one iteration from slow to end ⇒ O(n)

Space: O(1)


### Method 2


#### Code


```java
public class Solution {
    public int[] moveZero(int[] array) {
        // Write your solution here
        if (array == null || array.length < 2) {
            return array;
        }
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] != 0) {
                int temp = array[slow];
                array[slow++] = array[fast];
                array[fast] = temp;
            }
        }
        return array;
    }
}
```



#### Complexity

Time: one iteration over the whole array ⇒ O(n)

Space: O(1)


<!-- Docs to Markdown version 1.0β14 -->
