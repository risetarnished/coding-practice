package coollime.recursion.maximumpathsumbinarytreeiii;

import static org.junit.jupiter.api.Assertions.*;

import coollime.common.objects.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaximumPathSumBinaryTreeIIITest {

  private static Solution sut;
  private TreeNode root;

  @BeforeAll
  static void setInstance() {
    sut = new Solution();
  }

  @BeforeEach
  void setUp() {
    root = null;
  }

  @Test
  void shouldReturnZeroWhenThereIsNoTree() {
    assertEquals(0, sut.maxPathSum(root));
  }

  @Test
  void shouldReturnTheSumOfTheMaxPath() {
    root =
      TreeNode.buildTree(
        new ArrayList<>(
          Arrays.asList(-5, 2, 11, null, null, 6, 14, null, null, -3)
        )
      );
    int actual = sut.maxPathSum(root);
    assertEquals(25, actual);
  }
}
