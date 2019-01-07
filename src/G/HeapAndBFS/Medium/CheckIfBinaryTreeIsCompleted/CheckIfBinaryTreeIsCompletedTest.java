package G.HeapAndBFS.Medium.CheckIfBinaryTreeIsCompleted;

import helper.TreeNode.TreeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckIfBinaryTreeIsCompletedTest {
    private static CheckIfBinaryTreeIsCompleted ifBalanced;
    private TreeNode root;

    @BeforeAll
    static void setInstance() {
        ifBalanced = new CheckIfBinaryTreeIsCompleted();
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
        assertTrue(ifBalanced.isCompleted(root));
    }

    @Test
    void testOneNode() {
        root = new TreeNode(0);
        assertTrue(ifBalanced.isCompleted(root));
    }

    @Test
    void testBalanced() {
        // In-order building tree: [5, 3, 8, 1, 4]
        //             5
        //
        //          /    \
        //
        //        3        8
        //
        //      /   \
        //
        //    1      4
        //
        // is completed.
        root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4)));
        assertTrue(ifBalanced.isCompleted(root));
    }

    @Test
    void testUnbalanced() {
        // In-order building tree: [5, 3, 8, 1, 4, null, 11]
        //             5
        //
        //          /    \
        //
        //        3        8
        //
        //      /   \        \
        //
        //    1      4        11
        // is not completed
        root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4, null, 11)));
        assertFalse(ifBalanced.isCompleted(root));
    }
}