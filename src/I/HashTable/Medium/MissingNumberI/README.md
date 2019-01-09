<!----- Conversion time: 0.952 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Wed Jan 09 2019 02:17:44 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=19ZgQkwFwXkDF_i9xo02WsUpDuXZrXpWDLX4HAvdJbYw
----->



# Missing Number I

[https://app.laicode.io/app/problem/68](https://app.laicode.io/app/problem/68)


## Description

Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.

Assumptions



*   The given array is not null, and N >= 1

Examples



*   A = {2, 1, 4}, the missing number is 3
*   A = {1, 2, 3}, the missing number is 4
*   A = {}, the missing number is 1



Medium

Bit Operations

Hashtable

Math


## Assumption

The input array should not be null or empty.


## Algortihm



1.  Hash table
    1.  use a HashSet to store the elements in the array
    1.  assume that the input array has n elements in it
    1.  loop from 1 to n+1 to see which number is not in the HashSet
1.  sum(1 to n) - sum(array), assuming the array has (n - 1) elements because it is missing one number from 1 to n
    1.  algorithm
        1.  calculate the sum of all elements in the array
        1.  calculate the sum of integers from 1 to n
        1.  (result of step b) - (result of step a) = missing integer
    1.  e.g.
        1.  From 1 to 5
        1.  array = \[2, 5, 4, 1\]
        1.  missing 3
        1.  (1 + 2 + 3 + 4 + 5) - (2 + 5 + 4 + 1) ⇐⇒ (1 - 2) + (2 - 5) + (3 - 4) + (4 - 1) + 5
1.  XOR
    1.  exclusive or
        1.  properties
            1.  1 xor 0 = 1
            1.  0 xor 1 = 1
            1.  0 xor 0 = 0
            1.  1 xor 1 = 0
            1.  a xor b = b xor a
            1.  a xor (b xor c) = (a xor b) xor c
            1.  0 xor a = a xor 0 = a
            1.  any number XOR with 0 gives us the original number
            1.  any number XOR with itself gives us 0
        1.  algorithm
            1.  b1 = a\[0\] xor a\[1\] xor a\[2\] xor … xor a\[n - 1\]
            1.  b2 = 1 xor 2 xor 3 xor … xor (n + 1)
            1.  missing number = b1 xor b2
        1.  e.g. n = 4, input = \[1, 4, 3\], output = 2
            1.  (1 xor 2 xor 3 xor 4) xor (1 xor 4 xor 3)

                = (1 xor 1) xor (3 xor 3) xor (4 xor 4) xor 2


                = 0 xor 2


                = 2





## Solution


### Method 1 - Hash table


#### Code


```java
public class Solution {
  public int missing(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return 1;
    }
    /*
    Set<Integer> set = new HashSet<>();
    for (int number : array) {
      set.add(number);
    }
    for (int i = 1; i < array.length + 1; i++) {
      if (!set.contains(i)) {
        return i;
      }
    }
    return -1;
    */
    boolean[] exist = new boolean[array.length + 1];
    for (int number : array) {
      exist[number - 1] = true; // index = number - 1
    }
    for (int i = 0; i < array.length + 1; i++) {
      if (!exist[i]) {
        return i + 1; // index = number - 1
      }
    }
    return -1;
  }
}
```



#### Complexity

Time: O(n) on average

Space: O(n)


### Method 2 - sum(1 to N) - sum(array)


#### Code


```java
public class Solution {
  public int missing(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return 1;
    }
    // Method 1
    // sum(1 to n) - sum(array)
    /*
    int expectedSum = 0;
    for (int i = 1; i <= array.length + 1; i++) {
      expectedSum += i;
    }
    int actualSum = 0;
    for (int number : array) {
      actualSum += number;
    }
    return expectedSum - actualSum;
    */
    // Method 2
    // Subtraction on the fly
    // Variable diff represents the difference between all the elements
    // from 1 to n - 1
    int diff = 0;
    for (int i = 0; i < array.length; i++) {
      diff += (i + 1) - array[i];
    }
    // The last number is n
    // If we use the difference among the previous (n - 1) numbers plus n
    // We get the final difference
    return array.length + 1 + diff;
  }
}
```



#### Complexity

Time: O(n)

Space: O(1)


### Method 3 - XOR


#### Code


```java
public class Solution {
  public int missing(int[] array) {
    // Write your solution here
    int n = array.length + 1;
    int xor = 0;
    // XOR 1 to N
    for (int i = 1; i <= n; i++) {
      xor ^= i;
    }
    // XOR the array
    for (int number : array) {
      xor ^= number;
    }
    return xor;
  }
}
```



#### Complexity

Time: O(n)

Space: O(1)


<!-- GD2md-html version 1.0β13 -->
