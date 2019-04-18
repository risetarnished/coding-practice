<!----- Conversion time: 0.944 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β16
* Wed Apr 03 2019 02:37:20 GMT-0700 (PDT)
* Source doc: https://docs.google.com/open?id=1pFuT7mx0Yt9i4x2iSlDzuMyAa19STqeyGYRpyEYW3ms
* This is a partial selection. Check to make sure intra-doc links work.
----->



# Palindrome Permutation II

[https://app.laicode.io/app/problem/500](https://app.laicode.io/app/problem/500)


## Description

Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindrome permutation could be form.

For example:

Given s = "aabb", return ["abba", "baab"].

Given s = "abc", return [].

Medium

Backtracking


## Assumption

The input string should not be null or empty


## Algorithm

This problem is a modification of [String II/All Permutations II](../../../../J/String/II/Hard/AllPermutationsII). The only change we need to make is the base case: only keep the permutations that are palindromes.



*   High-level idea
    *   Do depth-first search to get all permutations of the input string
    *   Pay attention to duplicate letters
    *   For every permutation, check if it is a palindrome
    *   Only keep the ones that are palindromes
*   Implementation
    *   For each index i, the letters that are available to be placed at this position are in [i + 1, end]
    *   Put each candidate to the current position and go to the next index
    *   Use a set to deduplicate
    *   Base case: when all positions have been considered/when all positions have been placed with letters


## Solution


### Code


```java
public class Solution {
  public List<String> generatePalindromes(String input) {
    // Write your solution here
    List<String> result = new ArrayList<>();
    if (input == null) {
      return result;
    }
    permutePalindromes(input.toCharArray(), 0, result);
    return result;
  }
  
  private void permutePalindromes(char[] array, int index, 
                                  List<String> result) {
    // Base case: when letters for all positions have been picked
    if (index == array.length) {
      // Only keep the ones that are palindromes
      if (isPalindrome(array)) {
        result.add(new String(array));
      }
      return;
    }
    // For each index, pick one from [index + 1, end]
    // use a HashSet to deduplicate
    Set<Character> picked = new HashSet<>(array.length - index + 1);
    for (int i = index; i < array.length; i++) {
      if (picked.contains(array[i])) {
        continue;
      }
      // Put the candidate to the current position
      swap(array, index, i);
      picked.add(array[index]);
      // Go to the next index
      permutePalindromes(array, index + 1, result);
      // Restore to the previous state
      swap(array, index, i);
    }
  }
  
  private boolean isPalindrome(char[] array) {
    int n = array.length;
    for (int i = 0; i < n / 2; i++) {
      if (array[i] != array[n - 1 - i]) {
        return false;
      }
    }
    return true;
  }
  
  private void swap(char[] array, int left, int right) {
    char temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
```



### Complexity


#### Time

At level i, there are (i - 1) letters to pick. There are n levels in total ⇒ O(n * (n - 1) * (n - 2) * …

⇒ O(n!)


#### Space

There are n letters/positions/indices to pick and put. So, there are n levels in the recursion tree. In each level, there is a HashSet used to keep track of the letters that have been picked at this index. ⇒ total space O(n^2)


<!-- Docs to Markdown version 1.0β16 -->
