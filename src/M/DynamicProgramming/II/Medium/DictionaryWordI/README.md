<!----- Conversion time: 1.519 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Fri Jan 18 2019 04:41:54 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1afr6xEvGHS96Mfgbsg4Qz_Mo_OEjIMTeEGTpkNbXK_A
* This document has images: check for >>>>>  gd2md-html alert:  inline image link in generated source and store images to your server.
----->



# Dictionary Word I

[https://app.laicode.io/app/problem/99](https://app.laicode.io/app/problem/99)


## Description

Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.

Assumptions



*   The given word is not null and is not empty
*   The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty

Examples

Dictionary: {"bob", "cat", "rob"}



*   Word: "robob" return false
*   Word: "robcatbob" return true since it can be composed by "rob", "cat", "bob"

Medium

Recursion

Dynamic Programming




## Assumption

Neither the word or the dictionary is null or empty.


## Algorithm

Similar to Max _[Product of Cutting Rope](../../../I/Medium/MaxProductOfCuttingRope)_, this problem can be solved using the left/right big/small chunks cutting method.



![alt_text](dictionary_word.png "image_tooltip")



## Solution


### Code


```java
public class Solution {
  public boolean canBreak(String input, String[] dict) {
    // Write your solution here
    if (input == null || dict == null || dict.length == 0) {
      return false;
    }
    // Convert the dict to a HashSet for better performance
    Set<String> dictionary = new HashSet<>(Arrays.asList(dict));
    // Because we can cut the word with an empty string (length 0)
    // we need an array with length of (n + 1)
    boolean[] canCut = new boolean[input.length() + 1];
    // canCut[i] represents the fact that whether the first i letters
    // of the input string (input.substring(0, i)) can be made up
    // by words in the dictionary
    // Base case: empty string can be made up by the dictionary
    canCut[0] = true;
    // Check for every substring with lengths from 1 to n
    for (int i = 1; i <= input.length(); i++) {
      // The whole substring may just be a word in the dict
      if (dictionary.contains(input.substring(0, i))) {
        canCut[i] = true;
        continue;
      }
      // Otherwise, we need to check its substrings
      // with lengths from 1 to (i - 1)
      for (int j = 1; j < i; j++) {
        // Check the canCut history for the 1st part [0, j)
        // Check the presence in dictionary for the 2nd part [j, i)
        if (canCut[j] && dictionary.contains(input.substring(j, i))) {
          canCut[i] = true;
          break;  // Break as soon as we have found one true case
        }
      }
    }
    return canCut[input.length()];
  }
}
```


_To simplify the code a bit, we can remove the test for the whole substring at the beginning in the outer for-loop. Instead, we can check **one more cut** in the second for-loop: **0 cuts** ⇒ input.substring(0, i)_

_As implemented below:_


```java
public class Solution {
  public boolean canBreak(String input, String[] dict) {
    // Write your solution here
    if (input == null || dict == null || dict.length == 0) {
      return false;
    }
    Set<String> dictionary = new HashSet<>(Arrays.asList(dict));
    boolean[] canCut = new boolean[input.length() + 1];
    canCut[0] = true;
    // Check for every substring with lengths from 1 to n
    for (int i = 1; i <= input.length(); i++) {
      // Check for cuts from lengths 0 to i - 1
      for (int j = 0; j < i; j++) {
        if (canCut[j] && dictionary.contains(input.substring(j, i))) {
          canCut[i] = true;
          break;
        }
      }
    }
    return canCut[input.length()];
  }
}
```



### Complexity

Time:

A for-loop from 1 → n and a nested for-loop from 0 → n with a .substring() call ⇒ O(n^3)

Space:

boolean[] breakable and Set<String> dictionary ⇒ O(2n) ⇒ O(n)


<!-- Docs to Markdown version 1.0β14 -->
