package G.HeapAndBFS.Medium.CheckIfBinaryTreeIsCompleted;

import helper.TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://app.laicode.io/app/problem/47
 *
 * Description
 *
 * Check if a given binary tree is completed. A complete binary tree is one in which every level of the binary tree is completely filled except possibly the last level. Furthermore, all nodes are as far left as possible.
 *
 * Examples
 *
 *         5
 *
 *       /    \
 *
 *     3        8
 *
 *   /   \
 *
 * 1      4
 *
 * is completed.
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
 * is not completed.
 *
 * Corner Cases
 *
 * What if the binary tree is null? Return true in this case.
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

public class CheckIfBinaryTreeIsCompleted {
    public boolean isCompleted(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return true;
        }
        // Use a flag to indicate whether there is a node missing a child before current node
        boolean childMissing = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            // If current does not have both or either children, set the flag to true
            if (current.left == null) {
                // Left child is missing
                childMissing = true;
            } else if (childMissing) {
                // If there is a previous node missing a child, but current does have a left child ==> not completed
                return false;
            } else {
                // If current has a left child and no previous node is missing a child
                // Put the left child into the queue
                queue.offer(current.left);
            }
            // Same for the right child
            if (current.right == null) {
                // Right child is missing
                childMissing = true;
            } else if (childMissing) {
                return false;
            } else {
                queue.offer(current.right);
            }
        }
        return true;
    }
}
