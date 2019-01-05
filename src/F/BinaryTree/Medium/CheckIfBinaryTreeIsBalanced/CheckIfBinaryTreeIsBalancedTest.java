package F.BinaryTree.Medium.CheckIfBinaryTreeIsBalanced;

import helper.TreeNode.TreeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfBinaryTreeIsBalancedTest {
    private static CheckIfBinaryTreeIsBalanced ifBinaryTreeIsBalanced;
    private TreeNode root;

    @BeforeAll
    static void setInstance() {
        ifBinaryTreeIsBalanced = new CheckIfBinaryTreeIsBalanced();
    }

    @BeforeEach
    void setUp() {
        root = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        assertTrue(ifBinaryTreeIsBalanced.isBalanced(root));
    }

    @Test
    void testOneNode() {
        root = new TreeNode(0);
        assertTrue(ifBinaryTreeIsBalanced.isBalanced(root));
    }

    // In-order build tree: [5, 3, 8, 1, 4, #, 11]
    //              5
    //           /    \
    //         3        8
    //       /   \        \
    //     1      4        11
    @Test
    void testTrue() {
        root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4, null, 11)));
        assertTrue(ifBinaryTreeIsBalanced.isBalanced(root));
    }

    // In-order build tree: [5, 3, null, 1, 4]
    //              5
    //           /
    //        3
    //      /  \
    //    1     4
    @Test
    void testFalse() {
        root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 3, null, 1, 4)));
        assertFalse(ifBinaryTreeIsBalanced.isBalanced(root));
    }
}
