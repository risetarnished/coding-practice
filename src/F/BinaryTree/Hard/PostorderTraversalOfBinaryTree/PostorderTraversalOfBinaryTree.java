package F.BinaryTree.Hard.PostorderTraversalOfBinaryTree;

import helper.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://app.laicode.io/app/problem/45
 *
 * Description
 * Implement an iterative, post-order traversal of a given binary tree, return the list of keys of each node in the tree as it is post-order traversed.
 *
 * Examples
 *
 *         5
 *
 *       /    \
 *
 *     3        8
 *
 *   /   \        \
 *
 * 1      4        11
 *
 * Post-order traversal is [1, 4, 3, 11, 8, 5]
 *
 * Corner Cases
 *
 * What if the given binary tree is null? Return an empty list in this case.
 * How is the binary tree represented?
 *
 * We use the level order traversal sequence with a special symbol "#" denoting the null node.
 *
 * For Example:
 *
 * The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
 *
 *     1
 *
 *   /   \
 *
 *  2     3
 *
 *       /
 *
 *     4
 */

public class PostorderTraversalOfBinaryTree {
    public List<Integer> postOrder(TreeNode root) {
        // Write your solution here
        /*
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        */
        /* Recursive method */
        /*
        List<Integer> left = postOrder(root.left);
        List<Integer> right = postOrder(root.right);
        result.addAll(left);
        result.addAll(right);
        result.add(root.key);
        return result;
        */

        /* Iterative method */
        /*
        // Use a stack (of course, since we are coming back) to keep track of the root's path
        // Use a helper node to keep track of the previously visited node
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode previous = null; // Previous node of root ==> null
        stack.offerFirst(root);
        // Do a while-loop until the stack becomes empty
        // Check the stack top each time and compare it with the previously visited node
        while (!stack.isEmpty()) {
            // The current stack top is the root
            // We'd like to keep it in the stack because we are visiting back later ==> peek()
            TreeNode current = stack.peekFirst();
            // Case 1.1: previous is null ==> current is the root
            //      1.2: previous is the parent of current
            //      in both cases ==> traverse down the tree ==> left then right
            //      1.3: cannot go either way ==> current is a leaf node or traversals are done ==> add it to result and remove it from stack
            // Case 2.1: previous is current's left child and current has a right child ==> go right
            //      2.2: previous is current's left child and current has no right child ==> add it to result and remove it from stack
            // Case 3.1: previous is current's right child ==> traversals are done ==> add it to the result and remove it from stack
            // Check the previous ==> previous = current
            if (previous == null || current == previous.left || current == previous.right) {
                if (current.left != null) {
                    stack.offerFirst(current.left);
                } else if (current.right != null) {
                    stack.offerFirst(current.right);
                } else {
                    result.add(current.key);
                    stack.pollFirst();
                }
            } else if (previous == current.left) {
                if (current.right != null) {
                    stack.offerFirst(current.right);
                } else {
                    result.add(current.key);
                    stack.pollFirst();
                }
            } else if (previous == current.right) {
                result.add(current.key);
                stack.pollFirst();
            }
            // Move to the next step
            previous = current;
        }
        return result;
        */

        /* Leetcode method */
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

/**
 * 1. Recursion
 * Time complexity: n nodes in the tree ==> O(n)
 * Space complexity: determined by the height of the tree ==> O(height)
 *
 * 2. Iteration
 * Time complexity: n nodes in the tree ==> O(n)
 * Space complexity: a stack is created ==> O(n)
 */
