<!----- Conversion time: 0.953 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β16
* Wed Apr 03 2019 02:09:59 GMT-0700 (PDT)
* Source doc: https://docs.google.com/open?id=1MAtVl2b3vRPjHQNH7PvUXOvuQlfeqTC6IZWqpCCDmh8
----->



# Palindrome Permutation

[https://app.laicode.io/app/problem/499](https://app.laicode.io/app/problem/499)


## Description

Given a string, determine if a permutation of the string could form a palindrome.

For example,

"code" -> False, "aab" -> True, "carerac" -> True.

Easy

Hashtable


## Assumption

The input string should not be null ⇒ false

If the input is empty ⇒ true


## Algorithm



*   High-level idea
    *   If all letters have an even number of occurrence ⇒ true
    *   If all letters, except one, have an even number of occurrence ⇒ true
*   Implementation
    *   Use a HashMap to record the relationship <letter, frequency>
    *   Calculate the frequency map of each character in the input string
    *   For all letters in the input, if there is at most one letter that has an odd number of frequency ⇒ true


## Solution


### Code


```java
public class Solution {
  public boolean canPermutePalindrome(String input) {
    // Write your solution here
    // Corner cases according to the assumptions
    if (input == null) {
      return false;
    } else if (input.length() <= 1) {
      return true;
    }
    Map<Character, Integer> frequency = new HashMap<>();
    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
    }
    // For all letters in the input, if there is at most one letter that
    // has an odd number of occurrences ⇒ true
    int odd = 0;
    for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
      if (entry.getValue() % 2 != 0 && ++odd > 1) {
        return false;
      }
    }
    return true;
  }
}
```



### Complexity


#### Time



*   getting the frequency map ⇒ O(n)
*   looking for odd frequencies in the entry set ⇒ O(n)
*   total time ⇒ O(n)


#### Space



*   HashMap recording the frequency of each letter ⇒ O(n)

<!-- Docs to Markdown version 1.0β16 -->
