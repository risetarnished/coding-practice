<!----- Conversion time: 0.668 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β15
* Mon Feb 18 2019 02:11:33 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1dPU3a7QvTgH82-0GbXgJ4cXoK9PqwBuQwoF2Xur5Eew
----->



# Search in Binary Tree

[https://app.laicode.io/app/problem/52](https://app.laicode.io/app/problem/52)


## Description

Find the target key K in the given binary search tree, return the node that contains the key if K is found, otherwise return null.

Assumptions



*   There are no duplicate keys in the binary search tree

Easy

Binary Tree

Iterative

Recursion


## Assumption

The given binary search tree should not be null and there are no duplicate keys in the tree.


## Algorithm



*   High level idea
    *   Because this is a BST, it is straightforward to use its native feature to look for the target.
        *   Every node in the root's left subtree is smaller than the root
        *   Every node in the root's right subtree is larger than the root
    *   Use this feature to look for the target
*   Implementation: this problem can be solved with either iteration or recursion
    *   3 conditions
        *   Find the target
            *   if (root.key == target)
        *   Search left
            *   if (root.key > target)
        *   Search right
            *   if (root.key < target)


## Solution


### Iteration


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
  public TreeNode search(TreeNode root, int key) {
    // Write your solution here
    // Corner case
    if (root == null) {
      return null;
    }
    while (root != null) {
      if (root.key == key) {
        return root;
      } else if (root.key > key) {
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return null;
  }
}
```



#### Complexity


##### Time

Because this is a BST, the searching for a specific target can take O(n) time in the worst case (when the BST is a singly linked list) while it should take O(log(n)) on average (when the tree is balanced). The total time complexity is dependent on the height of the tree ⇒ O(height)


##### Space

No additional data structures have been used ⇒ O(1)


### Recursion


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
  public TreeNode search(TreeNode root, int key) {
    // Write your solution here
    // Base case
    if (root == null || root.key == key) {
      return root;
    }
    return root.key > key ?
        search(root.left, key) : search(root.right, key);
  }
}
```



#### Complexity


##### Time

The number of nodes it may take to check is dependent on the height of the tree ⇒ O(height)


##### Space

In the worst case, when the tree is a singly linked list, the depth of the recursion tree is n ⇒ O(n)

On average, when the tree is balanced, the depth of the recursion tree is log(n) ⇒ O(log(n))

In general, it is dependent on the height of the tree ⇒ O(height)


<!-- Docs to Markdown version 1.0β15 -->
