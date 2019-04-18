# All Valid Permutations of Parentheses II

[https://app.laicode.io/app/problem/179](https://app.laicode.io/app/problem/179)

## Description

Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

**Assumptions**

- l, m, n >= 0
- l + m + n > 0

**Examples**

l = 1, m = 1, n = 0, all the valid permutations are \["()<>", "(<>)", "<()>", "<>()"\]

**Tags**

- Hard

- Depth First Search

- Recursion

## Assumption

- The input number of brackets, l, m, n, should all > 0

## Algorithm

### High-level idea

- Since we need to find out all permutations of valid combinations, we can do a depth-first search for all possibilities
- At each level, we can consider pick one bracket from all of which are available
- The valid ones should always have more left brackets before the right ones
- The valid ones should always have a left bracket matching the current right bracket

### Implementation

- Because we need to see if the previous bracket is a matching left bracket style of the current right bracket we are adding, we can use a stack to keep track of the previous left bracket added
- Every time a left bracket is added, push it onto the stack
- Every time a matching right bracket is added, pop the stack

### Improvement

- Given the number of pairs of parentheses (l, m, n in this case), we can generalize the problem to an **array** of number of pairs of parentheses
- Thus, we can iterate over the array and add the corresponding parentheses based on the index we are exploring
- E.g.
  - \[l, m, n\] = \[1, 1, 0\]
    - for each left/right bracket at index i
    - there is a corresponding left/right bracket in another array at index i

## Solution

### Code

```java
public class Solution {
  public List<String> validParentheses(int l, int m, int n) {
    // Write your solution here
    List<String> result = new ArrayList<>();
    // Base case according to the assumption
    if (l <= 0 && m <= 0 && n <= 0) {
      return result;
    }
    // Build arrays
    // 1. array representing the # of parentheses left
    // 2. array representing the corresponding parentheses
    int[] pairs = new int[] {l, l, m, m, n, n};
    char[] parentheses = new char[] {'(', ')', '<', '>', '{', '}'};
    // Do a depth-first search to explore all possible combinations
    permute(new StringBuilder(), pairs, parentheses, new ArrayDeque<>(), result);
    return result;
  }
  
  private void permute(StringBuilder sb, int[] pairs, char[] parentheses,
                       Deque<Character> stack, List<String> result) {
    // Base case: when all parentheses have been taken
    if (allUsed(pairs)) {
      result.add(sb.toString());
      return;
    }
    // For each left parenthesis, consider the possibility of adding it
    for (int i = 0; i < pairs.length; i += 2) {
      // Case left: when there are still left parenthesis available
      if (pairs[i] > 0) {
        sb.append(parentheses[i]);
        stack.offerFirst(parentheses[i]);
        pairs[i] = pairs[i] - 1;
        permute(sb, pairs, parentheses, stack, result);
        pairs[i] = pairs[i] + 1;
        stack.pollFirst();
        sb.deleteCharAt(sb.length() - 1);
      }
      // Case right: when there are more right parentheses than left
      //             AND when the previously added left parenthesis matches its type
      if (pairs[i + 1] > pairs[i]) {
        if (stack.peekFirst() != parentheses[i]) {
          continue;
        }
        sb.append(parentheses[i + 1]);
        char left = stack.pollFirst();
        pairs[i + 1] = pairs[i + 1] - 1;
        permute(sb, pairs, parentheses, stack, result);
        pairs[i + 1] = pairs[i + 1] + 1;
        stack.offerFirst(left);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
  
  private boolean allUsed(int[] pairs) {
    for (int i = 0; i < pairs.length; i++) {
      if (pairs[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
```

- Naive method - not using the helper arrays

```java
public class Solution {
  public List<String> validParentheses(int l, int m, int n) {
    // Write your solution here
    List<String> result = new ArrayList<>();
    if (l <= 0 && m <= 0 && n <= 0) {
      return result;
    }
    permute(new StringBuilder(), l, l, m, m, n, n, new ArrayDeque<>(), result);
    return result;
  }
  
  private void permute(StringBuilder sb, int ll, int rl, int lm, int rm, int ln, int rn,
                       Deque<Character> stack, List<String> result) {
    // Base case: when all brackets have been picked
    if (ll == 0 && rl == 0 && lm == 0 && rm == 0 && ln == 0 && rn == 0) {
      result.add(sb.toString());
      return;
    }
    // Case left: when there are still left brackets left
    //            we can add a left bracket
    if (ll > 0) {
      sb.append('(');
      stack.offerFirst('(');
      permute(sb, ll - 1, rl, lm, rm, ln, rn, stack, result);
      stack.pollFirst();
      sb.deleteCharAt(sb.length() - 1);
    }
    if (lm > 0) {
      sb.append('<');
      stack.offerFirst('<');
      permute(sb, ll, rl, lm - 1, rm, ln, rn, stack, result);
      stack.pollFirst();
      sb.deleteCharAt(sb.length() - 1);
    }
    if (ln > 0) {
      sb.append('{');
      stack.offerFirst('{');
      permute(sb, ll, rl, lm, rm, ln - 1, rn, stack, result);
      stack.pollFirst();
      sb.deleteCharAt(sb.length() - 1);
    }
    // Case right: when there are more right brackets left than the left counterparts
    //             we can add a right bracket
    // A right bracket can only be added when the previously added left bracket
    // matches its type
    if (rl > ll) {
      if (stack.peekFirst() == '(') {
        sb.append(')');
        char left = stack.pollFirst();
        permute(sb, ll, rl - 1, lm, rm, ln, rn, stack, result);
        stack.offerFirst(left);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
    if (rm > lm) {
      if (stack.peekFirst() == '<') {
        sb.append('>');
        char left = stack.pollFirst();
        permute(sb, ll, rl, lm, rm - 1, ln, rn, stack, result);
        stack.offerFirst(left);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
    if (rn > ln) {
      if (stack.peekFirst() == '{') {
        sb.append('}');
        char left = stack.pollFirst();
        permute(sb, ll, rl, lm, rm, ln, rn - 1, stack, result);
        stack.offerFirst(left);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}
```



### Complexity

In terms of the **generalized method**:

- Time
  - If there are **k** types of parentheses and **n** pairs of parentheses in total, there will be **2n** levels in the recursion tree
  - At each level, we need to decide whether to add one type of the parentheses or not. This is **2k** choices in total.
  - Therefore, the total time complexity is O(2n^(2k))
- Space
  - There are **2n** levels in the recursion tree
  - Additional data structures are
    - Two 1-D arrays
    - One stack
    - All declared in the main method
    - O(n) in total
  - Total space is O(2n + 3n) ==> O(n)

In terms of the **naive method**:

- Time
  - Same as the generalized method
- Space
  - There are **2n** levels in the recursion tree
  - A stack is created in the main method
  - Total space is O(2n + n) ==> O(n)