# Longest Common Substring

[https://app.laicode.io/app/problem/176](https://app.laicode.io/app/problem/176)

## Description

Find the longest common substring of two given strings.

**Assumptions**

- The two given strings are not null

**Examples**

- S = “abcde”, T = “cdf”, the longest common substring of S and T is “cd”

**Tags**

- Medium
- 2 D Array
- String

## Assumption

- Input
  - Two strings
  - Not null
- Output
  - String: the longest common substring of  the two

## Solution

### High-level Idea

- Naive solution
  - Iterate over S, for each character at index i
    - Iterate over T, for each character at index j
      - Check S\[i + j\] == T\[j]
  - O(n * m) time and O(1) space
- Better solution
  - Avoid re-calculations (iteration over T each time) by dynamic programming
  - common\[i]\[j] represents the length of the longest common substring of 
    - the first i characters in S and
    - the first j characters in T
  - If S\[i] == T\[j]
    - If we are at index 0
      - common\[i]\[j] = 1
    - Otherwise
      - The length of the current longest common substring is one letter longer than the previous one
      - common\[i]\[j] = common\[i - 1]\[j - 1] + 1
    - Update the global max
  - Otherwise, ignore it such that common\[i]\[j] stays 0

### Code

```java
public class Solution {
  public String longestCommon(String source, String target) {
    // Write your solution here
    if (source == null || target == null) {
      return null;
    }
    // Keep track of the length and  the starting index of the longest common substring
    int longest = 0;
    int start = 0;
    // common[i][j] represents the length of the longest common substring of
    // the first i characters in source and the first j characters in target
    int[][] common = new int[source.length()][target.length()];
    for (int i = 0; i < source.length(); i++) {
      for (int j = 0; j < target.length(); j++) {
        if (source.charAt(i) == target.charAt(j)) {
          if (i == 0 || j == 0) {
            common[i][j] = 1;
          } else {
            common[i][j] = common[i - 1][j - 1] + 1;
          }
          // Update global max and the starting index
          if (common[i][j] > longest) {
            longest = common[i][j];
            // i is pointing to the end so far and the length is "longest"
            start = i - longest + 1;
          }
        }
      }
    }
    // source[start, start + longest] is the result
    return source.substring(start, start + longest);
  }
}
```

### Complexity

- Time
  - For each character in the source, every character in the target is checked
  - O(n * m)
- Space
  - The "common" matrix is used to help speed up and avoid duplicate calculations
  - O(n * m)