<!----- Conversion time: 0.935 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Tue Jan 08 2019 02:34:39 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1_Wija3URqxqUdzhhmUc3Uxt12_p7wIDyxVMTfnw8xtc
----->



# All Permutations I

[https://app.laicode.io/app/problem/64](https://app.laicode.io/app/problem/64)


## Description

Given a string with no duplicate characters, return a list with all permutations of the characters.

Examples



*   Set = "abc", all permutations are \["abc", "acb", "bac", "bca", "cab", "cba"\]
*   Set = "", all permutations are \[""\]
*   Set = null, all permutations are \[\]

Medium

Depth First Search


## Assumption

The input string is not null.

If it is null, the permutations are \[\]

If it is empty, the permutations are supposed to be \[""\]


## Algorithm

DFS thinking process:

E.g. set = "abc"



1.  How many levels are there? What does it store on each level?
    1.  Three levels. Each level represents one position of the string: position 0, 1, 2
2.  How many different states are there in each level
    1.  If we are at the i-th level, there are (n - i) states
        1.  the first position (position 0) has 3 states
            1.  **a**
            2.  **b**
            3.  **c**
        2.  the second position (position 1) has 2 states
            1.  a**b**/a**c**
            2.  b**a**/b**c**
            3.  c**a**/c**b**
        3.  the third position (position 2) has 1 state
            1.  ab**c**/ac**b**
            2.  ba**c**/bc**a**
            3.  ca**b**/cb**a**

input[] = "abc"

                                **root (a b c)**

                    **/                 |                \**

                    **a(bc)            b(ac)            c(ba)**

                **/    \                /    \                /    \**

                **b(c)    c(b)    a(c)    c(a)    b(a)    a(b)**

            **|          |          |          |          |          |**

            ** c         b         c         a         a          b**


## Solution


### Code


```java
public class Solution {
  public List<String> permutations(String set) {
    // Write your solution here
    List<String> result = new ArrayList<>();
    if (set == null) {
      return result;
    }
    // Convert the input to char[] for simpler operations
    permute(set.toCharArray(), 0, result);
    return result;
  }

  private void permute(char[] input, int index, List<String> result) {
    // Base case: when all positions have been placed with selected characters
    if (index == input.length) {
      result.add(new String(input));
      return;
    }
    // In each level, we need to choose all possible characters to put
    // into this position
    // At the current level/index, input[0, index] are the fixed part
    // input[index, end] are candidates to be put at position index
    for (int i = index; i < input.length; i++) {
      // Because this is a char[],
      // to put element at index i to the current index
      // we can just swap them
      swap(input, index, i);
      // Go to the next level/position/index
      permute(input, index + 1, result);
      // Backtrack: restore the original relative positions
      swap(input, i, index);
    }
  }

  private void swap(char[] input, int left, int right) {
    char temp = input[left];
    input[left] = input[right];
    input[right] = temp;
  }
}
```



### Complexity


#### Time

There are n levels/positions, and (n - 1), (n - 2), …, (n - i), …, 1 states to consider at corresponding levels ⇒ O(n!)


#### Space

There are n levels ⇒ O(n)


<!-- GD2md-html version 1.0β13 -->
