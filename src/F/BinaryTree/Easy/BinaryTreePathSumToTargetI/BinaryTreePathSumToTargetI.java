package F.BinaryTree.Easy.BinaryTreePathSumToTargetI;

import helper.TreeNode.TreeNode;

/**
 * BinaryTreePathSumToTargetI
 *
 * @author meng
 * @date 1/31/19
 */
public class BinaryTreePathSumToTargetI {

    private BinaryTreePathSumToTargetI() {

    }

    private static class SingletonHolder {
        private static final BinaryTreePathSumToTargetI INSTANCE = new BinaryTreePathSumToTargetI();
    }

    public static BinaryTreePathSumToTargetI getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * Determine if a binary tree has a root-to-leaf path that sums up to a target number
     *
     * @param root    the root of the given binary tree
     * @param target  the target sum
     * @return        whether there exists such a root-to-leaf path
     */
    public boolean exist(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.key == target;
        }
        return exist(root.left, target - root.key) ||
                exist(root.right, target - root.key);
    }
}
