<!----- Conversion time: 0.646 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Mon Jan 21 2019 17:57:30 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1vuvUfULBNFZ3O0ON8f14cYzwyOu3E_iuKVS5U4ba67g
----->



# Random1000 Using Random5

[https://app.laicode.io/app/problem/112](https://app.laicode.io/app/problem/112)


## Description

Given a random generator random5(), the return value of random5() is 0 - 4 with equal probability. Use random5() to implement random1000()

Medium

Probability

Sampling And Randomization


## Assumption

A random5() method is provided and can be used directly


## Algorithm

The algorithm can be generalized. E.g., how to design a random1,000,000 with random2?



*   random2 → random2^k (e.g., random8, random32768)
    *   to get random1M, we need to make 2^k >= 1M
    *   the result is k == 20 ⇒ 20 bits
    *   for i = 0 → 20: value = (value << 1) + random2();
        *   value \[0, 2^20 == 1048576] at the end
    *   So, we need to call random2() 20 times to get a binary representation of the number
        *   \[0, 2^20 - 1 > 1,000,000]
        *   if the number falls into the range, return it
        *   otherwise, re-generate random2() 20 times until the value falls into the range


## Solution


### Code


```java
public class Solution {
  public int random1000() {
    // Write your solution here.
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    // First, count the number of digits of radix 5 numbers needed
    // ==> the first power of 5 that exceeds 1000
    int digits = 1;
    int base = 5;
    while (base < 1000) {
      digits++;
      base *= base;
    }
    while (true) {
      int num = 0;
      for (int i = 0; i <= digits; i++) {
        num = num * 5 + RandomFive.random5();
      }
      if (num < 1000) {
        return num % 1000;
      }
    }
  }
}
```



### Complexity


#### Time

\[content]


#### Space

\[content]


<!-- Docs to Markdown version 1.0β14 -->
