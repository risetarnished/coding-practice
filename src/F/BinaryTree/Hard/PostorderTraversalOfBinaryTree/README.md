<!----- Conversion time: 0.869 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Fri Jan 04 2019 19:31:50 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1B0O0AH5BXfjkJ_QCYxFwdx-QoWnc4nWA7PhLbfE0deg
----->



## Post-order Traversal of Binary Tree

[https://app.laicode.io/app/problem/45](https://app.laicode.io/app/problem/45)


## Description

Implement an iterative, post-order traversal of a given binary tree, return the list of keys of each node in the tree as it is post-order traversed.

Examples

            5

          /    \

        3        8

      /   \        \

    1      4        11

Post-order traversal is \[1, 4, 3, 11, 8, 5\]

Corner Cases



*   What if the given binary tree is null? Return an empty list in this case.

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence \[1, 2, 3, #, #, 4\] represents the following binary tree:

        1

      /   \

     2     3

          /

        4


## Assumption

The tree should not be null


## Algorithm


### Recursion



1.  Base case: when we reach a leaf node ⇒ if (node == null) ⇒ return whatever there are in the result list
1.  Recursion rule: recursively go to the left and right subtree of the root; add everything returned from the left and right subtree to the result list; add the value of the root to the list


### Iteration



1.  Use a helper node which keeps track of the previously visited node
1.  Push the root onto the stack before entering the while loop
1.  Do a while-loop until the stack becomes empty ⇒ stack.isEmpty()
    1.  when we check the stack top, we do not want to remove it from the stack because of the nature of post-order traversal (we need to come back to the node after finishing left/right traversal). So, we peek the stack to get the current node
    1.  when we get the current node, we need to check its relationship with the previous visiting node
        1.  when previous is null (current is the root of the tree) or current is the child of previous, we should traverse down the tree
            1.  try to go to the left subtree first
            1.  try to go to the right subtree
            1.  if we cannot go either way, meaning we are at a leaf or the left and right traversal has finished, we need to add current to the result list and remove it from the stack top
        1.  when previous is current's left child (we are coming back from the left subtree)
            1.  if current has a right child ⇒ go right
            1.  if not ⇒ add current to the list and remove it from the stack
        1.  when previous is current's right child (we are coming back from the right subtree)
            1.  we do not need to do any more traversing ⇒ add current to the list and remove it from the stack
    1.  now we have finish traversal from the current node, we need to go back and check the previous node ⇒ previous = current


### Iteration - Alternative

There is also an alternative iterative method provided on [LeetCode](https://leetcode.com/problems/binary-tree-postorder-traversal/solution/):



*   Let's start from the root and then at each iteration pop the current node out of the stack and push its child nodes. In the implemented strategy we push nodes into stack following the order Top->Bottom and Left->Right. Since DFS postorder transversal is Bottom->Top and Left->Right the output list should be reverted after the end of loop.
*   Basically, it is the reversed version of [Pre-order Traversal of Binary Tree](../../Easy/PreorderTraversalOfBinaryTree):
    *   Push the root to the stack first
    *   Do a while-loop until the stack becomes empty
    *   Pop the stack pop element and **_add it to the head of the returning linked list_**
    *   Try to traverse to the right subtree first because we are **_adding to the head of the returning linked list_**


## Solution


### Recursive Method


#### Code


```java
/**
 * public class TreeNode {
 *     public int key;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int key) {
 *         this.key = key;
 *     }
 * }
 */
public class Solution {
    public List<Integer> postOrder(TreeNode root) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> left = postOrder(root.left);
        List<Integer> right = postOrder(root.right);
        result.addAll(left);
        result.addAll(right);
        result.add(root.key);
        return result;
    }
}
```



#### Complexity

Time: n nodes in the tree ⇒ check every one of them ⇒ O(n)

Space: O(height)




### Iterative Method


#### Code


```java
public class Solution {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            // The current node on the top of stack is the root
            // and it needs to be kept in place because we are
            // visiting it again after we finish traversal from
            // its child subtrees
            TreeNode curr = stack.peekFirst(); // peek instead of pop
            if (prev == null || curr == prev.left || curr == prev.right) {
                // When prev is null (root is the "root") or prev is the
                // parent of the current node
                // We should go down (left subtree first)
                if (curr.left != null) {
                    stack.offerFirst(curr.left);
                } else if (curr.right != null) {
                    stack.offerFirst(curr.right);
                } else {
                    // Child traversal has finished
                    // Now we need to pop the stack
                    result.add(curr.key);
                    stack.pollFirst();
                }
            } else if (prev == curr.left) {
                // When we are coming back from the left subtree
                // We should try to go right
                if (curr.right != null) {
                    stack.offerFirst(curr.right);
                } else {
                    result.add(curr.key);
                    stack.pollFirst();
                }
            } else {
                // When we are coming back from the right subtree
                // Only need to deal with the current root
                result.add(curr.key);
                stack.pollFirst();
            }
            prev = curr;
        }
        return result;
    }
}
```



#### Complexity

Time: n nodes in the tree ⇒ O(n).

Space: a stack is created ⇒ O(n).


### Iterative Method - LeetCode Alternative


#### Code


```java
public class Solution {
    public List<Integer> postOrder(TreeNode root) {
        // Write your solution here
        // Use a linked list for the result such that we can add new
        // elements to the result from the head
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pollFirst();
            result.addFirst(current.key);
            if (current.left != null) {
                stack.offerFirst(current.left);
            }
            if (current.right != null) {
                stack.offerFirst(current.right);
            }
        }
        return result;
    }
}
```



#### Complexity

Time: we visit each node exactly once, thus the time complexity is O(n), where n is  the number of nodes, _i.e._ the size of tree.

Space: depending on the tree structure, we could keep up to the entire tree, therefore, the space complexity is O(n).


<!-- GD2md-html version 1.0β13 -->
