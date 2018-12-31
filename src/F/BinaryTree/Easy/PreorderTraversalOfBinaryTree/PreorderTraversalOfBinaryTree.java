package F.BinaryTree.Easy.PreorderTraversalOfBinaryTree;

import helper.ListNode.TreeNode;

import java.util.*;

/**
 * https://app.laicode.io/app/problem/44
 * Description
 * Implement an iterative, pre-order traversal of a given binary tree, return the list of keys of each node in the tree as it is pre-order traversed.
 *
 * Examples
 *
 *         5
 *
 *       /    \
 *
 *     3        8
 *
 *   /   \        \
 *
 * 1      4        11
 *
 * Pre-order traversal is [5, 3, 1, 4, 8, 11]
 *
 * Corner Cases
 *
 * What if the given binary tree is null? Return an empty list in this case.
 * How is the binary tree represented?
 *
 * We use the level order traversal sequence with a special symbol "#" denoting the null node.
 *
 * For Example:
 *
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

public class PreorderTraversalOfBinaryTree {
    public List<Integer> preOrder(TreeNode root) {
        // Write your solution here
        /* Recursive method */
        /*
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
        */

        /* Iterative method */
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // Use a stack to store the left/right children of the root such that they can be trace back later
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollFirst();
            result.add(node.key);
            // Push the right child first such that it will be visit later than the left child
            if (node.right != null) {
                stack.offerFirst(node.right);
            }
            if (node.left != null) {
                stack.offerFirst(node.left);
            }
        }
        return result;
    }
}

/**
 * Recursion
 * Time complexity:
 * check every single node ==> O(n)
 *
 * Space complexity:
 * # of levels of recursion tree is determined by the height of the binary tree
 * worst case: if the tree is a linked list ==> O(n)
 * best case: if the tree is a balanced binary tree ==> O(log(n))
 * Therefore, O(height)
 *
 * Iteration
 * Time complexity:
 * a while-loop checking every single node ==> O(n)
 *
 * Space complexity:
 * a stack keeping of the nodes being traversed ==> O(n)
 */
