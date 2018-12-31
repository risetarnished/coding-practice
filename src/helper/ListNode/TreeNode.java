package helper.ListNode;

import java.util.*;

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
        return key == treeNode.key &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, left, right);
    }

    /* Method to build a tree from a list of integer key values */
    /**
     *               0  1  2  3  4  5
     * The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
     *
     *     1
     *
     *   /   \
     *
     *  2     3
     *
     *       /
     *
     *     4
     */
    // # symbol is used to represent null
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

    /* Method to build a node given an Integer key (could be null) */
    public static TreeNode buildNode(Integer key) {
        if (key == null) {
            return null;
        }
        return new TreeNode(key);
    }

    // Test
    public static void main(String[] args) {
        TreeNode root = buildTree(new ArrayList<>(Arrays.asList(1, 2, 3, null, null, 4)));
    }
}
