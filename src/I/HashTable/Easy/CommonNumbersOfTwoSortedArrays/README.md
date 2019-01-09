<!----- Conversion time: 0.699 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Wed Jan 09 2019 03:16:51 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1KCo73TBhAmbo9GbcNJMbCS9erIdg1it3Kz2HJPX-PNI
----->



# Common Numbers of Two Sorted Arrays

[https://app.laicode.io/app/problem/72](https://app.laicode.io/app/problem/72)


## Description

Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).

Assumptions



*   In each of the two sorted arrays, there could be duplicate numbers.
*   Both two arrays are not null.

Examples



*   A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are \[1, 1, 2\]

Easy

Array


## Assumption

The input lists are not null or empty


## Algorithm



1.  Hashtable
    1.  Use a HashMap to store the elements and their corresponding number of appearances in A.
    1.  <k, v> → <element, # of times it appears in A>
    1.  For each element in B, check if there is a corresponding element in A:
    1.  if there is, add it do the result list and decrement the # of times it appears in A by 1 since we are moving forward such that the searching range has been cut off
1.  Merge sort method
    1.  two pointers initialized to the beginning of the two lists
    1.  compare the two pointed values
        1.  if (a == b) ⇒ add a or b then a++ b++
        1.  if (a < b) ⇒ a++
        1.  if (a > b) ⇒ b++


## Solution


### Method 1 - Hash table


#### Code


```java
public class Solution {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    if (A == null || A.isEmpty() || B == null || B.isEmpty()) {
      return result;
    }
    // Use a map to store <element, # of times it occurs in A> relationship
    Map<Integer, Integer> existsInA = new HashMap<>();
    for (Integer element : A) {
      existsInA.put(element, existsInA.getOrDefault(element, 0) + 1);
    }
    // For every element in B, look for its occurrence in A
    for (Integer number : B) {
      // If this number is present in A
      // and does not exceeds the number of occurrence in A
      // add it to the result
      if (existsInA.containsKey(number) && existsInA.get(number) > 0) {
        result.add(number);
        // Since we are moving forward, the searching window will
        // be moving towards right, as well.
        // The # of times this element appears in A needs to be
        // decremented by 1
        existsInA.put(number, existsInA.get(number) - 1);
      }
    }
    return result;
  }
}
```



#### Complexity

Time: initialization of map ⇒ O(m) + checking numbers in B ⇒ O(n) ⇒ O(m + n)

Space: use the list that has a smaller size to build the map ⇒ O(min(m, n))


### Method 2 - Merge sort


#### Code


```java
public class Solution {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    if (A == null || A.isEmpty() || B == null || B.isEmpty()) {
      return result;
    }
    int left = 0;
    int right = 0;
    while (left < A.size() && right < B.size()) {
      if (A.get(left).equals(B.get(right))) {
        result.add(A.get(left));
        left++;
        right++;
      } else if (A.get(left) < B.get(right)) {
        left++;
      } else {
        right++;
      }
    }
    return result;
  }
}
```



#### Complexity

Time: one whole iteration over the longer list ⇒ O(max(m, n)) or O(m + n)

Space: O(1)


<!-- GD2md-html version 1.0β13 -->
