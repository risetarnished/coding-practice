package F.BinaryTree.Medium.InorderTraversalOfBinaryTree;

import helper.TreeNode.TreeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InorderTraversalOfBinaryTreeTest {
    private static InorderTraversalOfBinaryTree inOrderTraversal;
    private TreeNode root;

    @BeforeAll
    static void setInstance() {
        inOrderTraversal = new InorderTraversalOfBinaryTree();
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
        List<Integer> result = inOrderTraversal.inOrder(root);
        assertEquals(new ArrayList<>(), result);
    }

    // Tree that only has a root
    @Test
    void testOneNode() {
        root = new TreeNode(0);
        List<Integer> result = inOrderTraversal.inOrder(root);
        assertEquals(new ArrayList<>(Collections.singletonList(0)), result);
    }

    // In-order build tree: [5, 3, 8, 1, 4, #, 11]
    // In-order result: [1, 3, 4, 5, 8, 11]
    @Test
    void testOne() {
        List<Integer> keys = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4, null, 11));
        System.out.println("Input keys in-order: " + keys.toString());
        root = TreeNode.buildTree(keys);
        List<Integer> result = inOrderTraversal.inOrder(root);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 8, 11));
        System.out.println("Expected in-order output: " + expected.toString());
        System.out.println("Actual in-order output: " + result.toString());
        assertEquals(expected, result);
    }
}
