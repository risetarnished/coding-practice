<!----- Conversion time: 0.682 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Fri Jan 11 2019 01:44:45 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=13EXDMxPXa6CBwvmMvOH3tVkx90OZAcHnF_8tc2aFFVg
----->



# Right Shift by N Characters

[https://app.laicode.io/app/problem/397](https://app.laicode.io/app/problem/397)


## Description

Right shift a given string by n characters.

Assumptions



*   The given string is not null.
*   n >= 0.


## Assumption

Stated in the description above.


## Algorithm

E.g. s = "abcdef"



1.  Reverse the string ⇒ "fedcba"
1.  Reverse separately at index n
    1.  fe dcba
    1.  **ef** dcba
    1.  **ef abcd**


## Solution


### Code


```java
public class Solution {
  public String rightShift(String input, int n) {
    // Write your solution here
    if (input == null || input.length() <= 1) {
      return input;
    }
    int offset = n % input.length();
    char[] array = input.toCharArray();
    // Step 1: reverse the entire string
    reverse(array, 0, array.length - 1);
    // Step 2: reverse the two parts separated at offset
    reverse(array, 0, offset - 1);
    reverse(array, offset, array.length - 1);
    return new String(array);
  }

  private void reverse(char[] array, int start, int end) {
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


#### Time

Step 1 takes O(n)

Step 2 takes O(n)

⇒ O(2n) ⇒ O(n)


#### Space

O(1) because we consider this is in-place


<!-- GD2md-html version 1.0β13 -->
