package coollime.binarytree.searchinbinarysearchtree;

import coollime.helper.TreeNode;

public class Solution {

  /**
   * Given a Binary Search Tree, look for the node with a target key Recursive
   * method
   *
   * @param root The root of the given BST
   * @param key  The value of the target key
   * @return The node with the target key. Or null if no such node in the tree
   */
  public TreeNode search(TreeNode root, int key) {
    if (root == null || root.key == key) {
      return root;
    }
    return root.key > key ? search(root.left, key) : search(root.right, key);
  }

  /**
   * Given a Binary Search Tree, look for the node with a target key Iterative
   * method
   *
   * @param root The root of the given BST
   * @param key  The value of the target key
   * @return The node with the target key. Or null if no such node in the tree
   */
  public TreeNode iterativeSearch(TreeNode root, int key) {
    // Write your solution here
    // Corner case
    if (root == null) {
      return null;
    }
    while (root != null) {
      if (root.key == key) {
        return root;
      } else if (root.key > key) {
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return null;
  }
}
