package C.Recursion.II.Medium.LowestCommonAncestorI;

import helper.TreeNode.TreeNode;

/**
 * LowestCommonAncestorI
 *
 * @author meng
 * @date 1/23/19
 */
public class LowestCommonAncestorI {
    /**
     * Find the lowest common ancestor of node one and two
     * under current binary tree node root
     *
     * @param root  the root of the tree
     * @param one   the first child node
     * @param two   the second child node
     * @return      the lowest common ancestor of one and two
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        // Write your solution here
        // Base case:
        // 1. root is null ==> may be leaf or one and be are not in the subtree
        // 2. a/b is the root ==> a/b is the lca
        if (root == null || root == one || root == two) {
            return root;
        }
        // Recursive rule:
        // Look for the two nodes in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);
        // Case 1: neither of the two subtrees returns null
        //         ==> the subtrees contain the two nodes
        //         ==> root is their lca
        if (left != null && right != null) {
            return root;
        }
        // Case 2: either of the subtrees returns a non-null node
        //         ==> only one of the two nodes is in the subtrees
        //         ==> lca is above root
        if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        // Case 3: both subtrees return null
        //         ==> neither of the two nodes is present in the subtrees
        return null;
    }
}
