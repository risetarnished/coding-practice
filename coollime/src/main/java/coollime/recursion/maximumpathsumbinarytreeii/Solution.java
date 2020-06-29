package coollime.recursion.maximumpathsumbinarytreeii;

import coollime.helper.TreeNode;

public class Solution {

  public int maxPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int[] max = new int[] { Integer.MIN_VALUE };
    findMaxPathSum(root, max);
    return max[0];
  }

  private int findMaxPathSum(TreeNode root, int[] max) {
    // Base case: when reaching a null
    if (root == null) {
      return 0;
    }
    // Ask the left and right subtrees for their max path sum
    int left = findMaxPathSum(root.left, max);
    int right = findMaxPathSum(root.right, max);
    // Treat any negative result as 0 since it will not increase our result
    left = left < 0 ? 0 : left;
    right = right < 0 ? 0 : right;
    // Update max
    max[0] = Math.max(max[0], left + right + root.key);
    // Return the larger single path sum to the parent
    return Math.max(left, right) + root.key;
  }
}
