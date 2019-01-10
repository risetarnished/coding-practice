<!----- Conversion time: 0.716 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Wed Jan 09 2019 23:36:59 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1y2NQZLM6dJN-95wM1LM8wdPY3okNrDVwqyrn7CK-z6Y
----->



# Reverse String

[https://app.laicode.io/app/problem/396](https://app.laicode.io/app/problem/396)


## Description

Reverse a given string.

Assumptions



*   The given string is not null.

Easy

String




## Algorithm

Two pointers: left vs. right

        "A    B    C    D    E    F"

         l →                    ← r

        "F    B    C    D    E    A"

              l →          ← r

        "F    E    C    D    B    A"

                   l →← r




## Solution


### Recursion


#### Code


```java
public class Solution {
  public String reverse(String input) {
    // Write your solution here
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] array = input.toCharArray();
    reverseCharacters(array, 0, array.length - 1);
    return new String(array);
  }

  private void reverseCharacters(char[] input, int left, int right) {
    // No need to care about the mid point when left meets right
    // Reversing something will never touch it.
    // So left == right is included in the base case
    if (left >= right) {
      return;
    }
    char temp = input[left];
    input[left] = input[right];
    input[right] = temp;
    reverseCharacters(input, left + 1, right - 1);
  }
}
```



#### Complexity

Time:

There are n characters in the string and we need to reverse all of them in O(1) time for each operation ⇒ O(n)

Space:

The only thing created is a char array which costs O(n). But in this exercise, it is not taken into consideration. We are considered to do this "in-place". ⇒ O(1)


### Iteration


#### Code


```java
public class Solution {
  public String reverse(String input) {
    // Write your solution here
    if (input == null || input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      swap(array, left++, right--);
    }
    return new String(array);
  }

  private void swap(char[] array, int left, int right) {
    char temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
```



#### Complexity

Time:

There are n characters in the string and we need to reverse all of them in O(1) time for each operation ⇒ O(n)

Space:

The only thing created is a char array which costs O(n). But in this exercise, it is not taken into consideration. We are considered to do this "in-place". ⇒ O(1)


<!-- GD2md-html version 1.0β13 -->
