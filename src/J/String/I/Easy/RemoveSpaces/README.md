<!----- Conversion time: 0.869 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Thu Jan 10 2019 03:08:06 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1tQjc2TajC0Xmxvp8jgspZDef2RlNLn33a4k3WDhPRYs
----->



# Remove Spaces

[https://app.laicode.io/app/problem/281](https://app.laicode.io/app/problem/281)


## Description

Given a string, remove all leading/trailing/duplicated empty spaces.

Assumptions:



*   The given string is not null.

Examples:



*   "  a" --> "a"
*   "   I     love MTV " --> "I love MTV"


## Assumption

The input string should not be null or empty.


## Algorithm

The problem is similar to [Remove Certain Characters](../RemoveCertainCharacters).

We may use two pointers (slow and fast) moving towards the same direction (head → end).

The two pointers represents:



1.  array\[0, slow\]: all elements before but **not including** slow are the ones that are kept for result
1.  array\[fast, end\]: all elements after and **including** fast are the ones that are to be processed; fast is the one that is being processed at this time
1.  array\[slow, fast\]: all elements between slow and fast - 1 are the ones that have been processed but determined to be useless (i.e. multiple spaces)

At each step, we need to consider:



1.  array\[fast\] = ' '
    1.  slow == 0 (leading spaces) || array\[slow - 1\] == ' ' (multiple spaces): skip this space
        1.  ⇒ fast++
    1.  array\[slow - 1\] != ' ': keep this space for result
        1.  ⇒ array\[slow++\] = array\[fast++\]
1.  array\[fast\] != ' ': keep the character for result
    1.  ⇒ array\[slow++\] = array\[fast++\]

Post-processing:

To deal with possible trailing spaces:



1.  after exiting the loop
1.  while (slow > 0 && array\[slow - 1\] == ' ') ⇒ slow--




## Solution


### Code


```java
public class Solution {
  public String removeSpaces(String input) {
    // Write your solution here
    if (input == null || input.length() == 0) {
      return input;
    }
    // Convert the string to char[] for in-place operations
    char[] array = input.toCharArray();
    // Two pointers moving in the same direction
    // 1. elements before the slow pointers are ready for result
    // 2. elements between slow and fast are useless
    // 3. elements after and including fast are to be processed
    int slow = 0;
    int fast = 0;
    while (fast < array.length) {
      if (array[fast] == ' ') {
        if (slow == 0) {
          // Leading spaces
          fast++;
        } else if (array[slow - 1] == ' ') {
          // Duplicated spaces
          fast++;
        } else {
          // This char is either a letter
          // Or a single space
          array[slow++] = array[fast++];
        }
      } else {
        // Keep the letter
        array[slow++] = array[fast++];
      }
    }
    // Post-processing:
    // There could be one and only one trailing space
    if (slow > 0 && array[slow - 1] == ' ') {
      slow--;
    }
    return new String(array, 0, slow);
  }
}
```


_The code above is clear but somewhat redundant._

_The method below is prettier._


```java
public class Solution {
  public String removeSpaces(String input) {
    // Write your solution here
    if (input == null || input.length() == 0) {
      return input;
    }
    // Convert the string to char[] for in-place operations
    char[] array = input.toCharArray();
    // Two pointers moving in the same direction
    // 1. elements before the slow pointers are ready for result
    // 2. elements between slow and fast are useless
    // 3. elements after and including fast are to be processed
    int end = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == ' ' && (i == 0 || array[i - 1] == ' ')) {
        // Skip all leading/duplicated spaces
        continue;
      }
      // Otherwise, this character is either a letter
      // or a word splitting single space and we need
      // to keep it
      array[end++] = array[i];
    }
    // Post-processing:
    // There could be one and only one extra space at the end
    if (end > 0 && array[end - 1] == ' ') {
      end--;
    }
    return new String(array, 0, end);
  }
}
```



### Complexity


#### Time

We check every character in the string exactly once ⇒ O(n).


#### Space

Not taking the char array into consideration ⇒ O(1)


<!-- GD2md-html version 1.0β13 -->
