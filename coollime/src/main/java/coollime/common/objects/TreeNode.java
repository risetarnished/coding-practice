package coollime.common.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class TreeNode {

  public int key;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int key) {
    this.key = key;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TreeNode)) return false;
    TreeNode treeNode = (TreeNode) o;
    return (
      key == treeNode.key &&
      Objects.equals(left, treeNode.left) &&
      Objects.equals(right, treeNode.right)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, left, right);
  }

  /* Method to build a tree from a list of integer key values */
  /**
   * 0 1 2 3 4 5 The sequence [1, 2, 3, #, #, 4] represents the following binary
   * tree: # symbol is used to represent null 1
   *
   * / \
   *
   * 2 3
   *
   * /
   *
   * 4
   *
   * @param keys The keys of the nodes in in-order sequence
   * @return A binary tree based on the in-order sequence of node's keys
   */
  public static TreeNode buildTree(List<Integer> keys) {
    if (keys == null || keys.isEmpty()) {
      return null;
    }
    int index = 0;
    int keySize = keys.size();
    TreeNode root = new TreeNode(keys.get(index++));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        TreeNode left = index >= keySize ? null : buildNode(keys.get(index++));
        node.left = left;
        TreeNode right = index >= keySize ? null : buildNode(keys.get(index++));
        node.right = right;
        // Add the children to the queue if they are not null
        if (left != null) {
          queue.offer(left);
        }
        if (right != null) {
          queue.offer(right);
        }
        // Stop if we reach the end of the list
        if (index >= keySize) {
          break;
        }
      }
    }
    return root;
  }

  public static TreeNode buildNode(Integer key) {
    if (key == null) {
      return null;
    }
    return new TreeNode(key);
  }

  /**
   * Find the node with a given key in a binary tree with no duplicate keys
   *
   * @param root The root of the binary tree
   * @param key  The key to look for
   * @return A TreeNode which has a key == key
   */
  public static TreeNode getNode(TreeNode root, Integer key) {
    if (root == null || root.key == key) {
      return root;
    }
    // Pre-order traversal
    Deque<TreeNode> stack = new LinkedList<>();
    stack.offerFirst(root);
    while (!stack.isEmpty()) {
      TreeNode curr = stack.pollFirst();
      if (curr.key == key) {
        return curr;
      }
      if (curr.right != null) {
        stack.offerFirst(curr.right);
      }
      if (curr.left != null) {
        stack.offerFirst(curr.left);
      }
    }
    return null;
  }

  // Test
  public static void main(String[] args) {
    buildTree(new ArrayList<>(Arrays.asList(1, 2, 3, null, null, 4)));
  }
}
