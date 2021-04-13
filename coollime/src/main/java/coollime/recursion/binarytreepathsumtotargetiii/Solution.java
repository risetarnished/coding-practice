package coollime.recursion.binarytreepathsumtotargetiii;

import coollime.common.objects.TreeNode;
import java.util.HashSet;
import java.util.Set;

public class Solution {

  public boolean exist(TreeNode root, int target) {
    // Write your solution here
    // Base case: root is null
    if (root == null) {
      return false;
    }
    Set<Integer> prefixSums = new HashSet<>();
    prefixSums.add(0);
    return existPath(root, prefixSums, 0, target);
  }

  private boolean existPath(
    TreeNode root,
    Set<Integer> prefixSums,
    int currentSum,
    int target
  ) {
    currentSum += root.key;
    // When the current_path_sum - target is in the path's prefixSum set
    // there is such a path
    if (prefixSums.contains(currentSum - target)) {
      return true;
    }
    boolean needRemove = prefixSums.add(currentSum);
    if (
      root.left != null && existPath(root.left, prefixSums, currentSum, target)
    ) {
      return true;
    }
    if (
      root.right != null &&
      existPath(root.right, prefixSums, currentSum, target)
    ) {
      return true;
    }
    if (needRemove) {
      prefixSums.remove(currentSum);
    }
    return false;
  }
}
