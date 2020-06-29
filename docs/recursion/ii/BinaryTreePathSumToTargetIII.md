# Binary Tree Path Sum to Target III

https://app.laicode.io/app/problem/141

## Description

Given a binary tree in which each node contains an integer number. Determine if there exists a path **(the path can only be from one node to itself or to any of its descendants),** the sum of the numbers on the path is the given target number.

**Examples**

​ 5

/ \

2 11

​ / \

​ 6 14

/

3

If target = 17, There exists a path 11 + 6, the sum of the path is target.

If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.

If target = 10, There does not exist any paths sum of which is target.

If target = 11, There exists a path only containing the node 11.

**How is the binary tree represented?**

We use the level order traversal sequence with a special symbol "#" denoting the null node.

**For Example:**

The sequence \[1, 2, 3, #, #, 4\] represents the following binary tree:

​ 1

/ \

2 3

​ /

​ 4

**Tags**

- Medium
- Binary Tree
- Depth First Search
- Dynamic Programming

## Assumption

- The input binary tree should not be null

## Algorithms

### High-level Idea

- The problem can be solved using recursion (because it is a binary tree) + dynamic programming (keep the record of a path prefix sum hash set)
  - The DP part is similar to [Largest Subarray Sum](../../../../../L/DynamicProgramming/III/Medium/LargestSubarraySum)
- Use a HashSet to keep the record of the prefix_sum of the paths
  - E.g. for path 5 -> 11 -> 6 -> 3, the prefix_sum is {**5**, 16 (= 5 + 11), **22** (= 16 + 6), 25 (= 22 + 3)}
  - If we are looking for target = **17**
  - When the current prefixSum = 22, and (22 - 17) == 5 is in the prefix_sum set. There exists such a path
- At each level, ask if the left or right subtree has such a path
- If there does not exist such a path, remove the current path sum from the prefix sum set and backtrack

## Solution

### Code

```java
/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */

public class Solution {

  public boolean exist(TreeNode root, int target) {
    // Write your solution here
    // Corner case
    if (root == null) {
      return false;
    }
    // prefixSums stores the prefix sums of the nodes on the current path
    // The current path could be from any parent node to a child
    // Not necessarily started from the root
    Set<Integer> prefixSums = new HashSet<>();
    prefixSums.add(0);
    return existPath(root, target, prefixSums, 0);
  }

  private boolean existPath(
    TreeNode root,
    int target,
    Set<Integer> prefixSums,
    int currentSum
  ) {
    // Update the sum of the current path
    currentSum += root.key;
    // Base case:
    // when the current path sum - target is present in the prefix sum of the current path
    if (prefixSums.contains(currentSum - target)) {
      return true;
    }
    // See if the left or right subtree has such a path
    boolean needBacktrack = prefixSums.add(currentSum);
    if (
      root.left != null && existPath(root.left, target, prefixSums, currentSum)
    ) {
      return true;
    }
    if (
      root.right != null &&
      existPath(root.right, target, prefixSums, currentSum)
    ) {
      return true;
    }
    // Backtracking
    // When there does not exist such a path, remove the added current sum from the set
    if (needBacktrack) {
      prefixSums.remove(currentSum);
    }
    return false;
  }
}
```

### Complexity

- Time
  - This method only traverse the tree once
  - Total time is O(n)
- Space
  - The recursion tree can have at most O(n) levels because there are n nodes in the tree and the tree could be a linked list in the worst case (height = n)
  - There is a HashSet used to keep track of the path's prefix sum
  - Total space is O(n)
