# Insert in Binary Search Tree

[https://app.laicode.io/app/problem/51](https://app.laicode.io/app/problem/51)

## Description

Insert a key in a binary search tree if the binary search tree does not already contain the key. Return the root of the binary search tree.

Assumptions

- There are no duplicate keys in the binary search tree
- If the key is already existed in the binary search tree, you do not need to do anything

Examples

            5

          /    \

        3        8

      /   \

     1     4

insert 11, the tree becomes

            5

          /    \

        3        8

      /   \        \

     1     4       11

Easy

Binary Tree

Iterative

Recursion

## Assumption

The given BST should not be null and there should not be duplicate elements in the tree.

## Algorithm

- High level, basic idea
  - Use the characteristics of BST, look for the insertion point
    - Every node in the root's left subtree is less than the root
    - Every node in the root's right subtree is larger than the root
- Implementation
  - Iteration
    - Use a node curr to keep track of the current movement
      - 3 conditions
        - curr.key == key
          - no duplicates allowed
        - curr.key > key
          - insertion point is to the left
        - curr.key < key
          - insertion point is to the right
    - Check curr.left and curr.right respectively to try the next move
      - If we are going right
        - curr.right == null
          - this is the insertion point
        - curr.right != null
          - search curr.right subtree
      - Apply the same logic to the left subtree
  - Recursion
    - Base case
      - when we reach a null ⇒ return the new node to the parent
    - Recursive rule
      - In each level, ask the correct child to try the insertion
      - The child subtree would return the root of its subtree
      - If a node with the same key is found ⇒ return the node directly to the parent

## Solution

### Iteration

#### Code

```java
public TreeNode insert(TreeNode root, int key) {
  // Write your solution here
  // Corner case
  if (root == null) {
    return new TreeNode(key);
  }
  // Look for the expected position of the new node
  TreeNode curr = root;
  while (curr != null) {
    if (curr.key == key) {
      // 1. If a node with the same key is already present
      return root;
    } else if (curr.key < key) {
      // 2. Check the right subtree
      if (curr.right == null) {
        // Add the node if there is no right child
        curr.right = new TreeNode(key);
        break;
      } else {
        // Traverse to the right
        curr = curr.right;
      }
    } else {
      // 3. Check the left subtree
      //    Apply the same logic as before
      if (curr.left == null) {
        curr.left = new TreeNode(key);
        break;
      } else {
        curr = curr.left;
      }
    }
  }
  return root;
}
```

#### Complexity

Time:

The time it takes to find the expected position of the insertion point depends on the height of the tree ⇒ O(height)

Space:

Only constant space variables (TreeNode curr) created ⇒ O(1)

### Recursion

#### Code

```java
public TreeNode insert(TreeNode root, int key) {
  // Write your solution here
  // Base case: empty tree or null child of leaf node
  if (root == null) {
    return new TreeNode(key);
  } else if (root.key < key) {
    root.right = insert(root.right, key);
  } else if (root.key > key) {
    root.left = insert(root.left, key);
  }
  return root;
}
```

#### Complexity

Time:

The time it takes to find the expected position of the insertion point depends on the height of the tree ⇒ O(height)

Space:

The depth of recursion tree depends on the height of the tree ⇒ O(height)
