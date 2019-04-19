<!----- Conversion time: 0.573 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Wed Jan 16 2019 01:23:52 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1KXHL9XGmEQSeThL7a7v37q6FMErIVwGYIgVxIE8S5sU
----->



# All Subsets II

[https://app.laicode.io/app/problem/63](https://app.laicode.io/app/problem/63)


## Description

Given a set of characters represented by a String, return a list containing all subsets of the characters.

Assumptions



*   There could be duplicate characters in the original set.

​Examples



*   Set = "abc", all the subsets are \["", "a", "ab", "abc", "ac", "b", "bc", "c"\]
*   Set = "abb", all the subsets are \["", "a", "ab", "abb", "b", "bb"\]
*   Set = "", all the subsets are \[""\]
*   Set = null, all the subsets are \[\]


## Assumption

The input string may have duplicate characters and they are not in any particular order.


## Algorithm

We can do a DFS on the problem. However, because there could be duplicate characters in the input string, there is a simple way to avoid adding duplicate subsets to the final result.



1.  Convert the input string to a char[] as usual
1.  Sort the char[] array such that any duplicate characters will be sorted alongside each other.
1.  Do a DFS on the char[]
    1.  at each index/level, we choose to either pick or skip this character
    1.  if this character is the same as the previous character, skip this character


## Solution


### Code


```java
public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here.
    List<String> result = new ArrayList<>();
    if (set == null) {
      return result;
    }
    char[] array = set.toCharArray();
    // Sort the array so that the duplicates can be avoided
    Arrays.sort(array);
    findAllUniqueSubsets(array, new StringBuilder(),
                         0, result);
    return result;
  }

  private void findAllUniqueSubsets(char[] array, StringBuilder subset,
                                    int index, List<String> result) {
    // Base case: when we have considered every character
    if (index == array.length) {
      result.add(subset.toString());
      return;
    }
    // 1. Add this character to the subset and move on
    subset.append(array[index]);
    findAllUniqueSubsets(array, subset, index + 1, result);
    // Backtrack when returning back
    subset.deleteCharAt(subset.length() - 1);
    // Skip all the following duplicate characters
    while (index < array.length - 1 && array[index] == array[index + 1]) {
      index++;
    }
    // 2. Add nothing in this level
    findAllUniqueSubsets(array, subset, index + 1, result);
  }
}
```

_Alternative method: at the current level/index, continue DFS, controlled by the variable "index"_

```java
public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here.
    List<String> result = new ArrayList<>();
    if (set == null) {
      return result;
    }
    char[] array = set.toCharArray();
    // Sort the array so that the duplicates can be avoided
    Arrays.sort(array);
    findAllUniqueSubsetsAlt(array, new StringBuilder(),
                            0, result);
    return result;
  }

  private void findAllUniqueSubsetsAlt(char[] array, StringBuilder subset,
                                       int index, List<String> result) {
    // Add every legit node in the recursion tree to the result
    result.add(subset.toString());
    // From the current level, continue doing DFS
    for (int i = index; i < array.length; i++) {
      // Skip duplicate elements
      if (i > index && array[i] == array[i - 1]) {
        continue;
      }
      subset.append(array[i]);
      findAllUniqueSubsetsAlt(array, subset, i + 1, result);
      subset.deleteCharAt(subset.length() - 1);
    }
  }
}
```



### Complexity


#### Time

There are n letters in total, and we consider two states for each one of them ⇒ O(n^2)


#### Space

O(n) levels in the recursion tree


<!-- GD2md-html version 1.0β13 -->
