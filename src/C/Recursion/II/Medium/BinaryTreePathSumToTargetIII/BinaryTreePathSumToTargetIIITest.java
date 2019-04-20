package C.Recursion.II.Medium.BinaryTreePathSumToTargetIII;

import helper.TreeNode.TreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreePathSumToTargetIIITest {
  private static BinaryTreePathSumToTargetIII instance;
  private TreeNode root;
  private int target;

  @BeforeAll
  static void setInstance() {
    instance = new BinaryTreePathSumToTargetIII();
  }

  @BeforeEach
  void setUp() {
    root = null;
    target = 0;
  }

  @Test
  void exist() {
    assertFalse(instance.exist(root, target));

    root = TreeNode.buildTree(new ArrayList<>(Arrays.asList(5, 2, 11, null, null, 6, 14, 3)));
    target = 17;
    assertTrue(instance.exist(root, target));
  }
}