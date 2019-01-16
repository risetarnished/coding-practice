<!----- Conversion time: 1.173 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Thu Jan 10 2019 02:11:50 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1qKhRdxk7-ndwtNqvUxaByF-7TP7u7tCzLqdN0hZRfnI
----->



# Remove Certain Characters

[https://app.laicode.io/app/problem/395](https://app.laicode.io/app/problem/395)


## Description

Remove given characters in input string, the relative order of other characters should be remained. Return the new string after deletion.

Assumptions



*   The given input string is not null.
*   The characters to be removed is given by another string, it is guaranteed to be not null.

Examples



*   input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".


## Assumption

The input strings s and t should not be null.

The characters to be remove from s are the ones offered in t. This does not mean that we need to remove all presence of t as substrings in s.


## Algorithm

e.g. s = "student", t = "un", output = "stdet"



1.  Primitive thinking
    1.  iterate over s
    1.  look for 'u' and 'n'
    1.  use **str.deleteCharAt(i)** to remove the character
    1.  This is a **bad** algorithm because str.deleteCharAt(i) actually takes O(n) time
    1.  **deleteCharAt()** and **substring(start, end)** methods are both O(n)
1.  Two pointers - better algorithm
    1.  a slow and a fast pointer
    1.  fast points to the letter being processed
    1.  slow points to the first letter that is not included in the result portion
        1.  everything before slow are processed and ready for the result
        1.  [0, slow) ⇒ ready for result
    1.  everything between slow and fast - 1 are the ones that we do not care about any more
        1.  [slow, fast) ⇒ useless portion
    1.  if array\[fast\] is one of the characters to be removed, fast++
    1.  if array\[fast\] is not one of the characters to be removed, put it to where the slow pointer points to (array\[slow\] = array\[fast\]) and move on (slow++; fast++)




## Solution


### Code


```java
public class Solution {
  public String remove(String input, String t) {
    // Write your solution here
    if (input == null || input.length() == 0 || t == null) {
      return input;
    }
    // Store the characters to be removed in a HashSet
    Set<Character> toRemove = new HashSet<>(t.length());
    for (int i = 0; i < t.length(); i++) {
      toRemove.add(t.charAt(i));
    }
    // Convert the input string to char[] for in-place operations
    char[] array = input.toCharArray();
    int slow = 0;
    int fast = 0;
    while (fast < input.length()) {
      if (!toRemove.contains(array[fast])) {
        // When the char does not need to be remove
        // we need to keep it at where slow is now
        // such that it becomes ready for the result
        array[slow++] = array[fast];
      }
      // Whether we keep array[fast] or not,
      // we need to move on
      fast++;
    }
    // Use the String constructor that uses
    // offset and length count
    return new String(array, 0, slow);
  }
}
```



### Complexity


#### Time

Assume input.length() == n and t.length() == m

We put all the characters in t to the HashSet ⇒ O(m)

We check every character in the input exactly once ⇒ O(n)

Total time complexity ⇒ O(n + m) ⇒ O(max(n, m))


#### Space

A HashSet of size m is used to store the characters to be deleted ⇒ O(m) ⇒ O(n)


<!-- GD2md-html version 1.0β13 -->
