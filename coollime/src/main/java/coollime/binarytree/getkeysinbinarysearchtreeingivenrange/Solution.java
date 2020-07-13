package coollime.binarytree.getkeysinbinarysearchtreeingivenrange;

import coollime.helper.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<Integer> getRange(TreeNode root, int min, int max) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    // Iterative method:
    // Use a stack to keep track of the traversal path
    // Use a helper node to try the next steps
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode current = root;
    while (current != null || !stack.isEmpty()) {
      if (current != null) {
        // Traversing to the left
        stack.offerFirst(current);
        current = current.left;
      } else {
        // Left traversal finished
        // Get the root from stack and test its value
        // Then traverse to the right
        current = stack.pollFirst();
        if (current.key >= min && current.key <= max) {
          result.add(current.key);
        }
        current = current.right;
      }
    }
    return result;
  }

  public List<Integer> getRangeRecursively(TreeNode root, int min, int max) {
    // Recursive method
    /*
     * // To meet the requirement that the result should be in ascending order // We
     * need to do an in-order traversal // Case 1: traverse to the left if (root.key
     * > min) { result.addAll(getRange(root.left, min, max)); } // Case 2: add root
     * if (root.key >= min && root.key <= max) { result.add(root.key); } // Case 3:
     * traverse to the right if (root.key < max) {
     * result.addAll(getRange(root.right, min, max)); } return result;
     */
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    if (root.key > min) {
      result.addAll(getRangeRecursively(root.left, min, max));
    }
    if (root.key >= min && root.key <= max) {
      result.add(root.key);
    }
    if (root.key < max) {
      result.addAll(getRangeRecursively(root.right, min, max));
    }
    return result;
  }
}
