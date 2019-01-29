package N.CrossTraining.II.Medium.ClosestNumberInBinarySearchTree;

import helper.TreeNode.TreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClosestNumberInBinarySearchTreeTest {
    private static ClosestNumberInBinarySearchTree closestNumber;
    private TreeNode root;
    private int target;

    @BeforeAll
    static void setInstance() {
        closestNumber = new ClosestNumberInBinarySearchTree();
    }

    @BeforeEach
    void setUp() {
        root = null;
        target = -1;
    }

    @Test
    void closest() {
        assertEquals(-1, closestNumber.closest(root, target));

        root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 2, 11, null, null, 6, 14)));
        // Test 1
        target = 4;
        assertEquals(5, closestNumber.closest(root, target));
        // Test 2
        target = 10;
        assertEquals(11, closestNumber.closest(root, target));
        // Test 3
        target = 6;
        assertEquals(6, closestNumber.closest(root, target));
    }
}