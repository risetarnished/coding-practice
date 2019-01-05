package F.BinaryTree.Medium.TweakedIdenticalBinaryTrees;

import helper.TreeNode.TreeNode;

/**
 * https://app.laicode.io/app/problem/50
 *
 * Description
 * Determine whether two given binary trees are identical assuming any number of ‘tweak’s are allowed. A tweak is defined as a swap of the children of one node in the tree.
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
 * and
 *
 *         5
 *
 *       /    \
 *
 *     8        3
 *
 *            /   \
 *
 *           1     4
 *
 * the two binary trees are tweaked identical.
 *
 * How is the binary tree represented?
 *
 * We use the level order traversal sequence with a special symbol "#" denoting the null node.
 */

public class TweakedIdenticalBinaryTrees {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        // Write your solution here
        // Case 1: if both of the nodes are null ==> identical
        // Case 2: if either of the nodes is null ==> different
        // Case 3: if both of the nodes are not null, but keys are different ==> different
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key) {
            return false;
        }
        // Recursively check if
        // 1. left.left == right.right && left.right == right.left
        //    ||
        // 2. left.left == right.left && left.right == right.right
        return isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left) ||
                isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right);
    }
}

// Time complexity: we need to check all n nodes ==> O(n)
// Space complexity: O(height)
