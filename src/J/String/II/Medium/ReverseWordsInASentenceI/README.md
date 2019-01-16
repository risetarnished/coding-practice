<!----- Conversion time: 0.832 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Fri Jan 11 2019 01:25:16 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1VQh5uk2v7CowItBb_RxH4PQ6iI3uz71iy_04lj-f7E4
----->



# Reverse Words in a Sentence I

[https://app.laicode.io/app/problem/84](https://app.laicode.io/app/problem/84)


## Description

Reverse the words in a sentence.

Assumptions



*   Words are separated by single space
*   There are no heading or tailing white spaces

Examples



*   "I love Google" → "Google love I"

Corner Cases



*   If the given string is null, we do not need to do anything.

Medium

Array

String


## Algorithm



1.  Reverse the whole sentence, char by char:
    1.  "I love Google" → "elgooG evol I"
1.  Reverse each word in the reversed sentence, word by word separated by single space
    1.  "elgooG evol I" → "Google love I"




## Solution


### Code


```java
public class Solution {
  public String reverseWords(String input) {
    // Write your solution here
    if (input == null || input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    // Step 1: reverse the sentence as a whole
    reverseCharacters(array, 0, array.length - 1);
    // Step 2: reverse each word separated by spaces in the sentence
    int start = 0;
    for (int end = 1; end < array.length; end++) {
      if (array[end] == ' ') {
        // When we see a space, reverse the word before it
        reverseCharacters(array, start, end - 1);
        // Update the start and end pointer
        start = ++end; // Skip the space
      } else if (end == array.length - 1) {
        // The sentence has no leading/trailing spaces
        // So we need to manually check the last word
        reverseCharacters(array, start, end);
      }
    }
    return new String(array);
  }

  private void reverseCharacters(char[] array, int start, int end) {
    while (start < end) {
      char temp = array[start];
      array[start] = array[end];
      array[end] = temp;
      start++;
      end--;
    }
  }
}
```



### Complexity

Time: iterate and operate each character exactly twice ⇒ O(2n) ⇒ O(n)

Space: considered O(1)


<!-- GD2md-html version 1.0β13 -->
