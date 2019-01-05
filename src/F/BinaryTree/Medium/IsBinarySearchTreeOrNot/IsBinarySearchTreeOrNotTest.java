package F.BinaryTree.Medium.IsBinarySearchTreeOrNot;

import helper.TreeNode.TreeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IsBinarySearchTreeOrNotTest {
    private static IsBinarySearchTreeOrNot isBinarySearchTreeOrNot;
    private TreeNode root;

    @BeforeAll
    static void setInstance() {
        isBinarySearchTreeOrNot = new IsBinarySearchTreeOrNot();
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
        assertTrue(isBinarySearchTreeOrNot.isBST(root));
    }

    @Test
    void testOneNode() {
        root = new TreeNode(0);
        assertTrue(isBinarySearchTreeOrNot.isBST(root));
    }

    @Test
    void testValid() {
        // BST: in-order build tree [6, 4, 10, 2, 5, 7, 12]
        //             6
        //          /    \
        //        4       10
        //      /  \     /  \
        //     2   5    7   12
        root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(6, 4, 10, 2, 5, 7, 12)));
        assertTrue(isBinarySearchTreeOrNot.isBST(root));
    }

    @Test
    void testInvalid() {
        // In-order build tree [6, 4, 10, 2, 5, 6, 12]
        //             6
        //          /    \
        //        4       10
        //      /  \     /  \
        //     2   5    6   12
        //              ^
        //              |
        // This violates line #37
        root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(6, 4, 10, 2, 5, 6, 12)));
        assertFalse(isBinarySearchTreeOrNot.isBST(root));
    }
}
