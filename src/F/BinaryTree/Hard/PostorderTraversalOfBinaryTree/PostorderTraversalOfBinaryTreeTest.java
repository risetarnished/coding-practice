package F.BinaryTree.Hard.PostorderTraversalOfBinaryTree;

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

class PostorderTraversalOfBinaryTreeTest {
    private static PostorderTraversalOfBinaryTree postOrderTraversal;
    private TreeNode root;

    @BeforeAll
    private static void setInstance() {
        postOrderTraversal = new PostorderTraversalOfBinaryTree();
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
        List<Integer> result = postOrderTraversal.postOrder(root);
        assertEquals(new ArrayList<>(), result);
    }

    // Tree that only has a root
    @Test
    void testOneNode() {
        root = new TreeNode(0);
        List<Integer> result = postOrderTraversal.postOrder(root);
        assertEquals(new ArrayList<>(Collections.singletonList(0)), result);
    }

    // In-order build tree: [5, 3, 8, 1, 4, #, 11]
    // Post-order result: [1, 4, 3, 11, 8, 5]
    @Test
    void testOne() {
        List<Integer> keys = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4, null, 11));
        System.out.println("Input keys in-order: " + keys.toString());
        root = TreeNode.buildTree(keys);
        List<Integer> result = postOrderTraversal.postOrder(root);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 4, 3, 11, 8, 5));
        System.out.println("Expected post-order output: " + expected.toString());
        System.out.println("Actual post-order output: " + result.toString());
        assertEquals(expected, result);
    }
}