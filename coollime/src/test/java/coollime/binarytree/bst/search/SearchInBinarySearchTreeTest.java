package coollime.binarytree.bst.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import coollime.helper.TreeNode;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchInBinarySearchTreeTest {

  private static Solution sut;
  private TreeNode root;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    root = null;
  }

  @Test
  void shouldNotFindAnyWhenTheTreeIsEmpty() {
    assertNull(sut.search(root, 0));
    assertNull(sut.iterativeSearch(root, 0));
  }

  @Test
  void shouldNotFindTheNodeWhenItIsNotInTheTree() {
    root = TreeNode.buildTree(Arrays.asList(5, 3, 8, 1, 4, null, 11));
    assertNull(sut.search(root, 0));
    assertNull(sut.iterativeSearch(root, 0));

    assertNull(sut.search(root, 10));
    assertNull(sut.iterativeSearch(root, 10));
  }

  @Test
  void shouldFindTheNodeWhenItIsInTheTree() {
    root = TreeNode.buildTree(Arrays.asList(5, 3, 8, 1, 4, null, 11));
    assertEquals(3, sut.search(root, 3).key);
    assertEquals(3, sut.iterativeSearch(root, 3).key);

    assertEquals(11, sut.search(root, 11).key);
    assertEquals(11, sut.iterativeSearch(root, 11).key);
  }
}
