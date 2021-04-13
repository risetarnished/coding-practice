package coollime.binarytree.general.balanced;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import coollime.helper.TreeNode;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckIfBinaryTreeIsBalancedTest {

  private static Solution sut;
  private TreeNode root;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    root = null;
  }

  @Test
  void shouldReturnTrueWhenTheTreeIsEmpty() {
    assertTrue(sut.isBalanced(root));
  }

  @Test
  void shouldReturnTrueWhenTheTreeHasOnlyOneNode() {
    root = new TreeNode(0);
    assertTrue(sut.isBalanced(root));
  }

  @Test
  void shouldReturnTrueWhenTheTreeIsBalanced() {
    // In-order build tree: [5, 3, 8, 1, 4, #, 11]
    // 5
    // / \
    // 3 8
    // / \ \
    // 1 4 11
    root = TreeNode.buildTree(Arrays.asList(5, 3, 8, 1, 4, null, 11));
    assertTrue(sut.isBalanced(root));
  }

  @Test
  void shouldReturnTrueWhenTheTreeIsNotBalanced() {
    // In-order build tree: [5, 3, null, 1, 4]
    // 5
    // /
    // 3
    // / \
    // 1 4
    root = TreeNode.buildTree(Arrays.asList(5, 3, null, 1, 4));
    assertFalse(sut.isBalanced(root));
  }
}
