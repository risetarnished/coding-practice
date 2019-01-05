package F.BinaryTree.Easy.PreorderTraversalOfBinaryTree;

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

class PreorderTraversalOfBinaryTreeTest {
    private static PreorderTraversalOfBinaryTree instance;
    private TreeNode root;

    @BeforeAll
    private static void setInstance() {
        instance = new PreorderTraversalOfBinaryTree();
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
        List<Integer> result = instance.preOrder(root);
        assertEquals(new ArrayList<>(), result);
    }

    // Tree that only has a root
    @Test
    void testOneNode() {
        root = new TreeNode(0);
        List<Integer> result = instance.preOrder(root);
        assertEquals(new ArrayList<>(Collections.singletonList(0)), result);
    }

    // In-order: [5, 3, 8, 1, 4, #, 11]
    // Pre-order result: [5, 3, 1, 4, 8, 11]
    @Test
    void testOne() {
        List<Integer> keys = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4, null, 11));
        System.out.println("Input keys in-order: " + keys.toString());
        root = TreeNode.buildTree(keys);
        List<Integer> result = instance.preOrder(root);
        List<Integer> expected = new ArrayList<>(Arrays.asList(5, 3, 1, 4, 8, 11));
        System.out.println("Expected pre-order output: " + expected.toString());
        System.out.println("Actual pre-order output: " + result.toString());
        assertEquals(expected, result);
    }
}
