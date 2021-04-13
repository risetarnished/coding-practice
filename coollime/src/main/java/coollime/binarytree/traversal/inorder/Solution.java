package coollime.binarytree.traversal.inorder;

import coollime.helper.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

  public List<Integer> inOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    List<Integer> left = inOrder(root.left);
    List<Integer> right = inOrder(root.right);
    result.addAll(left);
    result.add(root.key);
    result.addAll(right);
    return result;
  }

  public List<Integer> iterativeInOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode current = root;
    while (current != null || !stack.isEmpty()) {
      if (current != null) {
        // When the node does have a left child, go left
        stack.offerFirst(current);
        current = current.left;
      } else {
        // When the node does not have a left child
        // current stack top is the node: add the key to result and go right
        current = stack.pollFirst();
        result.add(current.key);
        current = current.right;
      }
    }
    return result;
  }
}
