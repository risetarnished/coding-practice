<!----- Conversion time: 0.719 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Sun Jan 13 2019 00:13:23 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=17P_cS6q79K16dNXHW4RVEL3YkLfx68INCB8vQCzEmow
----->



# Longest Substring without Repeating Characters

[https://app.laicode.io/app/problem/253](https://app.laicode.io/app/problem/253)


## Description

Given a string, find the longest substring without any repeating characters and return the length of it. The input string is guaranteed to be not null.

For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.

Medium

String


## Assumption

The input is not null, nor is it of length 0. In either case, it is considered to have a max length of 0


### Algorithm

Use the two pointers/sliding windows approach.

The slow pointer only moves when we see a duplicate character.

The fast pointer only moves when there is no duplicate characters present in the window.

For example,

    "a  b  c  d  e  c  f  g"

     0  1  2  3  4  5  6  7

     s →

        f →

…

    "a  b  c  d  e  c  f  g"

     0  1  2  3  4  5  6  7

     s →

                    f →

    "a  b  c  d  e  c  f  g"

     0  1  2  3  4  5  6  7

        s →

                    f →

    "a  b  c  d  e  c  f  g"

     0  1  2  3  4  5  6  7

           s →

                    f →

    "a  b  c  d  e  c  f  g"

     0  1  2  3  4  5  6  7

              s →

                    f →

    "a  b  c  d  e  c  f  g"

     0  1  2  3  4  5  6  7

              s →

                       f →

    "a  b  c  d  e  c  f  g"

     0  1  2  3  4  5  6  7

              s →

                          f →




### Solution


#### Code


```java
public class Solution {
    public int longest(String input) {
        // Write your solution here
        if (input == null || input.length() == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        int maxLen = 0;
        Set<Character> seen = new HashSet<>();
        while (fast < input.length()) {
            if (!seen.contains(input.charAt(fast))) {
                // If this character has not appeared before
                // 1. add it to the hash set
                // 2. move the fast pointer down by one
                // 3. update the max length
                seen.add(input.charAt(fast));
                fast++;
                maxLen = Math.max(maxLen, fast - slow);
            } else {
                // If this character has appeared before
                // 1. remove the character that slow points to from the set
                // 2. move the slow pointer down by one
                seen.remove(input.charAt(slow));
                slow++;
            }
        }
        return maxLen;
    }
}
```



#### Complexity

Time:

There are n characters in the string and there is only one iteration.

So, the time complexity is O(n)

Space:

A HashSet has been created to record the appearance of characters. So, the space complexity is O(n).


<!-- GD2md-html version 1.0β13 -->
