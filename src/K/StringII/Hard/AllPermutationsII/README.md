<!----- Conversion time: 0.933 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Sat Jan 12 2019 17:55:32 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1GYjory7JvWP-QTnmRLGElUp1UQVbmdanUc3RrWlCg5A
----->



# All Permutations II

[https://app.laicode.io/app/problem/65](https://app.laicode.io/app/problem/65)


## Description

Given a string with possible duplicate characters, return a list with all permutations of the characters.

Examples



*   Set = "abc", all permutations are \["abc", "acb", "bac", "bca", "cab", "cba"\]
*   Set = "aba", all permutations are \["aab", "aba", "baa"\]
*   Set = "", all permutations are \[""\]
*   Set = null, all permutations are \[\]

Hard

Depth First Search


## Assumption

The input string should not be null or empty


## Algorithm

Simpler question with no duplicate characters [All Permutations I](../../../../H/DFS/Medium/AllPermutationsI)

The two problems are quite similar to each other. The only difference is that in this problem, we need to worry about duplicate input which would lead to duplicate output.

To avoid that from happening, deduplication (use of a hash table) should be applied in each level. When we are trying all possible letters to be placed at a certain position, we should see if there is any previous solution that already has this letter at this position.




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
    permute(set.toCharArray(), 0, result);
    return result;
  }

  private void permute(char[] array, int index, List<String> result) {
    // Base case: when all positions have been placed with letters
    if (index == array.length) {
      result.add(new String(array));
      return;
    }
    // Use a HashSet to record the letters picked at this position
    Set<Character> used = new HashSet<>(array.length);
    // At each level/position, try all possible letters
    // Candidates are in [index, end]
    for (int i = index; i < array.length; i++) {
      if (used.contains(array[i])) {
        continue;
      }
      used.add(array[i]);
      swap(array, index, i);
      permute(array, index + 1, result);
      swap(array, i, index);
    }
  }

  private void swap(char[] array, int left, int right) {
    char temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
```



### Complexity

Time complexity:

n letters in the input → n options at the first level → (n - 1) options for each of the n options from the previous level → n * (n - 1) * (n - 2) * … * 2 * 1 = n!

Space complexity:

n levels. A HashSet in each level → O(n^2)


<!-- GD2md-html version 1.0β13 -->
