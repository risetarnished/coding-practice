<!----- Conversion time: 0.925 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Wed Jan 16 2019 03:40:41 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1LHT_VRwSYWjRD2Ov3shNsPFXC8hKG3ux7OFrPAtlPII
----->



# Longest Ascending SubArray

[https://app.laicode.io/app/problem/86](https://app.laicode.io/app/problem/86)


## Description

Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.

Assumptions



*   The given array is not null

Examples



*   {7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.
*   {1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.

Easy

Array




## Assumption

When the input array is null or its length is 0, the result should be 0


## Algorithm

Because this is only 1D, we can use "linear scan and look back".

Use an array to record the maximum length of the ascending subarray up to a certain point (must include that point).


<table>
  <tr>
   <td>Index
   </td>
   <td>0
   </td>
   <td>1
   </td>
   <td>2
   </td>
   <td>3
   </td>
   <td>4
   </td>
   <td>5
   </td>
   <td>6
   </td>
   <td>7
   </td>
  </tr>
  <tr>
   <td>Array[]
   </td>
   <td>7
   </td>
   <td>2
   </td>
   <td>3
   </td>
   <td>1
   </td>
   <td>5
   </td>
   <td>8
   </td>
   <td>9
   </td>
   <td>6
   </td>
  </tr>
  <tr>
   <td>M[]
   </td>
   <td>1
   </td>
   <td>1
   </td>
   <td>2
   </td>
   <td>1
   </td>
   <td>2
   </td>
   <td>3
   </td>
   <td>4
   </td>
   <td>1
   </td>
  </tr>
</table>


A variable recording the global max will be needed, too.




## Solution


### Code


```java
public class Solution {
    public int longest(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] subarrayLength = new int[array.length];
        subarrayLength[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                subarrayLength[i] = subarrayLength[i - 1] + 1;
                maxLength = Math.max(maxLength, subarrayLength[i]);
            } else {
                subarrayLength[i] = 1;
            }
        }
        return maxLength;
    }
}
```



### Complexity Analysis

Time:

One iteration over an array of length n. O(n)

Space:

An array recording the maximum length of an ascending subarray up to and including index i is created. O(n)




## Optimized Solution


### Code


```java
public class Solution {
    public int longest(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return 0;
        }
        int currentLength = 1;
        int maxLength = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }
        }
        return maxLength;
    }
}
```



### Complexity Analysis

Time:

One iteration over an array of length n. O(n)

Space:

Only a variable recording the length of the current subarray is created. O(1)




## Discussion

What if we would like to return the longest ascending subarray?


### Algorithm

Linear scan & look back still applies to this problem.

When we look back and update the value of currentLength and maxLength, we can also update some more variables maintained: currentStart (start index of the current subarray), maxStart (start index of the longest ascending subarray), and maxEnd (end index of the longest ascending subarray).

After one iteration that generates all these values, we just do another iteration from maxStart to maxEnd and return array\[maxStart, maxEnd\].


### Code


```java
public class Solution {
    public int[] longestAscendingSubarray(int[] array) {
        if (array == null || array.length == 0) {
            return new int[] {};
        }
        int currentLength = 1;
        int maxLength = 1;
        int currentStart = 0;
        int maxStart = 0;
        int maxEnd = 0;
        // Linear scan & look back: 1 → n
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxStart = currentStart;
                    maxEnd = i;
                }
            } else {
                currentLength = 1;
                currentStart = i;
            }
        }
        int[] result = new int[maxEnd - maxStart + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i + maxStart];
        }
        return result;
    }
}
```



### Complexity

Time: two iterations ⇒ O(n)

Space: O(1)


<!-- GD2md-html version 1.0β13 -->
