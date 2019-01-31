<!----- Conversion time: 0.91 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Mon Jan 28 2019 18:01:15 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1fEvoyRJCh953zlS8pd5iANg1iAWvQmKS2XDkYiMR6NI
----->



# Largest Number Smaller in Binary Search Tree

[https://app.laicode.io/app/problem/136](https://app.laicode.io/app/problem/136)


## Description

In a binary search tree, find the node containing the largest number smaller than the given target number.

If there is no such number, return INT_MIN.

Assumptions:



*   The given root is not null.
*   There are no duplicate keys in the binary search tree.

Examples

        5

      /    \

    2      11

         /    \

        6     14

largest number smaller than 1 is Integer.MIN_VALUE(Java) or INT_MIN(c++)

largest number smaller than 10 is 6

largest number smaller than 6 is 5

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence \[1, 2, 3, #, #, 4] represents the following binary tree:

        1

      /   \

     2     3

          /

        4

**_Medium_**

**_Binary Search Tree_**




## Assumption

The tree should not be null or empty

There should not be duplicates in the BST


## Algorithm

This problem utilizes the classical BST traversal:



1.  if (root.key > target) ⇒ go left
1.  if (root.key < target) ⇒ go right

In this problem particularly, we maintain a global solution variable. This variable gets updated only when a node whose key is smaller than the target is met. Because this condition meets case 2, we need to go right. Since everything on the right of the node is larger than it, when we see another node < target in the right subtree of the current node, we can directly update the global solution.




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
  public int largestSmaller(TreeNode root, int target) {
    // Write your solution here
    int result = Integer.MIN_VALUE;
    while (root != null) {
      if (root.key < target) {
        // Case 1: update the result
        result = root.key;
        root = root.right;
      } else {
        // Case 2: look for a smaller node
        root = root.left;
      }
    }
    return result;
  }
}
```



### Complexity

Time:

On average, if the BST is balanced, traversal of the tree to a leaf node costs O(log(n)). In the worst case where the BST is flattened to a linked list, it is O(n). In either case, the complexity is O(height of the tree)

Space:

No additional data structures used ⇒ O(1)


<!-- Docs to Markdown version 1.0β14 -->
