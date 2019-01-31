package N.CrossTraining.II.Medium.DeleteInBinarySearchTree;

import helper.TreeNode.TreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteInBinarySearchTreeTest {
    private static DeleteInBinarySearchTree deleteInBinarySearchTree;
    private TreeNode root;
    private int key;

    @BeforeAll
    static void setInstance() {
        deleteInBinarySearchTree = new DeleteInBinarySearchTree();
    }

    @BeforeEach
    void setUp() {
        root = null;
        key = 0;
    }

    @Test
    void deleteTree() {
        assertNull(deleteInBinarySearchTree.deleteTree(root, key));

        // Build a test tree:
        root = buildTestTree();
        key = 15;
        TreeNode expected = TreeNode.buildTree(new ArrayList<>(Arrays.asList(12, 11, 14, 10, null, 13)));
        assertEquals(expected, deleteInBinarySearchTree.deleteTree(root, key));

        root = buildTestTree();
        key = 11;
        expected = TreeNode.buildTree(new ArrayList<>(Arrays.asList(12, 10, 14, null, null, 13, 15)));
        assertEquals(expected, deleteInBinarySearchTree.deleteTree(root, key));

        root = buildTestTree();
        key = 12;
        expected = TreeNode.buildTree(new ArrayList<>(Arrays.asList(13, 11, 14, 10, null, null, 15)));
        assertEquals(expected, deleteInBinarySearchTree.deleteTree(root, key));
    }

    private TreeNode buildTestTree() {
        return TreeNode.buildTree(new ArrayList<>(Arrays.asList(12, 11, 14, 10, null, 13, 15)));

    }
}