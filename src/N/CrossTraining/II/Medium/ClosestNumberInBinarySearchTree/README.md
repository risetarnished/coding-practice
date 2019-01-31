<!----- Conversion time: 0.875 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Mon Jan 28 2019 17:41:54 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1hhxmeXO6CVKMOWnPnTt5URQLVBTdvPtbbai4N4PI1X8
----->



# Closest Number in Binary Search Tree

[https://app.laicode.io/app/problem/135](https://app.laicode.io/app/problem/135)


## Description

In a binary search tree, find the node containing the closest number to the given target number.

Assumptions:



*   The given root is not null.
*   There are no duplicate keys in the binary search tree.

Examples:

        5

      /    \

    2      11

         /    \

        6     14

closest number to 4 is 5

closest number to 10 is 11

closest number to 6 is 6

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence \[1, 2, 3, #, #, 4] represents the following binary tree:

        1

      /   \

     2     3

          /

        4

Medium

Binary Search Tree


## Assumption

As stated in the description


## Algorithm

Maintain two variables:



1.  minDiff = the min difference in the key and the target
1.  solution node = the node that gives us the minDiff

Algorithm:



1.  Initialization: curr = root, minDiff = +infinity, solution = root (to prevent npe)
1.  In each step
    1.  curr.key == target ⇒ return solution = curr
    1.  curr.key > target ⇒ update minDiff and solution, curr = curr.left
    1.  curr.key < target ⇒ update minDiff and solution, curr = curr.right


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
  public int closest(TreeNode root, int target) {
    // Write your solution here
    if (root == null) {
      return -1;
    }
    TreeNode current = root;
    TreeNode closest = root;
    int minDiff = Integer.MAX_VALUE;
    while (current != null) {
      if (current.key == target) {
        return current.key;
      }
      // Update minDiff and closest node
      int diff = Math.abs(current.key - target);
      if (diff < minDiff) {
        minDiff = diff;
        closest = current;
      }
      // Update the traversing direction
      if (current.key < target) {
        current = current.right;
      } else {
        current = current.left;
      }
    }
    return closest.key;
  }
}
```



### Complexity


#### Time

In the worst case, we need to traverse the entire tree and check every single node ⇒ O(n)


#### Space

Constant space ⇒ O(1)


<!-- Docs to Markdown version 1.0β14 -->
