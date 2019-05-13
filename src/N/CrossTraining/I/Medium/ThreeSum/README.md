# 3 Sum

[https://app.laicode.io/app/problem/186](https://app.laicode.io/app/problem/186)

## Description

Determine if there exists three elements in a given array that sum to the given target number. Return all the triple of values that sums to target.

Assumptions

- The given array is not null and has length of at least 3
- No duplicate triples should be returned, order of the values in the tuple does not matter

Examples

- A = {1, 2, 2, 3, 2, 4}, target = 8, return \[\[1, 3, 4], \[2, 2, 4]]

**Tags**

- Medium
- Array
- Sort

## Solution

### High-level Idea

- Do two 2Sum
  - either separately or nested
  - For each diff, run the second 2Sum, excluding the element at the current index
  - Use a set to avoid duplicate results
  - This is complicated because there are a lot of care should be taken in order to avoid duplicates
- Sort the array and use 3 pointers to do "two sum"
  - Sort the array (takes O(n log(n)), but nested two sum takes O(n^2) so this is not bad)
  - index i, j, k representing three pointers that point to the three elements in the triplet
    - i is fixed to the first element
    - use j and k to do a two sum process in a sorted array, looking for target - array\[i]
  - Look for array\[i] <= array\[j] <= array\[k] that sum up to target
  - When incrementing the pointers, skip the duplicate elements
    - i, j, and k can point to numbers with the same value separately and at the same time. But, each pointer cannot point to numbers with the same value for multiple times after being incremented

### Notes

```
Do two sum:

A = {1, 2, 2, 3, 2, 4}, target = 8
Sort the array and get
     0  1  2  3  4  5
A = {1, 2, 2, 2, 3, 4}

for i = 0: j = 1, k = 5, new target = 8 - \[i] = 8 - 1 = 7
  look for array\[j] + array\[k] == 7
    if smaller: j++
    if greater: k--
    if found: triplet.add(\[i], \[j], \[k])
  found 3 and 4
  result: {1, 3, 4}

for i = 1: j = 2, k = 5, target = 8 - \[i] = 8 -2 = 6
  ...
  found 2 and 4
  result: {2, 2, 4}

for i = 2: \[i] == \[i - 1] pass

for i = 3: \[i] == \[i - 1] pass

for i = 4: j = 5, k = 5, target = 8 - \[i] = 8 - 3 = 5
  ...
  found nothing
```

### Code



```java
public class Solution {
  public List<List<Integer>> allTriples(int[] array, int target) {
    // Write your solution here
    List<List<Integer>> result = new ArrayList<>();
    if (array == null || array.length <= 2) {
      return result;
    }
    // Sort the array to avoid duplicate easily
    Arrays.sort(array);
    // Use three pointers, i, j, k which point to the three triplets
    for (int i = 0; i < array.length; i++) {
      // [i] is fixed to be the first element in the potential triplet
      // So, skip any duplicate that have been checked already
      if (i > 0 && array[i] == array[i - 1]) {
        continue;
      }
      int start = i + 1;
      int end = array.length - 1;
      // Check until there are less than 2 elements left
      int diff = target - array[i];
      while (start < end) {
        if (array[start] + array[end] == diff) {
          result.add(new ArrayList<>(Arrays.asList(array[i], array[start], array[end])));
          // Increment start and skip any duplicate
          while (start < array.length - 1 && array[start] == array[start + 1]) {
            start++;
          }
          start++;
        } else if (array[start] + array[end] < diff) {
          // Increment start to make it greater
          while (start < array.length - 1 && array[start] == array[start + 1]) {
            start++;
          }
          start++;
        } else {
          // Decrement end to make it smaller
          while (end > 0 && array[end] == array[end - 1]) {
            end--;
          }
          end--;
        }
      }
    }
    return result;
  }
}
```

### Complexity

- Time
  - Sorting takes O(n log(n))
  - The for loop takes:
    - n + (n - 1) + (n - 2) + ... + 2 + 1 steps of comparisons
    - O(n^2)
  - Total time O(n^2)
- Space
  - Constant space O(1)