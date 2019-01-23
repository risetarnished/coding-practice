package C.Recursion.II.Medium.LowestCommonAncestorII;

/**
 * LowestCommonAncestorII
 *
 * @author meng
 * @date 1/23/19
 */
public class LowestCommonAncestorII {
    /**
     * Find the lowest common ancestor of two nodes
     * in a binary tree with parent pointer
     *
     * @param one   the first node
     * @param two   the second node
     * @return      the lowest common ancestor of one and two
     */
    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        // Write your solution here
        if (one == null || two == null) {
            return null;
        }
        int depthOne = getDepth(one);
        int depthTwo = getDepth(two);
        return lca(one, two, depthOne, depthTwo);
    }

    /**
     * Calculate the depth in the tree where the given node sits at
     *
     * @param node  the designated node
     * @return      the depth of the tree up to that level
     */
    private int getDepth(TreeNodeP node) {
        if (node == null) {
            return 0;
        }
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.parent;
        }
        return depth;
    }

    /**
     * Find the LCA of two nodes in a bottom-up fashion with parent pointer
     *
     * @param one       the first node
     * @param two       the second node
     * @param depthOne  the depth of the first node
     * @param depthTwo  the depth of the second node
     * @return          the LCA of the two nodes
     */
    private TreeNodeP lca(TreeNodeP one, TreeNodeP two, int depthOne, int depthTwo) {
        // Corner case: if either of them is null
        if (depthOne == 0 || depthTwo == 0) {
            return null;
        }
        // Traverse from the deeper node until the other node's level
        // At that point, traverse along the two node's parent pointers
        // until reaching a common node
        int diff = depthOne - depthTwo;
        TreeNodeP curr = null;
        if (diff > 0) {
            // Case 1: one sits deeper
            curr = one;
            while (diff > 0) {
                diff--;
                curr = curr.parent;
            }
            // When the two nodes get to the same level
            while (curr != two) {
                curr = curr.parent;
                two = two.parent;
            }
        } else {
            // Case 2: two sits deeper
            curr = two;
            while (diff < 0) {
                diff++;
                curr = curr.parent;
            }
            // When the two nodes get to the same level
            while (curr != one) {
                curr = curr.parent;
                one = one.parent;
            }
        }
        return curr;
    }
}

class TreeNodeP {
    int key;
    TreeNodeP left;
    TreeNodeP right;
    TreeNodeP parent;
    TreeNodeP(int key, TreeNodeP parent) {
        this.key = key;
        this.parent = parent;
    }
}
