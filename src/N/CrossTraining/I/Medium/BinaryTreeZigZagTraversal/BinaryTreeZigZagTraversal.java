package N.CrossTraining.I.Medium.BinaryTreeZigZagTraversal;

import helper.TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * BinaryTreeZigZagTraversal
 *
 * @author meng
 * @date 1/25/19
 */
public class BinaryTreeZigZagTraversal {
    /**
     * Traverse a binary tree in zig-zag order
     * Get the keys of the nodes in a list
     *
     * @param root The root of the binary tree
     * @return     A list of the keys
     */
    public List<Integer> zigZag(TreeNode root) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        int level = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                // 1. even level: pollFirst()
                // 2. odd level: pollLast()
                TreeNode node = level % 2 == 0 ? deque.pollFirst() : deque.pollLast();
                result.add(node.key);
                if (level % 2 != 0) {
                    // In odd level
                    // 1. pollLast() to get nodes in this level
                    //    So, we have to offerFirst() to maintain the order
                    // 2. Because we will do pollFirst() in the next level
                    //    the right child gets offered before left child here
                    if (node.right != null) {
                        deque.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.offerFirst(node.left);
                    }
                } else {
                    // In even level
                    // 1. pollFirst() to get nodes in this level
                    //    So, we have to offerLast() to maintain the order
                    // 2. Because we will do pollLast() in the next level
                    //    the left child gets offerd before right child here
                    if (node.left != null) {
                        deque.offerLast(node.left);
                    }
                    if (node.right != null) {
                        deque.offerLast(node.right);
                    }
                }
            }
            // Finish traversing one level
            level++;
        }
        return result;
    }
}
