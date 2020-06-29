<!----- Conversion time: 0.767 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Tue Jan 15 2019 04:48:21 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=19iOYn1UU_-SjMLnm6uIzVVSywndCsTE68x3Q1kqGokI
----->

## Search In Unknown Sized Sorted Array

[https://app.laicode.io/app/problem/20](https://app.laicode.io/app/problem/20)

## Description

Given a integer dictionary A of unknown size, where the numbers in the dictionary are sorted in ascending order, determine if a given target integer T is in the dictionary. Return the index of T in A, return -1 if T is not in A.

Assumptions

- dictionary A is not null
- dictionary.get(i) will return null(Java)/INT_MIN(C++)/None(Python) if index i is out of bounds

Examples

- A = {1, 2, 5, 9, ......}, T = 5, return 2
- A = {1, 2, 5, 9, 12, ......}, T = 7, return -1

Medium

Array

Binary Search

## Algorithm

Do a counter-binary-search to find the sufficient end point that covers the target.

Then, do a normal binary search.

Similar problem on lintcode:

[https://www.lintcode.com/problem/search-in-a-big-sorted-array/description](https://www.lintcode.com/problem/search-in-a-big-sorted-array/description)

## Solution

### Code

#### Method 1: classical binary search:

```java
/*
 *  interface Dictionary {
 *    public Integer get(int index);
 *  }
 */

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
public class Solution {

  public int search(Dictionary dict, int target) {
    // Write your solution here
    // Corner cases
    if (dict == null || dict.get(0) == null) {
      return -1;
    }
    // Step 1: find the search range containing the target
    int start = 0;
    int end = 1;
    while (
      end <= Integer.MAX_VALUE / 2 &&
      dict.get(end) != null &&
      dict.get(end) < target
    ) {
      start = end + 1;
      end = end * 2;
    }
    // Step 2: look for the target in [start, end]
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (dict.get(mid) == null) {
        end = mid - 1;
      } else if (dict.get(mid) == target) {
        return mid;
      } else if (dict.get(mid) < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }
}
```

#### Method 2: binary search variant

```java
public class Solution {

  public int search(Dictionary dict, int target) {
    // Write your solution here
    if (dict == null || dict.get(0) == null) {
      return -1;
    }
    int start = 0;
    int end = 1;
    // Try to lock down the domain that contains the target
    while (
      end < Integer.MAX_VALUE / 2 &&
      dict.get(end) != null &&
      dict.get(end) < target
    ) {
      start = end + 1;
      end *= 2;
    }
    // With the start and end bounds found, look for the
    // target position using binary search
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (dict.get(mid) == null) {
        end = mid;
        continue;
      }
      // The test above was come up eventually after
      // several failed submissions for null pointer exception
      if (dict.get(mid) == target) {
        return mid;
      } else if (dict.get(mid) < target) {
        start = mid;
      } else {
        end = mid;
      }
    }
    // The null test statements were added also after failed runs
    if (dict.get(start) != null && dict.get(start) == target) {
      return start;
    } else if (dict.get(end) != null && dict.get(end) == target) {
      return end;
    }
    return -1;
  }
}
```

<!-- GD2md-html version 1.0β13 -->
