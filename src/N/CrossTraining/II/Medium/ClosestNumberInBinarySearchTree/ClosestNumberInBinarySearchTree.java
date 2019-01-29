package N.CrossTraining.II.Medium.ClosestNumberInBinarySearchTree;

import helper.TreeNode.TreeNode;

/**
 * ClosestNumberInBinarySearchTree
 *
 * @author meng
 * @date 1/28/19
 */
public class ClosestNumberInBinarySearchTree {
    /**
     * In a BST, find the node containing the closest number to the given target number
     *
     * @param root    The root of the BST
     * @param target  The target number
     * @return        The key that is closest to the target number
     */
    public int closest(TreeNode root, int target) {
        // Write your solution here
        if (root == null) {
            return -1;
        }
        TreeNode current = root;
        TreeNode closest = root;
        int minDiff = Integer.MAX_VALUE;
        while (current != null) {
            if (current.key == target) {
                return current.key;
            }
            // Update minDiff and solution
            int diff = Math.abs(current.key - target);
            if (diff < minDiff) {
                minDiff = diff;
                closest = current;
            }
            // Update the traversing direction
            if (current.key < target) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return closest.key;
    }
}
