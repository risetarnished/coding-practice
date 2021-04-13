package coollime.binarytree.traversal.preorder;

import coollime.helper.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<Integer> preOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    // Use a stack to store the left/right children of the root such that they can
    // be trace back later
    Deque<TreeNode> stack = new LinkedList<>();
    stack.offerFirst(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pollFirst();
      result.add(node.key);
      // Push the right child first such that it will be visit later than the left
      // child
      if (node.right != null) {
        stack.offerFirst(node.right);
      }
      if (node.left != null) {
        stack.offerFirst(node.left);
      }
    }
    return result;
  }

  public List<Integer> recursivePreOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    List<Integer> left = preOrder(root.left);
    List<Integer> right = preOrder(root.right);
    result.add(root.key);
    result.addAll(left);
    result.addAll(right);
    return result;
  }
}
