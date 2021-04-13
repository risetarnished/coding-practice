package coollime.binarytree.traversal.postorder;

import coollime.common.objects.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<Integer> postOrder(TreeNode root) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode previous = null; // Previous node of root ==> null
    stack.offerFirst(root);
    while (!stack.isEmpty()) {
      TreeNode current = stack.peekFirst();
      // TODO: try to refactor and simplify the logic
      if (
        previous == null ||
        current == previous.left ||
        current == previous.right
      ) {
        if (current.left != null) {
          stack.offerFirst(current.left);
        } else if (current.right != null) {
          stack.offerFirst(current.right);
        } else {
          result.add(current.key);
          stack.pollFirst();
        }
      } else if (previous == current.left) {
        if (current.right != null) {
          stack.offerFirst(current.right);
        } else {
          result.add(current.key);
          stack.pollFirst();
        }
      } else if (previous == current.right) {
        result.add(current.key);
        stack.pollFirst();
      }
      // Move to the next step
      previous = current;
    }
    return result;
  }

  public List<Integer> recursivePostOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    List<Integer> left = postOrder(root.left);
    List<Integer> right = postOrder(root.right);
    result.addAll(left);
    result.addAll(right);
    result.add(root.key);
    return result;
  }
}
