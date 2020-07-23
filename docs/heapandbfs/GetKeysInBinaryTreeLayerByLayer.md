# Get Keys In Binary Tree Layer By Layer

[https://app.laicode.io/app/problem/57](https://app.laicode.io/app/problem/57)

## Description

Get the list of list of keys in a given binary tree layer by layer. Each layer is represented by a list of keys and the keys are traversed from left to right.

Examples

            5

          /    \

        3        8

      /   \        \

     1     4        11

the result is \[ \[5\], \[3, 8\], \[1, 4, 11\] \]

Corner Cases

- What if the binary tree is null? Return an empty list of list in this case.

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence \[1, 2, 3, #, #, 4\] represents the following binary tree:

        1

      /   \

     2     3

          /

        4

Easy

Binary Tree

Breadth First Search

Depth First Search

## Assumption

The input binary tree should not be empty.

## Algorithm

This is what is called _[level-order traversal of binary tree](https://www.geeksforgeeks.org/level-order-tree-traversal/)_

- BFS1 (Breadth First Search)
- Data structure: FIFO queue
- Basic flow to describe a BFS process:
  - Definition 1: Expand a node _s_
  - Definition 2: Generate the neighbors of _s_
  - Data structure: Maintain a FIFO queue, put all generated nodes into the queue
  - Termination condition: do a loop until the queue becomes empty

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

  public List<List<Integer>> layerByLayer(TreeNode root) {
    // Write your solution here
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode curr = queue.poll();
        if (curr.left != null) {
          queue.offer(curr.left);
        }
        if (curr.right != null) {
          queue.offer(curr.right);
        }
        level.add(curr.key);
      }
      result.add(level);
    }
    return result;
  }
}
```

### Complexity

Time: traversing the whole tree ⇒ O(n)

Space: a queue is used ⇒ O(n)
