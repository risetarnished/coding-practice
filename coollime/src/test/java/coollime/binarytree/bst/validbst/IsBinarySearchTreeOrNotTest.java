package coollime.binarytree.bst.validbst;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import coollime.common.objects.TreeNode;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IsBinarySearchTreeOrNotTest {

  private static Solution sut;
  private TreeNode root;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    root = null;
  }

  @Test
  void shouldReturnTrueWhenTheTreeIsEmpty() {
    assertTrue(sut.isBST(root));
  }

  @Test
  void shouldReturnTrueWhenThereIsOnlyOneNode() {
    root = new TreeNode(0);
    assertTrue(sut.isBST(root));
  }

  @Test
  void shouldReturnTrueWhenTheTreeIsBST() {
    // BST: in-order build tree [6, 4, 10, 2, 5, 7, 12]
    // 6
    // / \
    // 4 10
    // / \ / \
    // 2 5 7 12
    root = TreeNode.buildTree(Arrays.asList(6, 4, 10, 2, 5, 7, 12));
    assertTrue(sut.isBST(root));
  }

  @Test
  void shouldReturnFalseWhenTheTreeIsNotBST() {
    // In-order build tree [6, 4, 10, 2, 5, 6, 12]
    // 6
    // / \
    // 4 10
    // / \ / \
    // 2 5 6 12
    // ^
    // |
    // This violates line #37
    root = TreeNode.buildTree(Arrays.asList(6, 4, 10, 2, 5, 6, 12));
    assertFalse(sut.isBST(root));
  }
}
