package coollime.binarytree.traversal.preorder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import coollime.common.objects.TreeNode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PreorderTraversalOfBinaryTreeTest {

  private static Solution sut;
  private TreeNode root;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    root = null;
  }

  @Test
  void shouldReturnEmptyListWhenTheTreeIsEmpty() {
    assertEquals(Collections.emptyList(), sut.preOrder(root));
    assertEquals(Collections.emptyList(), sut.recursivePreOrder(root));
  }

  @Test
  void shouldDoPreOrderTraversal() {
    root = new TreeNode(0);
    assertEquals(Collections.singletonList(0), sut.preOrder(root));
    assertEquals(Collections.singletonList(0), sut.recursivePreOrder(root));

    // In-order: [5, 3, 8, 1, 4, #, 11]
    // Pre-order result: [5, 3, 1, 4, 8, 11]
    List<Integer> keys = Arrays.asList(5, 3, 8, 1, 4, null, 11);
    root = TreeNode.buildTree(keys);
    List<Integer> expected = Arrays.asList(5, 3, 1, 4, 8, 11);
    assertEquals(expected, sut.preOrder(root));
    assertEquals(expected, sut.recursivePreOrder(root));
  }
}
