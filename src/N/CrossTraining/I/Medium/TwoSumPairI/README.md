# Two Sum All Pair I

<https://app.laicode.io/app/problem/181>

## Description

Find all pairs of elements in a given array that sum to the given target number. Return all the pairs of indexes.

**Assumptions**

- The given array is not null and has length of at least 2.

**Examples**

- A = {1, 3, 2, 4}, target = 5, return \[\[0, 3], \[1, 2]]
- A = {1, 2, 2, 4}, target = 6, return \[\[1, 3], \[2, 3]]

**Tags**

- Medium
- Array
- Hashtable

## Solution

### High-level Idea

- Do it in one iteration
- Use a map to store the relationship between
  - key: the remaining target number (remain = target - processing number)
  - value: the index of the processing number
- When we process the current number, store its corresponding remaining target and the index of itself as a key-value pair into the map
  - We need to make sure that elements which have the same key will not get overwritten
  - Therefore, we can use a helper class which holds the number's value and a list of indexes that it occurs in the array 
- When we see the current processing element is present in the map, indicating that it is one of the processed element's remaining target, we have found one result. 
- Keep doing this until all elements in the array has been checked

### Code

```java
public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    // Write your solution here
    List<List<Integer>> result = new ArrayList<>();
    if (array == null || array.length == 0) {
      return result;
    }
    // Use a HashMap to store the <remaining target, indexex of the current number> relationship
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      List<Integer> indexes = map.getOrDefault(array[i], new ArrayList<>());
      // If this number is one of the processed number's target difference
      // They are a pair
      if (!indexes.isEmpty()) {
        // For each occurrence of the diff, there is one pair
        for (int index : indexes) {
          result.add(new ArrayList<>(Arrays.asList(index, i)));
        }
      }
      // Add the current index to the current number's difference target's indexes list
      int diff = target - array[i];
      List<Integer> diffIndexes = map.getOrDefault(diff, new ArrayList<>());
      diffIndexes.add(i);
      map.put(diff, diffIndexes);
    }
    return result;
  }
}
```

### Complexity

- Time
  - One iteration over the array costs O(n)
  - Iteration over the indexes of the difference (target - array[i]) could cost up to O(n) in the worst case
  - O(n^2)
- Space
  - The map can be as large as the array
  - O(n)