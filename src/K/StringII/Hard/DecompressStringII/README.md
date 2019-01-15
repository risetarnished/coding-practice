<!----- Conversion time: 0.562 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Sat Jan 12 2019 23:19:17 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=189rq4irdPgNRKSjsqLPqrrnTcyaiPd0GzaRA6lBympQ
----->



# Decompress String II

[https://app.laicode.io/app/problem/175](https://app.laicode.io/app/problem/175)


## Description

Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences.

Assumptions



*   The string is not null
*   The characters used in the original string are guaranteed to be 'a' - 'z'
*   There are no adjacent repeated characters with length > 9

Examples



*   "a1c0b2c4" → "abbcccc"



Hard

String


## Assumption

As stated in the description.

Usually, if we are required to do this in-place, the input array will be sufficient enough in space to hold the result such that we do not need to create any new result arrays. But to demonstrate this problem, we have to create one with a new size

There should be no letters with a count greater than 10 (no characters appear more than 10 times consecutively). In this case, we can use the [Character.digit(char ch, int radix)](https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#digit-char-int-) method with a radix value of 10.


## Algorithm



1.  Convert the input string to a char array to do it **in-place**. Although there is actually no need to do it for this problem, we can still do it since it is not a bad practice
1.  Determine the size will be needed for the result
1.  Iterate over the input and populate the output according to the count numbers of each character




## Solution


### Code


```java
public class Solution {
  public String decompress(String input) {
    // Write your solution here
    if (input == null || input.length() == 0) {
      return input;
    }
    // Allocate enough space for the result
    int size = getSize(input);
    char[] result = new char[size];
    int outputIndex = 0;
    // Populate the result
    for (int i = 0; i < input.length() - 1; i += 2) {
      int charCount = getDigit(input.charAt(i + 1));
      for (int j = 0; j < charCount; j++) {
        result[outputIndex++] = input.charAt(i);
      }
    }
    return new String(result);
  }

  private int getSize(String input) {
    int size = 0;
    for (int i = 0; i < input.length() - 1; i += 2) {
      size += getDigit(input.charAt(i + 1));
    }
    return size;
  }

  private int getDigit(char ch) {
    return ch - '0';
  }
}
```


_We can also use a StringBuilder to do this_


```java
public String decompress(String input) {
  // Write your solution here
  if (input == null || input.length() == 0) {
    return input;
  }
  StringBuilder sb = new StringBuilder();
  for (int i = 0; i < input.length() - 1; i += 2) {
    int charCount = getDigit(input.charAt(i + 1));
    for (int j = 0; j < charCount; j++) {
      sb.append(input.charAt(i));
    }
  }
  return sb.toString();
}
```



### Complexity

Time:

O(n) time to count the size

O(n) time to iterate over the input again and O(charCount) populating operations inside the iterations.

Therefore, O(n * character count).

For example, "a1b4c0d2" → "abbbbdd"

O(n * 4) since there are 4 b's

Space:

char[] result ⇒ O(n), but it is used for output ⇒ O(1)


<!-- GD2md-html version 1.0β13 -->
