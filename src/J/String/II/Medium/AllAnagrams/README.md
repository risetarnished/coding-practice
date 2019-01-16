<!----- Conversion time: 1.006 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Sun Jan 13 2019 18:44:44 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=15TB2ZCGeyu-RQESoL1jhgJmpHzto0QETko5yPBWbKxA
----->



# All Anagrams

[https://app.laicode.io/app/problem/398](https://app.laicode.io/app/problem/398)


## Description

Find all occurrence of anagrams of a given string s in a given string l. Return the list of starting indices.

Assumptions



*   s is not null or empty.
*   l is not null.

Examples



*   l = "abcbac", s = "ab", return \[0, 3\] since the substring with length 2 starting from index 0/3 are all anagrams of "ab" ("ab", "ba").


## Assumption

Both of the strings should not be null or empty. The size of the shorter string should not be longer than the longer string.


## Algorithm

HashMap + sliding window



1.  Build a HashMap with <character in sh, frequency> relationship in shorter string
1.  Iterate over the longer string in a sliding window of shorter.length()
    1.  check every character's frequency in the map
    1.  if found one occurrence, decrement the frequency by one, suggesting that the number of this character needed to be found in the sliding window is now one less
        1.  if the frequency has dropped to 0 ⇒ we have found one match
    1.  if the number of matches in the current sliding window == size of the map, we have got a result ⇒ add the first index of this window to the result
    1.  when moving the window forwards, we need to take out the first character from the window, incrementing the frequency of it in the map by 1 because we need to find one more occurrence of it in the new sliding window
    1.  by doing this, we only need to check the newly entered character each time in the sliding window


## Solution


### Code


```java
public class Solution {
  public List<Integer> allAnagrams(String sh, String lo) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    if (sh == null || lo == null) {
      return result;
    }
    if (lo.length() == 0 || sh.length() > lo.length()) {
      return result;
    }
    // Use a map to store the <letter, frequency> relationship
    Map<Character, Integer> frequency = countFrequency(sh);
    // when the matches == the total # of distinct characters in map
    // we have found a result
    int match = 0;
    // Search the anagrams in a sliding window fashion
    int windowSize = sh.length();
    for (int i = 0; i < lo.length(); i++) {
      // For the character that just entered the sliding window
      // If it is in the map, decrement its frequency by 1 because
      // we need to match one less occurrence of it now
      // When its frequency is dropped to 1, we have a match
      char newChar = lo.charAt(i);
      Integer newFreq = frequency.get(newChar);
      if (newFreq != null) {
        frequency.put(newChar, --newFreq);
        if (newFreq == 0) {
          match++;
        }
      }
      // Moving the window forwards, handling the first character
      if (i >= windowSize) {
        char oldChar = lo.charAt(i - windowSize);
        Integer oldFreq = frequency.get(oldChar);
        if (oldFreq != null) {
          // Restore its frequency back to original state
          frequency.put(oldChar, ++oldFreq);
          if (oldFreq == 1) {
            match--;
          }
        }
      }
      // If we have matched all distinct letters and their
      // # of occurrence, we have found a result
      if (match == frequency.size()) {
        result.add(i - windowSize + 1);
      }
    }
    return result;
  }

  private Map<Character, Integer> countFrequency(String sh) {
    Map<Character, Integer> frequency = new HashMap<>(sh.length());
    for (int i = 0; i < sh.length(); i++) {
      frequency.put(sh.charAt(i),
                    frequency.getOrDefault(sh.charAt(i), 0) + 1);
    }
    return frequency;
  }
}
```



### Complexity


#### Time

Assume the size of sh is m and the size of lo is n

Build a frequency map of all letters in sh ⇒ O(m)

Maintain a sliding window to check every letter in lo ⇒ O(n)

In total, O(m + n) ⇒ O(n)


#### Space

HashMap of size m ⇒ O(m)


<!-- GD2md-html version 1.0β13 -->
