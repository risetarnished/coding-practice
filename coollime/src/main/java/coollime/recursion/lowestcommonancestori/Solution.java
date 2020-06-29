package coollime.recursion.lowestcommonancestori;

import coollime.helper.TreeNode;

/**
 * LowestCommonAncestorI
 *
 * @author meng
 * @date 1/23/19
 */
public class Solution {

  /**
   * Find the lowest common ancestor of node one and two
   * under current binary tree node root
   *
   * @param root  the root of the tree
   * @param one   the first child node
   * @param two   the second child node
   * @return      the lowest common ancestor of one and two
   */
  public TreeNode lowestCommonAncestor(
    TreeNode root,
    TreeNode one,
    TreeNode two
  ) {
    if (root == null || root == one || root == two) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, one, two);
    TreeNode right = lowestCommonAncestor(root.right, one, two);
    if (left != null && right != null) {
      return root;
    }
    if (left != null) {
      return left;
    } else if (right != null) {
      return right;
    }
    return null;
  }
}
