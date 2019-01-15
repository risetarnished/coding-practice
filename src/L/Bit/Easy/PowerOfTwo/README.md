<!----- Conversion time: 0.916 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Mon Jan 14 2019 03:29:28 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1BILX16h4Mb5xb0Y5ccQbDU6ECPwK6qN81PROBgHxiSs
----->



# Power of Two

[https://app.laicode.io/app/problem/74](https://app.laicode.io/app/problem/74)


## Description

Determine if a given integer is power of 2.

Examples



*   16 is power of 2 (2 ^ 4)
*   3 is not
*   0 is not
*   -1 is not


## Assumption

The number should not be negative

We do not consider 0 as a valid power of two


## Algorithm

Method 1: count the number bits that are 1's



1.  If a number is some power of 2, its bit representation will only have one 1 in it:
    1.  4 ⇒ 0100
    1.  16 ⇒ 1 0000
    1.  1024 ⇒ 0100 0000 0000
1.  Right shift the number and bitwise & with 1
    1.  0100 >> 0010 >> 0001 & 0001 ⇒ 1
    1.  count the number of 1's
1.  If there is only one 1 in the original number ⇒ true

Method 2: compare x & (x - 1)



1.  Assume the number is positive
1.  Calculate x & (x - 1)
    1.  0100 & 0011 ⇒ 0
    1.  1010 & 1001 ⇒ 1000 != 0
1.  If the result is 0 ⇒ true


## Solution


### Method 1


#### Code


```java
public class Solution {
  public boolean isPowerOfTwo(int number) {
    // Write your solution here
    if (number <= 0) {
      return false;
    }
    int ones = 0;
    while (number > 0) {
      ones += (number & 1);
      number >>= 1;
    }
    return ones == 1;
  }
}
```



#### Complexity


##### Time

If the number has n bits ⇒ O(n)

But it is just a bitwise operation ⇒ O(1)


##### Space

Constant space ⇒ O(1)


### Method 2


#### Code


```java
public class Solution {
  public boolean isPowerOfTwo(int number) {
    // Write your solution here
    return number > 0 && (number & (number - 1)) == 0;
  }
}
```



#### Complexity


##### Time

Bitwise operation ⇒ O(1)


##### Space

Constant space ⇒ O(1)


<!-- GD2md-html version 1.0β13 -->
