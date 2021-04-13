package coollime.binarytree.general.symmetric;

import coollime.helper.TreeNode;

public class Solution {

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isSymmetricBinaryTree(root.left, root.right);
  }

  private boolean isSymmetricBinaryTree(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    } else if (left == null || right == null) {
      return false;
    } else if (left.key != right.key) {
      return false;
    }
    return (
      isSymmetricBinaryTree(left.left, right.right) &&
      isSymmetricBinaryTree(right.left, left.right)
    );
  }
}
