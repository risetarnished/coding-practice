<!----- Conversion time: 0.874 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Mon Jan 14 2019 03:45:53 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1RWIbfoReqAsouMYx23XtFy2bhShGzOTNjgOBMconcOM
----->



# Number of Different Bits

[https://app.laicode.io/app/problem/75](https://app.laicode.io/app/problem/75)


## Description

Determine the number of bits that are different for two given integers.

Examples



*   5("0101") and 8("1000") has 3 different bits


## Assumption

Because we cannot know the sign of the two numbers, we have to use logical shift (>>> or <<<)


## Algorithm

Straightforward method:

Because we are trying to figure out the difference between bits, we should come up with the idea of exclusive or (XOR). For example, if we are to compare integer 5 and 6:


1.  Calculate a XOR b and get a result, call it c
1.  Count the number of bits that are 1's in c


## Solution


### Code


```java
public class Solution {
  public int diffBits(int a, int b) {
    // Write your solution here
    int result = a ^ b;
    int ones = 0;
    while (result != 0) {
      ones += result & 1;
      result = result >>> 1;
    }
    return ones;
  }
}
```



### Complexity


#### Time

Both inputs are integers ⇒ 32 bits

XOR takes O(32)

32 logical right shifts.

In each shift, there is an & operation that takes O(32)

Therefore, O(32 * 32)


#### Space

Constant space ⇒ O(1)


<!-- GD2md-html version 1.0β13 -->
