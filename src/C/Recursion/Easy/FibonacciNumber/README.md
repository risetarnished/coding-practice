<!----- Conversion time: 0.86 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Tue Jan 15 2019 18:25:23 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1YJG1tsxLUsQWsgtmEoLLNqHtb0IS1VKTPKsWaD8etuk
----->



# Fibonacci Number

[https://app.laicode.io/app/problem/12](https://app.laicode.io/app/problem/12)


## Description

Get the Kth number in the Fibonacci Sequence. (K is 0-indexed, the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).

Examples



*   0th fibonacci number is 0
*   1st fibonacci number is 1
*   2nd fibonacci number is 1
*   3rd fibonacci number is 2
*   6th fibonacci number is 8

Corner Cases



*   What if K < 0? in this case, we should always return 0.
*   Is it possible the result fibonacci number is overflowed? We can assume it will not be overflowed when we solve this problem on this online judge, but we should also know that it is possible to get an overflowed number, and sometimes we will need to use something like BigInteger.

Easy

Recursion


## Assumption

The first and second Fibonacci number are 0 and 1.


## Algorithm

Recursively compute k = (k - 1) + (k - 2)

Base case: the first Fibonacci number is 0; the second one is 1.


## Solution


### Code: Recursion


```
public class Solution {
    public long fibonacci(int k) {
        // Write your solution here
        if (k == 0) {
            return 0;
        } else if (k == 1) {
            return 1;
        }
        return fibonacci(k - 1) + fibonacci(k - 2);
    }
}
```



### Complexity

Time:

total number of nodes in the recursion tree = 2 ^ n

each node takes O(1) operation

Therefore, O(2 ^ n)

Space:

n nodes to check → O(n)




### Code: Iteration (DP)


```java
public class Solution {
    public long fibonacci(int k) {
        // Write your solution here
        if (k <= 0) {
            return 0;
        } else if (k == 1) {
            return 1;
        }
        long[] fiboArray = new long[k + 1];
        fiboArray[0] = 0;
        fiboArray[1] = 1;
        for (int i = 2; i <= k; i++) {
            fiboArray[i] = fiboArray[i - 1] + fiboArray[i - 2];
        }
        return fiboArray[k];
    }
}
```



### Complexity

Time:

A single iteration over \[2, k\] ⇒ O(n)

Space:

An integer array to store the previous Fibonacci numbers ⇒ O(n)


<!-- GD2md-html version 1.0β13 -->
