package coollime.recursion.lowestcommonancestori;

import static org.junit.jupiter.api.Assertions.*;

import coollime.common.objects.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LowestCommonAncestorITest {

  private static Solution sut;
  private TreeNode root, one, two;

  @BeforeAll
  static void setInstance() {
    sut = new Solution();
  }

  @BeforeEach
  void setUp() {
    root = null;
    one = null;
    two = null;
  }

  @AfterEach
  void tearDown() {}

  @Test
  void shouldNotFindANodeIfThereIsNoTree() {
    assertNull(sut.lowestCommonAncestor(root, one, two));
  }

  @Test
  void shouldFindTheLowestCommonAncestor() {
    // Binary Tree:
    // 5
    //
    // / \
    //
    // 9 12
    //
    // / \ \
    //
    // 2 3 14
    // 1. Look for LCA of node 2 and 14
    // 2. Look for LCA of node 2 and 9
    // 3. Look for LCA of node 2 and 3
    root =
      TreeNode.buildTree(
        new ArrayList<>(Arrays.asList(5, 9, 12, 2, 3, null, 14))
      );
    one = TreeNode.getNode(root, 2);
    two = TreeNode.getNode(root, 14);
    TreeNode expected = root;
    TreeNode result = sut.lowestCommonAncestor(root, one, two);
    printInfo(one, two, expected, result);
    assertEquals(expected, result);

    two = TreeNode.getNode(root, 9);
    expected = two;
    result = sut.lowestCommonAncestor(root, one, two);
    printInfo(one, two, expected, result);
    assertEquals(expected, result);

    two = TreeNode.getNode(root, 3);
    expected = TreeNode.getNode(root, 9);
    result = sut.lowestCommonAncestor(root, one, two);
    printInfo(one, two, expected, result);
    assertEquals(expected, result);
  }

  private void printInfo(
    TreeNode one,
    TreeNode two,
    TreeNode expected,
    TreeNode result
  ) {
    System.out.format(
      "The LCA of node %d and node %d:\n" +
      "Expected node %d\n" +
      "Actual   node %d\n",
      one.key,
      two.key,
      expected.key,
      result.key
    );
  }
}
