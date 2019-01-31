package N.CrossTraining.II.Medium.DeleteInBinarySearchTree;

import helper.TreeNode.TreeNode;

/**
 * DeleteInBinarySearchTree
 *
 * @author meng
 * @date 1/29/19
 */
public class DeleteInBinarySearchTree {
    /**
     * Delete the node with a given key in a binary search tree
     *
     * @param root  The root of the given BST
     * @param key   The key of the target node
     * @return      The root of the BST after deletion
     */
    public TreeNode deleteTree(TreeNode root, int key) {
        // Write your solution here
        // Base/Corner case: empty tree or leaf node
        if (root == null) {
            return null;
        }
        // Recursive rule
        // Classic BST traversal
        if (root.key > key) {
            root.left = deleteTree(root.left, key);
        } else if (root.key < key) {
            root.right = deleteTree(root.right, key);
        } else {
            // We have found the node with the target key
            if (root.left == null && root.right == null) {
                // Case 1: leaf node
                // Return itself as null to the parent
                return null;
            } else if (root.left == null || root.right == null) {
                // Case 2: the node has only one non-null child
                // Return the non-null child to the parent
                return root.left == null ? root.right : root.left;
            } else {
                // Case 3: the node has both left and right children
                // 1. find the smallest node in its right subtree
                // 2. copy and cover the node's key with the smallest value
                // 3. delete the smallest node in the node's right subtree
                int smallest = findSmallest(root.right);
                root.key = smallest;
                root.right = deleteTree(root.right, smallest);
            }
        }
        return root;
    }

    /**
     * Find the smallest key in a BST
     *
     * @param root  The root of the BST
     * @return      The smallest key
     */
    private int findSmallest(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.key;
    }
}
