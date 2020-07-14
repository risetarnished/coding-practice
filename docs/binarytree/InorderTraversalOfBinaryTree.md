## In-order Traversal Of Binary Tree

[https://app.laicode.io/app/problem/43](https://app.laicode.io/app/problem/43)

## Description

Implement an iterative, in-order traversal of a given binary tree, return the list of keys of each node in the tree as it is in-order traversed.

Examples

            5

          /    \

        3        8

      /   \        \

    1      4        11

In-order traversal is \[1, 3, 4, 5, 8, 11\]

Corner Cases

- What if the given binary tree is null? Return an empty list in this case.

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

Iterative

Recursion

## Assumption

The tree should not be null.

## Algorithm

### Recursion

Recursively go to the left child of current node, after which go to the right child. Addition to the list is in the order of (left, root, right). Fairly straightforward.

### Iteration

We can't throw away the root in the stack before traversing the left subtree.

The root is the top element in the stack, so we could use a helper node to store the next "visiting" node and the subtree.

Cases:

1.  when helper is not null: traversal to the left subtree of the current root; push helper and go left
2.  when helper is null: traversal to the left subtree has finished; the current root is the top element in the tack; deal with the top and let helper = top.right
3.  repeat 1 & 2 until helper is null and there are no more nodes left in the stack


    	          5

                /   \

              2      8

             /  \

           1    3

helper: (initialized to root) stack: adding:
5 {}

5 → 5 not null, helper = 5.left {5}

2 → 2 not null, helper = 2.left {5, 2}

1 → 1 not null, helper = 1.left {5, 2, 1}

null, helper = 1.right {5, 2} 1

null, helper = 2.right {5} 2

3 → 3 not null, helper = 3.left {5, 3}

null, helper = 3.right {5} 3

null, helper = 5.right {} 5

8 → 8 not null, helper = 8.left {8}

null, helper = 8.right {} 8

null {}

## Solution

### Recursive method

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

  public List<Integer> inOrder(TreeNode root) {
    // Write your solution here
    // Recursion
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    List<Integer> left = inOrder(root.left);
    List<Integer> right = inOrder(root.right);
    result.addAll(left);
    result.add(root.key);
    result.addAll(right);
    return result;
  }
}
```

#### Complexity

Time: n nodes in the tree ⇒ O(n)

Space: the height of the tree determines the number of levels of the recursion tree ⇒ O(height)

### Iterative Method

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

  public List<Integer> inOrder(TreeNode root) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode current = root;
    while (current != null || !stack.isEmpty()) {
      if (current != null) {
        // The "current" node is not null, we need to traverse to the left
        stack.offerFirst(current);
        current = current.left;
      } else {
        // The "current" node is null, meaning the left traversal has
        // finished. Add the current root (stack top) to the lsit and
        // begin traversing to the right
        current = stack.pollFirst();
        result.add(current.key);
        current = current.right;
      }
    }
    return result;
  }
}
```

#### Complexity

Time: there are n nodes and we need to check every one of them ⇒ O(n)

Space: a stack and a helper node is used ⇒ O(n)
