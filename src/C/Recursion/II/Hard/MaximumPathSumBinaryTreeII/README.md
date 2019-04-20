# Maximum Path Sum Binary Tree II

https://app.laicode.io/app/problem/139

## Description

Given a binary tree in which each node contains an integer number. Find the maximum possible sum **from any node to any node (the start node and the end node can be the same).** 

**Assumptions**

- The root of the given binary tree is not null

**Examples**

   -1

  /    \

2      11

​       /    \

​     6    -14

one example of paths could be -14 -> 11 -> -1 -> 2

another example could be the node 11 itself

The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18

**How is the binary tree represented?**

We use the level order traversal sequence with a special symbol "#" denoting the null node.

**For Example:**

The sequence \[1, 2, 3, #, #, 4\] represents the following binary tree:

​    1

  /   \

 2     3

​      /

​    4

**Tags**

- Hard
- Binary Tree

## Assumption

- The input binary tree should not be null
- The keys of the nodes are only integers
- There may be positive or negative keys

## Algorithm

### High-level Idea

- Binary tree problems can be easily solved using recursion
- At each node being processed, ask its left and right child for their max path sum respectively
- When a null is reached, return 0
- At the current level, if a child's result is negative, treat it as 0 because a negative number will not make the result of this level (+ root.key) larger
- Pick the larger sum between the two subtrees and add root's key to it
- Return the larger **single path sum** to the parent

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
  public int maxPathSum(TreeNode root) {
    // Write your solution here
    // Corner case
    if (root == null) {
      return 0;
    }
    int[] max = new int[] {Integer.MIN_VALUE};
    findMaxPathSum(root, max);
    return max[0];
  }
  
  private int findMaxPathSum(TreeNode root, int[] max) {
    // Base case: when reaching a null
    if (root == null) {
      return 0;
    }
    // Ask the left and right subtrees for their max path sum
    int left = findMaxPathSum(root.left, max);
    int right = findMaxPathSum(root.right, max);
    // Treat any negative result as 0 since it will not increase our result
    left = left < 0 ? 0 : left;
    right = right < 0 ? 0 : right;
    // Update max
    max[0] = Math.max(max[0], left + right + root.key);
    // Return the larger single path sum to the parent
    return Math.max(left, right) + root.key;
  }
}
```

### Complexity

- Time
  - We need to traverse the entire tree to find the result
  - Total time is O(n)
- Space
  - The depth of the recursion tree depends on the height of the binary tree
  - Total space is O(height)
