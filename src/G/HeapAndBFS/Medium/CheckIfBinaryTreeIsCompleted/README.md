<!----- Conversion time: 1.461 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Sun Jan 06 2019 17:45:03 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1L5R-Ddf9DTetsiDQmyUIukf_ZLDJSZN3LuSSSMIJdiw
----->



# Check if Binary Tree is Completed

[https://app.laicode.io/app/problem/47](https://app.laicode.io/app/problem/47)


## Description

Check if a given binary tree is completed. A complete binary tree is one in which every level of the binary tree is completely filled except possibly the last level. Furthermore, all nodes are as far left as possible.

Examples

            5

          /    \

        3        8

      /   \

    1      4

is completed.

            5

          /    \

        3        8

      /   \        \

    1      4        11

is not completed.

Corner Cases



*   What if the binary tree is null? Return true in this case.

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

Breadth First Search


## Assumption

The input binary tree is not null or empty.


## Algorithm

BFS expand + generate



*   Case 1: if a node has a left child but no right child ⇒ false
*   Case 2: if a node misses a child, check all following node and see if any of them has node generated (if any ⇒ false)

E.g.

                                        1

                                /                \

                        3                            2                             ← 2 is the first node that misses a child

                    /        \                    /        \

                4            5                6            null

            /      \       /     \

        7          8  null  null                                            ← 4 generates 7 and 8


## Solution


### Code


```java
public class Solution {
  public boolean isCompleted(TreeNode root) {
    // Write your solution here
    if (root == null) {
      return true;
    }
    // Use a flag to indicate whether there is a previous node missing a child
    boolean childMissing = false;
    // Queue for BFS
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();
      // If the node is missing either or both children, raise flag
      if (current.left == null) {
        // Left child missing
        childMissing = true;
      } else if (childMissing) {
        // current has a left child, but a previous node misses a child
        return false;
      } else {
        // current does have a left child and no previous child missing
        queue.offer(current.left);
      }
      // Apply the same logic to the right child
      if (current.right == null) {
        childMissing = true;
      } else if (childMissing) {
        return false;
      } else {
        queue.offer(current.right);
      }
    }
    return true;
  }
}
```



### Complexity

Time

Although this is BFS, but the only thing we check is the queue. At most, the entire tree will be offer to the queue and each node will be offered exactly once ⇒ O(n).

Space

FIFO queue ⇒ O(n).


<!-- GD2md-html version 1.0β13 -->
