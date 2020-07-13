package coollime.binarytree.isbinarysearchtreeornot;

import coollime.helper.TreeNode;

public class Solution {

  public boolean isBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isValidBST(TreeNode root, int min, int max) {
    if (root == null) {
      return true;
    }
    if (root.key <= min || root.key >= max) {
      return false;
    }
    return (
      isValidBST(root.left, min, root.key) &&
      isValidBST(root.right, root.key, max)
    );
  }
}
