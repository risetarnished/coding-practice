package F.BinaryTree.Easy.GetKeysInBinarySearchTreeInGivenRange;

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

class GetKeysInBinarySearchTreeInGivenRangeTest {
    private static GetKeysInBinarySearchTreeInGivenRange getKeysInRange;
    private TreeNode root;
    private int min;
    private int max;

    @BeforeAll
    static void setInstance() {
        getKeysInRange = new GetKeysInBinarySearchTreeInGivenRange();
    }

    @BeforeEach
    void setUp() {
        root = null;
        min = Integer.MIN_VALUE;
        max = Integer.MAX_VALUE;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        List<Integer> result = getKeysInRange.getRange(root, min, max);
        assertEquals(new ArrayList<>(), result);
    }

    @Test
    void testOneNode() {
        root = new TreeNode(0);
        List<Integer> result = getKeysInRange.getRange(root, min, max);
        List<Integer> expected = new ArrayList<>(Collections.singletonList(0));
        assertEquals(expected, result);
    }

    @Test
    void testExample() {
        // Example BST: in-order [5, 3, 8, 1, 4, null, 11]
        //           5
        //
        //        /    \
        //
        //      3        8
        //
        //    /   \        \
        //
        //   1     4        11
        root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4, null, 11)));
        min = 2;
        max = 5;
        List<Integer> result = getKeysInRange.getRange(root, min, max);
        List<Integer> expected = new ArrayList<>(Arrays.asList(3, 4, 5));
        assertEquals(expected, result);
    }

    @Test
    void testNotInRange() {
        // Nothing in range
        // Same tree above
        // range = [13, 15]
        root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4, null, 11)));
        min = 13;
        max = 15;
        List<Integer> result = getKeysInRange.getRange(root, min, max);
        assertEquals(new ArrayList<>(), result);
    }
}
