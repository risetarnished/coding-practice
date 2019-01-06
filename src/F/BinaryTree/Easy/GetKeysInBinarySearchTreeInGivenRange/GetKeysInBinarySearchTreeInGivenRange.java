package F.BinaryTree.Easy.GetKeysInBinarySearchTreeInGivenRange;

import helper.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://app.laicode.io/app/problem/55
 *
 * Description
 * Get the list of keys in a given binary search tree in a given range[min, max] in ascending order, both min and max are inclusive.
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
 *  1     4        11
 *
 * get the keys in [2, 5] in ascending order, result is  [3, 4, 5]
 *
 * Corner Cases
 *
 * What if there are no keys in the given range? Return an empty list in this case.
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

public class GetKeysInBinarySearchTreeInGivenRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // Recursive method
        /*
        // To meet the requirement that the result should be in ascending order
        // We need to do an in-order traversal
        // Case 1: traverse to the left
        if (root.key > min) {
            result.addAll(getRange(root.left, min, max));
        }
        // Case 2: add root
        if (root.key >= min && root.key <= max) {
            result.add(root.key);
        }
        // Case 3: traverse to the right
        if (root.key < max) {
            result.addAll(getRange(root.right, min, max));
        }
        return result;
        */

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
}
