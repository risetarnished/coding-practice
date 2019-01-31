<!----- Conversion time: 0.754 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Thu Jan 10 2019 04:11:27 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1KEeDKjMrsZG2YPx6BC8kZaFsBBS1s5A9QnQg3fSwvLQ
----->



# Remove Adjacent Repeated Characters IV

[https://app.laicode.io/app/problem/82](https://app.laicode.io/app/problem/82)


## Description

Repeatedly remove all adjacent, repeated characters in a given string from left to right.

No adjacent characters should be identified in the final string.

Examples



*   "abbbaaccz" → "aaaccz" → "ccz" → "z"
*   "aabccdc" → "bccdc" → "bdc"

Hard

Array

Stack

String


## Assumption

The input string should not be null and have at least one element in it.


## Algorithm

We need to look back into the elements that have already been processed, for example, "abbaaccz" → remove "bb" → "aaaccz" → remove "aaa" → "ccz" → remove "cc" → "z"

Whenever we need to look back into the processed portion of the input, the latest processed item in fact, we should consider use a stack or something mimicking the features of a stack.

In this case, we can simply use a pointer, named "stackPointer", which points to the first element that is out of the "stack". Therefore, everything to the left of the stack pointer is in the "stack".

When we iterate over the string: compare the current character to the stack top



1.  when the stack is/becomes empty ⇒ push the current character ⇒ stackPointer++
1.  when the two characters are different ⇒ push the current character ⇒ sp++
1.  when the two characters are the same ⇒ skip them ⇒ pop stack ⇒ stackPointer--


## Solution


### Code


```java
public class Solution {
  public String deDup(String input) {
    // Write your solution here
    if (input == null || input.length() < 2) {
      return input;
    }
    char[] array = input.toCharArray();
    int stackPointer = 0;
    for (int i = 1; i < array.length; i++) {
      // Case 1 and 2: when we need to push
      if (stackPointer < 0 || array[i] != array[stackPointer]) {
        // When the stack becomes empty or the letter is different
        // We push the letter onto the stack
        array[++stackPointer] = array[i];
      } else {
        // Otherwise, skip the (consecutive) duplicates and pop the stack
        // When !stack.isEmpty() && array[i] == array[stackPointer]
        while (i < array.length - 1 && array[i] == array[i + 1]) {
          i++;
        }
        stackPointer--;
      }
    }
    // Everything to the left of stackPointer, including itself,
    // are kept for return
    return new String(array, 0, stackPointer + 1);
  }
}
```



### Complexity

Time: one iteration over the input string ⇒ O(n)

Space: O(1) in-place


<!-- GD2md-html version 1.0β13 -->
