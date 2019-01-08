<!----- Conversion time: 0.651 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Mon Jan 07 2019 16:37:15 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1y3zkb5xoyB6kqFhStBS3ye-8IO534vpnSRyhe66FkHI
----->



# All Valid Permutations of Parentheses I

[https://app.laicode.io/app/problem/66](https://app.laicode.io/app/problem/66)


## Description

Given N pairs of parentheses "()", return a list with all the valid permutations.

Assumptions



*   N >= 0

Examples



*   N = 1, all valid permutations are \["()"\]
*   N = 3, all valid permutations are \["((()))", "(()())", "(())()", "()(())", "()()()"\]
*   N = 0, all valid permutations are \[""\]


## Assumption

The number of parentheses should be >= 0.


## Algorithm

DFS

E.g. N = 3

DFS process:



1.  How many levels are there? What does it store on each level?
    1.  Six levels (3 pairs of parentheses).
    2.  On each level, we only consider one position (only one parentheses can be added at this position)
2.  How many different states should we try on this level?
    1.  Two states: "(" or ")"

The DFS helper function needs to take in 4 parameters:



1.  a holder of the current combination of parentheses (may be a StringBuilder in this case)
2.  l (number of "(" added so far)
3.  r (number of ")" added so far)
4.  a result list

The number of of ")" added so far can never exceeds the number of "(". When l < n, we can keep adding "(" and then ")".


## Solution


### Code


```java
public class Solution {
  public List<String> validParentheses(int n) {
    // Write your solution here
    List<String> result = new ArrayList<>();
    if (n <= 0) {
      return result;
    }
    permute(new StringBuilder(), n, n, result);
    return result;
  }

  private void permute(StringBuilder parentheses, int left, int right,
                       List<String> result) {
    // Base case: when all n pairs of () have been added
    if (left == 0 && right == 0) {
      result.add(parentheses.toString());
      return;
    }
    // Case 1: when there are still ( left
    if (left > 0) {
      parentheses.append('(');
      // Go to the next level
      permute(parentheses, left - 1, right, result);
      // Backtracking
      parentheses.deleteCharAt(parentheses.length() - 1);
    }
    // Case 2: when there are more ) than ( left
    if (right > left) {
      parentheses.append(')');
      permute(parentheses, left, right - 1, result);
      parentheses.deleteCharAt(parentheses.length() - 1);
    }
  }
}
```



### Complexity


#### Time

There are n pairs of parentheses, so the recursion tree will have 2n levels. We need to consider two states (add "(" or ")") on each level ⇒ O(2^(2n)) ⇒ O(4^n) ⇒ we can still think it is O(2^n)


#### Space

There are 2n levels in the recursion tree. Only a StringBuilder is used in each level ⇒ O(2n)


<!-- GD2md-html version 1.0β13 -->
