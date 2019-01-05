<!----- Conversion time: 0.816 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Sat Jan 05 2019 03:33:33 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1kaBiYFnU0IPUrBIZmU3z3ximMEM_dbfLxMFBfDrYq2E
----->



## Is Binary Search Tree or Not

[https://app.laicode.io/app/problem/54](https://app.laicode.io/app/problem/54)


## Description

Determine if a given binary tree is binary search tree.

Assumptions



*   There should no be duplicate keys in binary search tree.
*   You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.

Corner Cases



*   What if the binary tree is null? Return true in this case.

Medium

Binary Tree

Iterative

Recursion


## Assumption

The tree is not null or empty.

null ⇒ is BST

empty tree or tree with only one node ⇒ is BST


## Algorithm

Helper function recursion.



1.  Base case: leaf node null ⇒ true
1.  Parameters:
    1.  root node
    1.  min
    1.  max
1.  Conditions:
    1.  the root node should be in the range (min, max)
1.  Recursive rule:
    1.  check the current root's left subtree
        1.  new root = root.left
        1.  min = min
        1.  max = root.key
    1.  check the current root's right subtree
        1.  new root = root.right
        1.  min = root.key
        1.  max = max




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
  public boolean isBST(TreeNode root) {
    // Write your solution here
    if (root == null) {
      return true;
    }
    return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isValidBST(TreeNode root, int min, int max) {
    // Base case: when leaf node is reached
    if (root == null) {
      return true;
    }
    // Recursive rule:
    // For every node in the subtree, it should be in the range (min, max)
    if (root.key <= min && root.key >= max) {
      return false;
    }
    // Update the min and max values respectively when traversing
    return isValidBST(root.left, min, root.key) &&
        isValidBST(root.right, root.key, max);
  }
}
```



### Complexity

Time: we need to check every single node in the tree ⇒ O(n)

Space: the recursion tree is dependent on the height of the binary tree ⇒ O(height)


<!-- GD2md-html version 1.0β13 -->
