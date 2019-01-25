package N.CrossTraining.I.Medium.BinaryTreeZigZagTraversal;

import helper.TreeNode.TreeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeZigZagTraversalTest {
    private static BinaryTreeZigZagTraversal zigZagTraversal;
    private TreeNode root;

    @BeforeAll
    static void setInstance() {
        zigZagTraversal = new BinaryTreeZigZagTraversal();
    }

    @BeforeEach
    void setUp() {
        root = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void zigZag() {
        // Test root = null
        assertEquals(new ArrayList<>(), zigZagTraversal.zigZag(root));

        // Test root with no child
        root = new TreeNode(0);
        assertEquals(new ArrayList<>(Collections.singletonList(0)), zigZagTraversal.zigZag(root));

        // Test the example tree
        root = TreeNode.buildTree(
                new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4, null, 11))
        );
        assertEquals(
                new ArrayList<>(Arrays.asList(5, 3, 8, 11, 4, 1)),
                zigZagTraversal.zigZag(root)
        );
    }
}