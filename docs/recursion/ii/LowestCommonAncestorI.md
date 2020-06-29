# Lowest Common Ancestor I

[https://app.laicode.io/app/problem/126](https://app.laicode.io/app/problem/126)

## Description

Given two nodes in a binary tree, find their lowest common ancestor.

Assumptions

- There is no parent pointer for the nodes in the binary tree
- The given two nodes are guaranteed to be in the binary tree

Examples

            5

          /   \

         9     12

       /  \      \

      2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9

Medium

Binary Tree

## Assumption

The two nodes are guaranteed to be in the tree.

## Algorithm

1.  What do I expect from the left/right child? ⇒ usually it is the return type of the recursion function
1.  What do I want to do in the current layer?
1.  What do you want to report to your parent? ⇒ same as step 1

Base case:

1.  if current root == a or root == b ⇒ current root is the LCA
1.  if current root is null ⇒ it cannot be the LCA ⇒ return null

Recursive rule:

1.  node a/b is a child of b/a
    1.  it is not possible to get non-null results from both left and right subtree
    1.  if both left and right return null ⇒ node a and b are not in the subtree ⇒ return null to the parent
    1.  if either left or right is not null ⇒ left/right subtree contains one of the two nodes ⇒ return left/right to the parent
1.  node a/b are not parent/child related
    1.  if both node a and b are not null ⇒ the current node c is their LCA ⇒ return the current node c to the parent
    1.  if left/right is not null ⇒ left/right is present in the subtrees of node c ⇒ return left/right to the parent
    1.  if both left and right are null ⇒ they are both absent from the subtrees of node c ⇒ return null to the parent

## Solution

### Code

```java
public class Solution {

  public TreeNode lowestCommonAncestor(
    TreeNode root,
    TreeNode one,
    TreeNode two
  ) {
    // Write your solution here.
    // Base case:
    // 1. root is null ==> leaf
    // 2. one/two is the root ==> one/two is the LCA itself
    if (root == null || root == one || root == two) {
      return root;
    }
    // Recursive rule:
    // Look for the two nodes in the left/right subtree of the root
    TreeNode left = lowestCommonAncestor(root.left, one, two);
    TreeNode right = lowestCommonAncestor(root.right, one, two);
    // 1. If both left and right are not null
    //    ==> both one and two are children of the root ==> root is the LCA
    if (left != null && right != null) {
      return root;
    }
    // 2. If only one of left/right is null
    //    ==> only left/right is root's child ==> LCA is above root
    if (left != null) {
      return left;
    } else if (right != null) {
      return right;
    }
    // 3. If left & right are null
    //    ==> root is not their ancestor
    return null;
  }
}
```

### Complexity

Time: in the worst case, we have to check every single node ⇒ O(n)

Space: O(height)
