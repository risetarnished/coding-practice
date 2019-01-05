package F.BinaryTree.Medium.InorderTraversalOfBinaryTree;

import helper.TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://app.laicode.io/app/problem/43
 * Description
 * Implement an iterative, in-order traversal of a given binary tree, return the list of keys of each node in the tree as it is in-order traversed.
 *
 * Examples
 *
 *              5
 *
 *           /    \
 *
 *         3        8
 *
 *       /   \        \
 *
 *     1      4        11
 *
 * In-order traversal is [1, 3, 4, 5, 8, 11]
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
 *         1
 *
 *       /   \
 *
 *      2     3
 *
 *           /
 *
 *         4
 */

public class InorderTraversalOfBinaryTree {
    public List<Integer> inOrder(TreeNode root) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        /* Recursive method */
        /*
        List<Integer> left = inOrder(root.left);
        List<Integer> right = inOrder(root.right);
        result.addAll(left);
        result.add(root.key);
        result.addAll(right);
        return result;
        */

        /* Iterative method */
        // Use a stack to keep track of the "root" nodes along the paths to the subtrees
        // Case 1: when the root has a left child ==> push the root to the stack and go left
        // Case 2: when the root doesn't have a left child ==> add root's key to the result and go right
        Deque<TreeNode> stack = new ArrayDeque<>();
        // Use a helper node to keep track of the root such that we can try its next moves
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

/**
 * 1. Recursion
 * Time complexity:
 * We need to traverse the entire tree ==> O(n).
 * Space complexity:
 * The # of levels in the recursion tree is determined by the height of the tree
 * Worst case: when the tree is a "linked list" ==> O(n)
 * Best case: when the tree is a balanced BST ==> O(log(n))
 * O(height)
 *
 * 2. Iteration
 * Time complexity:
 * A while loop traversing all the nodes in the tree ==> O(n).
 * Space complexity:
 * A stack is created to keep track of the root and its next moves ==> O(n).
 */
