package coollime.binarytree.general.balanced;

import coollime.helper.TreeNode;

public class Solution {

  /**
   * Naive recursive method which may have a lot of duplicate calculations
   *
   * @param root the root of the binary tree
   * @return whether the binary tree is balanced
   */
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
  }

  /**
   * Better and recursive method which avoids duplicate calculations
   *
   * @param root the root of the binary tree
   * @return whether the binary tree is balanced
   */
  public boolean improvedIsBalanced(TreeNode root) {
    return getDepth(root) != -1;
  }

  private int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }

  private int getDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = getDepth(root.left);
    if (leftHeight == -1) {
      return -1;
    }
    int rightHeight = getDepth(root.right);
    if (rightHeight == -1) {
      return -1;
    }
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
