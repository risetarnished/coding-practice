package F.BinaryTree.Medium.TweakedIdenticalBinaryTrees;

import helper.TreeNode.TreeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TweakedIdenticalBinaryTreesTest {
    private static TweakedIdenticalBinaryTrees tweakedIdenticalBinaryTrees;
    private TreeNode one;
    private TreeNode two;

    @BeforeAll
    static void setInstance() {
        tweakedIdenticalBinaryTrees = new TweakedIdenticalBinaryTrees();
    }

    @BeforeEach
    void setUp() {
        one = null;
        two = null;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testNull() {
        assertTrue(tweakedIdenticalBinaryTrees.isTweakedIdentical(one, two));
    }

    @Test
    void testOneNode() {
        one = new TreeNode(0);
        two = new TreeNode(0);
        assertTrue(tweakedIdenticalBinaryTrees.isTweakedIdentical(one, two));
    }

    @Test
    void testIdentical() {
        // Tree one:
        //           5
        //
        //        /    \
        //
        //      3        8
        //
        //    /   \
        //
        //  1      4
        // Tree two:
        //           5
        //
        //        /    \
        //
        //      8        3
        //
        //             /   \
        //
        //            1     4
        one = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4)));
        two = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 8, 3, null, null, 1, 4)));
        assertTrue(tweakedIdenticalBinaryTrees.isTweakedIdentical(one, two));
    }

    @Test
    void testDifferent() {
        // Tree one:
        //           5
        //
        //        /    \
        //
        //      3        8
        //
        //    /   \
        //
        //  1      4
        // Tree two:
        //           5
        //
        //        /    \
        //
        //      8        3
        //
        //       \     /
        //
        //        4  1
        one = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 3, 8, 1, 4)));
        two = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 8, 3, null, 4, 1)));
        assertFalse(tweakedIdenticalBinaryTrees.isTweakedIdentical(one, two));
    }
}
