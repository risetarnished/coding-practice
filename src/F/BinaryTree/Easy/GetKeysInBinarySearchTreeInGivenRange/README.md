<!----- Conversion time: 0.99 seconds.


Using this Markdown file:

1. Cut and paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* GD2md-html version 1.0β13
* Sun Jan 06 2019 01:04:12 GMT-0800 (PST)
* Source doc: https://docs.google.com/open?id=1oOY4dWJ8bFw0TVaAzM81uwwe5M4tF1VDZ2Qs4bxaclk
----->



## Get Keys in Binary Search Tree in Given Range

[https://app.laicode.io/app/problem/55](https://app.laicode.io/app/problem/55)


## Description

Get the list of keys in a given binary search tree in a given range[min, max] in ascending order, both min and max are inclusive.

Examples

            5

          /    \

        3        8

      /   \        \

     1     4        11

get the keys in \[2, 5\] in ascending order, result is  \[3, 4, 5\]

Corner Cases



*   What if there are no keys in the given range? Return an empty list in this case.

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

Iterative

Recursion


## Assumption

The tree should not be null or empty. And it should be a BST.


## Algorithm

This problem is pretty much the same as [Is Binary Search Tree or Not](../../Medium/IsBinarySearchTreeOrNot)



*   Recursively compare each node with the corresponding min and max bounds
*   Do an in-order traversal because the result needs to be in ascending order
*   When root.key is in the range, add it to the result


## Solution


### Recursive Method


#### Code


```java
public class Solution {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // To meet the requirement that the result should be in ascending order
        // We need to do an in-order traversal
        // Case 1: traverse to the left
        if (root.key > min) {
            result.addAll(getRange(root.left, min, max));
        }
        // Case 2: add root
        if (root.key >= min && root.key <= max) {
            result.add(root.key);
        }
        // Case 3: traverse to the right
        if (root.key < max) {
            result.addAll(getRange(root.right, min, max));
        }
        return result;
    }
}
```



#### Complexity


##### Time

We may need to traverse the whole tree ⇒ O(n).


##### Space

Because this is a BST, and the recursion tree is determined by the height of the tree ⇒ O(log(n)).


### Iterative Method


#### Code


```java
public class Solution {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // Use a stack to keep track of the traversal path
        // Use a helper node to try the next steps
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                // Traversing to the left
                stack.offerFirst(current);
                current = current.left;
            } else {
                // Left traversal finished
                // Get the root from stack and test its value
                // Then traverse to the right
                current = stack.pollFirst();
                if (current.key >= min && current.key <= max) {
                    result.add(current.key);
                }
                current = current.right;
            }
        }
        return result;
    }
}
```



#### Complexity


##### Time

The while-loop checks all of the nodes in the tree ⇒ O(n)


##### Space

The height of a BST is log(n) ⇒ O(log(n)).


<!-- GD2md-html version 1.0β13 -->
