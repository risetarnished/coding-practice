package F.BinaryTree.Easy.InsertInBinarySearchTree;

import helper.TreeNode.TreeNode;

/**
 * InsertInBinarySearchTree
 *
 * @author meng
 * @date 2/18/19
 */
public class InsertInBinarySearchTree {
    /**
     * Given a Binary Search Tree and a key, insert a new node with the given key
     * into the binary search tree
     *
     * Recursive method
     *
     * @param root  The root of the BST
     * @param key   The key of the new node to get inserted
     * @return      The root of the BST after insertion
     */
    public TreeNode recursiveInsert(TreeNode root, int key) {
        // Base case
        if (root == null) {
            return new TreeNode(key);
        } else if (root.key > key) {
            root.left = recursiveInsert(root.left, key);
        } else if (root.key < key) {
            root.right = recursiveInsert(root.right, key);
        }
        return root;
    }

    /**
     * Given a Binary Search Tree and a key, insert a new node with the given key
     * into the binary search tree
     *
     * Iterative method
     *
     * @param root  The root of the BST
     * @param key   The key of the new node to get inserted
     * @return      The root of the BST after insertion
     */
    public TreeNode iterativeInsert(TreeNode root, int key) {
        // Write your solution here
        // Corner case
        if (root == null) {
            return new TreeNode(key);
        }
        // Look for the expected position of the new node
        TreeNode curr = root;
        while (curr != null) {
            if (curr.key == key) {
                // 1. If a node with the same key is already present
                return root;
            } else if (curr.key < key) {
                // 2. Check the right subtree
                if (curr.right == null) {
                    // Add the node if there is no right child
                    curr.right = new TreeNode(key);
                    break;
                } else {
                    // Traverse to the right
                    curr = curr.right;
                }
            } else {
                // 3. Check the left subtree
                //    Apply the same logic as before
                if (curr.left == null) {
                    curr.left = new TreeNode(key);
                    break;
                } else {
                    curr = curr.left;
                }
            }
        }
        return root;
    }
}
