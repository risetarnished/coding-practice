## Check if Binary Tree is Balanced

[https://app.laicode.io/app/problem/46](https://app.laicode.io/app/problem/46)

## Description

Check if a given binary tree is balanced. A balanced binary tree is one in which the depths of every node's left and right subtree differ by at most 1.

Examples

            5

          /    \

        3        8

      /   \        \

    1      4        11

is balanced binary tree,

            5

          /

        3

      /   \

    1      4

is not balanced binary tree.

Corner Cases

- What if the binary tree is null? Return true in this case.

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence \[1, 2, 3, #, #, 4\] represents the following binary tree:

        1

      /   \

     2     3

          /

        4

Medium

Binary Tree

## Assumption

The tree is not null or empty.

## Algorithm

1.  According to the definition of a _balanced binary tree_
    1.  the depth of the left and right subtrees of every node differ by only 1 or less
    2.  recursively calculate the depth of every node in each subtree
    3.  compare the difference between the depths of left and right subtree at that node
2.  Avoid redundant depth calculations
    1.  there are a lot of duplicated computations in the first method
    2.  we can use a helper function which calculates the depth of the tree to avoid it
    3.  return -1 denotes the fact that the tree is not balanced
    4.  return the depth if it is balanced

## Solution

### Method 1

#### Code

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

  public boolean isBalanced(TreeNode root) {
    // Write your solution here
    // Recursively check
    // Base case: an empty tree or a leaf node is balanced
    if (root == null) {
      return true;
    }
    // Recursive rule:
    // Recursively compute and compare the height of the left and right subtree
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return false;
    }
    // Tail recursion
    return isBalanced(root.left) && isBalanced(root.right);
  }

  private int getHeight(TreeNode root) {
    // Base case: null ==> 0 height
    if (root == null) {
      return 0;
    }
    // Take the max value between left and right subtree height and plus 1 (this level)
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }
}
```

#### Complexity

Time: n nodes in the tree ⇒ log(n) levels, O(n) operation in each level ⇒ O(n log(n))

Space: log(n) levels ⇒ O(log(n)) or O(height)

### Method 2

#### Code

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

  public boolean isBalanced(TreeNode root) {
    // Write your solution here
    return maxDepth(root) != -1;
  }

  private int maxDepth(TreeNode root) {
    // Base case: null ==> 0 height
    if (root == null) {
      return 0;
    }
    // If either left or right subtree is not balanced or the height difference
    // is greater than 1
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
      return -1;
    }
    // Return the height at the current level
    return Math.max(left, right) + 1;
  }

  // An even cleaner way
  private int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = height(root.left);
    if (leftHeight == -1) {
      return -1;
    }
    int rightHeight = height(root.right);
    if (rightHeight == -1) {
      return -1;
    }
    // If both subtrees are balanced, check the height difference
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }
    // Otherwise, return the height at this level
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
```

#### Complexity

Time: log(n) levels in the tree and O(n) operation ⇒ O(n log(n))

Space: O(height)
