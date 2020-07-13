package coollime.binarytree.binarytreepathsumtotargeti;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import coollime.helper.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreePathSumToTargetITest {
  private static Solution sut;
  private TreeNode root;
  private int target;

  @BeforeEach
  void setUp() {
    sut = Solution.getInstance();
    root = null;
    target = 0;
  }

  @Test
  void shouldReturnFalseIfTheTreeIsInvalid() {
    assertFalse(sut.exist(root, target));
  }

  @Test
  void shouldReturnFalseIfThereAreNoSuchPaths() {
    root =
      TreeNode.buildTree(
        new ArrayList<>(
          Arrays.asList(5, 4, 8, 1, null, 3, 4, 7, 2, null, null, null, 1)
        )
      );

    target = 9;
    assertFalse(sut.exist(root, target));
  }

  @Test
  void shouldReturnTrueIfThereIsSuchAPath() {
    root = new TreeNode(0);
    assertTrue(sut.exist(root, target));

    root =
      TreeNode.buildTree(
        new ArrayList<>(
          Arrays.asList(5, 4, 8, 1, null, 3, 4, 7, 2, null, null, null, 1)
        )
      );
    target = 12;
    assertTrue(sut.exist(root, target));

    target = 16;
    assertTrue(sut.exist(root, target));

    root =
      TreeNode.buildTree(
        new ArrayList<>(
          Arrays.asList(3, -8, 9, 4, 10, 2, -5, 1, -2, null, null, -3)
        )
      );
    target = 11;
    assertTrue(sut.exist(root, target));
  }
}
