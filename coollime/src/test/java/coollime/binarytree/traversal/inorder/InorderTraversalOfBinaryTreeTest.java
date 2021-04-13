package coollime.binarytree.traversal.inorder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import coollime.common.objects.TreeNode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InorderTraversalOfBinaryTreeTest {

  private static Solution sut;
  private TreeNode root;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    root = null;
  }

  @Test
  void shouldNotTraverseWhenTheTreeIsEmpty() {
    assertEquals(Collections.emptyList(), sut.inOrder(root));
    assertEquals(Collections.emptyList(), sut.iterativeInOrder(root));
  }

  @Test
  void shouldDoInOrderTraversal() {
    root = new TreeNode(0);
    assertEquals(Collections.singletonList(0), sut.inOrder(root));
    assertEquals(Collections.singletonList(0), sut.iterativeInOrder(root));

    // In-order build tree: [5, 3, 8, 1, 4, #, 11]
    // In-order result: [1, 3, 4, 5, 8, 11]
    root = TreeNode.buildTree(Arrays.asList(5, 3, 8, 1, 4, null, 11));
    List<Integer> expected = Arrays.asList(1, 3, 4, 5, 8, 11);
    assertEquals(expected, sut.inOrder(root));
    assertEquals(expected, sut.iterativeInOrder(root));
  }
}
