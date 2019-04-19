package C.Recursion.II.Medium.MaximumPathSumBinaryTreeIII;

import helper.TreeNode.TreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MaximumPathSumBinaryTreeIIITest {
  private static MaximumPathSumBinaryTreeIII instance;
  private TreeNode root;

  @BeforeAll
  static void setInstance() {
    instance = new MaximumPathSumBinaryTreeIII();
  }

  @BeforeEach
  void setUp() {
    root = null;
  }

  @Test
  void maxPathSum() {
    assertEquals(0, instance.maxPathSum(root));

    root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(-5, 2, 11, null, null, 6, 14, null, null, -3)));
    int actual = instance.maxPathSum(root);
    assertEquals(25, actual);
  }
}