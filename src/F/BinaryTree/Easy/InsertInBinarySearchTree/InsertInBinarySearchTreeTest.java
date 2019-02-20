package F.BinaryTree.Easy.InsertInBinarySearchTree;

import helper.TreeNode.TreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InsertInBinarySearchTreeTest {
    private static InsertInBinarySearchTree instance;
    private TreeNode root;
    private int key;

    @BeforeAll
    static void setInstance() {
        instance = new InsertInBinarySearchTree();
    }

    @BeforeEach
    void setUp() {
        root = null;
        key = 0;
    }

    @Test
    void recursiveInsert() {
        assertEquals(new TreeNode(key), instance.recursiveInsert(root, key));

        root = new TreeNode(-1);
        TreeNode expected = TreeNode.buildTree(new ArrayList<>(Arrays.asList(-1, null, 0)));
        assertEquals(expected,instance.recursiveInsert(root, key));

        root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4)));
        key = 11;
        expected = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4, null, 11)));
        assertEquals(expected, instance.recursiveInsert(root, key));
    }

    @Test
    void iterativeInsert() {
        assertEquals(new TreeNode(key), instance.iterativeInsert(root, key));

        root = new TreeNode(-1);
        TreeNode expected = TreeNode.buildTree(new ArrayList<>(Arrays.asList(-1, null, 0)));
        assertEquals(expected,instance.iterativeInsert(root, key));

        root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4)));
        key = 11;
        expected = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4, null, 11)));
        assertEquals(expected, instance.iterativeInsert(root, key));
    }
}