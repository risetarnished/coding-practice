package coollime.binarytree.general.symmetric;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import coollime.common.objects.TreeNode;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SymmetricBinaryTreeTest {

  private static Solution sut;
  private TreeNode root;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    root = null;
  }

  @Test
  void shouldReturnTrueWhenTheTreeIsEmpty() {
    assertTrue(sut.isSymmetric(root));
  }

  @Test
  void shouldReturnTrueWhenThereIsOnlyOneNode() {
    root = new TreeNode(0);
    assertTrue(sut.isSymmetric(root));
  }

  @Test
  void shouldReturnTrueWhenTheTreeIsSymmetric() {
    // Symmetric binary tree:
    // 5
    //
    // / \
    //
    // 3 3
    //
    // / \ / \
    //
    // 1 4 4 1
    root = TreeNode.buildTree(Arrays.asList(5, 3, 3, 1, 4, 4, 1));
    assertTrue(sut.isSymmetric(root));
  }

  @Test
  void shouldReturnFalseWhenTheTreeIsAsymmetric() {
    // Asymmetric binary tree:
    // 5
    //
    // / \
    //
    // 3 3
    //
    // / \ / \
    //
    // 1 4 1 4
    root = TreeNode.buildTree(Arrays.asList(5, 3, 3, 1, 4, 1, 4));
    assertFalse(sut.isSymmetric(root));
  }
}
