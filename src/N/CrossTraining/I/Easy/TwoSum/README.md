# Two Sum

[https://app.laicode.io/app/problem/180](https://app.laicode.io/app/problem/180)

## Description


Determine if there exist two elements in a given array, the sum of which is the given target number.

**Assumptions**

- The given array is not null and has length of at least 2

**Examples**

- A = {1, 2, 3, 4}, target = 5, return true (1 + 4 = 5)
- A = {2, 4, 2, 1}, target = 4, return true (2 + 2 = 4)
- A = {2, 4, 1}, target = 4, return false

 **Tags**

- Easy
- Array
- Hashtable
- Sort

## Solution

### High-level Idea

- Do it in one iteration
- Use a set to store the remaining target that we are looking for
  - remaining target = target - current number being processed
- Whenever the current number is present in the set, indicating that it is a remaining target of one of the processed number, we have found a pair to meet the sum

### Code

```java
public class Solution {
  public boolean existSum(int[] array, int target) {
    // Write your solution here
    if (array ==  null || array.length == 0) {
      return false;
    }
    // Use a set that stores the corresponding pair number of the
    // current number that is being processed
    // target - current number = corresponding pair
    Set<Integer> set = new HashSet<>(array.length);
    for (int i = 0; i < array.length; i++) {
      if (set.contains(array[i])) {
        return true;
      }
      set.add(target - array[i]);
    }
    return false;
  }
}
```

### Complexity

- Time
  - One iteration over the array
  - O(n)
- Space
  - A HashSet which could be as large as the array
  - O(n)