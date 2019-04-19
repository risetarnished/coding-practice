# All Subsets with Size of K

## Description

Find all subsets which has a fixed size of k of a given string.

E.g., for input "abcd", all subsets that has a size of 2 are: {"ab", "ac", "ad", "bc", "bd", "cd"}

## Assumption

- The input type is a string (can also be easily generalized to list, array, or other collections)
- The input should not be null
- K >= 0
- Return a list of all subsets

## Algorithms

### High-level Idea

- This is still a subset problem (looking for possible subsets of a given set), therefore, it can be solved by a depth-first search
- Base case: 
  - when the subset has k elements, add it to the result list
- Recursive rule: 
  - at each level, we need to consider whether to add or skip the current element
- Data structure:
  - since the input is a string, we can use a StringBuilder to store the current subset

## Solution

### Code

```java
public class Solution {
  public List<String> subSets(String set, int k) {
    // Corner case
    List<String> result = new ArrayList<>();
    if (set == null || k < 0) {
      return result;
    }
    // Do a depth-first search to look for all possible subsets which has a size of k
    findAllSubsets(set, k, new StringBuilder(), 0, result);
    return result;
  }
  
  private void findAllSubsets(String set, int k, StringBuilder subset, int index,
                              List<String> result) {
    // Base case: when all elements have been checked and the subset has a size of k
    if (index == set.length()) {
      if (subset.length() == k) {
        result.add(subset.toString());
      }  
      return;
    }
    // Case 1: add the current element
    subset.append(set.charAt(index));
    findAllSubsets(set, k, subset, index + 1, result);
    subset.deleteCharAt(subset.length() - 1);
    // Case 2: skip the current element
    findAllSubsets(set, k, subset, index + 1, result);
  }
}
```

*An alternative way: continue doing DFS at every index/level - making the base case look better*

```java
public class Solution {
  public List<String> subSets(String set, int k) {
    // Corner case
    List<String> result = new ArrayList<>();
    if (set == null || k < 0) {
      return result;
    }
    // Do a depth-first search to look for all possible subsets which has a size of k
    findAllSubsets(set, k, new StringBuilder(), 0, result);
    return result;
  }
  
  private void findAllSubsets(String set, int k, StringBuilder subset, int index,
                              List<String> result) {
    // Base case: when the subset has a size of k
    if (subset.length() == k) {
      result.add(subset.toString());
      return;
    }
    // In each level, consider adding or skipping the current element and move on
    for (int i = index; i < set.length(); i++) {
      subset.append(set.charAt(i));
      findAllSusbets(set, k, subset, i + 1, result);
      subset.deleteCharAt(subset.length() - 1);
    }
  }
}
```

### Complexity

- Time
  - If there are n elements in the input set, we will need to do an n-level depth-first search
  - In each level, we need to consider two states: add or skip the current element
  - O(2^n)
- Space
  - The recursion tree has n levels
  - No additional data structure used
  - O(n)

