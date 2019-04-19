package C.Recursion.II.Medium.MaximumPathSumBinaryTreeIII;

import helper.TreeNode.TreeNode;

public class MaximumPathSumBinaryTreeIII {
  public int maxPathSum(TreeNode root) {
    // Write your solution here
    // Base case according to our assumptions
    if (root == null) {
      return 0;
    }
    // Maintain a global variable to keep track of the max path sum
    int[] max = new int[] {Integer.MIN_VALUE};
    findMaxPathSum(root, max);
    return max[0];
  }

  private int findMaxPathSum(TreeNode root, int[] max) {
    // Base case: when we reach a null, just return 0
    if (root == null) {
      return 0;
    }
    // Ask the left and right child for their maximum sub-path sums
    int left = findMaxPathSum(root.left, max);
    int right = findMaxPathSum(root.right, max);
    // In the current level, compare the two sums and the root's value
    // Return the largest one to the parent
    int larger = Integer.MIN_VALUE;
    // Directly return the root's key if it has no children
    if (root.left == null && root.right == null) {
      return root.key;
    } else if (root.left == null) {
      larger = right;
    } else if (root.right == null) {
      larger = left;
    } else {
      larger = Math.max(left, right);
    }
    // Update the global max only when there are sub-paths from either child
    max[0] = Math.max(max[0], larger);
    // Return the largest value among left, right, and the root
    return root.key > larger ? root.key : root.key + larger;
  }
}
