<!----- Conversion time: 0.854 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Sat Jan 12 2019 16:26:06 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1I4TuF-VS03d1i2ehMacRBelxsMPaK-Le4YILbkv8_fk
----->



# String Replace

[https://app.laicode.io/app/problem/172](https://app.laicode.io/app/problem/172)


## Description

Given an original string input, and two strings S and T, replace all occurrences of S in input with T.

Assumptions



*   input, S and T are not null, S is not empty string

Examples



*   input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
*   input = "dodododo", S = "dod", T = "a", input becomes "aoao"





Hard

String


## Assumption

There are two possible cases:



1.  source.length() >= target.length() ⇒ we do not need to concern about the size of the array
1.  source.length < target.length() ⇒ we need to calculate how many more extra spaces we need to make the output array sufficient

Although this is not usually the case that we need to take into consideration if we are asked to do it in-place, we still need to do this for practice


## Algorithm

Two solutions



1.  Use StringBuilder to avoid overhead
    1.  iterate over the input, whenever there is a match of the source, append the target to the StringBuilder object.
    1.  otherwise, append whatever character it is in the input
    1.  we can utilize String's indexOf() method, but never the replace() method directly
1.  Use char[] array
    1.  source.length() vs. target.length()
        1.  if (source.length() >= target.length())
            1.  Two pointers/sliding window
        1.  if (source.length() < target.length()
            1.  Iterate over the input, count the number of source's appearances to get the number of extra spaces needed for the output
            1.  Populate the output array according to the input




## Solution


### Method 1: StringBuilder


#### Code


```java
public class Solution {
  public String replace(String input, String source, String target) {
    // Write your solution here
    if (input == null || input.length() == 0) {
      return input;
    }
    StringBuilder sb = new StringBuilder();
    // Check if source exists as a substring(s) in the input from fromIndex
    int fromIndex = 0;
    int matchIndex = input.indexOf(source, fromIndex);
    while (matchIndex != -1) {
      // matchIndex = index of the first occurrence of source in input
      // If we append input[fromIndex, matchIndex - 1]
      // we will safely skip the source
      sb.append(input, fromIndex, matchIndex).append(target);
      // Skip the source in input
      fromIndex = matchIndex + source.length();
      // Look for the next occurrence of source in input
      matchIndex = input.indexOf(source, fromIndex);
    }
    // No (more) occurrences of source in input
    // append the (rest of) input to the result
    sb.append(input, fromIndex, input.length());
    return sb.toString();
  }
}
```




_An alternative way - avoid using String.indexOf()_


```java
public class Solution {
    public String replace(String input, String source, String target) {
        // Write your solution here
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] inputArray = input.toCharArray();
        StringBuilder output = new StringBuilder();
        int inputIndex = 0;
        while (inputIndex < inputArray.length) {
            // When we are not in the window that contains the source
            // Just copy whatever in the input to the output
            if (!isSubstring(inputArray, inputIndex, source)) {
                output.append(inputArray[inputIndex++]);
                continue;
            }
            // Substring matches
            // Copy the target to the output
            for (int i = 0; i < target.length(); i++) {
                output.append(target.charAt(i));
            }
            // inputIndex pointer needs to move to the next "word"
            inputIndex += source.length();
        }
        return new String(output);
    }

    private boolean isSubstring(char[] input, int start, String source) {
        for (int i = 0; i < source.length(); i++) {
            if (start + i >= input.length) {
                return false;
            }
            if (input[start + i] != source.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
```



#### Complexity

Time:

n iterations for the while loop to check everything in the input

Inside the while loop, it takes O(k) times to check the substring

Therefore, O(n * k)

Space:

O(n) char array + O(n) StringBuilder




### Method 2: Char Array


#### Code


```java
public class Solution {
  public String replace(String input, String source, String target) {
    // Write your solution here
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] array = input.toCharArray();
    if (source.length() >= target.length()) {
      return replaceDirectly(array, source, target);
    }
    return replaceWithExtraSpace(array, source, target);
  }

  private String replaceDirectly(char[] array, String source, String target) {
    // Because the original input has sufficient space for the result
    // Just use two-pointers method to replace every occurrence of
    // source with target
    int slow = 0;
    int fast = 0;
    while (fast < array.length) {
      if (isSubstring(array, fast, source)) {
        // Check if fast points to an occurrence of source
        // If so, replace it with target
        replaceSource(array, slow, target);
        slow += target.length();
        fast += source.length();
      } else {
        // If no occurrence of source detected
        // Just copy fast to slow and move on
        array[slow++] = array[fast++];
      }
    }
    return new String(array, 0, slow);
  }

  private String replaceWithExtraSpace(char[] array,
                                       String source, String target) {
    // Because the input does not have enough space for the result
    // We need to calculate the number of extra space needed
    int sourceCount = 0;
    for (int i = 0; i <= array.length - source.length(); i++) {
      if (isSubstring(array, i, source)) {
        sourceCount++;
        i += source.length() == 1 ? 0 : source.length();
      }
    }
    // Allocate enough space for the result
    char[] result = new char[
        array.length + sourceCount * (target.length() - source.length())];
    // Two pointers:
    // 1. Elements to the left of output is to be returned
    // 2. Elements to the right of input is to be processed
    int inputPointer = 0;
    int outputPointer = 0;
    while (inputPointer < array.length) {
      if (isSubstring(array, inputPointer, source)) {
        replaceSource(result, outputPointer, target);
        inputPointer += source.length();
        outputPointer += target.length();
      } else {
        result[outputPointer++] = array[inputPointer++];
      }
    }
    return new String(result);
  }

  private boolean isSubstring(char[] array, int start, String source) {
    for (int i = 0; i < source.length(); i++) {
      if (start + i >= array.length) {
        return false;
      }
      if (array[start + i] != source.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  private void replaceSource(char[] array, int start, String target) {
    for (int i = 0; i < target.length(); i++) {
      array[start + i] = target.charAt(i);
    }
  }
}
```



#### Complexity

Time:

count the # of source in input to allocate extra space ⇒ O(n)

replace every occurrence of source with target ⇒ O(n)

⇒ O(n)

Space:

char array considered in-place ⇒ O(1)


<!-- GD2md-html version 1.0β13 -->
