package N.CrossTraining.II.Medium.LargestNumberSmallerInBinarySearchTree;

import helper.TreeNode.TreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LargestNumberSmallerInBinarySearchTreeTest {
    private static LargestNumberSmallerInBinarySearchTree largest;
    private TreeNode root;
    private int target;

    @BeforeAll
    static void setInstance() {
        largest = new LargestNumberSmallerInBinarySearchTree();
    }

    @BeforeEach
    void setUp() {
        root = null;
        target = 0;
    }

    @Test
    void largestSmaller() {
        assertEquals(Integer.MIN_VALUE, largest.largestSmaller(root, target));

        root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 2, 11, null, null, 6, 14)));
        // Test 1
        target = 1;
        assertEquals(Integer.MIN_VALUE, largest.largestSmaller(root, target));
        // Test 2
        target = 6;
        assertEquals(5, largest.largestSmaller(root, target));
        // Test 3
        target = 11;
        assertEquals(6, largest.largestSmaller(root, target));
        // Test 4
        target = 12;
        assertEquals(11, largest.largestSmaller(root, target));
    }
}