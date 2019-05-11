# Two Sum All Pair II

<https://app.laicode.io/app/problem/182>

## Description

Find all pairs of elements in a given array that sum to the pair the given target number. Return all the **distinct** pairs of values.

**Assumptions**

- The given array is not null and has length of at least 2
- The order of the values in the pair does not matter

**Examples**

- A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return \[\[2, 4], \[3, 3]]

**Tags**

- Medium
- Array
- Hashtable
- Sort

## Solution

### High-level Idea

- Use two sets
  - set 1 stores the elements that have occurred and been processed in the array
  - set 2 stores the elements that have been added to the result already

### Code

```java
public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // Write your solution here
    List<List<Integer>> result = new ArrayList<>();
    if (array == null || array.length == 0) {
      return result;
    }
    Set<Integer> occurred = new HashSet<>();
    Set<Integer> inResult = new HashSet<>();
    for (int i = 0; i < array.length; i++) {
      // Avoid duplicate pairs being added to the result
      if (inResult.contains(array[i])) {
        continue;
      }
      int diff = target - array[i];
      if (ocurred.contains(diff)) {
        result.add(new ArrayList<>(Arrays.asList(array[i], diff)));
        // Add both of them to set 2
        inResult.add(array[i]);
        inResult.add(diff);
      }
      // The current element has occurred
      occurred.add(array[i]);
    }
    return result;
  }
}
```

### Complexity

- Time
  - Iterate over the array once
  - O(n)
- Space
  - Two HashSets which can grow as large as the array
  - O(2n) ==> O(n)