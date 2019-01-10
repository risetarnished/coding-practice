<!----- Conversion time: 0.691 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Thu Jan 10 2019 04:37:57 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1hiEuklb1HfNGYZznalcTguAEmhB8m8PiPufzhAOw89A
----->



# Determine if One String is Another's Substring

[https://app.laicode.io/app/problem/85](https://app.laicode.io/app/problem/85)


## Description

Determine if a small string is a substring of another large string.

Return the index of the first occurrence of the small string in the large string.

Return -1 if the small string is not a substring of the large string.

Assumptions



*   Both large and small are not null
*   If small is empty string, return 0

Examples



*   "ab" is a substring of "bcabc", return 2
*   "bcd" is not a substring of "bcabc", return -1
*   "" is substring of "abc", return 0


## Assumption

Neither of the strings shall be null.

If the smaller one is empty, return 0.


## Algorithm



1.  Direct comparison
    1.  loop through the large string
    1.  starting from each index i, look for the smaller string
1.  [Robin-Karp Algorithm](https://en.wikipedia.org/wiki/Rabin%E2%80%93Karp_algorithm)


## Solution


### Method 1: direct comparison


#### Code


```java
public class Solution {
  public int strstr(String large, String small) {
    // Write your solution here
    if (large == null || small == null) {
      return -1;
    }
    if (large.length() < small.length()) {
      return -1;
    }
    if (small.length() == 0) {
      return 0;
    }
    for (int i = 0; i < large.length() - small.length() + 1; i++) {
      for (int j = 0; j < small.length(); j++) {
        if (small.charAt(j) != large.charAt(i + j)) {
          break;
        }
        if (j == small.length() - 1) {
          return i;
        }
      }
    }
    return -1;
  }
}
```



#### Complexity


##### Time

For every index in the large string, we need to look for the presence of the small string

⇒ O(n * m) ⇒ O(n^2)


##### Space

Constant space ⇒ O(1)




### Method 2: Robin-Karp


#### Code


#### Complexity


##### Time


##### Space


<!-- GD2md-html version 1.0β13 -->
