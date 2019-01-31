package N.CrossTraining.II.Medium.LargestNumberSmallerInBinarySearchTree;

import helper.TreeNode.TreeNode;

/**
 * LargestNumberSmallerInBinarySearchTree
 *
 * @author meng
 * @date 1/28/19
 */
public class LargestNumberSmallerInBinarySearchTree {
    /**
     * In a binary search tree, find the node containing the largest number smaller than
     * the given target number.
     *
     * @param root    The root of the given BST
     * @param target  The target number
     * @return        The key of the node that is the largest number smaller than the target
     */
    public int largestSmaller(TreeNode root, int target) {
        // Write your solution here
        int result = Integer.MIN_VALUE;
        while (root != null) {
            if (root.key < target) {
                // Case 1: update the result
                result = root.key;
                root = root.right;
            } else {
                // Case 2: look for a smaller root
                root = root.left;
            }
        }
        return result;
    }
}
