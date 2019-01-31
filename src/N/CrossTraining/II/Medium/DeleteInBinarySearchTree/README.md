<!----- Conversion time: 0.649 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Thu Jan 31 2019 01:42:01 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1G_aT7CXoRucDweJNcZoyn-xG91eJhgscujG87Hg3Nm4
----->



# Delete in Binary Search Tree

[https://app.laicode.io/app/problem/53](https://app.laicode.io/app/problem/53)


## Description

Delete the target key K in the given binary search tree if the binary search tree contains K. Return the root of the binary search tree.

Find your own way to delete the node from the binary search tree, after deletion the binary search tree's property should be maintained.

Assumptions



*   There are no duplicate keys in the binary search tree
*   The smallest larger node is first candidate after deletion

Medium

Binary Tree

Iterative

Recursion


## Assumption

As listed in the description


## Algorithm

E.g., in the BST:

        12

       /  \

      11  13

     /   /  \

    10  12.5 14

If we try to delete a node with a given key



1.  if the node is a leaf node ⇒ just delete the node and return null (e.g. node 14)
1.  if the node has exactly one non-null child ⇒ delete the node and return its non-null child (e.g. node 11)
1.  if the node has two non-null children
    1.  find the node with the smallest key in the current node's right subtree
    1.  copy that key to the current position
    1.  recursively delete the smallest node from the right subtree


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
  public TreeNode deleteTree(TreeNode root, int key) {
    // Write your solution here
    // Base case: empty tree or leaf node
    if (root == null) {
      return null;
    }
    // Recursive rule:
    // Classical BST traversal
    if (root.key < key) {
      root.right = deleteTree(root.right, key);
    } else if (root.key > key) {
      root.left = deleteTree(root.left, key);
    } else {
      // We have found the node to delete
      if (root.left == null && root.right == null) {
        // Case 1: this is a leaf node
        // Delete it directly by returning a null to the parent
        return null;
      } else if (root.left == null || root.right == null) {
        // Case 2: the root has only one non-null child
        // Delete it by return its non-null child to the parent
        return root.left == null ? root.right : root.left;
      } else {
        // Case 3: the root has both left and right children
        // Delete it by:
        //   1. find the smallest node in its right subtree
        //   2. copy the smallest key and cover the node's key
        //   3. delete the smallest node from the right subtree
        int smallest = findSmallestKey(root.right);
        root.key = smallest;
        root.right = deleteTree(root.right, smallest);
      }
    }
    return root;
  }

  private int findSmallestKey(TreeNode root) {
    while (root.left != null) {
      root = root.left;
    }
    return root.key;
  }
}
```



### Complexity


#### Time

Although a search/delete/insert operation in BST will try to narrow the range of operations down by half each time, a BST may be a singly linked list in the worst case. The number of operations (levels of recursion tree) is dependent on the height of the BST ⇒ O(height) ⇒ O(log(n)) on average ⇒ O(n) worst case


#### Space

There are no extra spaces used in each recursion call ⇒ O(height)


<!-- Docs to Markdown version 1.0β14 -->
