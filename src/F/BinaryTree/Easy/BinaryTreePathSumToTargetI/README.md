<!----- Conversion time: 0.653 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β14
* Thu Jan 31 2019 04:55:52 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=18Zi8lHhTXXZKWz5vg28G3pTyy3M2aIVMCTPCjIofLmU
----->



# Binary Tree Path Sum to Target I

[https://app.laicode.io/app/problem/440](https://app.laicode.io/app/problem/440)


## Description

Given a binary tree and a target sum, determine if the tree has a **root-to-leaf** path such that adding up all the values along the path equals the given target.

**Example:**

Given the below binary tree and target = 16,

             5
             / \
            4   8
           /   / \
          1    3  4
         /  \      \
        7    2      1


return true, as there exist a root-to-leaf path 5-8-3 which sum is 16.

Easy

Binary Tree

Recursion

Depth First Search


## Assumption

The given binary tree is not null


## Algorithm

The key insight of this problem is that the path has to be a **root-to-leaf** one. The nature of this requirement pretty much indicates that this should be solved with DFS.

The flow of thoughts follows the classic **Binary Tree + DFS **method:



1.  What do I expect from the left/right child? ⇒ usually it is the return type of the recursion function
    1.  If there exists a path that sums up to the target
1.  What do I want to do in the current layer?
    1.  Add my key to the path sum and check if there exists a path that sums up to the target in my left and right subtrees
1.  What do you want to report to your parent? ⇒ same as step 1
    1.  If there exists a path that sums up to the target in my left/right subtrees

Specifically for this problem:



*   Base case
    *   when the node is null ⇒ false
    *   when the node is leaf ⇒ if this path sums up to target ⇒ true
*   Recursive rule
    *   Look for the new target = target - root.key in my left/right subtrees


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
  public boolean exist(TreeNode root, int target) {
    // Write your solution here
    // Base case 1: null ==> false;
    if (root == null) {
      return false;
    }
    // Base case 2: leaf node ==> if path sum == target
    if (root.left == null && root.right == null) {
      return root.key == target;
    }
    // Recursive rule:
    // Look for path sum in the left and right subtrees
    // down to a leaf
    // If a path exists in either path ==> true
    return exist(root.left, target - root.key) ||
           exist(root.right, target - root.key);
  }
}
```



### Complexity


#### Time

In the worst case, we need to check every single node in the tree ⇒ O(n)


#### Space

We need one recursive call to check each one of the nodes in the tree. Therefore, there are n levels in the recursion tree ⇒ O(n)


<!-- Docs to Markdown version 1.0β14 -->
