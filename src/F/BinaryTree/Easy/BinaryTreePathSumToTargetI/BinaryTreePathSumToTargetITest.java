package F.BinaryTree.Easy.BinaryTreePathSumToTargetI;

import helper.TreeNode.TreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreePathSumToTargetITest {
    private static BinaryTreePathSumToTargetI instance;
    private TreeNode root;
    private int target;

    @BeforeAll
    static void setInstance() {
        instance = BinaryTreePathSumToTargetI.getInstance();
    }

    @BeforeEach
    void setUp() {
        root = null;
        target = 0;
    }

    @Test
    void exist() {
        assertFalse(instance.exist(root, target));

        root = new TreeNode(0);
        assertTrue(instance.exist(root, target));

        root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(
                5, 4, 8, 1, null, 3, 4, 7, 2, null, null, null, 1
        )));

        target = 9;
        assertFalse(instance.exist(root, target));

        target = 12;
        assertTrue(instance.exist(root, target));

        target = 16;
        assertTrue(instance.exist(root, target));

        root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(
                3, -8, 9, 4, 10, 2, -5, 1, -2, null, null, -3
        )));
        target = 11;
        assertTrue(instance.exist(root, target));
    }
}