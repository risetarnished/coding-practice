package F.BinaryTree.Medium.IsBinarySearchTreeOrNot;

import helper.TreeNode.TreeNode;

/**
 * https://app.laicode.io/app/problem/54
 *
 * Description
 * Determine if a given binary tree is binary search tree.
 *
 * Assumptions
 *
 * There should no be duplicate keys in binary search tree.
 * You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.
 * Corner Cases
 *
 * What if the binary tree is null? Return true in this case.
 */

public class IsBinarySearchTreeOrNot {
    public boolean isBST(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return true;
        }
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int min, int max) {
        // Base case: when leaf node is reached
        if (root == null) {
            return true;
        }
        // Recursive rule:
        // Check the left and right subtrees
        // The root should always in the range (min, max)
        if (root.key <= min || root.key >= max) {
            return false;
        }
        // When we go left, the max becomes root's key
        // When we go right, the min becomes root's key
        return isValidBST(root.left, min, root.key) &&
                isValidBST(root.right, root.key, max);
    }
}

// Time complexity: we need to check all n nodes in the tree ==> O(n)
// Space complexity: recursion tree depends on the height of the binary tree ==> O(height)
