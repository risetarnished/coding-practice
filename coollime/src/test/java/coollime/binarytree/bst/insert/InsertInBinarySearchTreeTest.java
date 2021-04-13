package coollime.binarytree.bst.insert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import coollime.common.objects.TreeNode;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InsertInBinarySearchTreeTest {

  private static Solution sut;
  private TreeNode root;
  private int key;

  @BeforeEach
  void setUp() {
    sut = new Solution();
    root = null;
    key = 0;
  }

  @Test
  void shouldInsertAsRootWhenTheTreeIsEmpty() {
    assertEquals(new TreeNode(key), sut.recursiveInsert(root, key));
    assertEquals(new TreeNode(key), sut.iterativeInsert(root, key));
  }

  @Test
  void shouldInsertTheNode() {
    root = new TreeNode(-1);
    TreeNode expected = TreeNode.buildTree(Arrays.asList(-1, null, 0));
    assertEquals(expected, sut.recursiveInsert(root, key));
    assertEquals(expected, sut.iterativeInsert(root, key));

    root = TreeNode.buildTree(Arrays.asList(5, 3, 8, 1, 4));
    key = 11;
    expected = TreeNode.buildTree(Arrays.asList(5, 3, 8, 1, 4, null, 11));
    assertEquals(expected, sut.recursiveInsert(root, key));
    assertEquals(expected, sut.iterativeInsert(root, key));
  }
}
