package F.BinaryTree.Easy.SymmetricBinaryTree;

import helper.TreeNode.TreeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SymmetricBinaryTreeTest {
    private static SymmetricBinaryTree symmetricBinaryTree;
    private TreeNode root;

    @BeforeAll
    static void setInstance() {
        symmetricBinaryTree = new SymmetricBinaryTree();
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
        assertTrue(symmetricBinaryTree.isSymmetric(root));
    }

    @Test
    void testOneNode() {
        root = new TreeNode(0);
        assertTrue(symmetricBinaryTree.isSymmetric(root));
    }

    // Symmetric binary tree:
    //         5
    //
    //      /    \
    //
    //    3        3
    //
    //  /   \    /   \
    //
    //1      4  4      1
    @Test
    void testSymmetric() {
        root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 3, 3, 1, 4, 4, 1)));
        assertTrue(symmetricBinaryTree.isSymmetric(root));
    }

    // Asymmetric binary tree:
    //         5
    //
    //      /    \
    //
    //    3        3
    //
    //  /   \    /   \
    //
    //1      4  1      4
    @Test
    void testAsymmetric() {
        root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 3, 3, 1, 4, 1, 4)));
        assertFalse(symmetricBinaryTree.isSymmetric(root));
    }
}