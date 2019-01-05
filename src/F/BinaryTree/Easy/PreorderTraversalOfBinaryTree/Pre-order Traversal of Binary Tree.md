<!----- Conversion time: 0.652 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Wed Jan 02 2019 03:54:33 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1VVhLUDsj5bp-noWq2_N40pgw6NDYnNqiEXyNIDFyXgs
----->


<h2>Pre-order Traversal Of Binary Tree</h2>


[https://app.laicode.io/app/problem/44](https://app.laicode.io/app/problem/44)

<h2>Description</h2>


Implement an iterative, pre-order traversal of a given binary tree, return the list of keys of each node in the tree as it is pre-order traversed.

Examples

            5

          /    \

        3        8

      /   \        \

    1      4        11

Pre-order traversal is \[5, 3, 1, 4, 8, 11\]

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

<h2> Assumption</h2>


The tree should not be null.

<h2>Algorithm</h2>


<h3>Recursion</h3>


The recursive method is straightforward.



1.  Base case: when we reach a leaf node ⇒ node == null ⇒ return whatever we have for the result list
1.  Recursive rule: go to the left and right subtree of the current root respectively; add the value of current root to the result list; add all the thing we get from the left subtree; add all the thing we get from the right subtree

<h3>Iteration</h3>


The iterative method is trivial.



1.  Use a stack to keep track of the nodes we have traversed.
1.  Push the current root to the stack first
1.  Do a while-loop until everything in the stack has been popped out ⇒ stack.isEmpty()
    1.  pop the stack top ⇒ get the current root ⇒ add it to the result list
    1.  check if the current root has a right child ⇒ push it onto the stack
    1.  check if the current root has a left child ⇒ push it onto the stack



<h2>Solution</h2>


<h3>Code</h3>


<h5>Recursion</h5>



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
  public List<Integer> preOrder(TreeNode root) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    List<Integer> left = preOrder(root.left);
    List<Integer> right = preOrder(root.right);
    result.add(root.key);
    result.addAll(left);
    result.addAll(right);
    return result;
  }
}
```


<h5>Complexity</h5>


Time: there are n nodes in the tree and we need to check every one of them ⇒ O(n)

Space: the depth of the recursion tree is determined by the height of the tree ⇒ O(height)



<h5>Iteration</h5>



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
  public List<Integer> preOrder(TreeNode root) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.offerFirst(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pollFirst();
      result.add(node.key);
      if (node.right != null) {
        stack.offerFirst(node.right);
      }
      if (node.left != null) {
        stack.offerFirst(node.left);
      }
    }
    return result;
  }
}
```


<h5>Complexity</h5>


Time: a while-loop that checks every single node in the tree ⇒ O(n)

Space: a stack keeping track of the nodes traversed ⇒ O(n)


<!-- GD2md-html version 1.0β13 -->
