package F.BinaryTree.Medium.CheckIfBinaryTreeIsBalanced;

import helper.TreeNode.TreeNode;

/**
 * https://app.laicode.io/app/problem/46
 *
 * Description
 * Check if a given binary tree is balanced. A balanced binary tree is one in which the depths of every node’s left and right subtree differ by at most 1.
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
 * is balanced binary tree,
 *
 *         5
 *
 *       /
 *
 *     3
 *
 *   /   \
 *
 * 1      4
 *
 * is not balanced binary tree.
 *
 * Corner Cases
 *
 * What if the binary tree is null? Return true in this case.
 */

public class CheckIfBinaryTreeIsBalanced {
    public boolean isBalanced(TreeNode root) {
        // Write your solution here
        /* Method 1: Definition of Balanced Binary Tree */
        /*
        // Base case: an empty tree or a leaf node is balanced
        if (root == null) {
            return true;
        }
        // Recursive rule:
        // Recursively compute the height of the left and right subtree
        // Compare the difference
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        // Tail recursion: check if the left and right subtrees are balanced
        return isBalanced(root.left) && isBalanced(root.right);
        */

        /* Method 2: height of subtrees (avoid duplicated computations) */
        if (root == null) {
            return true;
        }
        // -1 denotes the fact that the tree is not balanced
        // if the tree is balanced, returned value is its actual depth
        return height(root) != -1;
    }

    private int getHeight(TreeNode root) {
        // Base case: null ==> 0 height
        if (root == null) {
            return 0;
        }
        // Take the max value between left and right subtree height and plus 1 (this level)
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private int height(TreeNode root) {
        // Base case: null ==> 0 height
        if (root == null) {
            return 0;
        }
        // If either left or right subtree is not balanced
        // we do not need to continue the computation, just return -1
        int leftHeight = height(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = height(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        // If both subtrees are balanced, check the height difference
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        // Otherwise, return the height at this level
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
