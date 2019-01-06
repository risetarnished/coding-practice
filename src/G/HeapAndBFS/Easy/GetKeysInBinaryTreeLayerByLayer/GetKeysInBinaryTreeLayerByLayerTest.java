package G.HeapAndBFS.Easy.GetKeysInBinaryTreeLayerByLayer;

import helper.TreeNode.TreeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class GetKeysInBinaryTreeLayerByLayerTest {
    private static GetKeysInBinaryTreeLayerByLayer levelOrderTraversal;
    private TreeNode root;

    @BeforeAll
    static void setInstance() {
        levelOrderTraversal = new GetKeysInBinaryTreeLayerByLayer();
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
        assertEquals(new ArrayList<>(), levelOrderTraversal.layerBylayer(root));
    }

    @Test
    void testOneNode() {
        root = new TreeNode(0);
        List<List<Integer>> result = levelOrderTraversal.layerBylayer(root);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Collections.singletonList(0)));
        assertEquals(expected, result);
    }

    @Test
    void testExampleOne() {
        // In-order: [5, 3, 8, 1, 4, null, 11]
        //            5
        //
        //         /    \
        //
        //       3        8
        //
        //     /   \        \
        //
        //    1     4        11
        root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4, null, 11)));
        List<List<Integer>> result = levelOrderTraversal.layerBylayer(root);
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> levelZero = new ArrayList<>(Collections.singletonList(5));
        List<Integer> levelOne = new ArrayList<>(Arrays.asList(3, 8));
        List<Integer> levelTwo = new ArrayList<>(Arrays.asList(1, 4, 11));
        expected.add(levelZero);
        expected.add(levelOne);
        expected.add(levelTwo);
        assertEquals(expected, result);
    }
}
