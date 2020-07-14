## Tweaked Identical Binary Trees

[https://app.laicode.io/app/problem/50](https://app.laicode.io/app/problem/50)

## Description

Determine whether two given binary trees are identical assuming any number of 'tweak's are allowed. A tweak is defined as a swap of the children of one node in the tree.

Examples

            5

          /    \

        3        8

      /   \

    1      4

and

            5

          /    \

        8        3

               /   \

              1     4

the two binary trees are tweaked identical.

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

The tree is not null or empty

## Algorithm

Similar to the [Symmetric Binary Tree](../../Easy/SymmetricBinaryTree) problem.

Instead of just comparing

1.  the left child of the left subtree with the right child of the right subtree
2.  the right child of the left subtree with the left child of the right subtree

We need to check:

1.  the _left child_ of the _left subtree_ with the _right child \_of the \_right subtree_
2.  the _right child_ of the _left subtree_ with the _left child_ of the _right subtree_
3.  the _left child_ of the _left subtree_ with the _left child_ of the _right subtree_
4.  the _right child_ of the _left subtree_ with the _right child_ of the _right subtree_

(1 && 2) || (3 && 4) ⇒ true

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

  public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
    // Write your solution here
    // Case 1: if both of the nodes are null ==> identical
    // Case 2: if either of the nodes is null ==> different
    // Case 3: if both of the nodes are not null, but keys are different ==> different
    if (one == null && two == null) {
      return true;
    } else if (one == null || two == null) {
      return false;
    } else if (one.key != two.key) {
      return false;
    }
    // Recursively check if
    // 1. left.left == right.right && left.right == right.left
    //    ||
    // 2. left.left == right.left && left.right == right.right
    return (
      isTweakedIdentical(one.left, two.right) &&
      isTweakedIdentical(one.right, two.left) ||
      isTweakedIdentical(one.left, two.left) &&
      isTweakedIdentical(one.right, two.right)
    );
  }
}
```

### Complexity

Time: we need to check all n nodes ⇒ O(n)

Space: recursion tree depends on the height of the tree ⇒ O(height)

## Additional Notes

![alt_text](Tweaked-Identical0.png "image_tooltip")
