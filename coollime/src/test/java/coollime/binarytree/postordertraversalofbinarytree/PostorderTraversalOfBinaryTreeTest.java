package coollime.binarytree.postordertraversalofbinarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import coollime.helper.TreeNode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PostorderTraversalOfBinaryTreeTest {
  private static Solution sut;
  private TreeNode root;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    root = null;
  }

  @Test
  void shouldReturnEmptyListWhenTheTreeIsEmpty() {
    assertEquals(Collections.emptyList(), sut.postOrder(root));
    assertEquals(Collections.emptyList(), sut.recursivePostOrder(root));
  }

  @Test
  void shouldDoPostOrderTraversal() {
    root = new TreeNode(0);
    List<Integer> expected = Collections.singletonList(0);
    assertEquals(expected, sut.postOrder(root));
    assertEquals(expected, sut.recursivePostOrder(root));

    // In-order build tree: [5, 3, 8, 1, 4, #, 11]
    // Post-order result: [1, 4, 3, 11, 8, 5]
    root = TreeNode.buildTree(Arrays.asList(5, 3, 8, 1, 4, null, 11));
    expected = Arrays.asList(1, 4, 3, 11, 8, 5);
    assertEquals(expected, sut.postOrder(root));
    assertEquals(expected, sut.recursivePostOrder(root));
  }
}
